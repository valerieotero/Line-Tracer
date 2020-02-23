import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.Color;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LineTracer extends JPanel{

	int inputFromX = 0;
	int inputFromY = 0;
	private JFrame frame;
	private JTextField inputX;
	private JTextField inputY;	
	public JLabel label;
	public JLabel label2;
	public Line line;
	public Integer coord[] = {0,0,0,0};	
	public JLabel lblX = new JLabel("x =");
	public JLabel lblY = new JLabel("y =");
	public JLabel lblR = new JLabel("r =");
	public JLabel lblA = new JLabel("ang =");


	public JComboBox<String> comboBox_TypeofGraphic;

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
	}


	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		//MAIN FRAME
		frame = new JFrame();		
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		//TYPE OF GRAPHIC DROPDOWN
//		JComponent newContentPane = new ComboBoxGraphic();
//		newContentPane.setOpaque(true);
//		frame.setContentPane(newContentPane);

		// X TEXT FIELD 
		inputX = new JTextField();
		inputX.setBounds(45, 124, 28, 20);
		frame.getContentPane().add(inputX);
		inputX.setColumns(10);


		// Y TEXT FIELD
		inputY = new JTextField();
		inputY.setBounds(45, 155, 28, 20);
		frame.getContentPane().add(inputY);
		inputY.setColumns(10);


		// X TEXT FIELD LABEL
		lblX = new JLabel("x =");
		lblX.setBounds(10, 127, 28, 14);
		frame.getContentPane().add(lblX);		

		// Y TEXT FIELD LABEL
		JLabel lblY = new JLabel("y =");
		lblY.setBounds(10, 158, 17, 14);
		frame.getContentPane().add(lblY);

		//TYPE OF GRAPHIC LABEL
		JLabel lblTypeOfGraphic = new JLabel("Type of Graphic:");
		lblTypeOfGraphic.setBounds(10, 375, 106, 14);
		frame.getContentPane().add(lblTypeOfGraphic);

		//ENTER BUTTON
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					inputFromX = Integer.parseInt(inputX.getText());   //receive input from x text field
					inputFromY = Integer.parseInt(inputY.getText());   //receive input from y text field

					if(dataValidation(inputFromX, inputFromY)) { 
						JOptionPane.showMessageDialog(null, "Number must be less than or equal to 20", "Warning", JOptionPane.INFORMATION_MESSAGE);
					} else {
						planeCoordinates(inputFromX, inputFromY);
						coordinateArray(coord[2], coord[3], inputFromX, inputFromY);
						drawing();
					}
				}
				catch(NumberFormatException ex) {
					System.out.println("Not a number, try again");
				}
			}
		});
		btnEnter.setBounds(10, 186, 123, 23);
		frame.getContentPane().add(btnEnter);


		//RESET BUTTON
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnReset.setBounds(10, 280, 123, 23);
		frame.getContentPane().add(btnReset);


		//BACK TO ORIGIN BUTTON
		JButton btnBackToOrigin = new JButton("Back to origin");
		btnBackToOrigin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputX.setText("0");
				inputY.setText("0");

				coord[2] = 0;
				coord[3] = 0;
			}
		});
		btnBackToOrigin.setIcon(null);
		btnBackToOrigin.setBounds(10, 314, 123, 23);
		frame.getContentPane().add(btnBackToOrigin);


		//TYPE OF COORDINATES DROPDOWN
		JComboBox comboBox_typeOfCoordinates = new JComboBox<String>();
		comboBox_typeOfCoordinates.addItem("Cartesian");
		comboBox_typeOfCoordinates.addItem("Polar");
		comboBox_typeOfCoordinates.setBounds(10, 44, 123, 20);
		frame.getContentPane().add(comboBox_typeOfCoordinates);
		comboBox_typeOfCoordinates.setSelectedIndex(0);
		comboBox_typeOfCoordinates.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				String options = (String) cb.getSelectedItem();	
				try {

					if(options.equals("Cartesian")) {
						lblR.setVisible(false);
						lblA.setVisible(false);

						// X TEXT FIELD LABEL
						lblX.setBounds(10, 127, 28, 14);
						lblX.setVisible(true);
						frame.getContentPane().add(lblX);

						// Y TEXT FIELD LABEL
						lblY.setBounds(10, 158, 28, 14);
						lblY.setVisible(true);
						frame.getContentPane().add(lblY);

						//DUMMY LABEL ***IMPORTANT***
						JLabel nuller = new JLabel("");
						frame.getContentPane().add(nuller);
					}
					if(options.equals("Polar")) {
						lblX.setVisible(false);
						lblY.setVisible(false);

						// R TEXT FIELD LABEL
						lblR.setBounds(9, 127, 28, 14);
						lblR.setVisible(true);
						frame.getContentPane().add(lblR);

						// A TEXT FIELD LABEL
						lblA.setBounds(9, 158, 50/*17*/, 14);
						lblA.setVisible(true);
						frame.getContentPane().add(lblA);

						//DUMMY LABEL ***IMPORTANT***
						JLabel nuller = new JLabel("");
						frame.getContentPane().add(nuller);
					}
				}
				catch(NumberFormatException ex) {
					System.out.println("");
				}

			}

		});


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

		//DUMMY LABEL *IMPORTANT*
		JLabel nuller = new JLabel("");
		frame.getContentPane().add(nuller);
		frame.setVisible(true);

		//DUMMY LABEL ***IMPORTANT***
		JLabel nuller1 = new JLabel("");
		frame.getContentPane().add(nuller1);
	}

	//Helper methods

	//validates that the input X and Y are less than 20 to stay inside the Cartesian plane
	public boolean dataValidation(Integer x, Integer y) {
		if(x > 20 || y > 20) { //only save when its input<20
			return true;
		}
		return false;
	}

	//changes the plane coordinates direction
	public void planeCoordinates(Integer x, Integer y) {
		if(x >= 0 && y >= 0) y = -1*y;
		else if (x >= 0 && y < 0) y = -1*y;
		else if (x < 0 && y >= 0) y = -1*y;
		else y = -1*y;
		
		inputFromX = x;
		inputFromY = y;
	}
	
	//changes the values inside the array to draw the lines
	public void coordinateArray(Integer x1, Integer y1, Integer x2, Integer y2) {
		coord[0] = x1;
		coord[1] = y1;
		coord[2] = x2;
		coord[3] = y2;
	}
	
	//draw and create the lines
	public void drawing() {
		line = new Line();	
		line.setForeground(Color.RED); //Color of line. change late
		line.setOpaque(false); //make canvas color transparent so line can appear in front of plane
		line.setBounds(225, 20, 475, 475); //These bounds should be the same as the plane image bound
		frame.getContentPane().add(line);

		line.list.set(0,coord[0]*12 + 237);
		line.list.set(1,coord[1]*12 + 237);
		line.list.set(2,coord[2]*12 + 237);
		line.list.set(3,coord[3]*12 + 237);
		line.repaint();
	}
}
