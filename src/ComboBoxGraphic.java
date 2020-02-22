import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxGraphic extends JPanel
implements ActionListener {
	JLabel label;
	JLabel picture;

	public ComboBoxGraphic() {
		super(new BorderLayout());

		String[] options = { "Cartesian", "Polar"};

		//Create the combo box.
		JComboBox cBoxList = new JComboBox(options);
		cBoxList.setBounds(10, 400, 123, 25);
		cBoxList.setSelectedIndex(0);
		cBoxList.addActionListener(this);

		//Set up the picture.
		label = new JLabel();
		picture = new JLabel();
		updateLabel(options[cBoxList.getSelectedIndex()]);
		//picture.setBounds(0, 230, 123, 20);
		picture.setPreferredSize(new Dimension(475,475));

		add(cBoxList);
		add(picture, BorderLayout.EAST);
		//add(label, BorderLayout.PAGE_END);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
	}

	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		String options = (String)cb.getSelectedItem();
		updateLabel(options);
	}

	protected void updateLabel(String name) {
		ImageIcon icon = createImageIcon("/" + name + ".jpg");
		picture.setIcon(icon);
		picture.setToolTipText("Graph: " + name.toLowerCase());
		if (icon != null) {
			picture.setText(null);
		} else {
			picture.setText("Image not found");
		}
	}

	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = ComboBoxGraphic.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}