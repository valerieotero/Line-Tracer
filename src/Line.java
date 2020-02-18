
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Line extends JPanel{

	public void paint (Graphics g)
    {
    	super.paintComponent(g);
    	//g.drawLine(x1, y1, x2, y2);    
    	g.drawLine(10, 10, 0, 80);
    }
}