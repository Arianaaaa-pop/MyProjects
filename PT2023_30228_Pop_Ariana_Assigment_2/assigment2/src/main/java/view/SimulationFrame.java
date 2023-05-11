package view;

import businessLogic.SimulationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationFrame extends JFrame {
    private SimulationManager sim;
    private static JTextArea textArea;
    private JScrollPane scrollPane;
    private JFrame frame;
    private JButton start;
    private JButton reset;
    private JTextField simTime;
    private JTextField clients;
    private JTextField queues;
    private JTextField minArrival;
    private JTextField maxArrival;
    private JTextField minProcessing;
    private JTextField maxProcessing;

    /**
     * Create the application.
     */
    public SimulationFrame() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SimulationFrame window = new SimulationFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("QUEUE MANAGER");
        frame.setBounds(100, 100, 737, 691);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.getContentPane().setBackground(new Color(249, 196, 206));

        textArea = new JTextArea("");
        textArea.setBounds(10, 286, 1004, 314);
        textArea.setEditable(false);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 22, 701, 292);
        frame.getContentPane().add(scrollPane);

        simTime = new JTextField();
        simTime.setBounds(242, 341, 86, 20);
        frame.getContentPane().add(simTime);
        simTime.setColumns(10);

        clients = new JTextField();
        clients.setBounds(242, 383, 86, 20);
        clients.setColumns(10);
        frame.getContentPane().add(clients);

        queues = new JTextField();
        queues.setBounds(242, 424, 86, 20);
        queues.setColumns(10);
        frame.getContentPane().add(queues);

        minArrival = new JTextField();
        minArrival.setBounds(242, 472, 86, 20);
        minArrival.setColumns(10);
        frame.getContentPane().add(minArrival);

        maxArrival = new JTextField();
        maxArrival.setBounds(242, 523, 86, 20);
        maxArrival.setColumns(10);
        frame.getContentPane().add(maxArrival);

        minProcessing = new JTextField();
        minProcessing.setBounds(242, 566, 86, 20);
        minProcessing.setColumns(10);
        frame.getContentPane().add(minProcessing);

        maxProcessing = new JTextField();
        maxProcessing.setBounds(242, 609, 86, 20);
        maxProcessing.setColumns(10);
        frame.getContentPane().add(maxProcessing);

        JLabel lblSimTime = new JLabel("Simulation Time");
        lblSimTime.setBounds(25, 344, 167, 14);
        frame.getContentPane().add(lblSimTime);

        JLabel lblNumberOfClinets = new JLabel("Number of Clients");
        lblNumberOfClinets.setBounds(25, 386, 167, 14);
        frame.getContentPane().add(lblNumberOfClinets);

        JLabel lblNumberOfQueues = new JLabel("Number of Queues");
        lblNumberOfQueues.setBounds(25, 427, 167, 14);
        frame.getContentPane().add(lblNumberOfQueues);

        JLabel lblMinArrivalTime = new JLabel("Min Arrival Time");
        lblMinArrivalTime.setBounds(25, 475, 167, 14);
        frame.getContentPane().add(lblMinArrivalTime);

        JLabel lblMaxArrivalTime = new JLabel("Max Arrival Time");
        lblMaxArrivalTime.setBounds(25, 526, 167, 14);
        frame.getContentPane().add(lblMaxArrivalTime);

        JLabel lblMinProcessingTime = new JLabel("Min Processing Time");
        lblMinProcessingTime.setBounds(25, 566, 167, 14);
        frame.getContentPane().add(lblMinProcessingTime);

        JLabel lblMaxProcessingTime = new JLabel("Max Processing Time");
        lblMaxProcessingTime.setBounds(25, 612, 167, 14);
        frame.getContentPane().add(lblMaxProcessingTime);

        start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int time = Integer.parseInt(getSimTime());
                int maxArrival = Integer.parseInt(getMaxArrival());
                int minArrival = Integer.parseInt((getMinArrival()));
                int minService = Integer.parseInt(getMinProcessing());
                int maxSerivce = Integer.parseInt(getMaxProcessing());
                int nrClients = Integer.parseInt(getClients());
                int nrQueues = Integer.parseInt(getQueues());

                sim = new SimulationManager(maxArrival, minArrival, maxSerivce, minService, nrClients, nrQueues, time);
                Thread t = new Thread(sim);
                t.start();
//                sim = new SimulationManager(30, 2, 4, 2, 4, 2, 60);
//                Thread t = new Thread(sim);
//                t.start();
            }
        });
        start.setBounds(513, 359, 89, 23);
        frame.getContentPane().add(start);

        reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getSimTime1().setText("");
                getMaxArrival1().setText("");
                getMinArrival1().setText("");
                getMaxProcessing1().setText("");
                getMinProcessing1().setText("");
                getClients1().setText("");
                getQueues1().setText("");
                SimulationFrame.getTextArea().setText("");
            }
        });
        reset.setBounds(513, 423, 89, 23);
        frame.getContentPane().add(reset);

        frame.setVisible(true);
    }

    public String getSimTime() {
        return simTime.getText();
    }

    public String getQueues() {
        return queues.getText();
    }

    public String getMinArrival() {
        return minArrival.getText();
    }

    public String getClients() {
        return clients.getText();
    }

    public String getMaxArrival() {
        return maxArrival.getText();
    }

    public String getMinProcessing() {
        return minProcessing.getText();
    }

    public String getMaxProcessing() {
        return maxProcessing.getText();
    }


    public JTextField getSimTime1() {
        return simTime;
    }

    public JTextField getClients1() {
        return clients;
    }

    public JTextField getQueues1() {
        return queues;
    }

    public JTextField getMinArrival1() {
        return minArrival;
    }

    public JTextField getMaxArrival1() {
        return maxArrival;
    }

    public JTextField getMinProcessing1() {
        return minProcessing;
    }

    public JTextField getMaxProcessing1() {
        return maxProcessing;
    }
    public static JTextArea getTextArea() {
        return textArea;
    }

}