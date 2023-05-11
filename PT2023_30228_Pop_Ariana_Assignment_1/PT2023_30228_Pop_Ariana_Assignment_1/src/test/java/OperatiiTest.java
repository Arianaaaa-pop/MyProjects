import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OperatiiTest {
    @Test
    public void  addTest() {
        Polinom P1;
        P1 = new Polinom();
        P1.addMonom(2, 3.0);
        P1.addMonom(1, 1.0);
        P1.addMonom(0, 1.0);

        Polinom P2;
        P2 = new Polinom();
        P2.addMonom(1, 1.0);
        P2.addMonom(0, 2.0);

        Polinom rez = new Polinom();
        rez.addMonom(2, 3.0);
        rez.addMonom(1, 2.0);
        rez.addMonom(0, 3.0);


        Polinom rez1 = new Polinom();
        rez1=Operatii.add(P1,P2);
        assertEquals("3.0+2.0x+3.0x^2",rez1.toString());

    }

   @Test
    public void  addTestFail() {
        Polinom P1;
        P1 = new Polinom();
        P1.addMonom(2, 3.0);
        P1.addMonom(1, 1.0);
        P1.addMonom(0, 1.0);

        Polinom P2;
        P2 = new Polinom();
        P2.addMonom(1, 1.0);
        P2.addMonom(0, 2.0);
        Polinom rez = new Polinom();
        rez.addMonom(2, 3.0);
        rez.addMonom(1, 2.0);
        rez.addMonom(0, 3.0);


        Polinom rez1 ;
        rez1=Operatii.add(P1,P2);
        assertNotEquals("2.0+2.0x+3.0x^2",rez1.toString());

    }

    @Test
    public void diffTest() {
        Polinom P1;
        P1 = new Polinom();
        P1.addMonom(2, 3.0);
        P1.addMonom(1, 1.0);
        P1.addMonom(0, 1.0);

        Polinom P2;
        P2 = new Polinom();
        P2.addMonom(1, 1.0);
        P2.addMonom(0, 2.0);

        Polinom rez = new Polinom();
        rez.addMonom(2, 3.0);
        rez.addMonom(0, -1.0);

        Polinom rez2 = new Polinom();
        rez2=Operatii.diff(P1,P2);
        assertEquals("-1.0+3.0x^2",rez2.toString());
    }

    @Test
    public void diffTestFail() {
        Polinom P1;
        P1 = new Polinom();
        P1.addMonom(2, 3.0);
        P1.addMonom(1, 1.0);
        P1.addMonom(0, 1.0);

        Polinom P2;
        P2 = new Polinom();
        P2.addMonom(1, 1.0);
        P2.addMonom(0, 2.0);

        Polinom rez = new Polinom();
        rez.addMonom(2, 3.0);
        rez.addMonom(0, -1.0);

        Polinom rez2 = new Polinom();
        rez2=Operatii.diff(P1,P2);
        assertNotEquals("1.0+3.0x^2",rez2.toString());
    }

    @Test
    public void muliplyTest() {
        Polinom P1;
        P1 = new Polinom();
        P1.addMonom(2, 3.0);
        P1.addMonom(1, 1.0);
        P1.addMonom(0, 1.0);

        Polinom P2;
        P2 = new Polinom();
        P2.addMonom(1, 1.0);
        P2.addMonom(0, 2.0);
        Polinom rez = new Polinom();

        rez.addMonom(3, 3.0);
        rez.addMonom(2, 7.0);
        rez.addMonom(1, 3.0);
        rez.addMonom(0, 2.0);

        Polinom rez3 = new Polinom();
        rez3=Operatii.multiply(P1,P2);
        assertEquals("2.0+3.0x+7.0x^2+3.0x^3",rez3.toString());
    }
    @Test
    public void muliplyTestFail() {
        Polinom P1;
        P1 = new Polinom();
        P1.addMonom(2, 3.0);
        P1.addMonom(1, 1.0);
        P1.addMonom(0, 1.0);

        Polinom P2;
        P2 = new Polinom();
        P2.addMonom(1, 1.0);
        P2.addMonom(0, 2.0);
        Polinom rez = new Polinom();

        rez.addMonom(3, 3.0);
        rez.addMonom(2, 7.0);
        rez.addMonom(1, 3.0);
        rez.addMonom(0, 2.0);

        Polinom rez3 = new Polinom();
        rez3=Operatii.multiply(P1,P2);
        assertNotEquals("12.0+3.0x+7.0x^2+3.0x^3",rez3.toString());
    }
    @Test
    public void derivareTest() {
        Polinom P1;
        P1 = new Polinom();
        P1.addMonom(2, 3.0);
        P1.addMonom(1, 1.0);
        P1.addMonom(0, 1.0);


        Polinom rez = new Polinom();

        rez.addMonom(1, 6.0);
        rez.addMonom(0, 1.0);

        Polinom rez4 = new Polinom();
        rez4=Operatii.derivare(P1);
        assertEquals("1.0+6.0x",rez4.toString());
    }
    @Test
    public void derivareTesFail() {
        Polinom P1;
        P1 = new Polinom();
        P1.addMonom(2, 3.0);
        P1.addMonom(1, 1.0);
        P1.addMonom(0, 1.0);


        Polinom rez = new Polinom();

        rez.addMonom(1, 6.0);
        rez.addMonom(0, 1.0);

        Polinom rez4 = new Polinom();
        rez4=Operatii.derivare(P1);
        assertNotEquals("1.0+10.0x",rez4.toString());
    }
    @Test
    public void integrareTest() {
        Polinom P1;
        P1 = new Polinom();
        P1.addMonom(2, 3.0);
        P1.addMonom(1, 1.0);
        P1.addMonom(0, 1.0);


        Polinom rez = new Polinom();

        rez.addMonom(3, 1.0);
        rez.addMonom(2, 0.5);
        rez.addMonom(1, 1.0);

        Polinom rez5 = new Polinom();
        rez5=Operatii.integrare(P1);
        assertEquals("x+0.5x^2+x^3",rez5.toString());
    }
    @Test
    public void integrareTestFail() {
        Polinom P1;
        P1 = new Polinom();
        P1.addMonom(2, 3.0);
        P1.addMonom(1, 1.0);
        P1.addMonom(0, 1.0);


        Polinom rez = new Polinom();

        rez.addMonom(3, 1.0);
        rez.addMonom(2, 0.5);
        rez.addMonom(1, 1.0);

        Polinom rez5 = new Polinom();
        rez5=Operatii.integrare(P1);
        assertNotEquals("5x+0.5x^2+x^3",rez5.toString());
    }
}