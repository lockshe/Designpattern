import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class TrafficLight {

	 protected Queue<Observer> observers=new LinkedList<>();

	 public abstract void addWaitObj(Observer observer);
	 public abstract void lightOn();
	 public abstract void deleteObj();
}
