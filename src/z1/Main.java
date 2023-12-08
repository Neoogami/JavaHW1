package z1;

import java.util.Objects;

public class Main {

    public static class Pracownik {
        private Pracownik przelozony;
        private int pensja;

        public Pracownik(Pracownik przelozony, int pensja) {
            this.przelozony = przelozony;
            this.pensja = pensja;
        }

        public Pracownik(Pracownik przelozony) {
            this(przelozony, 3600);
        }

        public int getPensja() {
            return pensja;
        }

        public Pracownik getPrzelozony() {
            return przelozony;
        }
    }

    public static void main(String[] args) {
        System.out.println("Zadanie 1");
        Pracownik dyrektor = new Pracownik(null, 100000);
        Pracownik kierownik = new Pracownik(dyrektor, 20000);
        Pracownik menadzer = new Pracownik(kierownik, 10000);
        Pracownik pracownik = new Pracownik(menadzer, 5000);
        Pracownik stazysta = new Pracownik(menadzer);

        assert stazysta.getPensja() == 3600;
        assert pracownik.getPensja() == 5000;
        assert menadzer.getPensja() == 10000;
        assert kierownik.getPensja() == 20000;
        assert dyrektor.getPensja() == 100000;
        assert Objects.equals(stazysta.getPrzelozony(), pracownik.getPrzelozony());
        assert Objects.equals(stazysta.getPrzelozony().getPrzelozony().getPrzelozony(), dyrektor);
        assert Objects.equals(null, dyrektor.getPrzelozony());
    }
}