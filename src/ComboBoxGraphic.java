import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/*
 * ComboBoxDemo.java uses these additional files:
 *   images/Bird.gif
 *   images/Cat.gif
 *   images/Dog.gif
 *   images/Rabbit.gif
 *   images/Pig.gif
 */
public class ComboBoxGraphic extends JPanel
                          implements ActionListener {
    JLabel label;
    JLabel picture;
 
    public ComboBoxGraphic() {
        super(new BorderLayout());
 
        String[] options = { "Cartesian", "Polar"};
 
        //Create the combo box, select the item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        JComboBox cBoxList = new JComboBox(options);
        cBoxList.setBounds(10, 400, 123, 25);
        cBoxList.setSelectedIndex(0);
        cBoxList.addActionListener(this);
 
        //Set up the picture.
        label = new JLabel();
        //label.setBounds(0, 0, 800, 600);
        //picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        //picture.setHorizontalAlignment(JLabel.CENTER);
        picture = new JLabel();
        updateLabel(options[cBoxList.getSelectedIndex()]);
        picture.setBounds(0, 230, 123, 20);
        //picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
 
        //The preferred size is hard-coded to be the width of the
        //widest image and the height of the tallest image + the border.
        //A real program would compute this.
        picture.setPreferredSize(new Dimension(475,475));
 
        //Lay out the demo.
        add(cBoxList);
        add(picture, BorderLayout.EAST);
        add(label, BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
    }
 
    /** Listens to the combo box. */
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
 
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ComboBoxGraphic.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("ComboBoxDemo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 
//        //Create and set up the content pane.
//        JComponent newContentPane = new ComboBoxDemo();
//        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);
// 
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
// 
//    public static void main(String[] args) {
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
}