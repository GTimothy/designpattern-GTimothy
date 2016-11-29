package eu.telecomnancy.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;


public class ConversionWindowDecorator extends WindowDecorator{
	private JButton button= new JButton("Convert to F");

	public ConversionWindowDecorator (final ISensorView windowToBeDecorated) {
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

				Double temp=windowToBeDecorated.getValue();
				update(temp);

			}
		});
		windowToBeDecorated.addComponent(button);
	}

	@Override
	public void update(Double d) {
		Double dd = d*1.8/32;
		windowToBeDecorated.update(dd);

	}


	@Override
	public void addComponent(Component c) {
		windowToBeDecorated.addComponent(c);

	}


	@Override
	public double getValue(){
		return windowToBeDecorated.getValue();
	}

}
