import java.util.ArrayList;
import java.util.List;

public class SaveCoordinates extends ArrayList<Integer> {

	ArrayList<Integer> coords = new ArrayList<>();	
		
	 /* Values for x1, y1, x2 and y2 are random for line testing. When plane image is set, x1 and y2 values should be 
	  * initialized to the (0,0) of the image position within in the frame. */
	
	public SaveCoordinates() {
		coords.add(10);   //x1
		coords.add(10);   //y1
		coords.add(10);   //x2 
		coords.add(80);   //y2
	}
	
	public ArrayList<Integer> getCoordinates() {
		return coords;
	}

	
	public void setCoordinates(ArrayList<Integer> xCoord) {
		 this.coords = xCoord;
	}	

}
