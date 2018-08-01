package demo;

/**
 * 
 * The {@code TriangleTest} class is to find the type of a triangle. 
 * It includes a inner class {@code Triangle} with various triangle properties. 
 * 
 * @author Bibhu
 *
 */
public class TriangleTest {

	public static void main(String[] args) {
		try {
			//int[] sides = {3, 5, 5};
			int[] sides = new int[3];

			if (args.length < 3) {
				System.err.println("Please provide 3 digits! Usage:TriangleTest 2 3 4");
				System.exit(1);
			} else if (args.length > 3) {
				System.out.println("Only first numbers will be considered for triangle!\n");
			}

			for (int i=0; i<3; i++) {
				try {
					sides[i] = Integer.parseInt(args[i]);
				} catch (NumberFormatException e) {
					System.err.println("\""+args[i]+"\" is not a number! Please provide only digits as input.");
					System.exit(1);
				}
			}

			Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);

			System.out.println(triangle + " is of type : "+ triangle.getTriangleType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This class provides the methods to check if provided inputs are valid to construct a triangle,
	 * to check if the triangle type is "EquiLateral/Isosceles/Scalene". 
	 * 
	 */
	static class Triangle {
		int a, b, c;

		public Triangle(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c= c;
		}

		/**
		 * Get the triangle type for input sides 
		 * 
		 */
		public String getTriangleType() {
			String result = null;
			if (!isValidTriangle()) {
				result = "Invalid Triangle!";
			} else if (isEquilateral()) {
				result = "Equilateral Triangle!";
			} else if (isIsosceles()) {
				result = "Isosceles Triangle!";
			} else {
				result = "Scalene Triangle!";
			}

			return result;
		}

		/**
		 * Checks if the sides are valid to construct a triangle. 
		 * Length of any two sides should be greated than third side.
		 * 
		 */
		private boolean isValidTriangle(){
			if ((a+b > c) &&
				(a+c > b) &&
					(b+c > a)) {
				return true;
			}
			return false;
		}

		/**
		 * Checks if the sides are Equilateral
		 * Length of all three sides should be equal. 
		 * 
		 */
		private boolean isEquilateral(){
			if ((a == b) &&
				(b == c)) {
				return true;
			}

			return false;
		}

		/**
		 * Checks if the sides are Isosceles
		 * Length of any of the two side should be equal.
		 * 
		 */
		private boolean isIsosceles(){
			if ((a == b) ||
				(a == c) ||
					(b == c)) {
				return true;
			}

			return false;
		}

		@Override
		public String toString() {
			return "Triangle [" + a + ", " + b + ", " + c + "]";
		}
	}

}
