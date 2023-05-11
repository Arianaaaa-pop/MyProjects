package businessLogic;

import model.Server;
import model.Task;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy{
    @Override
    public void addTask(List<Server> servers, Task t) {

        int min = Integer.MAX_VALUE;
        int poz = 0;

        for(int i = 0; i < servers.size(); i ++){
            if(min > servers.get(i).getTasks().size()){
                poz = i;
                min = servers.get(i).getTasks().size();
            }
        }
        servers.get(poz).addTask(t);
    }
}