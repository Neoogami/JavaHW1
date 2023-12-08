package z2;

import java.util.List;

interface ImienneZwierze {
    String getImie();

    String dajGlos();
}

abstract class Zwierze implements ImienneZwierze {
    private int wiek;
    private int ileNog;

    public Zwierze(int wiek, int ileNog) {
        this.wiek = wiek;
        this.ileNog = ileNog;
    }

    public int getWiek() {
        return wiek;
    }

    public int getIleNog() {
        return ileNog;
    }
}

// Klasa reprezentująca psa
class Pies extends Zwierze {
    private String imie;

    public Pies(int wiek, String imie) {
        super(wiek, 4);
        this.imie = imie;
    }

    @Override
    public String getImie() {
        return imie;
    }

    @Override
    public String dajGlos() {
        return "Hau hau";
    }
}

// Klasa reprezentująca rybę
class Ryba extends Zwierze {
    public Ryba(int wiek) {
        super(wiek, 0);
    }

    @Override
    public String getImie() {
        return "";
    }

    @Override
    public String dajGlos() {
        return "Bul bul";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Zadanie 2");

        List<Zwierze> zwierzeta = List.of(new Pies(10, "Burek"), new Ryba(1));
        Pies pies = (Pies) zwierzeta.get(0);
        Ryba ryba = (Ryba) zwierzeta.get(1);

        assert pies.getIleNog() == 4;
        assert pies.getWiek() == 10;
        assert pies.getImie().equals("Burek");
        assert ryba.getIleNog() == 0;
        assert ryba.getWiek() == 1;
        assert pies.dajGlos().equals("Hau hau");
        assert ryba.dajGlos().equals("Bul bul");
        assert ImienneZwierze.class.isInstance(pies);
        assert !ImienneZwierze.class.isInstance(ryba);
    }
}
