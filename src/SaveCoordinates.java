import java.util.ArrayList;

public class SaveCoordinates extends ArrayList<Integer> {

	ArrayList<Integer> coords = new ArrayList<>();	
		
	 /* Values for x1, y1, x2 and y2 are random for line testing. When plane image is set, x1 and y2 values should be 
	  * initialized to the (0,0) of the image position within in the frame. */
	public SaveCoordinates() {
		coords.add(0);   //x1, 237 is origin of the image
		coords.add(0);   //y1, 237 is origin of the image
		coords.add(0);   //x2 
		coords.add(0);   //y2
	}
	
	public ArrayList<Integer> getCoordinates() {
		System.out.println("getCoordinates" + coords);
		return coords;
	}

	
	public void setCoordinates(ArrayList<Integer> xCoord) {
		 this.coords = xCoord;
	}	

}