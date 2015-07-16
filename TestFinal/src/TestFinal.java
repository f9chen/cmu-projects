/** 
 * Final Exam
 * Click the button and a message dialog box will open.
 * Author : Fan CHEN 
 * Date: Dec 15, 2011
 * Andrew ID: fanc
 * File Name: TestFinal.java
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JApplet;

public class TestFinal extends JApplet {
	private JButton b1 = new JButton("Dear Professor");
	private MyDialog dlg = new MyDialog(null);

	public void init() {
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.show();
			}
		});
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b1);
		// add the button
	}

	class MyDialog extends JDialog {
		public MyDialog(JFrame parent) {
			super(parent, "My dialog", true);
			Container cp = getContentPane();
			cp.setLayout(new FlowLayout());
			cp.add(new JLabel("Happy Holidays!"));
			// display the dialog content
			JButton ok = new JButton("OK");
			ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose(); // Closes the dialog
				}
			});
			cp.add(ok);
			setSize(150, 125);
		}
	}
}