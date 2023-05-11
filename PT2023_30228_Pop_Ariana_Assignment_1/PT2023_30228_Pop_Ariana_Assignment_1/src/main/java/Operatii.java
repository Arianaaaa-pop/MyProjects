public class Operatii {
//4 ∗ 𝑋^5 − 3 ∗ 𝑋^4 + 𝑋^2 − 8 ∗ 𝑋 + 1

    public static Polinom add(Polinom P1, Polinom P2) {
        Polinom rezPol = new Polinom();

        for (Integer i : P1.getPolinom().keySet()) {
            if (P1.getPolinom().get(i) != null && P2.getPolinom().get(i) != null) {
                rezPol.addMonom(i, (P1.getPolinom().get(i) + P2.getPolinom().get(i)));
            } else if (P1.getPolinom().get(i) != null && P2.getPolinom().get(i) == null) {
                rezPol.addMonom(i, P1.getPolinom().get(i));
            }
        }
        for (Integer i : P2.getPolinom().keySet()) {
            if (P2.getPolinom().get(i) != null && P1.getPolinom().get(i) == null) {
                rezPol.addMonom(i, (P2.getPolinom().get(i)));
            }
        }
        return rezPol;
    }

    public static Polinom diff(Polinom P1, Polinom P2) {
        Polinom rezPol = new Polinom();

        for (Integer i : P1.getPolinom().keySet()) {
            if (P1.getPolinom().get(i) != null && P2.getPolinom().get(i) != null) {
                rezPol.addMonom(i, (P1.getPolinom().get(i) - P2.getPolinom().get(i)));
            } else if (P1.getPolinom().get(i) != null && P2.getPolinom().get(i) == null) {
                rezPol.addMonom(i, P1.getPolinom().get(i));
            }
        }
        for (Integer i : P2.getPolinom().keySet()) {
            if (P2.getPolinom().get(i) != null && P1.getPolinom().get(i) == null) {
                rezPol.addMonom(i, (P2.getPolinom().get(i)));
            }
        }
        return rezPol;
    }

    public static Polinom multiply(Polinom P1, Polinom P2) {
        double coef = 0;
        int putere = 0;
        Polinom rezPol = new Polinom();

        for (Integer i : P1.getPolinom().keySet()) {
            for (Integer j : P2.getPolinom().keySet()) {
                coef = (P1.getPolinom().get(i) * P2.getPolinom().get(j));
                putere = i + j;
                if (rezPol.getPolinom().containsKey(putere)) {
                    rezPol.addMonom(putere, coef + rezPol.getPolinom().get(putere));
                } else {
                    rezPol.addMonom(putere, coef);
                }
            }
        }

        return rezPol;
    }


    public static Polinom derivare(Polinom P1) {
        Polinom rezPol = new Polinom();

        for (Integer i : P1.getPolinom().keySet())
            if (P1.getPolinom().get(i) != null) rezPol.addMonom(i - 1, (P1.getPolinom().get(i)) * i);

        return rezPol;
    }

    public static Polinom integrare(Polinom P1) {
        Polinom rezPol = new Polinom();

        for (Integer i : P1.getPolinom().keySet()) {
            if (P1.getPolinom().get(i) != null) rezPol.addMonom(i + 1, (P1.getPolinom().get(i) / (i + 1)));
        }
        return rezPol;
    }

    public static Polinom reset(Polinom p1) {
        Polinom rezPol = new Polinom();
        for (Integer i : p1.getPolinom().keySet()) {
            if (p1.getPolinom().get(i) != null) rezPol.addMonom(0, 0);
        }
        return rezPol;
    }

}
