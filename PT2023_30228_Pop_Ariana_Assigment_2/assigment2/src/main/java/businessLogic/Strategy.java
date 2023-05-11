package businessLogic;

import model.Server;
import model.Task;

import java.util.*;

public interface Strategy {
    public void addTask(List<Server> servers, Task t);

}