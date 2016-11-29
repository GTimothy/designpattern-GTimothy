package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.ISensor;

import javax.swing.*;

import java.awt.*;

public class MainWindow extends JFrame {

    private ISensor sensor;
    private WindowDecorator sensorView;

    public MainWindow(ISensor sensor) {
        this.sensor = sensor;
        this.sensorView = new ConversionWindowDecorator(new RoundedWindowDecorator(new SensorView(this.sensor)));
        
        this.setLayout(new BorderLayout());
        this.add(this.sensorView.getPanel(), BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


}
