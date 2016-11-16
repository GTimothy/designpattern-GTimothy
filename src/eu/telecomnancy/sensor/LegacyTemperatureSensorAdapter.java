package eu.telecomnancy.sensor;

public class LegacyTemperatureSensorAdapter implements ISensor {
	private LegacyTemperatureSensor lts;
	
	public LegacyTemperatureSensorAdapter(LegacyTemperatureSensor legacyTemperatureSensor) {
		this.lts=legacyTemperatureSensor;
	}
	
	
	@Override
	public void on() {	
		if (!lts.getStatus())
			lts.onOff();
		
	}

	@Override
	public void off() {
		if (getStatus())
			lts.onOff();
		
	}

	@Override
	public boolean getStatus() {
		return lts.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		if (lts.getStatus()){
           lts.onOff();
           lts.onOff();           
		}
		
        else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
		
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		if (lts.getStatus()){
			return lts.getTemperature();
		}else{throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
		}
	}
}
