package eu.telecomnancy.sensor;


public interface Observable {
	public void registerObserver(Observer o);
	public void unregisterObsever(Observer o);
	public void notifyObservers();

}
