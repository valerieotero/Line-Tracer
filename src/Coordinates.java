
public class Coordinates {

	public static void main(String[] args) {
		double x = 10, y = 10;
		double r = PolarR(x, y);
		double angle = PolarAngle (x, y);
		System.out.println("r = " + r);
		System.out.println("Angle =" + angle);
		x = CartesianX(r, angle);
		y = CartesianY(r, angle);
		System.out.println("X = " + x);
		System.out.println("Y = " + y);
	}
	
	//returns the r of the vector 
	//formula: r = x^2 + y^2
	
	private static double PolarR (double X, double Y) {
		return Math.sqrt(X*X + Y*Y);
	}
	
	//returns the angle of the vector
	//formula: angle = tan^-1(y/x)
	private static double PolarAngle (double X, double Y) {
		return Math.atan2(Y,  X);
	}
	
	//returns the X value of the cartesian coordinate
	//formula: x = r*cos(angle)
	private static double CartesianX (double r, double a) {
		return r * Math.cos(a);
	}
	
	//returns the Y value of the cartesian coordinate
	//formula: x = r*sin(angle)
	private static double CartesianY (double r, double a) {
		return r * Math.sin(a);
	}
}