package eu.telecomnancy.sensor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class TemperatureSensorProxy implements ISensor {
    private TemperatureSensor temperatureSensor=new TemperatureSensor();
    static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    
    
    @Override
    public void on() {
    	temperatureSensor.on();
    	log("on()");
    }




	@Override
    public void off() {
        temperatureSensor.off();
        log("off()");
    }

    @Override
    public boolean getStatus() {
    	return (boolean) log("getStatus()",temperatureSensor.getStatus());
    }

    @Override
    public void update() throws SensorNotActivatedException {
        try{
        	temperatureSensor.update();
        	log("update()");
        }
        catch(SensorNotActivatedException E){
        	log("update()");
        	E.printStackTrace();
        }
        
    }

    @Override
    public double getValue() throws SensorNotActivatedException {  
    	try{
    		return (double) log("getValue()",temperatureSensor.getValue());
        }
        catch(SensorNotActivatedException E){
        	log("getValue()","exception thrown:");
        	throw E;
        }
    	
    }


    private Object log(String function, Object object) {
    	String result = " -returned-> "+object.toString();
		System.out.println(dateFormat.format(Calendar.getInstance().getTime())+ " : "+function  + result);
		return object;
		
	}
    

	private void log(String function) {
		System.out.println(dateFormat.format(Calendar.getInstance().getTime())+ " : "+function + "(void function)");
		
	}


}
