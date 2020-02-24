import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CoordinatesTester {
	
		int[] test1 = {10,19};
		int[] test2 = {0,10};
		int[] test3 = {-15,8};
		int[] test4 = {-7,-9};
		int[] test5 = {20,-20};
		
		@Before
		public void setUp() throws Exception{
			
		}

	@Test
	public void testPolarR() {
		assertTrue("PolarR() fails to get the magnitude of x=10 and y = 19", 21.470910553583888 ==
				Coordinates.PolarR(10, 19));
		assertTrue("PolarR() fails to get the magnitude of x=0 and y = 10", 10 == 
				Coordinates.PolarR(0, 10));
		assertTrue("PolarR() fails to get the magnitude of x=-15 and y = 8", 17.0 == 
				Coordinates.PolarR(-15, 8));
		assertTrue("PolarR() fails to get the magnitude of x=-7 and y = 9", 11.4017542509913797913604 == 
				Coordinates.PolarR(-7, -9));
		assertTrue("PolarR() fails to get the magnitude of x=20 and y = -20", 28.2842712474619009760337 == 
				Coordinates.PolarR(20, -20));
	}
	
	@Test
	public void testPolarA() {
		assertTrue("PolarA() fails to get the angle of x=10 and y = 19", 62.24145939893998 ==
				Coordinates.PolarAngle(10, 19));
		assertTrue("PolarA() fails to get the angle of x=0 and y = 10", 90 == 
				Coordinates.PolarAngle(0, 10));
		assertTrue("PolarA() fails to get the angle of x=-15 and y = 8", 151.92751306414706 == 
				Coordinates.PolarAngle(-15, 8));
		assertTrue("PolarA() fails to get the angle of x=-7 and y = -9",  -127.8749836510982 == 
				Coordinates.PolarAngle(-7, -9));
		assertTrue("PolarA() fails to get the angle of x=20 and y = -20", -45 == 
				Coordinates.PolarAngle(20, -20));
	}
	
	@Test
	public void testCartesianX() {
		assertTrue("CartesianX() fails to get the value of X from r = 10 and angle = 45", 7.0710678118654755 == 
				Coordinates.CartesianXPrecisionCalc(10, 45));
		assertTrue("CartesianX() fails to get the value of X from r = 28 and angle = 180", -28.0 == 
				Coordinates.CartesianXPrecisionCalc(28, 180));
		assertTrue("CartesianX() fails to get the value of X from r = 5 and angle = 285", 1.2940952255126015 == 
				Coordinates.CartesianXPrecisionCalc(5, 285));
		assertTrue("CartesianX() fails to get the value of X from r = 12 and angle = 90", 0 == 
				Math.round(Coordinates.CartesianXPrecisionCalc(12, 90)));
	}
	
	@Test
	public void testCartesianY() {
		assertTrue("CartesianX() fails to get the value of Y from r = 10 and angle = 45", 7.071067811865475 == 
				Coordinates.CartesianYPrecisionCalc(10, 45));
		assertTrue("CartesianX() fails to get the value of Y from r = 28 and angle = 180", 0.0 == 
				Math.round(Coordinates.CartesianYPrecisionCalc(28, 180)));
		assertTrue("CartesianX() fails to get the value of Y from r = 5 and angle = 285", -4.829629131445342 == 
				Coordinates.CartesianYPrecisionCalc(5, 285));
		assertTrue("CartesianX() fails to get the value of Y from r = 12 and angle = 90", 12.0 == 
				Coordinates.CartesianYPrecisionCalc(12, 90));
	}

}

