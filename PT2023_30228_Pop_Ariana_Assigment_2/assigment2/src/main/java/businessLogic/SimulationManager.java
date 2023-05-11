package businessLogic;

import model.Server;
import model.Task;
import view.SimulationFrame;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class SimulationManager implements Runnable {
    private int timeLimit;
    private int maxProcessingTime;
    private int minProcessingTime;
    private int maxArrivalTime;
    private int minArrivalTime;
    private int numberOfServers;
    private int numberOfClients;
    private SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_QUEUE;
    private Scheduler scheduler;
    private List<Task> generatedTasks;
    private float averageWaitingTime;
    private int peekHour;
    private float averageServiceTime;
    int avg;

    public SimulationManager(int maxArrivalTime, int minArrivalTime, int maxProcessingTime, int minProcessingTime, int numberOfClients, int numberOfServers, int timeLimit) {
        this.maxArrivalTime = maxArrivalTime;
        this.minArrivalTime = minArrivalTime;
        this.maxProcessingTime = maxProcessingTime;
        this.minProcessingTime = minProcessingTime;
        this.numberOfServers = numberOfServers;
        this.numberOfClients = numberOfClients;
        this.timeLimit = timeLimit;
        this.averageWaitingTime = 0;
        this.peekHour = 0;
        this.averageServiceTime = 0;

        this.scheduler = new Scheduler(numberOfServers, numberOfClients);
        this.scheduler.changeStrategy(selectionPolicy);
        this.generateNRandomTasks();
    }

    private void generateNRandomTasks() {
        generatedTasks = new ArrayList<Task>(numberOfClients);
        for (int i = 0; i < numberOfClients; i++) {
            int pT = minProcessingTime + (int) (Math.random() * (maxProcessingTime - minProcessingTime));
            int aT = minArrivalTime + (int) (Math.random() * (maxArrivalTime - minArrivalTime));
            Task t = new Task(aT, pT);
            generatedTasks.add(t);

            avg += pT;
        }
        Collections.sort(generatedTasks);

        averageServiceTime = avg / numberOfClients;
        averageWaitingTime = avg/(numberOfClients*numberOfServers);
    }


    @Override
    public void run() {
        int currentTime = 0;
        int max = Integer.MIN_VALUE;
        float sum = 0;

        try {
            FileWriter file = new FileWriter("test2.txt");
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.print(generatedTasks.toString() + "\n");
            //aici scri is pt frame

            System.out.println(generatedTasks.toString() + "\n");

            while (currentTime < timeLimit) {
                for (int i = 0; i < generatedTasks.size(); i++) {
                    if (generatedTasks.get(i).getArrivalTime() == currentTime) {
                        scheduler.dispatchTask(generatedTasks.get(i));
                        generatedTasks.remove(i--);

                    }
                }
                
                SimulationFrame.getTextArea().append(generatedTasks.toString() + "\n");
                printWriter.print(generatedTasks.toString() + "\n");
                printWriter.print("Timp simulare " + currentTime + "\n");
                SimulationFrame.getTextArea().append("Timp simulare " + currentTime + "\n");
                System.out.println("Timp simulare " + currentTime + "\n");



                for (int i = 0; i < scheduler.getServers().size(); i++) {
                    String print = new String();
                    SimulationFrame.getTextArea().append("   Coada " + (i + 1) + ": ");
                    printWriter.print("   Coada " + (i + 1) + ": ");
                    System.out.println("   Coada " + (i + 1) + ": ");

                    print = scheduler.getServers().get(i).getTasks().toString();
                    printWriter.write(print + "\n");
                    SimulationFrame.getTextArea().append(print + "\n");
                    System.out.println(print + "\n");
                }

                sum = 0;

                for (int i = 0; i < scheduler.getServers().size(); i++) {
                    sum += scheduler.getServers().get(i).getTasks().size();
                }

                if (sum > max) {
                    max = (int) sum;
                    peekHour = currentTime;
                }

                for (int i = 0; i < scheduler.getServers().size(); i++) {
                    if (scheduler.getServers().get(i).getTasks().size() != 0) {
                        int time = scheduler.getServers().get(i).getTasks().peek().getServiceTime();
                        if (time > 0) {
                            scheduler.getServers().get(i).getTasks().peek().setServiceTime(time - 1);
                        } else {
                            scheduler.getServers().get(i).deleteTask();
                        }
                    }
                }

                    if (generatedTasks.isEmpty()) {
                        int cnt = 0;
                        for (Server s : scheduler.getServers()) {
                            if (s.getTasks().size() == 0)
                                cnt++;
                        }
                        if (cnt == numberOfServers)
                            currentTime = timeLimit;

                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    currentTime++;


            }
                printWriter.write("Peek hour is " + peekHour + ".\n");
                printWriter.write("Average waiting time is " + averageWaitingTime + ".\n");
                printWriter.write("Average service time is " + averageServiceTime + ".\n");
                printWriter.close();

                //aici scri si pt frame
                SimulationFrame.getTextArea().append("Peek hour is " + peekHour + ".\n");
                SimulationFrame.getTextArea().append("Average waiting time is " + averageWaitingTime + ".\n");
                SimulationFrame.getTextArea().append("Average service time is " + averageServiceTime + ".\n");


                System.out.println("Peek hour is " + peekHour + ".\n");
                System.out.println("Average waiting time is " + averageWaitingTime + ".\n");
                System.out.println("Average service time is " + averageServiceTime + ".\n");

            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

