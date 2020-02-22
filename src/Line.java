import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class Line extends JPanel{
	
	private SaveCoordinates coords = new SaveCoordinates();
	
	List<Integer> list = coords.getCoordinates();
          
    public void paint (Graphics g)
    {  	    	
    	super.paintComponent(g);
    	g.drawLine(list.get(0), list.get(1), list.get(2), list.get(3)); // x1, y1, x2, y2   
    	//g.drawLine(00, 10, 100, 80);
    }
}