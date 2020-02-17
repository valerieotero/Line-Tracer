
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Line extends JPanel{

    public void paint (Graphics g)
    {
    	super.paintComponent(g);
    	g.drawLine(10, 10,80, 10);    
    	g.drawLine(80, 10, 0, 80);
    }


}