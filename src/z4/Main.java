package z4;

import java.util.ArrayList;
import java.util.List;

enum Kontynent {
    EUROPA,
    AZJA
}

interface Panstwo {
    Kontynent getKontynent();
    int getLiczbaLudnosci();
    String getStolica();
    List<Panstwo> getSasiedzi();
    void dodajSasiada(Panstwo sasiad);
    void setLiczbaLudnosci(int liczbaLudnosci);

}

class PanstwoEuropejskie implements Panstwo {
    private Kontynent kontynent;
    public int liczbaLudnosci;
    private String stolica;
    private List<Panstwo> sasiedzi;

    public PanstwoEuropejskie(Kontynent kontynent, int liczbaLudnosci, String stolica) {
        this.kontynent = kontynent;
        this.liczbaLudnosci = liczbaLudnosci;
        this.stolica = stolica;
        this.sasiedzi = new ArrayList<>();
    }

    @Override
    public Kontynent getKontynent() {
        return kontynent;
    }

    @Override
    public int getLiczbaLudnosci() {
        return liczbaLudnosci;
    }

    @Override
    public String getStolica() {
        return stolica;
    }

    @Override
    public List<Panstwo> getSasiedzi() {
        return sasiedzi;
    }

    @Override
    public void dodajSasiada(Panstwo sasiad) {
        sasiedzi.add(sasiad);
    }
    @Override
    public void setLiczbaLudnosci(int liczbaLudnosci) {
        this.liczbaLudnosci = liczbaLudnosci;
    }

}

class Rosja extends PanstwoEuropejskie {
    public Rosja() {
        super(Kontynent.AZJA, 143400000, "Moskwa");
    }

    public void migruj(Panstwo cel, int liczbaMigrantow) {
        if (this.getSasiedzi().contains(cel)) {
            this.liczbaLudnosci -= liczbaMigrantow;
            cel.setLiczbaLudnosci(cel.getLiczbaLudnosci() + liczbaMigrantow);
        }
    }
}

    class Polska extends PanstwoEuropejskie {
    public Polska() {
        super(Kontynent.EUROPA, 37750000, "Warszawa");
    }
}

class Niemcy extends PanstwoEuropejskie {
    public Niemcy() {
        super(Kontynent.EUROPA, 83122889, "Berlin");
    }
}

class Czechy extends PanstwoEuropejskie {
    public Czechy() {
        super(Kontynent.EUROPA, 10708981, "Praga");
    }
}

class Slowacja extends PanstwoEuropejskie {
    public Slowacja() {
        super(Kontynent.EUROPA, 5450421, "Bratysława");
    }
}

class Ukraina extends PanstwoEuropejskie {
    public Ukraina() {
        super(Kontynent.EUROPA, 43733762, "Kijów");
    }
}

class Bialorus extends PanstwoEuropejskie {
    public Bialorus() {
        super(Kontynent.EUROPA, 9408400, "Mińsk");
    }
}

class Litwa extends PanstwoEuropejskie {
    public Litwa() {
        super(Kontynent.EUROPA, 2730273, "Wilno");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Zadanie 4");

        Polska polska = new Polska();
        Niemcy niemcy = new Niemcy();
        Czechy czechy = new Czechy();
        Slowacja slowacja = new Slowacja();
        Ukraina ukraina = new Ukraina();
        Bialorus bialorus = new Bialorus();
        Litwa litwa = new Litwa();
        Rosja rosja = new Rosja();

        assert polska instanceof PanstwoEuropejskie;
        assert niemcy instanceof PanstwoEuropejskie;
        assert czechy instanceof PanstwoEuropejskie;
        assert slowacja instanceof PanstwoEuropejskie;
        assert ukraina instanceof PanstwoEuropejskie;
        assert bialorus instanceof PanstwoEuropejskie;
        assert litwa instanceof PanstwoEuropejskie;
        assert rosja instanceof Panstwo;

        assert polska instanceof Panstwo;
        assert niemcy instanceof Panstwo;
        assert czechy instanceof Panstwo;
        assert slowacja instanceof Panstwo;
        assert ukraina instanceof Panstwo;
        assert bialorus instanceof Panstwo;
        assert litwa instanceof Panstwo;
        assert rosja instanceof Panstwo;

        assert polska.getKontynent() == Kontynent.EUROPA;
        assert polska.getLiczbaLudnosci() == 37750000;
        assert polska.getStolica().equals("Warszawa");

        assert rosja.getKontynent() == Kontynent.AZJA;
        assert rosja.getLiczbaLudnosci() == 143400000;
        assert rosja.getStolica().equals("Moskwa");

        assert polska.getSasiedzi().equals(List.of());

        polska.dodajSasiada(niemcy);
        polska.dodajSasiada(czechy);
        polska.dodajSasiada(slowacja);
        polska.dodajSasiada(ukraina);
        polska.dodajSasiada(bialorus);
        polska.dodajSasiada(litwa);
        polska.dodajSasiada(rosja);

        assert polska.getSasiedzi().equals(List.of(
                niemcy,
                czechy,
                slowacja,
                ukraina,
                bialorus,
                litwa,
                rosja
        ));

        rosja.migruj(polska, 1000000);

        assert rosja.getLiczbaLudnosci() == 142400000;
        assert polska.getLiczbaLudnosci() == 38750000;
    }
}

