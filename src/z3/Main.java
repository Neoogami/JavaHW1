package z3;

interface Postac {
    int getPunktyZycia();
}

interface Walczaca extends Postac {
    void atakuj(Postac przeciwnik);
}

interface Leczaca extends Postac {
    void wylecz(Postac cel);
}

class Smok implements Walczaca {
    private int punktyZycia;

    public Smok() {
        this.punktyZycia = 1000;
    }

    @Override
    public int getPunktyZycia() {
        return punktyZycia;
    }

    @Override
    public void atakuj(Postac przeciwnik) {
        if (przeciwnik instanceof Walczaca) {
            Walczaca walczacaPrzeciwnik = (Walczaca) przeciwnik;
            walczacaPrzeciwnik.getPunktyZycia();
        }
    }
}

class Rycerz implements Walczaca {
    private int punktyZycia;
    private int sila;

    public Rycerz(int punktyZycia, int sila) {
        this.punktyZycia = punktyZycia;
        this.sila = sila;
    }

    @Override
    public int getPunktyZycia() {
        return punktyZycia;
    }

    @Override
    public void atakuj(Postac przeciwnik) {
        if (przeciwnik instanceof Walczaca) {
            Walczaca walczacaPrzeciwnik = (Walczaca) przeciwnik;
            walczacaPrzeciwnik.getPunktyZycia();
        }
    }

    public int getSila() {
        return sila;
    }
}

class Druid implements Leczaca, Walczaca {
    private int punktyZycia;
    private int mana;

    public Druid(int punktyZycia, int mana) {
        this.punktyZycia = punktyZycia;
        this.mana = mana;
    }

    @Override
    public int getPunktyZycia() {
        return punktyZycia;
    }

    @Override
    public void wylecz(Postac cel) {
        if (cel instanceof Leczaca) {
            Leczaca leczacaCel = (Leczaca) cel;
            leczacaCel.getPunktyZycia();
        }
    }

    @Override
    public void atakuj(Postac przeciwnik) {
        if (przeciwnik instanceof Walczaca) {
            Walczaca walczacaPrzeciwnik = (Walczaca) przeciwnik;
            walczacaPrzeciwnik.getPunktyZycia();
        }
    }

    public int getMana() {
        return mana;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Zadanie 3");

        Smok smok = new Smok();

        assert smok.getPunktyZycia() == 1000;
        assert smok instanceof Postac;

        Rycerz rycerz = new Rycerz(500, 50);

        assert rycerz.getPunktyZycia() == 500;
        assert rycerz.getSila() == 50;
        assert rycerz instanceof Postac;
        assert rycerz instanceof Walczaca;

        Druid druid = new Druid(250, 100);

        assert druid.getPunktyZycia() == 250;
        assert druid.getMana() == 100;
        assert druid instanceof Postac;
        assert druid instanceof Leczaca;

        smok.atakuj(rycerz);

        assert rycerz.getPunktyZycia() == 400;


        druid.atakuj(smok);

        assert smok.getPunktyZycia() == 999;

        rycerz.atakuj(smok);

        assert smok.getPunktyZycia() == 949;

        rycerz.atakuj(smok);

        assert smok.getPunktyZycia() == 899;

        rycerz.atakuj(smok);

        assert smok.getPunktyZycia() == 849;
    }
}
