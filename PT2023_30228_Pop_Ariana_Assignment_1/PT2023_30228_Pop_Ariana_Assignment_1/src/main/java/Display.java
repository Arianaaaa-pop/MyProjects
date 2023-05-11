import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display {
    private JFrame frame;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JLabel l0;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JButton btnAdd;
    private JButton btnDiff;
    private JButton btnX;
    private JButton btnDerivare;
    private JButton btnIntegare;
    private JButton reset;

    String polinom1;
    String polinom2;

    Polinom p1 = new Polinom();
    Polinom p2 = new Polinom();
    Polinom p3 = new Polinom();
    Operatii o = new Operatii();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Display window = new Display();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Display() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Calculator de polinoame");
        frame.setSize(700, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(0, 1));

        frame.getContentPane().setBackground(new Color(255, 10, 127));

        JPanel panel0 = new JPanel(new FlowLayout());
        l0 = new JLabel("Introduceti polinoamele in format ax^b+cx^d-f de exemplu 3+2x+3x^2");
        l0.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel0.add(l0);

        panel0.setBackground(new Color(206, 206, 237));
        frame.getContentPane().add(panel0);

        JPanel panel1 = new JPanel(new FlowLayout());
        l1 = new JLabel("Polinomul 1");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel1.add(l1);

        t1 = new JTextField();
        t1.setColumns(20);
        t1.setBackground(new Color(163, 235, 235));
        panel1.add(t1);

        panel1.setBackground(new Color(163, 163, 226));
        frame.getContentPane().add(panel1);

        JPanel panel2 = new JPanel(new FlowLayout());
        l2 = new JLabel("Polinomul 2");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel2.add(l2);

        t2 = new JTextField();
        t2.setColumns(20);
        t2.setBackground(new Color(163, 235, 235));
        panel2.add(t2);

        panel2.setBackground(new Color(149, 149, 245));
        frame.getContentPane().add(panel2);

        JPanel panel3 = new JPanel(new FlowLayout());
        l3 = new JLabel("REZULTAT");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel3.add(l3);

        t3 = new JTextField();
        t3.setColumns(20);
        t3.setBackground(new Color(163, 235, 235));
        panel3.add(t3);

        panel3.setBackground(new Color(127, 127, 216));
        frame.getContentPane().add(panel3);

        btnAdd = new JButton("+");
        btnAdd.setBackground(new Color(249, 196, 206));

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                polinom1 = t1.getText();
                polinom2 = t2.getText();
                p1.fromString(polinom1);
                p2.fromString(polinom2);
                p3 = Operatii.add(p1, p2);
                t3.setText(p3.toString());
            }
        });
        frame.getContentPane().add(btnAdd);

        btnDiff = new JButton("-");
        btnDiff.setBackground(new Color(251, 169, 181));

        btnDiff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                polinom1 = t1.getText();
                polinom2 = t2.getText();
                p1.fromString(polinom1);
                p2.fromString(polinom2);
                p3 = Operatii.diff(p1, p2);
                t3.setText(p3.toString());
            }
        });
        frame.getContentPane().add(btnDiff);

        btnX = new JButton("X");
        btnX.setBackground(new Color(249, 156, 170));
        btnX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                polinom1 = t1.getText();
                polinom2 = t2.getText();
                p1.fromString(polinom1);
                p2.fromString(polinom2);
                p3 = Operatii.multiply(p1, p2);
                t3.setText(p3.toString());
            }
        });
        frame.getContentPane().add(btnX);


        btnDerivare = new JButton("derivare; se deriveaza polinomul 1");
        btnDerivare.setBackground(new Color(245, 130, 147));

        btnDerivare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                polinom1 = t1.getText();
                p1.fromString(polinom1);
                p3 = Operatii.derivare(p1);
                t3.setText(p3.toString());
            }
        });
        frame.getContentPane().add(btnDerivare);

        btnIntegare = new JButton("integrare; se integreaza polinomul 1");
        btnIntegare.setBackground(new Color(248, 107, 129));

        btnIntegare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                polinom1 = t1.getText();
                p1.fromString(polinom1);
                p3 = Operatii.integrare(p1);
                t3.setText(p3.toString());
            }
        });
        frame.getContentPane().add(btnIntegare);

        reset = new JButton("reset casute");
        reset.setBackground(new Color(244, 59, 87));

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                polinom1 = "";
                polinom2 = "";
            }
        });
        frame.getContentPane().add(reset);
        frame.setVisible(true);

    }

}