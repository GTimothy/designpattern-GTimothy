package eu.telecomnancy.sensor;

public interface SensorState {
    public void on();
    public void off();
    public boolean getStatus();
    public void update() throws SensorNotActivatedException;
    public double getValue() throws SensorNotActivatedException;

}
