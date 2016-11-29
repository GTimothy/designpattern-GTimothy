package eu.telecomnancy.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;

import eu.telecomnancy.sensor.SensorNotActivatedException;

public class RoundedWindowDecorator extends WindowDecorator{
	private JButton button= new JButton("Round °C");
	private Double temp=0.0;

	public RoundedWindowDecorator (final ISensorView windowToBeDecorated) {
		super(windowToBeDecorated);
		button.setContentAreaFilled(false);

		button.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				button.setContentAreaFilled(false);

			}

			@Override
			public void focusGained(FocusEvent e) {
				button.setContentAreaFilled(true);

			}
		});
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					temp=windowToBeDecorated.getValue();
					temp = temp*100;
					temp = (double) Math.round(temp);
					temp = temp /100;
					update(temp);
				
				

			}
		});

		windowToBeDecorated.addComponent(button);
	}





}
