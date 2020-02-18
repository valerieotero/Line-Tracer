import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;

import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Canvas;

public class LineTracer extends JPanel{

	private JFrame frame;
	private JTextField inputX;
	private JTextField inputY;	

	ArrayList<Integer> x = new ArrayList<Integer>();
	ArrayList<Integer> y = new ArrayList<Integer>();


	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LineTracer window = new LineTracer();					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

	/*
	 * Create the application.
	 */
	public LineTracer() {
		initialize();
		createEvent();

	}

	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		//MAIN FRAME
		frame = new JFrame();		
		frame.setBounds(100, 100, 611, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// X TEXT FIELD 
		inputX = new JTextField();
		inputX.setBounds(28, 124, 28, 20);
		frame.getContentPane().add(inputX);
		inputX.setColumns(10);


		// Y TEXT FIELD
		inputY = new JTextField();
		inputY.setBounds(28, 155, 28, 20);
		frame.getContentPane().add(inputY);
		inputY.setColumns(10);


		// X TEXT FIELD LABEL
		JLabel lblX = new JLabel("x =");
		lblX.setBounds(10, 127, 28, 14);
		frame.getContentPane().add(lblX);


		// Y TEXT FIELD LABEL
		JLabel lblY = new JLabel("y =");
		lblY.setBounds(10, 158, 17, 14);
		frame.getContentPane().add(lblY);
		
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int inputFromX = 0;
				int inputFromY = 0;

				try {
					inputFromX = Integer.parseInt(inputX.getText());   //receive input from text field
					inputFromY = Integer.parseInt(inputY.getText());   //receive input from text field

					if (x.size() == 2 && y.size() == 2) {
						x.remove(0);
						y.remove(0);
					}

					x.add(inputFromX);
					y.add(inputFromY);										

				}
				catch(NumberFormatException ex) {
					System.out.println("Not a number, try again");
				}

				System.out.println(x);		
				System.out.println(y);

			}
		});


		btnEnter.setBounds(10, 186, 123, 23);
		frame.getContentPane().add(btnEnter);


		//RESET BUTTON
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(10, 280, 123, 23);
		frame.getContentPane().add(btnReset);


		//BACK TO ORIGIN BUTTON
		JButton btnBackToOrigin = new JButton("Back to origin");
		btnBackToOrigin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBackToOrigin.setIcon(null);
		btnBackToOrigin.setBounds(10, 314, 123, 23);
		frame.getContentPane().add(btnBackToOrigin);


		//TYPE OF COORDINATES DROPDOWN
		JComboBox<String> comboBox_typeOfCoordinates = new JComboBox<String>();
		comboBox_typeOfCoordinates.setBounds(10, 44, 123, 20);
		frame.getContentPane().add(comboBox_typeOfCoordinates);
		comboBox_typeOfCoordinates.addItem("Cartesian");
		comboBox_typeOfCoordinates.addItem("Polar");


		//TYPE OF COORDIANTES LABEL
		JLabel lblTypeOfCoordinates = new JLabel("Type of coordinates:");
		lblTypeOfCoordinates.setBounds(10, 19, 123, 14);
		frame.getContentPane().add(lblTypeOfCoordinates);


		//ACTIONS LABEL
		JLabel lblActions = new JLabel("Actions:");
		lblActions.setBounds(10, 255, 75, 14);
		frame.getContentPane().add(lblActions);


		//ENTER COORDINATES LABEL
		JLabel lblEnterCoordinates = new JLabel("Enter coordinates:");
		lblEnterCoordinates.setBounds(10, 99, 136, 14);
		frame.getContentPane().add(lblEnterCoordinates);


		//TYPE OF GRAPHIC DROPDOWN
		JComboBox<String> comboBox_TypeofGraphic = new JComboBox<String>();
		comboBox_TypeofGraphic.setBounds(317, 317, 123, 20);
		frame.getContentPane().add(comboBox_TypeofGraphic);
		comboBox_TypeofGraphic.addItem("Cartesian");
		comboBox_TypeofGraphic.addItem("Polar");


		//TYPE OF GRAPHIC LABEL
		JLabel lblTypeOfGraphic = new JLabel("Type of Graphic:");
		lblTypeOfGraphic.setBounds(317, 297, 106, 14);
		frame.getContentPane().add(lblTypeOfGraphic);
		Border blackline = BorderFactory.createLineBorder(Color.blue);	
		
	
	}	
	
	private void createEvent() {
		
		Line line = new Line();
		line.setBounds(211, 11, 341, 282);
		frame.getContentPane().add(line);	 
	}
}
