import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

public class Circle extends JPanel {
	
	private SaveCoordinates coordinates = new SaveCoordinates();
	List<Integer> listCircle = coordinates.getCoordinates();

	public void paintComponent(Graphics g)
	{  	
		super.paintComponent(g);
		g.drawOval(listCircle.get(2) - 4, listCircle.get(3) - 4, 7, 7); 
	}

}