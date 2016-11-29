package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.ui.cmd.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SensorView extends JPanel {
	private ISensor sensor;

    private JLabel value = new JLabel("N/A °C");
    private JButton on = new JButton("On");
    private JButton off = new JButton("Off");
    private JButton update = new JButton("Acquire");
    
    private Command onC,offC,updateC,getValueC;
    private Invoker commandInvoker = new Invoker();

    public SensorView(ISensor c) {
        this.sensor = c;
        onC = new onCommand(sensor);
        offC = new offCommand(sensor);
        updateC = new updateCommand(sensor);
        getValueC = new getValueCommand(sensor);
        this.setLayout(new BorderLayout());

        value.setHorizontalAlignment(SwingConstants.CENTER);
        Font sensorValueFont = new Font("Sans Serif", Font.BOLD, 18);
        value.setFont(sensorValueFont);

        this.add(value, BorderLayout.CENTER);


        on.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               commandInvoker.registerCommandAndExecute(onC);
            }
        });

        off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandInvoker.registerCommandAndExecute(offC);
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandInvoker.registerCommandAndExecute(updateC);
                double v = (double) commandInvoker.registerCommandAndExecute(getValueC);
                value.setText(""+v);
                

            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3));
        buttonsPanel.add(update);
        buttonsPanel.add(on);
        buttonsPanel.add(off);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }
}
