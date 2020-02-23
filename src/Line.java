import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;


public class Line extends JPanel{

	private SaveCoordinates coords = new SaveCoordinates();
	List<Integer> list = coords.getCoordinates();

	//paint the components
	@Override 
	public void paintComponent(Graphics g)
	{  	    	
		super.paintComponent(g);
		g.drawLine(list.get(0), list.get(1), list.get(2), list.get(3)); // x1, y1, x2, y2   
	}
}
