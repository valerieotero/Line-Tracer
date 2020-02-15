import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LineTracer extends JPanel{

	private JFrame frame;
	private JTextField inputX;
	private JTextField inputY;

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
			
		frame = new JFrame();		
		frame.setBounds(100, 100, 611, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inputX = new JTextField();
		inputX.setBounds(28, 124, 28, 20);
		frame.getContentPane().add(inputX);
		inputX.setColumns(10);
		
		inputY = new JTextField();
		inputY.setBounds(28, 155, 28, 20);
		frame.getContentPane().add(inputY);
		inputY.setColumns(10);
		
		JLabel lblX = new JLabel("x =");
		lblX.setBounds(10, 127, 28, 14);
		frame.getContentPane().add(lblX);
		
		JLabel lblY = new JLabel("y =");
		lblY.setBounds(10, 158, 17, 14);
		frame.getContentPane().add(lblY);
		
//		JLabel lblR = new JLabel("R =");
//		lblX.setBounds(10, 127, 28, 14);
//		frame.getContentPane().add(lblX);
//		
//		JLabel lblAngle = new JLabel("Angle =");
//		lblY.setBounds(10, 158, 17, 14);
//		frame.getContentPane().add(lblY);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnter.setBounds(10, 186, 123, 23);
		frame.getContentPane().add(btnEnter);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(10, 280, 123, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnBackToOrigin = new JButton("Back to origin");
		btnBackToOrigin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBackToOrigin.setIcon(null);
		btnBackToOrigin.setBounds(10, 314, 123, 23);
		frame.getContentPane().add(btnBackToOrigin);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 44, 123, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Cartesian");
		comboBox.addItem("Polar");
		
		JLabel lblTypeOfCoordinates = new JLabel("Type of coordinates:");
		lblTypeOfCoordinates.setBounds(10, 19, 123, 14);
		frame.getContentPane().add(lblTypeOfCoordinates);
		
		JLabel lblActions = new JLabel("Actions:");
		lblActions.setBounds(10, 255, 75, 14);
		frame.getContentPane().add(lblActions);
		
		JLabel lblEnterCoordinates = new JLabel("Enter coordinates:");
		lblEnterCoordinates.setBounds(10, 99, 136, 14);
		frame.getContentPane().add(lblEnterCoordinates);
		
		JComboBox comboBox_TypeofGraphic = new JComboBox();
		comboBox_TypeofGraphic.setBounds(317, 317, 123, 20);
		frame.getContentPane().add(comboBox_TypeofGraphic);
		comboBox_TypeofGraphic.addItem("Cartesian");
		comboBox_TypeofGraphic.addItem("Polar");
		
		JLabel lblTypeOfGraphic = new JLabel("Type of Graphic:");
		lblTypeOfGraphic.setBounds(317, 297, 106, 14);
		frame.getContentPane().add(lblTypeOfGraphic);
		Border blackline = BorderFactory.createLineBorder(Color.blue);	
	
	}	
	
	private void createEvent() {
		
	}
}
