package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SensorView extends JPanel implements ISensorView {
    
	private ISensor sensor;

    private Box centralBox = Box.createHorizontalBox();

    private JLabel value = new JLabel("             N/A °C           ");
    private Double v=0.0;
    private JButton on = new JButton("On");
    private JButton off = new JButton("Off");
    private JButton update = new JButton("Acquire");

    public SensorView(ISensor c) {
        this.sensor = c;
        this.setLayout(new BorderLayout());

        value.setHorizontalAlignment(SwingConstants.CENTER);
        Font sensorValueFont = new Font("Sans Serif", Font.BOLD, 18);
        value.setFont(sensorValueFont);


        centralBox.add(Box.createHorizontalGlue());
        centralBox.add(value);
        centralBox.add(Box.createHorizontalGlue());
        
        this.add(centralBox, BorderLayout.CENTER);


        on.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sensor.on();
            }
        });

        off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sensor.off();
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	sensor.update();
                	v=sensor.getValue();
                	value.setText(""+ v);
                } catch (SensorNotActivatedException sensorNotActivatedException) {
                    sensorNotActivatedException.printStackTrace();
                }
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3));
        buttonsPanel.add(update);
        buttonsPanel.add(on);
        buttonsPanel.add(off);
        on.requestFocus();
        on.requestFocusInWindow();
        on.requestFocus(true);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

	@Override
	public void update(Double d) {
		this.value.setText(""+d);
	}

	@Override
	public void addComponent(Component c) {
		centralBox.add(Box.createHorizontalGlue());
		centralBox.add(c);
		centralBox.add(Box.createHorizontalGlue());


	}

	@Override
	public JPanel getPanel() {
		return this;
	}

	@Override
	public double getValue(){
		return v;
	}
}
