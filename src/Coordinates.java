
public class Coordinates {

	public static void main(String[] args) {
		double x = 10, y = 10;
		double r = CartesianToPolarR(x, y);
		double angle = CartesianToPolarAngle (x, y);
		System.out.println("r = " + r);
		System.out.println("Angle =" + angle);
		x = PolarToCartesianX(r, angle);
		y = PolarToCartesianY(r, angle);
		System.out.println("X = " + x);
		System.out.println("Y = " + y);
	}
	
	//returns the r of the vector
	private static double CartesianToPolarR (double X, double Y) {
		return Math.sqrt(X*X + Y*Y);
	}
	
	//returns the angle of the vector
	private static double CartesianToPolarAngle (double X, double Y) {
		return Math.atan2(Y,  X);
	}
	
	//returns the X value of the cartesian coordinate
	private static double PolarToCartesianX (double r, double a) {
		return r * Math.cos(a);
	}
	
	//returns the Y value of the cartesian coordinate
	private static double PolarToCartesianY (double r, double a) {
		return r * Math.sin(a);
	}
}