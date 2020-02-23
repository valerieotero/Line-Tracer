
public class Coordinates {	
	//returns the r of the vector 
	//formula: r = x^2 + y^2
	public static double PolarR (double X, double Y) {
		return Math.sqrt(X*X + Y*Y);
	}
	
	//returns the angle of the vector
	//formula: angle = tan^-1(y/x)
	public static double PolarAngle (double X, double Y) {
		return Math.atan2(Y,  X);
	}
	
	//returns the X value of the cartesian coordinate
	//formula: x = r*cos(angle)
	public static double CartesianX (double r, double a) {
		return r * Math.cos(a);
	}
	
	//returns the Y value of the cartesian coordinate
	//formula: x = r*sin(angle)
	public static double CartesianY (double r, double a) {
		return r * Math.sin(a);
	}
}