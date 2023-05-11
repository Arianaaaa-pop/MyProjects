import java.util.HashMap;
import java.util.Map;

public class Polinom {
    //puterea la care este monomul si coeficientul sau
    private final Map<Integer, Double> polinom = new HashMap<Integer, Double>();

    public Polinom() {
    }

    public Map<Integer, Double> getPolinom() {
        return this.polinom;
    }

    public void addMonom(int exponent, double coeficient) {
        polinom.put(exponent, coeficient);
    }

    public String toString() {
        //str.apend(string s)
        //This method appends the mentioned string with the existing string.
        StringBuilder sb = new StringBuilder(); //It constructs a blank string builder with a capacity of 16 characters
        for (int exponent : this.polinom.keySet()) {
            Double coeficient = this.polinom.get(exponent);
            if (coeficient == 0) {
                continue; // termenul este 0, deci nu trebuie afișat
            }
            if (coeficient > 0 && sb.length() > 0) {
                sb.append("+"); // adaugă un semn "+" dacă coeficientul este pozitiv și nu este primul termen
            }
            if (coeficient != 1 || exponent == 0) {
                sb.append(coeficient); // afișează coeficientul dacă nu este 1 sau dacă exponentul este 0
            }
            if (exponent > 0) {
                sb.append("x");
            }
            if (exponent > 1) {
                sb.append("^" + exponent); // afișează exponentul dacă este mai mare decât 1
            }
        }
        if (sb.length() == 0) {
            sb.append("0"); // polinomul este 0, deci returnează "0"
        }
        return sb.toString();
    }

    public void fromString(String s) {
        String[] termStrings = s.split("(?=[+-])"); // separă termenii după  "+" și "-" in monoame
        for (String term : termStrings) {   // ia termenii pe rand din polinom
            double coeficient = 1.0; //initializam coef cu 1
            int exponent = 0;   // intializam exponentul cu 1
            String[] monom = term.split("x\\^?");   //ia numerele din monoame, deci fara x
            if (monom.length > 0) {
                if (monom[0].isEmpty()) {// daca nu este nimic in monom facem coef 0
                    coeficient = 1;//sa pun 1
                } else {
                    try {
                        coeficient = Double.parseDouble(monom[0]); // dam valoare coeficientului dupa val din monom
                    } catch (NumberFormatException e) {
                        coeficient = 1;
                    }
                }
            }
            if (monom.length > 1) {// daca monomul este mai lung deacat 1
                if (monom[1].isEmpty()) {//verificam daca  e gol la locul puterii
                    exponent = 1;
                } else {
                    try {
                        exponent = Integer.parseInt(monom[1]);// daca avem ceva pe locul puterii punem in exponent
                    } catch (NumberFormatException e) {
                        exponent = 1;
                    }
                }
            } else if (term.contains("x")) {// daca termenul contine x atunci automat exp e 1
                exponent = 1;
            }
            addMonom(exponent, coeficient);//adaugam ceea ca am obtinut pana acum
        }

    }

}

