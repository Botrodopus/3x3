import java.util.Arrays;

public class Solve_3x3 {
	
	public static int LENGTH = 12;
	//Arrays making up cube #1
	public static int[] topLayer = new int[LENGTH];
	public static int[] sliceLayer = new int[LENGTH];
	public static int[] bottomLayer = new int[LENGTH];
	public static int[] leftLayer = new int[LENGTH];
	public static int[] middleLayer = new int[LENGTH];
	public static int[] rightLayer = new int[LENGTH];
	public static int[] frontLayer = new int[LENGTH];
	public static int[] midSliceLayer = new int[LENGTH];
	public static int[] backLayer = new int[LENGTH];
	//Arrays to compare
	public static int[] leftLayer2 = new int[LENGTH];
	public static int[] middleLayer2 = new int[LENGTH];
	public static int[] rightLayer2 = new int[LENGTH];
	
	public static void main(String[] args) {
		
		//compare();
		


		createCube();
		scramble();
		print();
		System.out.println();
		cross();
		System.out.println();
		print();
		System.out.println();
		corners();
		System.out.println();
		print();
		System.out.println();
		secondLayer();
		System.out.println();
		print();
		System.out.println();
		oll();
		System.out.println();
		print();
		System.out.println();
		pll();
		System.out.println();
		print();

	}
//print each layer
	public static void print() {
		System.out.println(Arrays.toString(leftLayer));
		System.out.println(Arrays.toString(middleLayer));
		System.out.println(Arrays.toString(rightLayer));
		System.out.println(Arrays.toString(topLayer));
		System.out.println(Arrays.toString(sliceLayer));
		System.out.println(Arrays.toString(bottomLayer));
		System.out.println(Arrays.toString(frontLayer));
		System.out.println(Arrays.toString(midSliceLayer));
		System.out.println(Arrays.toString(backLayer));
	}
//create solved cube
	public static void createCube() {
		//create horizontal rows
		for(int x=0; x<LENGTH; x++) {
			topLayer[x] = x+1;
			sliceLayer[x] = x+13;
			bottomLayer[x] = x+25;
		}
	//create left column
		leftLayer[0] = 46;
		leftLayer[1] = 47;
		leftLayer[2] = 48;
		leftLayer[3] = topLayer[0];
		leftLayer[4] = sliceLayer[0];
		leftLayer[5] = bottomLayer[0];
		leftLayer[6] = 37;
		leftLayer[7] = 38;
		leftLayer[8] = 39;
		leftLayer[9] = bottomLayer[8];
		leftLayer[10] = sliceLayer[8];
		leftLayer[11] = topLayer[8];
	//create middle column
		middleLayer[0] = 49;
		middleLayer[1] = 50;
		middleLayer[2] = 51;
		middleLayer[3] = topLayer[1];
		middleLayer[4] = sliceLayer[1];
		middleLayer[5] = bottomLayer[1];
		middleLayer[6] = 40;
		middleLayer[7] = 41;
		middleLayer[8] = 42;
		middleLayer[9] = bottomLayer[7];
		middleLayer[10] = sliceLayer[7];
		middleLayer[11] = topLayer[7];
	//create right column
		rightLayer[0] = 52;
		rightLayer[1] = 53;
		rightLayer[2] = 54;
		rightLayer[3] = topLayer[2];
		rightLayer[4] = sliceLayer[2];
		rightLayer[5] = bottomLayer[2];
		rightLayer[6] = 43;
		rightLayer[7] = 44;
		rightLayer[8] = 45;
		rightLayer[9] = bottomLayer[6];
		rightLayer[10] = sliceLayer[6];
		rightLayer[11] = topLayer[6];
	//create front column
		frontLayer[0] = leftLayer[2];
		frontLayer[1] = middleLayer[2];
		frontLayer[2] = rightLayer[2];
		frontLayer[3] = topLayer[3];
		frontLayer[4] = sliceLayer[3];
		frontLayer[5] = bottomLayer[3];
		frontLayer[6] = rightLayer[6];
		frontLayer[7] = middleLayer[6];
		frontLayer[8] = leftLayer[6];
		frontLayer[9] = bottomLayer[11];
		frontLayer[10] = sliceLayer[11];
		frontLayer[11] = topLayer[11];
	//create mid-slice column
		midSliceLayer[0] = leftLayer[1];
		midSliceLayer[1] = middleLayer[1];
		midSliceLayer[2] = rightLayer[1];
		midSliceLayer[3] = topLayer[4];
		midSliceLayer[4] = sliceLayer[4];
		midSliceLayer[5] = bottomLayer[4];
		midSliceLayer[6] = rightLayer[7];
		midSliceLayer[7] = middleLayer[7];
		midSliceLayer[8] = leftLayer[7];
		midSliceLayer[9] = bottomLayer[10];
		midSliceLayer[10] = sliceLayer[10];
		midSliceLayer[11] = topLayer[10];
	//create back column
		backLayer[0] = leftLayer[0];
		backLayer[1] = middleLayer[0];
		backLayer[2] = rightLayer[0];
		backLayer[3] = topLayer[5];
		backLayer[4] = sliceLayer[5];
		backLayer[5] = bottomLayer[5];
		backLayer[6] = rightLayer[8];
		backLayer[7] = middleLayer[8];
		backLayer[8] = leftLayer[8];
		backLayer[9] = bottomLayer[9];
		backLayer[10] = sliceLayer[9];
		backLayer[11] = topLayer[9];
		
	//Create comparing arrays
		//create left column
		leftLayer2[0] = 46;
		leftLayer2[1] = 47;
		leftLayer2[2] = 48;
		leftLayer2[3] = topLayer[0];
		leftLayer2[4] = sliceLayer[0];
		leftLayer2[5] = bottomLayer[0];
		leftLayer2[6] = 37;
		leftLayer2[7] = 38;
		leftLayer2[8] = 39;
		leftLayer2[9] = bottomLayer[8];
		leftLayer2[10] = sliceLayer[8];
		leftLayer2[11] = topLayer[8];
	//create middle column
		middleLayer2[0] = 49;
		middleLayer2[1] = 50;
		middleLayer2[2] = 51;
		middleLayer2[3] = topLayer[1];
		middleLayer2[4] = sliceLayer[1];
		middleLayer2[5] = bottomLayer[1];
		middleLayer2[6] = 40;
		middleLayer2[7] = 41;
		middleLayer2[8] = 42;
		middleLayer2[9] = bottomLayer[7];
		middleLayer2[10] = sliceLayer[7];
		middleLayer2[11] = topLayer[7];
	//create right column
		rightLayer2[0] = 52;
		rightLayer2[1] = 53;
		rightLayer2[2] = 54;
		rightLayer2[3] = topLayer[2];
		rightLayer2[4] = sliceLayer[2];
		rightLayer2[5] = bottomLayer[2];
		rightLayer2[6] = 43;
		rightLayer2[7] = 44;
		rightLayer2[8] = 45;
		rightLayer2[9] = bottomLayer[6];
		rightLayer2[10] = sliceLayer[6];
		rightLayer2[11] = topLayer[6];
	}
	

	
//Create layers
	public static void createFront() {
		frontLayer[0] = leftLayer[2];
		frontLayer[1] = middleLayer[2];
		frontLayer[2] = rightLayer[2];
		frontLayer[3] = topLayer[3];
		frontLayer[4] = sliceLayer[3];
		frontLayer[5] = bottomLayer[3];
		frontLayer[6] = rightLayer[6];
		frontLayer[7] = middleLayer[6];
		frontLayer[8] = leftLayer[6];
		frontLayer[9] = bottomLayer[11];
		frontLayer[10] = sliceLayer[11];
		frontLayer[11] = topLayer[11];
	}
	
	public static void createMidSlice() {
		midSliceLayer[0] = leftLayer[1];
		midSliceLayer[1] = middleLayer[1];
		midSliceLayer[2] = rightLayer[1];
		midSliceLayer[3] = topLayer[4];
		midSliceLayer[4] = sliceLayer[4];
		midSliceLayer[5] = bottomLayer[4];
		midSliceLayer[6] = rightLayer[7];
		midSliceLayer[7] = middleLayer[7];
		midSliceLayer[8] = leftLayer[7];
		midSliceLayer[9] = bottomLayer[10];
		midSliceLayer[10] = sliceLayer[10];
		midSliceLayer[11] = topLayer[10];
	}
	
	public static void createBack() {
		backLayer[0] = leftLayer[0];
		backLayer[1] = middleLayer[0];
		backLayer[2] = rightLayer[0];
		backLayer[3] = topLayer[5];
		backLayer[4] = sliceLayer[5];
		backLayer[5] = bottomLayer[5];
		backLayer[6] = rightLayer[8];
		backLayer[7] = middleLayer[8];
		backLayer[8] = leftLayer[8];
		backLayer[9] = bottomLayer[9];
		backLayer[10] = sliceLayer[9];
		backLayer[11] = topLayer[9];
	}
	
	public static void createLeft() {
		leftLayer[0] = backLayer[0];
		leftLayer[1] = midSliceLayer[0];
		leftLayer[2] = frontLayer[0];
		leftLayer[3] = topLayer[0];
		leftLayer[4] = sliceLayer[0];
		leftLayer[5] = bottomLayer[0];
		leftLayer[6] = frontLayer[8];
		leftLayer[7] = midSliceLayer[8];
		leftLayer[8] = backLayer[8];
		leftLayer[9] = bottomLayer[8];
		leftLayer[10] = sliceLayer[8];
		leftLayer[11] = topLayer[8];
	}
	
	public static void createRight() {
		rightLayer[0] = backLayer[2];
		rightLayer[1] = midSliceLayer[2];
		rightLayer[2] = frontLayer[2];
		rightLayer[3] = topLayer[2];
		rightLayer[4] = sliceLayer[2];
		rightLayer[5] = bottomLayer[2];
		rightLayer[6] = frontLayer[6];
		rightLayer[7] = midSliceLayer[6];
		rightLayer[8] = backLayer[6];
		rightLayer[9] = bottomLayer[6];
		rightLayer[10] = sliceLayer[6];
		rightLayer[11] = topLayer[6];
	}
	
	public static void createMiddle() {
		middleLayer[0] = backLayer[1];
		middleLayer[1] = midSliceLayer[1];
		middleLayer[2] = frontLayer[1];
		middleLayer[3] = topLayer[1];
		middleLayer[4] = sliceLayer[1];
		middleLayer[5] = bottomLayer[1];
		middleLayer[6] = frontLayer[7];
		middleLayer[7] = midSliceLayer[7];
		middleLayer[8] = backLayer[7];
		middleLayer[9] = bottomLayer[7];
		middleLayer[10] = sliceLayer[7];
		middleLayer[11] = topLayer[7];
	}
	
	public static void createTop() {
		topLayer[0] = leftLayer[3];
		topLayer[1] = middleLayer[3];
		topLayer[2] = rightLayer[3];
		topLayer[3] = frontLayer[3];
		topLayer[4] = midSliceLayer[3];
		topLayer[5] = backLayer[3];
		topLayer[6] = rightLayer[11];
		topLayer[7] = middleLayer[11];
		topLayer[8] = leftLayer[11];
		topLayer[9] = backLayer[11];
		topLayer[10] = midSliceLayer[11];
		topLayer[11] = frontLayer[11];
	}
	
	public static void createBottom() {
		bottomLayer[0] = leftLayer[5];
		bottomLayer[1] = middleLayer[5];
		bottomLayer[2] = rightLayer[5];
		bottomLayer[3] = frontLayer[5];
		bottomLayer[4] = midSliceLayer[5];
		bottomLayer[5] = backLayer[5];
		bottomLayer[6] = rightLayer[9];
		bottomLayer[7] = middleLayer[9];
		bottomLayer[8] = leftLayer[9];
		bottomLayer[9] = backLayer[9];
		bottomLayer[10] = midSliceLayer[9];
		bottomLayer[11] = frontLayer[9];
	}
	
	public static void createSlice() {
		sliceLayer[0] = leftLayer[4];
		sliceLayer[1] = middleLayer[4];
		sliceLayer[2] = rightLayer[4];
		sliceLayer[3] = frontLayer[4];
		sliceLayer[4] = midSliceLayer[4];
		sliceLayer[5] = backLayer[4];
		sliceLayer[6] = rightLayer[10];
		sliceLayer[7] = middleLayer[10];
		sliceLayer[8] = leftLayer[10];
		sliceLayer[9] = backLayer[10];
		sliceLayer[10] = midSliceLayer[10];
		sliceLayer[11] = frontLayer[10];
	}
	
//update Cube after each turn
	public static void update() {
		createFront();
		createMidSlice();
		createBack();
		createLeft();
		createRight();
		createMiddle();
		createTop();
		createBottom();
		createSlice();
	}
		
//Rotations
//R, R', L, L', U, U', D, D', F, F', B, B', M, M', S, S', E, E'	
	public static void R() {
	//shift
		int hold1 = rightLayer[0];
		int hold2 = rightLayer[1];
		int hold3 = rightLayer[2];
		for(int i=0; i<LENGTH-3; i++) {
			rightLayer[i] = rightLayer[i+3];			
		}
		rightLayer[9] = hold1;
		rightLayer[10] = hold2;
		rightLayer[11] = hold3;
	//update corners
		hold1 = frontLayer[3];
		frontLayer[3] = frontLayer[5];
		hold2 = backLayer[3];
		backLayer[3] = hold1;
		hold1 = backLayer[5];
		backLayer[5] = hold2;
		frontLayer[5] = hold1;
	//update edges
		hold1 = frontLayer[4];
		frontLayer[4] = midSliceLayer[5];
		hold2 = midSliceLayer[3];
		midSliceLayer[3] = hold1;
		hold1 = backLayer[4];
		backLayer[4] = hold2;
		midSliceLayer[5] = hold1;
	//update affected layers	
		createTop();
		createSlice();
		createBottom();
		createFront();
		createMidSlice();
		createBack();
		System.out.print("R, ");
	}
	
	public static void Rp() {
	//shift
		int hold1 = rightLayer[9];
		int hold2 = rightLayer[10];
		int hold3 = rightLayer[11];
		for(int i=LENGTH-1; i>=3; i--) {
			rightLayer[i] = rightLayer[i-3];			
		}
		rightLayer[0] = hold1;
		rightLayer[1] = hold2;
		rightLayer[2] = hold3;
	//update side corners
		hold1 = frontLayer[5];
		frontLayer[5] = frontLayer[3];
		hold2 = backLayer[5];
		backLayer[5] = hold1;
		hold1 = backLayer[3];
		backLayer[3] = hold2;
		frontLayer[3] = hold1;
	//update side edges
		hold1 = frontLayer[4];
		frontLayer[4] = midSliceLayer[3];
		hold2 = midSliceLayer[5];
		midSliceLayer[5] = hold1;
		hold1 = backLayer[4];
		backLayer[4] = hold2;
		midSliceLayer[3] = hold1;	
	//update affected layers
		createTop();
		createSlice();
		createBottom();
		createFront();
		createMidSlice();
		createBack();
		System.out.print("R', ");
	}
	
	public static void L() {
	//shift
		int hold1 = leftLayer[9];
		int hold2 = leftLayer[10];
		int hold3 = leftLayer[11];
		for(int i=LENGTH-1; i>=3; i--) {
			leftLayer[i] = leftLayer[i-3];			
		}
		leftLayer[0] = hold1;
		leftLayer[1] = hold2;
		leftLayer[2] = hold3;
	//update corners
		hold1 = frontLayer[9];
		frontLayer[9] = frontLayer[11];
		hold2 = backLayer[9];
		backLayer[9] = hold1;
		hold1 = backLayer[11];
		backLayer[11] = hold2;
		frontLayer[11] = hold1;
	//update edges
		hold1 = frontLayer[10];
		frontLayer[10] = midSliceLayer[11];
		hold2 = midSliceLayer[9];
		midSliceLayer[9] = hold1;
		hold1 = backLayer[10];
		backLayer[10] = hold2;
		midSliceLayer[11] = hold1;
	//update affected layers
		createTop();
		createSlice();
		createBottom();
		createFront();
		createMidSlice();
		createBack();
		System.out.print("L, ");
	}
	
	public static void Lp() {
		//shift
		int hold1 = leftLayer[0];
		int hold2 = leftLayer[1];
		int hold3 = leftLayer[2];
		for(int i=0; i<LENGTH-3; i++) {
			leftLayer[i] = leftLayer[i+3];			
		}
		leftLayer[9] = hold1;
		leftLayer[10] = hold2;
		leftLayer[11] = hold3;
	//update corners
		hold1 = frontLayer[11];
		frontLayer[11] = frontLayer[9];
		hold2 = backLayer[11];
		backLayer[11] = hold1;
		hold1 = backLayer[9];
		backLayer[9] = hold2;
		frontLayer[9] = hold1;
	//update edges
		hold1 = frontLayer[10];
		frontLayer[10] = midSliceLayer[9];
		hold2 = midSliceLayer[11];
		midSliceLayer[11] = hold1;
		hold1 = backLayer[10];
		backLayer[10] = hold2;
		midSliceLayer[9] = hold1;
	//update affected layers		
		createTop();
		createSlice();
		createBottom();
		createFront();
		createMidSlice();
		createBack();
		System.out.print("L', ");
	}
	
	public static void U() {
		//shift
		int hold1 = topLayer[0];
		int hold2 = topLayer[1];
		int hold3 = topLayer[2];
		for(int i=0; i<LENGTH-3; i++) {
			topLayer[i] = topLayer[i+3];			
		}
		topLayer[9] = hold1;
		topLayer[10] = hold2;
		topLayer[11] = hold3;
	//update corners
		hold1 = frontLayer[0];
		frontLayer[0] = frontLayer[2];
		hold2 = backLayer[0];
		backLayer[0] = hold1;
		hold1 = backLayer[2];
		backLayer[2] = hold2;
		frontLayer[2] = hold1;
	//update edges
		hold1 = frontLayer[1];
		frontLayer[1] = midSliceLayer[2];
		hold2 = midSliceLayer[0];
		midSliceLayer[0] = hold1;
		hold1 = backLayer[1];
		backLayer[1] = hold2;
		midSliceLayer[2] = hold1;	
	//update affected layers
		createLeft();
		createMiddle();
		createRight();
		createFront();
		createMidSlice();
		createBack();
		System.out.print("U, ");
	}
	
	public static void Up() {
		//shift
		int hold1 = topLayer[9];
		int hold2 = topLayer[10];
		int hold3 = topLayer[11];
		for(int i=LENGTH-1; i>=3; i--) {
			topLayer[i] = topLayer[i-3];			
		}
		topLayer[0] = hold1;
		topLayer[1] = hold2;
		topLayer[2] = hold3;
	//update corners
		hold1 = frontLayer[2];
		frontLayer[2] = frontLayer[0];
		hold2 = backLayer[2];
		backLayer[2] = hold1;
		hold1 = backLayer[0];
		backLayer[0] = hold2;
		frontLayer[0] = hold1;
	//update edges
		hold1 = frontLayer[1];
		frontLayer[1] = midSliceLayer[0];
		hold2 = midSliceLayer[2];
		midSliceLayer[2] = hold1;
		hold1 = backLayer[1];
		backLayer[1] = hold2;
		midSliceLayer[0] = hold1;	
	//update affected layers
		createLeft();
		createMiddle();
		createRight();
		createFront();
		createMidSlice();
		createBack();
		System.out.print("U', ");
	}
	
	public static void D() {
		//shift
		int hold1 = bottomLayer[9];
		int hold2 = bottomLayer[10];
		int hold3 = bottomLayer[11];
		for(int i=LENGTH-1; i>=3; i--) {
			bottomLayer[i] = bottomLayer[i-3];			
		}
		bottomLayer[0] = hold1;
		bottomLayer[1] = hold2;
		bottomLayer[2] = hold3;
	//update corners
		hold1 = frontLayer[6];
		frontLayer[6] = frontLayer[8];
		hold2 = backLayer[6];
		backLayer[6] = hold1;
		hold1 = backLayer[8];
		backLayer[8] = hold2;
		frontLayer[8] = hold1;
	//update edges
		hold1 = frontLayer[7];
		frontLayer[7] = midSliceLayer[8];
		hold2 = midSliceLayer[6];
		midSliceLayer[6] = hold1;
		hold1 = backLayer[7];
		backLayer[7] = hold2;
		midSliceLayer[8] = hold1;	
	//update affected layers
		createLeft();
		createMiddle();
		createRight();
		createFront();
		createMidSlice();
		createBack();
		System.out.print("D, ");
	}
	
	public static void Dp() {
		//shift
		int hold1 = bottomLayer[0];
		int hold2 = bottomLayer[1];
		int hold3 = bottomLayer[2];
		for(int i=0; i<LENGTH-3; i++) {
			bottomLayer[i] = bottomLayer[i+3];			
		}
		bottomLayer[9] = hold1;
		bottomLayer[10] = hold2;
		bottomLayer[11] = hold3;
	//update corners
		hold1 = frontLayer[8];
		frontLayer[8] = frontLayer[6];
		hold2 = backLayer[8];
		backLayer[8] = hold1;
		hold1 = backLayer[6];
		backLayer[6] = hold2;
		frontLayer[6] = hold1;
	//update edges
		hold1 = frontLayer[7];
		frontLayer[7] = midSliceLayer[6];
		hold2 = midSliceLayer[8];
		midSliceLayer[8] = hold1;
		hold1 = backLayer[7];
		backLayer[7] = hold2;
		midSliceLayer[6] = hold1;	
	//update affected layers
		createLeft();
		createMiddle();
		createRight();
		createFront();
		createMidSlice();
		createBack();		
		System.out.print("D', ");
	}
	
	public static void F() {
	//shift
		int hold1 = frontLayer[9];
		int hold2 = frontLayer[10];
		int hold3 = frontLayer[11];
		for(int i=LENGTH-1; i>=3; i--) {
			frontLayer[i] = frontLayer[i-3];			
		}
		frontLayer[0] = hold1;
		frontLayer[1] = hold2;
		frontLayer[2] = hold3;
	//update corners
		hold1 = leftLayer[3];
		leftLayer[3] = leftLayer[5];
		hold2 = rightLayer[3];
		rightLayer[3] = hold1;
		hold1 = rightLayer[5];
		rightLayer[5] = hold2;
		leftLayer[5] = hold1;
	//update edges
		hold1 = middleLayer[3];
		middleLayer[3] = leftLayer[4];
		hold2 = rightLayer[4];
		rightLayer[4] = hold1;
		hold1 = middleLayer[5];
		middleLayer[5] = hold2;
		leftLayer[4] = hold1;	
	//update affected layers
		createTop();
		createSlice();
		createBottom();
		createLeft();
		createMiddle();
		createRight();
		System.out.print("F, ");
	}
	
	public static void Fp() {
		//shift
		int hold1 = frontLayer[0];
		int hold2 = frontLayer[1];
		int hold3 = frontLayer[2];
		for(int i=0; i<LENGTH-3; i++) {
			frontLayer[i] = frontLayer[i+3];			
		}
		frontLayer[9] = hold1;
		frontLayer[10] = hold2;
		frontLayer[11] = hold3;
	//update corners
		hold1 = leftLayer[5];
		leftLayer[5] = leftLayer[3];
		hold2 = rightLayer[5];
		rightLayer[5] = hold1;
		hold1 = rightLayer[3];
		rightLayer[3] = hold2;
		leftLayer[3] = hold1;
	//update edges
		hold1 = middleLayer[3];
		middleLayer[3] = rightLayer[4];
		hold2 = leftLayer[4];
		leftLayer[4] = hold1;
		hold1 = middleLayer[5];
		middleLayer[5] = hold2;
		rightLayer[4] = hold1;	
	//update affected layers
		createTop();
		createSlice();
		createBottom();
		createLeft();
		createMiddle();
		createRight();
		System.out.print("F', ");
	}
	
	public static void B() {
		int hold1 = backLayer[0];
		int hold2 = backLayer[1];
		int hold3 = backLayer[2];
		for(int i=0; i<LENGTH-3; i++) {
			backLayer[i] = backLayer[i+3];			
		}
		backLayer[9] = hold1;
		backLayer[10] = hold2;
		backLayer[11] = hold3;
	//update corners
		hold1 = leftLayer[9];
		leftLayer[9] = leftLayer[11];
		hold2 = rightLayer[9];
		rightLayer[9] = hold1;
		hold1 = rightLayer[11];
		rightLayer[11] = hold2;
		leftLayer[11] = hold1;
	//update edges
		hold1 = middleLayer[11];
		middleLayer[11] = rightLayer[10];
		hold2 = leftLayer[10];
		leftLayer[10] = hold1;
		hold1 = middleLayer[9];
		middleLayer[9] = hold2;
		rightLayer[10] = hold1;	
	//update affected layers
		createTop();
		createSlice();
		createBottom();
		createLeft();
		createMiddle();
		createRight();
		System.out.print("B, ");
	}
	
	public static void Bp() {
		int hold1 = backLayer[9];
		int hold2 = backLayer[10];
		int hold3 = backLayer[11];
		for(int i=LENGTH-1; i>=3; i--) {
			backLayer[i] = backLayer[i-3];			
		}
		backLayer[0] = hold1;
		backLayer[1] = hold2;
		backLayer[2] = hold3;
	//update corners
		hold1 = leftLayer[11];
		leftLayer[11] = leftLayer[9];
		hold2 = rightLayer[11];
		rightLayer[11] = hold1;
		hold1 = rightLayer[9];
		rightLayer[9] = hold2;
		leftLayer[9] = hold1;
	//update edges
		hold1 = middleLayer[11];
		middleLayer[11] = leftLayer[10];
		hold2 = rightLayer[10];
		rightLayer[10] = hold1;
		hold1 = middleLayer[9];
		middleLayer[9] = hold2;
		leftLayer[10] = hold1;	
	//update affected layers
		createTop();
		createSlice();
		createBottom();
		createLeft();
		createMiddle();
		createRight();
		System.out.print("B', ");
	}
	
	public static void M() {
	//shift
		int hold1 = middleLayer[9];
		int hold2 = middleLayer[10];
		int hold3 = middleLayer[11];
		for(int i=LENGTH-1; i>=3; i--) {
			middleLayer[i] = middleLayer[i-3];			
		}
		middleLayer[0] = hold1;
		middleLayer[1] = hold2;
		middleLayer[2] = hold3;
	//update affected layers
		createTop();
		createSlice();
		createBottom();
		createFront();
		createMidSlice();
		createBack();
		System.out.print("M, ");
	}
	
	public static void Mp() {
	//shift
		int hold1 = middleLayer[0];
		int hold2 = middleLayer[1];
		int hold3 = middleLayer[2];
		for(int i=0; i<LENGTH-3; i++) {
			middleLayer[i] = middleLayer[i+3];			
		}
		middleLayer[9] = hold1;
		middleLayer[10] = hold2;
		middleLayer[11] = hold3;
	//update affected layers
		createTop();
		createSlice();
		createBottom();
		createFront();
		createMidSlice();
		createBack();
		System.out.print("M', ");
	}

	public static void S() {
	//shift
		int hold1 = midSliceLayer[9];
		int hold2 = midSliceLayer[10];
		int hold3 = midSliceLayer[11];
		for(int i=LENGTH-1; i>=3; i--) {
			midSliceLayer[i] = midSliceLayer[i-3];			
		}
		midSliceLayer[0] = hold1;
		midSliceLayer[1] = hold2;
		midSliceLayer[2] = hold3;
	//update affected layers
		createLeft();
		createMiddle();
		createRight();
		createTop();
		createSlice();
		createBottom();
		System.out.print("S, ");
	}
	
	public static void Sp() {
	//shift
		int hold1 = midSliceLayer[0];
		int hold2 = midSliceLayer[1];
		int hold3 = midSliceLayer[2];
		for(int i=0; i<LENGTH-3; i++) {
			midSliceLayer[i] = midSliceLayer[i+3];			
		}
		midSliceLayer[9] = hold1;
		midSliceLayer[10] = hold2;
		midSliceLayer[11] = hold3;
	//update affected layers
		createLeft();
		createMiddle();
		createRight();
		createTop();
		createSlice();
		createBottom();
		System.out.print("S', ");
	}
	
	public static void E() {
	//shift
		int hold1 = sliceLayer[9];
		int hold2 = sliceLayer[10];
		int hold3 = sliceLayer[11];
		for(int i=LENGTH-1; i>=3; i--) {
			sliceLayer[i] = sliceLayer[i-3];			
		}
		sliceLayer[0] = hold1;
		sliceLayer[1] = hold2;
		sliceLayer[2] = hold3;
	//update affected layers
		createLeft();
		createMiddle();
		createRight();
		createFront();
		createMidSlice();
		createBack();
		System.out.print("E, ");
	}
	
	public static void Ep() {
	//shift
		int hold1 = sliceLayer[0];
		int hold2 = sliceLayer[1];
		int hold3 = sliceLayer[2];
		for(int i=0; i<LENGTH-3; i++) {
			sliceLayer[i] = sliceLayer[i+3];			
		}
		sliceLayer[9] = hold1;
		sliceLayer[10] = hold2;
		sliceLayer[11] = hold3;
	//update affected layers
		createLeft();
		createMiddle();
		createRight();
		createFront();
		createMidSlice();
		createBack();
		System.out.print("E', ");
	}
	
	public static void R2() {
		R(); R();
	}
	
	public static void L2() {
		L(); L();
	}
	
	public static void M2() {
		M(); M();
	}
	
	public static void F2() {
		F(); F();
	}
	
	public static void B2() {
		B(); B();
	}
	
	public static void S2() {
		S(); S();
	}

	public static void U2() {
		U(); U();
	}
	
	public static void D2() {
		D(); D();
	}
	
	public static void E2() {
		E(); E();
	}
	
	public static void X() {
		Lp(); M(); R();
	}
	
	public static void Xp() {
		L(); Mp(); Rp();
	}
	
	public static void Y() {
		U(); Ep(); Dp();
	}
	
	public static void Yp() {
		Up(); E(); D();
	}
	
//Scramble
	public static void scramble() {
		System.out.println("Scramble:");
	//array for making a nice scramble
	//char[] scramble = new char[20];
		int[] arr = new int[20];
		for(int i=0; i<20; i++) {
			double num = Math.random()*12;
			arr[i] = (int)num;
		}
		//TEMPORARY UNTIL ARRAYLISTS TAKE EFFECT
		//eliminate consecutive identical numbers
		for(int i=0; i<19; i++) {
			while(arr[i] == arr[i+1]) {
				if(arr[i+1] <10) {
					arr[i+1] = arr[i+1]+2;
				}
				else {
					arr[i+1] = arr[i+1]-2;
				}
			}
		}
		//convert numbers to moves, scramble
		for(int i=0; i<20; i++) {
			if(arr[i]==0) {
				R();	
			}
			if(arr[i]==1) {
				Rp();
			}
			if(arr[i]==2) {
				L();
			}
			if(arr[i]==3) {
				Lp();
			}
			if(arr[i]==4) {
				U();
			}
			if(arr[i]==5) {
				Up();
			}
			if(arr[i]==6) {
				D();
			}
			if(arr[i]==7) {
				Dp();
			}
			if(arr[i]==8) {
				F();
			}
			if(arr[i]==9) {
				Fp();
			}
			if(arr[i]==10) {
				B();
			}
			if(arr[i]==11) {
				Bp();
			}
		}
		System.out.println();
	}

//Solve the cube
//First Layer
	public static void cross() {
	//loop to count how many edges are input
		//check if white edges are in correct spot but wrong rotation, fix it
		//System.out.println("check if white edges are oriented wrong");
		while(!((middleLayer[6]==40) && (middleLayer[8]==42) && (midSliceLayer[6]==44) && (midSliceLayer[8]==38))) {
			if((middleLayer[6] == 26) || (middleLayer[6] == 29) || (middleLayer[6] == 32) || (middleLayer[6] == 35)) {
				flipCrossEdge();
			}
			if((middleLayer[8] == 32) || (middleLayer[8] == 29) || (middleLayer[8] == 26) || (middleLayer[8] == 35)) {
				D2();
				flipCrossEdge();
				D2();
			}
			if((midSliceLayer[6] == 35) || (midSliceLayer[6] == 29) || (midSliceLayer[6] == 32) || (midSliceLayer[6] == 26)) {
				Dp();
				flipCrossEdge();
				D();
			}
			if((midSliceLayer[8] == 29) || (midSliceLayer[8] == 35) || (midSliceLayer[8] == 32) || (midSliceLayer[8] == 26)) {
				D();
				flipCrossEdge();
				Dp();
			}
		//check first layer for white edge in wrong location, insert in correct spot
			//System.out.println("check first layer for white edge in wrong location");
			if(middleLayer[5] == 29) {
				Fp(); Dp(); F(); D();
			}
			if(middleLayer[5] == 32) {
				F2(); U2(); B2();
			}
			if(middleLayer[5] == 35) {
				F(); D(); Fp(); Dp();
			}
			if(middleLayer[9] == 35) {
				 B2();  Up(); L2();
			}
			if(middleLayer[9] == 26) {
				B2();  U2(); F2();
			}
			if(middleLayer[9] == 29) {
				B2();  U(); R2();
			}
			if(midSliceLayer[5] == 26) {
				Dp(); Fp(); D(); Fp();
			}
			if(midSliceLayer[5] == 32) {
				D(); B(); Dp(); Bp();
			}
			if(midSliceLayer[5] == 35) {
				R2(); U2(); L2();
			}
			if(midSliceLayer[9] == 26) {
				Lp(); Dp(); L(); D();
			}
			if(midSliceLayer[9] == 29) {
				L2(); U2(); R2();
			}
			if(midSliceLayer[9] == 32) {
				L(); D(); Lp(); Dp();
			}

		//check second layer for white edge, insert
			//System.out.println("check second layer");
			for(int i=0; i<LENGTH; i++) {
				if(i==0) {
					if(sliceLayer[i] == 40) {
						Dp(); L(); D();
					}
					if(sliceLayer[i] == 44) {
						D2(); L(); D2();
					}
					if(sliceLayer[i] == 42) {
						D(); L(); Dp();
					}
					if(sliceLayer[i] == 38) {
						L();
					}
				}
				if(i==2) {
					if(sliceLayer[i] == 40) {
						D(); Rp(); Dp();
					}
					if(sliceLayer[i] == 44) {
						Rp();
					}
					if(sliceLayer[i] == 42) {
						Dp(); Rp(); D();
					}
					if(sliceLayer[i] == 38) {
						D2(); Rp(); D2();
					}
				}
				if(i==3) {
					if(sliceLayer[i] == 40) {
						F();
					}
					if(sliceLayer[i] == 44) {
						Dp(); F(); D();
					}
					if(sliceLayer[i] == 42) {
						D2(); F(); D2();
					}
					if(sliceLayer[i] == 38) {
						D(); F(); Dp();
					}
				}
				if(i==5) {
					if(sliceLayer[i] == 40) {
						D2(); Bp(); D2();
					}
					if(sliceLayer[i] == 44) {
						D(); Bp(); Dp();
					}
					if(sliceLayer[i] == 42) {
						Bp();
					}
					if(sliceLayer[i] == 38) {
						Dp(); Bp(); D();
					}
				}
				if(i==6) {
					if(sliceLayer[i] == 40) {
						D(); R(); Dp();
					}
					if(sliceLayer[i] == 44) {
						R();
					}
					if(sliceLayer[i] == 42) {
						Dp(); R(); D();
					}
					if(sliceLayer[i] == 38) {
						D2(); R(); D2();
					}
				}
				if(i==8) {
					if(sliceLayer[i] == 40) {
						Dp(); Lp(); D();
					}
					if(sliceLayer[i] == 44) {
						D2(); Lp(); D2();
					}
					if(sliceLayer[i] == 42) {
						D(); Lp(); Dp();
					}
					if(sliceLayer[i] == 38) {
						Lp();
					}
				}
				if(i==9) {
					if(sliceLayer[i] == 40) {
						Dp(); L(); D();
					}
					if(sliceLayer[i] == 44) {
						D2(); L(); D2();
					}
					if(sliceLayer[i] == 42) {
						D(); L(); Dp();
					}
					if(sliceLayer[i] == 38) {
						L();
					}
				}
				if(i==11) {
					if(sliceLayer[i] == 40) {
						Fp();
					}
					if(sliceLayer[i] == 44) {
						Dp(); Fp(); D();
					}
					if(sliceLayer[i] == 42) {
						D2(); Fp(); D2();
					}
					if(sliceLayer[i] == 38) {
						D(); Fp(); Dp(); 
					}
				}
			}
			//check third layer for white edge, insert
			//System.out.println("check third layer");
			if(topLayer[1] == 40) {
				Up(); Rp(); F(); R();
			}
			if(topLayer[1] == 44) {
				F(); Rp(); F();
			}
			if(topLayer[1] == 42) {
				Rp(); Up(); R(); Bp();
			}
			if(topLayer[1] == 38) {
				Fp(); L(); F();
			}
			if(topLayer[4] == 40) {
				Rp(); F(); R();
			}
			if(topLayer[4] == 44) {
				U(); F(); Rp(); Fp();
			}
			if(topLayer[4] == 42) {
				R(); Bp(); Rp();
			}
			if(topLayer[4] == 38) {
				U(); Fp(); L(); F();
			}
			if(topLayer[7] == 40){
				Up(); L(); Fp(); Lp();
			}
			if(topLayer[7] == 44){
				Bp(); R(); B();
			}
			if(topLayer[7] == 42){
				U(); R(); Bp(); Rp();
			}
			if(topLayer[7] == 38){
				B(); Lp(); Bp();
			}
			if(topLayer[10] == 40) {
				L(); Fp(); Lp();
			}
			if(topLayer[10] == 44) {
				Up(); F(); Rp(); Fp();
			}
			if(topLayer[10] == 42) {
				Bp(); Lp(); B(); L();
			}
			if(topLayer[10] == 38) {
				Up(); Fp(); L(); F();
			}
			//check top side for white edges, insert
			//System.out.println("check top");
			if(frontLayer[1] == 40) {
				F2();
			}
			if(frontLayer[1] == 44) {
				Up(); R2();
			}
			if(frontLayer[1] == 42) {
				U2(); B2();
			}
			if(frontLayer[1] == 38) {
				U(); L2();
			}
			if(midSliceLayer[2] == 40) {
				U(); F2();
			}
			if(midSliceLayer[2] == 44) {
				R2();
			}
			if(midSliceLayer[2] == 42) {
				Up(); B2();
			}
			if(midSliceLayer[2] == 38) {
				U2(); L2();
			}
			if(backLayer[1] == 40){
				U2(); F2(); 
			}
			if(backLayer[1] == 44){
				U(); R2(); 
			}
			if(backLayer[1] == 42){
				B2(); 
			}
			if(backLayer[1] == 38){
				Up(); L2(); 
			}
			if(midSliceLayer[0] == 40) {
				Up(); F2();
			}
			if(midSliceLayer[0] == 44) {
				U2(); R2(); 
			}
			if(midSliceLayer[0] == 42) {
				U(); B2(); 
			}
			if(midSliceLayer[0] == 38) {
				L2();
			}
		}
	}
	
	public static void corners() {
		int count = 0;
		//check if any corners are already placed
		System.out.println("check if any corners are already placed");
		if(leftLayer[6] == 37) {
			count++;
		}
		if(rightLayer[6] == 43) {
			count++;
		}
		if(leftLayer[8] == 39) {
			count++;
		}
		if(rightLayer[8] == 45) {
			count++;
		}
		System.out.println("("+count+")");
		//check if corners are in wrong spot, insert
		System.out.println("check if corners are in wrong spot, insert");
		if(leftLayer[6] == 43) {
			Lp(); Up(); L(); R(); U(); R();
			count++;
		}
		if(leftLayer[6] == 45) {
			sexyLeft(); Rp(); U2(); R();
			count++;
		}
		if(leftLayer[6] == 39) {
			Lp(); U(); L(); Up(); L(); U2(); Lp();
			count++;
		}
		//
		if(rightLayer[6] == 45) {
			R(); Up(); Rp(); U(); Rp(); U2(); R(); 
			count++;
		}
		if(rightLayer[6] == 39) {
			sexy(); L(); U2(); Lp();
			count++;
		}
		if(rightLayer[6] == 37) {
			R(); U(); Rp(); U(); F(); Up(); Fp();
			count++;
		}
		//
		if(leftLayer[8] == 43) {
			L(); Up(); R(); Up(); Rp(); Lp(); 
			count++;
		}
		if(leftLayer[8] == 45) {
			L(); U(); Lp(); Rp(); Up(); R();
			count++;
		}
		if(leftLayer[8] == 37) {
			L(); U(); Lp(); U2(); Lp(); U(); L(); 
			count++;
		}
		//
		if(rightLayer[8] == 43) {
			Rp(); Up(); R(); U2(); R(); U(); Rp(); 
			count++;
		}
		if(rightLayer[8] == 37) {
			Rp(); Up(); R(); Up(); sledgehammerLeft();
			count++;
		}
		if(rightLayer[8] == 39) {
			Rp(); Up(); R(); L(); U(); Lp();
			count++;
		}		
	//check other layers
		while(!((leftLayer[6]==37) && (rightLayer[6]==43) && (leftLayer[8]==39) && (rightLayer[8]==45))) {
			//loop through bottom layer
			System.out.println("check first layer for any corner, insert");
			for(int i=0; i<LENGTH-1; i++) {
				//
				if(i==0) {
					if(bottomLayer[i] == 37) {
						D(); sexy(); sexy(); Dp();
						count++;
					}
					if(bottomLayer[i] == 36) {
						sexyLeft(); sexyLeft();
						count++;
					}
					//
					if(bottomLayer[i] == 27) {
						Lp(); Up(); L(); sledgehammer(); 
						count++;
					}
					if(bottomLayer[i] == 43) {
						F(); U2(); Fp(); U(); R(); U(); Rp(); 
						count++;
					}
					//
					if(bottomLayer[i] == 30) {
						Lp(); Up(); L(); Dp(); sledgehammer(); D();
						count++;
					}
					if(bottomLayer[i] == 45) {
						Lp(); U(); L(); Up(); Dp(); R(); U(); Rp(); D();
						count++;
					}
					//
					if(bottomLayer[i] == 33) {
						Lp(); Up(); L(); U(); D(); Lp(); Up(); L(); Dp();
						count++;
					}
					if(bottomLayer[i] == 39) {
						Lp(); U(); L(); D(); sledgehammerLeft(); Dp();
						count++;
					}
				}
				//
				if(i==2) {
					if(bottomLayer[i] == 37) {
						sexy(); F2(); L(); F2(); Lp(); 
						count++;
					}
					if(bottomLayer[i] == 25) {
						sexy(); D(); R(); U(); Rp(); Dp(); 
						count++;
					}
					//
					if(bottomLayer[i] == 28) {
						sexy(); sexy(); 
						count++;
					}
					if(bottomLayer[i] == 43) {
						R(); Up(); Rp(); sledgehammer(); 
						count++;
					}
					//
					if(bottomLayer[i] == 31) {
						sexy(); Dp(); sexy(); D(); 
						count++;
					}
					if(bottomLayer[i] == 45) {
						R(); Up(); Rp(); Dp(); sledgehammer(); D(); 
						count++;
					}
					//
					if(bottomLayer[i] == 34) {
						sexy(); D2(); R(); U(); Rp(); D2(); 
						count++;
					}
					if(bottomLayer[i] == 39) {
						R(); Up(); Rp(); D2(); sledgehammer(); D2(); 
						count++;
					}
				}
				//
				if(i==6) {
					Y(); Y();
					//
					if(bottomLayer[0] == 45) {
						D(); sexy(); sexy(); Dp();
						count++;
					}
					if(bottomLayer[0] == 30) {
						sexyLeft(); sexyLeft();
						count++;
					}
					//
					if(bottomLayer[0] == 33) {
						Lp(); Up(); L(); sledgehammer(); 
						count++;
					}
					if(bottomLayer[0] == 39) {
						F(); U2(); F2(); U(); F(); 
						count++;
					}
					//
					if(bottomLayer[0] == 36) {
						Lp(); Up(); L(); Dp(); sledgehammer(); D();
						count++;
					}
					if(bottomLayer[0] == 37) {
						Lp(); U(); L(); Rp(); U2(); R(); 
						count++;
					}
					//
					if(bottomLayer[0] == 27) {
						sexyLeft(); D(); sexyLeft(); Dp(); 
						count++;
					}
					if(bottomLayer[0] == 43) {
						Lp(); U(); L(); D(); sledgehammerLeft(); Dp();
						count++;
					}
					Y(); Y();
				}
				//
				if(i==8) {
					Y(); Y();
					if(bottomLayer[2] == 45) {
						sexy(); F2(); L(); F2(); Lp();  
						count++;
					}
					if(bottomLayer[2] == 30) {
						sexy(); D(); sledgehammer(); Dp();  
						count++;
					}
					
					if(bottomLayer[2] == 34) {
						sexy(); sexy(); 
						count++;
					}
					if(bottomLayer[2] == 39) {
						R(); Up(); Rp(); sledgehammer(); 
						count++;
					}
					
					if(bottomLayer[2] == 25) {
						sexy(); Dp(); sexy(); D(); 
						count++;
					}
					if(bottomLayer[2] == 37) {
						R(); Up(); Rp(); Dp(); sledgehammer(); D(); 
						count++;
					}
					
					if(bottomLayer[2] == 43) {
						sexy(); D(); F2(); L(); F2(); Lp(); Dp(); 
						count++;
					}
					if(bottomLayer[2] == 28) {
						sexy(); D2(); sexy(); D2(); 
						count++;
					}
				Y(); Y();
				}
			}
			System.out.println("check top face for corners, insert");
			//
			if(leftLayer[2] == 25) {
				F(); U(); Fp();  
			}
			if(leftLayer[2] == 36) {
				Lp(); Up(); L(); 
			}
			if(leftLayer[2] == 37) {
				Lp(); U2(); L(); U(); Lp(); Up(); L(); 
			}
			if(leftLayer[2] == 27) {
				Up(); sledgehammer();
			}
			if(leftLayer[2] == 28) {
				Up(); R(); U(); Rp();  
			}
			if(leftLayer[2] == 43) {
				Up(); sexy(); sexy(); sexy();
			}
			
			if(leftLayer[2] == 45) {
				 U2(); Rp(); U(); R(); Up(); Dp(); sledgehammer(); D();
			}
			if(leftLayer[2] == 30) {
				Dp(); R(); Up(); Rp(); D(); 
			}
			if(leftLayer[2] == 31) {
				Rp(); U2(); R(); 
			}
			if(leftLayer[2] == 39) {
				U(); L(); Up(); Lp(); U(); D(); sledgehammerLeft(); Dp();
			}
			if(leftLayer[2] == 33) {
				 Up(); L(); U2(); Lp(); 
			}
			if(leftLayer[2] == 34) {
				D(); sledgehammerLeft(); Dp();
			}			
			//
			if(rightLayer[2] == 27) {
				sledgehammer();
			}
			if(rightLayer[2] == 28) {
				R(); U(); Rp(); 
			}
			if(rightLayer[2] == 43) {
				R(); U2(); Rp(); Up(); R(); U(); Rp(); 
			}
			if(rightLayer[2] == 25) {
				Lp(); U(); L(); 
			}
			if(rightLayer[2] == 36) {
				U(); Lp(); Up(); L(); 
			}
			if(rightLayer[2] == 37) {
				U(); Lp(); U2(); L(); U(); Lp(); Up(); L(); 
			}
			
			if(rightLayer[2] == 31) {
				U2(); Rp(); U(); R();
			}
			if(rightLayer[2] == 30) {
				Up(); Rp(); Up(); R();
			}
			if(rightLayer[2] == 45) {
				 R(); Up(); R2(); U(); R();
			}
			if(rightLayer[2] == 33) {
				 D2(); sledgehammer(); D2(); 
			}
			if(rightLayer[2] == 34) {
				D2(); R(); U(); Rp(); D2(); 
			}
			if(rightLayer[2] == 39) {
				U2(); L(); Up(); Lp(); D2(); R(); U(); Rp(); D2(); 
			}
			//Rotate to find other 2 corners
			Y(); Y();
			//
			if(leftLayer[2] == 31) {
				F(); U(); Fp();  
			}
			if(leftLayer[2] == 30) {
				Lp(); Up(); L(); 
			}
			if(leftLayer[2] == 45) {
				Lp(); U2(); L(); U(); Lp(); Up(); L(); 
			}
			if(leftLayer[2] == 33) {
				R(); Up(); Rp(); 
			}
			if(leftLayer[2] == 34) {
				Up(); R(); U(); Rp(); 
			}
			if(leftLayer[2] == 39) {
				Up(); R(); U2(); Rp(); Up(); R(); U(); Rp(); 
			}
			if(leftLayer[2] == 36) {
				Dp(); R(); Up(); Rp(); D();   
			}
			if(leftLayer[2] == 25) {
				 Dp(); Up(); R(); U(); Rp(); D(); 
			}
			if(leftLayer[2] == 37) {
				U2(); Rp(); U(); R(); Dp(); R(); Up(); Rp(); D(); 
			}
			if(leftLayer[2] == 27) {
				 D(); Lp(); Up(); L(); Dp();  
			}
			if(leftLayer[2] == 28) {
				Bp(); U(); B();
			}
			if(leftLayer[2] == 43) {
				Lp(); U2(); L2(); U2(); Lp(); 
			}
			//
			if(rightLayer[2] == 33) {
				U(); R(); Up(); Rp();
			}
			if(rightLayer[2] == 34) {
				R(); U(); Rp(); 
			}
			if(rightLayer[2] == 39) {
				R(); U2(); Rp(); Up(); R(); U(); Rp(); 
			}
			if(rightLayer[2] == 30) {
				U(); Lp(); Up(); L();
			}
			if(rightLayer[2] == 31) {
				 U(); sledgehammerLeft();
			}
			if(rightLayer[2] == 45) {
				U(); F(); Up(); Fp(); U2(); sledgehammerLeft();
			}
			
			if(rightLayer[2] == 36) {
				B(); Up(); Bp(); 
			}
			if(rightLayer[2] == 25) {
				 U(); Rp(); U2(); R();
			}
			if(rightLayer[2] == 37) {
				Up(); Rp(); U(); R(); B(); U2(); Bp();
			}
			if(rightLayer[2] == 27) {
				L(); U2(); Lp(); 
			}
			if(rightLayer[2] == 28) {
				 Bp(); U2(); B(); 
			}
			if(rightLayer[2] == 43) {
				U2(); L(); Up(); Lp(); Bp(); U2(); B();  
			}
			//put red center in front again
			Y(); Y();
		}
	}
	
//Second Layer
	public static void secondLayer() {
		
		
		//FIND MISSING CASES
		//causes continuous loop
		
		
		//continue until all 4 edges are correct
		while(!((sliceLayer[0]==13) && (sliceLayer[2]==15) && (sliceLayer[6]==19) && (sliceLayer[8]==21))) {
			//insert all edges that are in top layer
			System.out.println();
			System.out.println("check top layer for edges, insert");
			//check for red edges
			for(int i=1; i<=4; i++) {
				if(topLayer[1] == 13) {
					insertLeftEdge();
				}
				if(topLayer[1] == 15) {
					insertRightEdge();
				}
				//
				if(topLayer[1] == 24) {
					Yp(); U();
					insertRightEdge();
					Y();
				}
				if(topLayer[1] == 16) {
					Y(); Up();
					insertLeftEdge();
					Yp();
				}
				U();
			}
			//check for green edges
			Y();
			for(int i=1; i<=4; i++) {
				if(topLayer[1] == 16) {
					insertLeftEdge();
				}
				if(topLayer[1] == 18) {
					insertRightEdge();
				}
				//
				if(topLayer[1] == 15) {
					Yp(); U();
					insertRightEdge();
					Y();
				}
				if(topLayer[1] == 19) {
					Y(); Up();
					insertLeftEdge();
					Yp();
				}
				U();
			}
			//check for orange edges
			Y();
			for(int i=1; i<=4; i++) {
				if(topLayer[1] == 19) {
					insertLeftEdge();
				}
				if(topLayer[1] == 21) {
					insertRightEdge();
				}
				//
				if(topLayer[1] == 18) {
					Yp(); U();
					insertRightEdge();
					Y();
				}
				if(topLayer[1] == 22) {
					Y(); Up();
					insertLeftEdge();
					Yp();
				}
				U();
			}
			//check for blue edges
			Y();
			for(int i=1; i<=4; i++) {
				if(topLayer[1] == 22) {
					insertLeftEdge();
				}
				if(topLayer[1] == 24) {
					insertRightEdge();
				}
				//
				if(topLayer[1] == 21) {
					Yp(); U();
					insertRightEdge();
					Y();
				}
				if(topLayer[1] == 13) {
					Y(); Up();
					insertLeftEdge();
					Yp();
				}
				U();
			}
			Y();
			
			//check second layer for misplaced edges, insert
			System.out.println();
			System.out.println("check second layer for misplaced edges, insert");
			for(int i=0; i<LENGTH-1; i=i+3){
				if(i == 0) {
					if(sliceLayer[0] == 24) {
						insertLeftEdge();
						U2();
						insertLeftEdge();
					}
					//
					if(sliceLayer[0] == 15) {
						insertLeftEdge();
						Y(); U();
						insertLeftEdge();
						Yp();					
					}
					if(sliceLayer[0] == 16) {
						insertLeftEdge();
						U2();
						insertRightEdge();				
					}
					//
					if(sliceLayer[0] == 18) {
						insertLeftEdge();
						Y(); Y();
						insertLeftEdge();
						Y(); Y();					
					}
					if(sliceLayer[0] == 19) {
						insertLeftEdge();
						Y(); U();
						insertRightEdge();
						Yp();
					}
					//
					if(sliceLayer[0] == 21) {
						insertLeftEdge();
						Yp(); Up();
						insertLeftEdge();
						Y();					
					}
					if(sliceLayer[0] == 22) {
						insertLeftEdge();
						Y(); Y();
						insertLeftEdge();
						Y(); Y();
					}
				}
				//
				if(i == 3) {
					Y();
					if(sliceLayer[0] == 15) {
						insertLeftEdge();
						U2();
						insertLeftEdge();
					}
					//
					if(sliceLayer[0] == 18) {
						insertLeftEdge();
						Y(); U();
						insertLeftEdge();
						Yp();					
					}
					if(sliceLayer[0] == 19) {
						insertLeftEdge();
						U2();
						insertRightEdge();				
					}
					
					//
					if(sliceLayer[0] == 21) {
						insertLeftEdge();
						Y(); Y(); 
						insertLeftEdge();
						Y(); Y(); 				
					}
					if(sliceLayer[0] == 22) {
						insertLeftEdge();
						Y(); U();
						insertRightEdge();	
						Yp();
					}
					//
					if(sliceLayer[0] == 24) {
						insertLeftEdge();
						Yp(); Up();
						insertLeftEdge();
						Y();					
					}
					if(sliceLayer[0] == 13) {
						insertLeftEdge();
						Y(); Y(); 
						insertRightEdge();
						Y(); Y(); 
					}
				}
				//
				if(i == 6) {
					Y();
					if(sliceLayer[0] == 18) {
						insertLeftEdge();
						U2();
						insertLeftEdge();
					}
					//
					if(sliceLayer[0] == 21) {
						insertLeftEdge();
						Y(); U();
						insertLeftEdge();
						Yp();					
					}
					if(sliceLayer[0] == 22) {
						insertLeftEdge();
						U2();
						insertRightEdge();				
					}
					
					//
					if(sliceLayer[0] == 24) {
						insertLeftEdge();
						Y(); Y();
						insertLeftEdge();
						Y(); Y(); 		
					}
					if(sliceLayer[0] == 13) {
						insertLeftEdge();
						Y(); U();
						insertRightEdge();
						Yp();
					}
					//
					if(sliceLayer[0] == 15) {
						insertLeftEdge();
						Yp(); Up();
						insertLeftEdge();
						Y();					
					}
					if(sliceLayer[0] == 16) {
						insertLeftEdge();
						Y(); Y(); 
						insertRightEdge();
						Y(); Y(); 
					}
				}
				//
				if(i == 9) {
					Y();
					if(sliceLayer[0] == 21) {
						insertLeftEdge();
						U2();
						insertLeftEdge();
					}
					//
					if(sliceLayer[0] == 24) {
						insertLeftEdge();
						Y(); U();
						insertLeftEdge();
						Yp();					
					}
					if(sliceLayer[0] == 13) {
						insertLeftEdge();
						U2();
						insertRightEdge();				
					}
					
					//
					if(sliceLayer[0] == 15) {
						insertLeftEdge();
						Y(); Y(); 
						insertLeftEdge();
						Y(); Y(); 				
					}
					if(sliceLayer[0] == 16) {
						insertLeftEdge();
						Y(); U();
						insertRightEdge();
						Yp();				
					}
					//
					if(sliceLayer[0] == 18) {
						insertLeftEdge();
						Yp(); Up();
						insertLeftEdge();
						Y();					
					}
					if(sliceLayer[0] == 19) {
						insertLeftEdge();
						Y(); Y();
						insertRightEdge();		
						Y(); Y();
					}
					
					Y();
				}
			}
		}
	}
	public static void oll() {
	//1st look
		//check if cross is formed already, goes in if  cross is false
		if(!(((midSliceLayer[0] == 49) || (midSliceLayer[0] == 47) || (midSliceLayer[0] == 51) || (midSliceLayer[0] == 53))
			&& ((midSliceLayer[2] == 49) || (midSliceLayer[2] == 47) || (midSliceLayer[2] == 51) || (midSliceLayer[2] == 53))
			&& ((middleLayer[0] == 49) || (middleLayer[0] == 47) || (middleLayer[0] == 51) || (middleLayer[0] == 53))
			&& ((middleLayer[2] == 49) || (middleLayer[2] == 47) || (middleLayer[2] == 51) || (middleLayer[2] == 53)))) 
		{
			//check for dot
			if(((midSliceLayer[0] != 49) && (midSliceLayer[0] != 47) && (midSliceLayer[0] != 51) && (midSliceLayer[0] != 53))
				&& ((middleLayer[0] != 49) && (middleLayer[0] != 47) && (middleLayer[0] != 51) && (middleLayer[0] != 53))
				&& ((middleLayer[2] != 49) && (middleLayer[2] != 47) && (middleLayer[2] != 51) && (middleLayer[2] != 53))
				&& ((midSliceLayer[2] != 49) && (midSliceLayer[2] != 47) && (midSliceLayer[2] != 51) && (midSliceLayer[2] != 53)))
			{
				dot2look();
			}
			//check for bar, horizontal then vertical
			else if(((midSliceLayer[0] == 49) || (midSliceLayer[0] == 47) || (midSliceLayer[0] == 51) || (midSliceLayer[0] == 53)) 
				&& ((midSliceLayer[2] == 49) || (midSliceLayer[2] == 47) || (midSliceLayer[2] == 51) || (midSliceLayer[2] == 53))
				&& !(((middleLayer[0] == 49) || (middleLayer[0] == 47) || (middleLayer[0] == 51) || (middleLayer[0] == 53))
						&& ((middleLayer[2] == 49) || (middleLayer[2] == 47) || (middleLayer[2] == 51) || (middleLayer[2] == 53))))
			{
				bar2look();	
			}
			else if(((middleLayer[0] == 49) || (middleLayer[0] == 47) || (middleLayer[0] == 51) || (middleLayer[0] == 53))
				&& ((middleLayer[2] == 49) || (middleLayer[2] == 47) || (middleLayer[2] == 51) || (middleLayer[2] == 53))
				&& !(((midSliceLayer[0] == 49) || (midSliceLayer[0] == 47) || (midSliceLayer[0] == 51) || (midSliceLayer[0] == 53)) 
						&& ((midSliceLayer[2] == 49) ||
								(midSliceLayer[2] == 47) || (midSliceLayer[2] == 51) || (midSliceLayer[2] == 53))))
			{
				U();
				bar2look();
			}
			
			//check for L-shape
			else if( ((middleLayer[0] == 49) || (middleLayer[0] == 47) || (middleLayer[0] == 51) || (middleLayer[0] == 53)
				&& (midSliceLayer[2] == 49) || (midSliceLayer[2] == 47) || (midSliceLayer[2] == 51) || (midSliceLayer[2] == 53))
				&& !((midSliceLayer[0] == 49) || (midSliceLayer[0] == 47) || (midSliceLayer[0] == 51) || (midSliceLayer[0] == 53)
				&& (middleLayer[2] == 49) || (middleLayer[2] == 47) || (middleLayer[2] == 51) || (middleLayer[2] == 53)) ) 
			{
				U();
				l2look();
			}
			//
			else if( ((middleLayer[0] == 49) || (middleLayer[0] == 47) || (middleLayer[0] == 51) || (middleLayer[0] == 53)
				&& (midSliceLayer[0] == 49) || (midSliceLayer[0] == 47) || (midSliceLayer[0] == 51) || (midSliceLayer[0] == 53))
				&& !((midSliceLayer[2] == 49) || (midSliceLayer[2] == 47) || (midSliceLayer[2] == 51) || (midSliceLayer[2] == 53)
				&& (middleLayer[2] == 49) || (middleLayer[2] == 47) || (middleLayer[2] == 51) || (middleLayer[2] == 53)) ) 
			{
				U2();
				l2look();
			}
			//
			else if( ((midSliceLayer[0] == 49) || (midSliceLayer[0] == 47) || (midSliceLayer[0] == 51) || (midSliceLayer[0] == 53)
					&& ((middleLayer[2] == 49) || (middleLayer[2] == 47) || (middleLayer[2] == 51) || (middleLayer[2] == 53)))
					&& !((midSliceLayer[2] == 49) || (midSliceLayer[2] == 47) || (midSliceLayer[2] == 51) || (midSliceLayer[2] == 53)
					&& (middleLayer[0] == 49) || (middleLayer[0] == 47) || (middleLayer[0] == 51) || (middleLayer[0] == 53)) ) 
			{
				Up();
				l2look();
			}
			//
			else if( ((midSliceLayer[2] == 49) || (midSliceLayer[2] == 47) || (midSliceLayer[2] == 51) || (midSliceLayer[2] == 53)
					&& ((middleLayer[2] == 49) || (middleLayer[2] == 47) || (middleLayer[2] == 51) || (middleLayer[2] == 53)))
					&& !((midSliceLayer[0] == 49) || (midSliceLayer[0] == 47) || (midSliceLayer[0] == 51) || (midSliceLayer[0] == 53)
					&& (middleLayer[0] == 49) || (middleLayer[0] == 47) || (middleLayer[0] == 51) || (middleLayer[0] == 53)) ) 
			{
				l2look();
			}
		}
		System.out.println();
		System.out.println("second look");
		
	//2nd look
		//loop to see all orientations
		boolean done=false;
		while(!done) {
			//check for headlight cases
			System.out.println();
			System.out.println("check for headlight cases");
			if(((topLayer[0] == 46) || (topLayer[0] == 48) || (topLayer[0] == 52) || (topLayer[0] == 54))
				&& ((topLayer[2] == 46) || (topLayer[2] == 48) || (topLayer[2] == 52) || (topLayer[2] == 54))) 
			{
				if(((topLayer[6] == 46) || (topLayer[6] == 48) || (topLayer[6] == 52) || (topLayer[6] == 54))
					&& ((topLayer[8] == 46) || (topLayer[8] == 48) || (topLayer[8] == 52) || (topLayer[8] == 54))) 
				{
					doubleHeadlightCross();	
					done=true;
				}
				else if (((topLayer[9] == 48) || (topLayer[9] == 54) || (topLayer[9] == 52) || (topLayer[9] == 46))
					&& ((topLayer[5] == 48) || (topLayer[5] == 54) || (topLayer[5] == 52) || (topLayer[5] == 46))) 
				{
					U();
					headlightCross();
					done=true;
				}
				else if (((backLayer[0] == 48) || (backLayer[0] == 54) || (backLayer[0] == 52) || (backLayer[0] == 46))
					&& ((backLayer[2] == 48) || (backLayer[2] == 54) || (backLayer[2] == 52) || (backLayer[2] == 46))) 
				{
					headlights();
					done=true;
				}
			}
			//check for sune
			else if(((topLayer[0] == 48) || (topLayer[0] == 54) || (topLayer[0] == 52) || (topLayer[0] == 46))
					&& ((topLayer[9] == 48) || (topLayer[9] == 54) || (topLayer[9] == 52) || (topLayer[9] == 46))
					&& ((topLayer[6] == 48) || (topLayer[6] == 54) || (topLayer[6] == 52) || (topLayer[6] == 46))) 
			{
				antiSune();
				done=true;
			}
			else if((topLayer[2] == 48) || (topLayer[2] == 54) || (topLayer[2] == 52) || (topLayer[2] == 46)) {
				if(((topLayer[5] == 48) || (topLayer[5] == 54) || (topLayer[5] == 52) || (topLayer[5] == 46))
					&& ((topLayer[8] == 48) || (topLayer[8] == 54) || (topLayer[8] == 52) || (topLayer[8] == 46)))
				{
					sune();
					done=true;
				}
			//check for diagonal thing
				else if(((topLayer[9] == 48) || (topLayer[9] == 54) || (topLayer[9] == 52) || (topLayer[9] == 46))
						&& ((frontLayer[0] == 48) || (frontLayer[0] == 54) || (frontLayer[0] == 52) || (frontLayer[0] == 46))
						&& ((backLayer[2] == 48) || (backLayer[2] == 54) || (backLayer[2] == 52) || (backLayer[2] == 46))) {
					diagonalThing();
					done=true;
				}
			}
			//check for sidelights
			else if(((topLayer[0] == 48) || (topLayer[0] == 54) || (topLayer[0] == 52) || (topLayer[0] == 46))
					&& ((topLayer[8] == 48) || (topLayer[8] == 54) || (topLayer[8] == 52) || (topLayer[8] == 46))
					&& ((backLayer[2] == 48) || (backLayer[2] == 54) || (backLayer[2] == 52) || (backLayer[2] == 46))
					&& ((frontLayer[2] == 48) || (frontLayer[2] == 54) || (frontLayer[2] == 52) || (frontLayer[2] == 46)))
			{
				sidelights();
				done=true;
			}
			U();
		}
	}
	
	public static void pll() {
	//1st look
		//look for corner pairs, if only 1 do A perm if none do E perm
		//loop until red corner is ligned up, for easier search
		while(topLayer[0] != 1) {
			U();
		}
		//count how many pairs there are
		//check each side for every pair
		int count=0;
		if( ((topLayer[0] == 1) && (topLayer[2] == 3)) 
			|| ((topLayer[0] == 4) && (topLayer[2] == 6))
			|| ((topLayer[0] == 7) && (topLayer[2] == 9))
			|| ((topLayer[0] == 10) && (topLayer[2] == 12)) ) 
		{
			count++;
		}
		if( ((topLayer[3] == 4) && (topLayer[5] == 6))
			|| ((topLayer[3] == 7) && (topLayer[5] == 9))
			|| ((topLayer[3] == 10) && (topLayer[5] == 12))
			|| ((topLayer[3] == 1) && (topLayer[5] == 3)) ) 
		{
			count++;
		}
		if( ((topLayer[6] == 7) && (topLayer[8] == 9))
			|| ((topLayer[6] == 10) && (topLayer[8] == 12))
			|| ((topLayer[6] == 1) && (topLayer[8] == 3))
			|| ((topLayer[6] == 4) && (topLayer[8] == 6)) ) 
		{
			count++;
		}
		if( ((topLayer[9] == 10) && (topLayer[11] == 12)) 
			|| ((topLayer[9] == 1) && (topLayer[11] == 3))
			|| ((topLayer[9] == 4) && (topLayer[11] == 6))
			|| ((topLayer[9] == 7) && (topLayer[11] == 9)) ) 
		{
			count++;
		}
		//
		if(count == 0) {
			ePerm();
		}
		//begins looking for cases
		else if(count == 1) {
			//loop until pair is at the back
			boolean position=false;
			while(!position) {
				if(((topLayer[6] == 7) && (topLayer[8] == 9)) || ((topLayer[6] == 10) && (topLayer[8] == 12))
					|| ((topLayer[6] == 1) && (topLayer[8] == 3)) || ((topLayer[6] == 4) && (topLayer[8] == 6))) 
				{
					position=true;
				}
				else {
					U();
				}
			}
			aPerm();
		}
		System.out.println();
		System.out.println("2nd look");
	//2nd look	
		//loop until red corner is lined up, easier to search
		while(topLayer[0] != 1) {
			U(); 
		}
		//count complete sides
		count=0;
		if((topLayer[0] == 1) && (topLayer[1] == 2) && (topLayer[2] == 3)) {
			count++;
		}
		if((topLayer[3] == 4) && (topLayer[4] == 5) && (topLayer[5] == 6)) {
			count++;
		}
		if((topLayer[6] == 7) && (topLayer[7] == 8) && (topLayer[8] == 9)) {
			count++;
		}
		if((topLayer[9] == 10) && (topLayer[10] == 11) && (topLayer[11] == 12)) {
			count++;
		}
		//
		System.out.println();
		System.out.println("("+count+")");
		if(count == 1) {
		//loop until complete edge is in the front
			boolean position=false;
			while(!position) {
				if(((topLayer[0] == 1) && (topLayer[1] == 2) && (topLayer[2] == 3)) 
					|| ((topLayer[0] == 4) && (topLayer[1] == 5) && (topLayer[2] == 6))
					|| ((topLayer[0] == 7) && (topLayer[1] == 8) && (topLayer[2] == 9))
					|| ((topLayer[0] == 10) && (topLayer[1] == 11) && (topLayer[2] == 12))) 
				{
					position=true;
				}
				else {
					U();
				}
			}
			if( ((topLayer[4] == 11) && (topLayer[7] == 5) && (topLayer[10] == 8))
				|| ((topLayer[4] ==  2) && (topLayer[7] == 8) && (topLayer[10] == 11))
				|| ((topLayer[4] == 5) && (topLayer[7] == 11) && (topLayer[10] == 2))
				|| ((topLayer[4] == 8) && (topLayer[7] == 2) && (topLayer[10] == 5)) )
			{
				UaPerm();
			}
			else if( ((topLayer[10] == 5) && (topLayer[7] == 11) && (topLayer[4] == 8)) 
				|| ((topLayer[10] == 8) && (topLayer[7] == 2) && (topLayer[4] == 11))
				|| ((topLayer[10] == 11) && (topLayer[7] == 5) && (topLayer[4] == 2))
				|| ((topLayer[10] == 2) && (topLayer[7] == 8) && (topLayer[4] == 5)) )
			{
				UbPerm();
			}
		}
		//
		else if(count == 0) {
			if(topLayer[1] == 8) {
				hPerm();
			}
			else if(topLayer[1] == 5) {
				zPerm();
				U2();					
			}
			else if(topLayer[1] == 11) {
				U();
				zPerm();
				U();
			}
		}
	//AUF: Adjust upper layer according to face's center piece
		//red
		if(sliceLayer[1] == 14) {
			while(topLayer[0] != 1) {
				U(); 
			}
		}
		//green
		else if(sliceLayer[1] == 17) {
			while(topLayer[0] != 4) {
				U(); 
			}
		}
		//orange
		else if(sliceLayer[1] == 20) {
			while(topLayer[0] != 7) {
				U(); 
			}
		}
		//blue
		else if(sliceLayer[1] == 23) {
			while(topLayer[0] != 10) {
				U(); 
			}
		}
		
	}
//Algortithms

//triggers
	public static void sexy() {
		R(); U(); Rp(); Up();
	}
	public static void sexyLeft() {
		Lp(); Up(); L(); U();
	}
	public static void sledgehammer() {
		Rp(); F(); R(); Fp();
	}
	public static void sledgehammerLeft() {
		L(); Fp(); Lp(); F();
	}
	
//Flip cross edge
	public static void flipCrossEdge() {
		F(); Dp(); L(); D();
	}
//Edge insertion
	public static void insertLeftEdge() {
		Up(); Lp(); Up(); L(); U(); F(); U(); Fp();
	}
	public static void insertRightEdge() {
		U(); R(); U(); Rp(); Up(); Fp(); Up(); F();
	}
	
//OLL algorightms
	//2-Look
	//1st look
	public static void bar2look() {
		F(); sexy(); Fp();
	}
	public static void l2look() {
		F(); S(); sexy(); Fp(); Sp();
	}
	public static void dot2look() {
		bar2look(); l2look();
	}
	//2nd look
	public static void antiSune() {
		Lp();	U();	R();	Up();	L();	U();	Rp();
	}
	public static void sune() {
		R();	Up();	Lp();	U();	Rp();	Up();	L();	
	}
	public static void doubleHeadlightCross() {
		F(); sexy(); sexy(); sexy(); Fp();
	}
	public static void headlightCross() {
		R(); U2(); R2(); Up(); R2(); Up(); R2(); U2(); R();
	}
	public static void headlights() {
		R2(); D(); Rp(); U2(); R(); Dp(); Rp(); U2(); Rp(); 
	}
	public static void sidelights() {
		R(); Mp(); U(); Rp(); Up(); Rp(); M(); F(); R(); Fp(); 
	}
	public static void diagonalThing() {
		Fp(); R(); Mp(); U(); Rp(); Up(); Rp(); M(); F(); R(); 
	}
	
	
//PLL algorithms
	//2-Look
	//1st look
	public static void aPerm() {
		X(); Rp(); U(); Rp(); D2(); R(); Up(); Rp(); D2(); R2(); Xp(); 
	}
	public static void ePerm() {
		Xp(); R(); Up(); Rp(); D(); R(); U(); Rp(); U2(); E2(); Rp(); U(); R(); D(); Rp(); Up(); R(); Xp();
	}
	//2nd look
	public static void UbPerm() {
		L(); Up(); L(); U(); L(); U(); L(); Up(); Lp(); Up(); L2(); 
	}
	public static void UaPerm() {
		Rp(); U(); Rp(); Up(); Rp(); Up(); Rp(); U(); R(); U(); R2(); 
	}
	public static void hPerm() {
		M2(); U(); M2(); U2(); M2(); U(); M2(); 
	}
	public static void zPerm() {
		M2(); U(); M2(); U(); Mp(); U2(); M2(); U2(); Mp();
	}
	
//Compare method
	public static void compare() {
		int correct = 0;
		int incorrect = 0;
		for(int j=0; j<5; j++) {
			createCube();
			scramble();
			cross();
			corners();
			secondLayer();
			oll();
			pll();
			int count = 0;
			for(int i=0; i<LENGTH; i++) {
				if(leftLayer[i] == leftLayer2[i])
					count++;
				if(middleLayer[i] == middleLayer2[i])
					count++;
				if(rightLayer[i] == rightLayer2[i])
					count++;
			}
			if(count == 36)
				correct++;
			else {
				for(int k=0; k<4; k++) {
					for(int i=0; i<LENGTH; i++) {
						if(leftLayer[i] == leftLayer2[i])
							count++;
						if(middleLayer[i] == middleLayer2[i])
							count++;
						if(rightLayer[i] == rightLayer2[i])
							count++;
					}
				}
				if(count == 36)
					correct++;
				else {
					incorrect++;
				}
			}
		}
		System.out.println();
		System.out.println("Solved: " + correct);
		System.out.println("Not solved: " + incorrect);
	}
}
