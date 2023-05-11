package model;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;

    public Server(int maxTasksPerServer) {
        this.tasks = new ArrayBlockingQueue<Task>(maxTasksPerServer);
        this.waitingPeriod = new AtomicInteger();

    }
    public void addTask(Task newTask) {
        //add task to queue
        //increment waitingPeriod
        this.tasks.add(newTask);
        waitingPeriod.addAndGet(newTask.getServiceTime());
    }

    public void deleteTask() {
        for (int i = 0; i < tasks.size(); i++)
            if (tasks.peek().getServiceTime() == 0) {
                tasks.remove();
            }
    }

    public void run() {
        while (true) {

            if (!tasks.isEmpty()) {
                Task currentTask = new Task(0, 0);
                currentTask = tasks.peek();
                if (currentTask != null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //decrement yhe waitingPeriod
                this.waitingPeriod.addAndGet(-currentTask.getServiceTime());
            }
        }
    }


    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    //    public  int getWaitingPeriod() {
//        return waitingPeriod.intValue();
    //}
//    @Override
//    public String toString() {
//        if(tasks.size() == 0)
//            return "close";
//        return "tasks=" + tasks;
//    }

}