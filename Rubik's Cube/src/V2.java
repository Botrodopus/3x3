/*
 * -The goal of Version 2 is to make solutions more efficient by 
 *  having the cube be represented by colors rather than numbers.
 *   -This requires me to rethink how roatations work, since
 *    chars can't be added
 * -Loop breaks and continues will eliminate unnecessary loop iterations
 * -Moves will not be printed directly, instead they will be put into an
 *  arrayList then simplified to avoid redundant or unnecessary  rotations
 * -2 Look will be replaced by 2 methods that do the first and second look,
 *  this is to make the code more legible and easier to understand
 * -Some layer arrays will be renamed for accuracy
 */

import java.util.Arrays;

public class V2 {
	
	public static int LENGTH = 12;
	public static char[] topLayer = new char[LENGTH];
	public static char[] equatorLayer = new char[LENGTH];
	public static char[] bottomLayer = new char[LENGTH];
	public static char[] leftLayer = new char[LENGTH];
	public static char[] middleLayer = new char[LENGTH];
	public static char[] rightLayer = new char[LENGTH];
	public static char[] frontLayer = new char[LENGTH];
	public static char[] sliceLayer = new char[LENGTH]; 
	public static char[] backLayer = new char[LENGTH];
	public static char R = 'R', G = 'G', O = 'O', B = 'B', W = 'W', Y = 'Y';
	
	public static void main(String[] args) {
		createCube();
		scramble();
		print();
		cross();
		print();
//		corners();
//		print();
//		secondLayer();
//		print();
//		oll();
//		print();
//		pll();
//		print();
	}
	
//print each layer
	public static void print() {
		System.out.println();
		System.out.println(Arrays.toString(leftLayer));
		System.out.println(Arrays.toString(middleLayer));
		System.out.println(Arrays.toString(rightLayer));
		System.out.println(Arrays.toString(topLayer));
		System.out.println(Arrays.toString(equatorLayer));
		System.out.println(Arrays.toString(bottomLayer));
		System.out.println(Arrays.toString(frontLayer));
		System.out.println(Arrays.toString(sliceLayer));
		System.out.println(Arrays.toString(backLayer));
		System.out.println();
	}
	

//create solved cube
	public static void createCube() {
		//create horizontal rows
		for(int x=0; x<3; x++) {
			topLayer[x] = R;
			equatorLayer[x] = R;
			bottomLayer[x] = R;
		}
		for(int x=3; x<6; x++) {
			topLayer[x] = G;
			equatorLayer[x] = G;
			bottomLayer[x] = G;
		}
		for(int x=6; x<9; x++) {
			topLayer[x] = O;
			equatorLayer[x] = O;
			bottomLayer[x] = O;
		}
		for(int x=9; x<12; x++) {
			topLayer[x] = B;
			equatorLayer[x] = B;
			bottomLayer[x] = B;
		}
	//create left column
		leftLayer[0] = Y;
		leftLayer[1] = Y;
		leftLayer[2] = Y;
		leftLayer[3] = topLayer[0];
		leftLayer[4] = equatorLayer[0];
		leftLayer[5] = bottomLayer[0];
		leftLayer[6] = W;
		leftLayer[7] = W;
		leftLayer[8] = W;
		leftLayer[9] = bottomLayer[8];
		leftLayer[10] = equatorLayer[8];
		leftLayer[11] = topLayer[8];
	//create middle column
		middleLayer[0] = Y;
		middleLayer[1] = Y;
		middleLayer[2] = Y;
		middleLayer[3] = topLayer[1];
		middleLayer[4] = equatorLayer[1];
		middleLayer[5] = bottomLayer[1];
		middleLayer[6] = W;
		middleLayer[7] = W;
		middleLayer[8] = W;
		middleLayer[9] = bottomLayer[7];
		middleLayer[10] = equatorLayer[7];
		middleLayer[11] = topLayer[7];
	//create right column
		rightLayer[0] = Y;
		rightLayer[1] = Y;
		rightLayer[2] = Y;
		rightLayer[3] = topLayer[2];
		rightLayer[4] = equatorLayer[2];
		rightLayer[5] = bottomLayer[2];
		rightLayer[6] = W;
		rightLayer[7] = W;
		rightLayer[8] = W;
		rightLayer[9] = bottomLayer[6];
		rightLayer[10] = equatorLayer[6];
		rightLayer[11] = topLayer[6];
	//create front column
		frontLayer[0] = leftLayer[2];
		frontLayer[1] = middleLayer[2];
		frontLayer[2] = rightLayer[2];
		frontLayer[3] = topLayer[3];
		frontLayer[4] = equatorLayer[3];
		frontLayer[5] = bottomLayer[3];
		frontLayer[6] = rightLayer[6];
		frontLayer[7] = middleLayer[6];
		frontLayer[8] = leftLayer[6];
		frontLayer[9] = bottomLayer[11];
		frontLayer[10] = equatorLayer[11];
		frontLayer[11] = topLayer[11];
	//create mid-slice column
		sliceLayer[0] = leftLayer[1];
		sliceLayer[1] = middleLayer[1];
		sliceLayer[2] = rightLayer[1];
		sliceLayer[3] = topLayer[4];
		sliceLayer[4] = equatorLayer[4];
		sliceLayer[5] = bottomLayer[4];
		sliceLayer[6] = rightLayer[7];
		sliceLayer[7] = middleLayer[7];
		sliceLayer[8] = leftLayer[7];
		sliceLayer[9] = bottomLayer[10];
		sliceLayer[10] = equatorLayer[10];
		sliceLayer[11] = topLayer[10];
	//create back column
		backLayer[0] = leftLayer[0];
		backLayer[1] = middleLayer[0];
		backLayer[2] = rightLayer[0];
		backLayer[3] = topLayer[5];
		backLayer[4] = equatorLayer[5];
		backLayer[5] = bottomLayer[5];
		backLayer[6] = rightLayer[8];
		backLayer[7] = middleLayer[8];
		backLayer[8] = leftLayer[8];
		backLayer[9] = bottomLayer[9];
		backLayer[10] = equatorLayer[9];
		backLayer[11] = topLayer[9];
	}
	

//Create layers
	public static void updateFront() {
		frontLayer[0] = leftLayer[2];
		frontLayer[1] = middleLayer[2];
		frontLayer[2] = rightLayer[2];
		frontLayer[3] = topLayer[3];
		frontLayer[4] = equatorLayer[3];
		frontLayer[5] = bottomLayer[3];
		frontLayer[6] = rightLayer[6];
		frontLayer[7] = middleLayer[6];
		frontLayer[8] = leftLayer[6];
		frontLayer[9] = bottomLayer[11];
		frontLayer[10] = equatorLayer[11];
		frontLayer[11] = topLayer[11];
	}
	
	public static void updateSlice() {
		sliceLayer[0] = leftLayer[1];
		sliceLayer[1] = middleLayer[1];
		sliceLayer[2] = rightLayer[1];
		sliceLayer[3] = topLayer[4];
		sliceLayer[4] = equatorLayer[4];
		sliceLayer[5] = bottomLayer[4];
		sliceLayer[6] = rightLayer[7];
		sliceLayer[7] = middleLayer[7];
		sliceLayer[8] = leftLayer[7];
		sliceLayer[9] = bottomLayer[10];
		sliceLayer[10] = equatorLayer[10];
		sliceLayer[11] = topLayer[10];
	}
	
	public static void updateBack() {
		backLayer[0] = leftLayer[0];
		backLayer[1] = middleLayer[0];
		backLayer[2] = rightLayer[0];
		backLayer[3] = topLayer[5];
		backLayer[4] = equatorLayer[5];
		backLayer[5] = bottomLayer[5];
		backLayer[6] = rightLayer[8];
		backLayer[7] = middleLayer[8];
		backLayer[8] = leftLayer[8];
		backLayer[9] = bottomLayer[9];
		backLayer[10] = equatorLayer[9];
		backLayer[11] = topLayer[9];
	}
	
	public static void updateLeft() {
		leftLayer[0] = backLayer[0];
		leftLayer[1] = sliceLayer[0];
		leftLayer[2] = frontLayer[0];
		leftLayer[3] = topLayer[0];
		leftLayer[4] = equatorLayer[0];
		leftLayer[5] = bottomLayer[0];
		leftLayer[6] = frontLayer[8];
		leftLayer[7] = sliceLayer[8];
		leftLayer[8] = backLayer[8];
		leftLayer[9] = bottomLayer[8];
		leftLayer[10] = equatorLayer[8];
		leftLayer[11] = topLayer[8];
	}
	
	public static void updateRight() {
		rightLayer[0] = backLayer[2];
		rightLayer[1] = sliceLayer[2];
		rightLayer[2] = frontLayer[2];
		rightLayer[3] = topLayer[2];
		rightLayer[4] = equatorLayer[2];
		rightLayer[5] = bottomLayer[2];
		rightLayer[6] = frontLayer[6];
		rightLayer[7] = sliceLayer[6];
		rightLayer[8] = backLayer[6];
		rightLayer[9] = bottomLayer[6];
		rightLayer[10] = equatorLayer[6];
		rightLayer[11] = topLayer[6];
	}
	
	public static void updateMiddle() {
		middleLayer[0] = backLayer[1];
		middleLayer[1] = sliceLayer[1];
		middleLayer[2] = frontLayer[1];
		middleLayer[3] = topLayer[1];
		middleLayer[4] = equatorLayer[1];
		middleLayer[5] = bottomLayer[1];
		middleLayer[6] = frontLayer[7];
		middleLayer[7] = sliceLayer[7];
		middleLayer[8] = backLayer[7];
		middleLayer[9] = bottomLayer[7];
		middleLayer[10] = equatorLayer[7];
		middleLayer[11] = topLayer[7];
	}
	
	public static void updateTop() {
		topLayer[0] = leftLayer[3];
		topLayer[1] = middleLayer[3];
		topLayer[2] = rightLayer[3];
		topLayer[3] = frontLayer[3];
		topLayer[4] = sliceLayer[3];
		topLayer[5] = backLayer[3];
		topLayer[6] = rightLayer[11];
		topLayer[7] = middleLayer[11];
		topLayer[8] = leftLayer[11];
		topLayer[9] = backLayer[11];
		topLayer[10] = sliceLayer[11];
		topLayer[11] = frontLayer[11];
	}
	
	public static void updateBottom() {
		bottomLayer[0] = leftLayer[5];
		bottomLayer[1] = middleLayer[5];
		bottomLayer[2] = rightLayer[5];
		bottomLayer[3] = frontLayer[5];
		bottomLayer[4] = sliceLayer[5];
		bottomLayer[5] = backLayer[5];
		bottomLayer[6] = rightLayer[9];
		bottomLayer[7] = middleLayer[9];
		bottomLayer[8] = leftLayer[9];
		bottomLayer[9] = backLayer[9];
		bottomLayer[10] = sliceLayer[9];
		bottomLayer[11] = frontLayer[9];
	}
	
	public static void updateEquator() {
		equatorLayer[0] = leftLayer[4];
		equatorLayer[1] = middleLayer[4];
		equatorLayer[2] = rightLayer[4];
		equatorLayer[3] = frontLayer[4];
		equatorLayer[4] = sliceLayer[4];
		equatorLayer[5] = backLayer[4];
		equatorLayer[6] = rightLayer[10];
		equatorLayer[7] = middleLayer[10];
		equatorLayer[8] = leftLayer[10];
		equatorLayer[9] = backLayer[10];
		equatorLayer[10] = sliceLayer[10];
		equatorLayer[11] = frontLayer[10];
	}

		
//Rotations
//R, R', L, L', U, U', D, D', F, F', B, B', M, M', S, S', E, E'	
	public static void R() {
	//shift
		char hold1 = rightLayer[0];
		char hold2 = rightLayer[1];
		char hold3 = rightLayer[2];
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
		frontLayer[4] = sliceLayer[5];
		hold2 = sliceLayer[3];
		sliceLayer[3] = hold1;
		hold1 = backLayer[4];
		backLayer[4] = hold2;
		sliceLayer[5] = hold1;
	//update affected layers	
		updateTop();
		updateEquator();
		updateBottom();
		updateFront();
		updateSlice();
		updateBack();
		System.out.print("R, ");
	}
	
	public static void Rp() {
	//shift
		char hold1 = rightLayer[9];
		char hold2 = rightLayer[10];
		char hold3 = rightLayer[11];
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
		frontLayer[4] = sliceLayer[3];
		hold2 = sliceLayer[5];
		sliceLayer[5] = hold1;
		hold1 = backLayer[4];
		backLayer[4] = hold2;
		sliceLayer[3] = hold1;	
	//update affected layers
		updateTop();
		updateEquator();
		updateBottom();
		updateFront();
		updateSlice();
		updateBack();
		System.out.print("R', ");
	}
	
	public static void L() {
	//shift
		char hold1 = leftLayer[9];
		char hold2 = leftLayer[10];
		char hold3 = leftLayer[11];
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
		frontLayer[10] = sliceLayer[11];
		hold2 = sliceLayer[9];
		sliceLayer[9] = hold1;
		hold1 = backLayer[10];
		backLayer[10] = hold2;
		sliceLayer[11] = hold1;
	//update affected layers
		updateTop();
		updateEquator();
		updateBottom();
		updateFront();
		updateSlice();
		updateBack();
		System.out.print("L, ");
	}
	
	public static void Lp() {
		//shift
		char hold1 = leftLayer[0];
		char hold2 = leftLayer[1];
		char hold3 = leftLayer[2];
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
		frontLayer[10] = sliceLayer[9];
		hold2 = sliceLayer[11];
		sliceLayer[11] = hold1;
		hold1 = backLayer[10];
		backLayer[10] = hold2;
		sliceLayer[9] = hold1;
	//update affected layers		
		updateTop();
		updateEquator();
		updateBottom();
		updateFront();
		updateSlice();
		updateBack();
		System.out.print("L', ");
	}
	
	public static void U() {
		//shift
		char hold1 = topLayer[0];
		char hold2 = topLayer[1];
		char hold3 = topLayer[2];
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
		frontLayer[1] = sliceLayer[2];
		hold2 = sliceLayer[0];
		sliceLayer[0] = hold1;
		hold1 = backLayer[1];
		backLayer[1] = hold2;
		sliceLayer[2] = hold1;	
	//update affected layers
		updateLeft();
		updateMiddle();
		updateRight();
		updateFront();
		updateSlice();
		updateBack();
		System.out.print("U, ");
	}
	
	public static void Up() {
		//shift
		char hold1 = topLayer[9];
		char hold2 = topLayer[10];
		char hold3 = topLayer[11];
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
		frontLayer[1] = sliceLayer[0];
		hold2 = sliceLayer[2];
		sliceLayer[2] = hold1;
		hold1 = backLayer[1];
		backLayer[1] = hold2;
		sliceLayer[0] = hold1;	
	//update affected layers
		updateLeft();
		updateMiddle();
		updateRight();
		updateFront();
		updateSlice();
		updateBack();
		System.out.print("U', ");
	}
	
	public static void D() {
		//shift
		char hold1 = bottomLayer[9];
		char hold2 = bottomLayer[10];
		char hold3 = bottomLayer[11];
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
		frontLayer[7] = sliceLayer[8];
		hold2 = sliceLayer[6];
		sliceLayer[6] = hold1;
		hold1 = backLayer[7];
		backLayer[7] = hold2;
		sliceLayer[8] = hold1;	
	//update affected layers
		updateLeft();
		updateMiddle();
		updateRight();
		updateFront();
		updateSlice();
		updateBack();
		System.out.print("D, ");
	}
	
	public static void Dp() {
		//shift
		char hold1 = bottomLayer[0];
		char hold2 = bottomLayer[1];
		char hold3 = bottomLayer[2];
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
		frontLayer[7] = sliceLayer[6];
		hold2 = sliceLayer[8];
		sliceLayer[8] = hold1;
		hold1 = backLayer[7];
		backLayer[7] = hold2;
		sliceLayer[6] = hold1;	
	//update affected layers
		updateLeft();
		updateMiddle();
		updateRight();
		updateFront();
		updateSlice();
		updateBack();		
		System.out.print("D', ");
	}
	
	public static void F() {
	//shift
		char hold1 = frontLayer[9];
		char hold2 = frontLayer[10];
		char hold3 = frontLayer[11];
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
		updateTop();
		updateEquator();
		updateBottom();
		updateLeft();
		updateMiddle();
		updateRight();
		System.out.print("F, ");
	}
	
	public static void Fp() {
		//shift
		char hold1 = frontLayer[0];
		char hold2 = frontLayer[1];
		char hold3 = frontLayer[2];
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
		updateTop();
		updateEquator();
		updateBottom();
		updateLeft();
		updateMiddle();
		updateRight();
		System.out.print("F', ");
	}
	
	public static void B() {
		char hold1 = backLayer[0];
		char hold2 = backLayer[1];
		char hold3 = backLayer[2];
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
		updateTop();
		updateEquator();
		updateBottom();
		updateLeft();
		updateMiddle();
		updateRight();
		System.out.print("B, ");
	}
	
	public static void Bp() {
		char hold1 = backLayer[9];
		char hold2 = backLayer[10];
		char hold3 = backLayer[11];
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
		updateTop();
		updateEquator();
		updateBottom();
		updateLeft();
		updateMiddle();
		updateRight();
		System.out.print("B', ");
	}
	
	public static void M() {
	//shift
		char hold1 = middleLayer[9];
		char hold2 = middleLayer[10];
		char hold3 = middleLayer[11];
		for(int i=LENGTH-1; i>=3; i--) {
			middleLayer[i] = middleLayer[i-3];			
		}
		middleLayer[0] = hold1;
		middleLayer[1] = hold2;
		middleLayer[2] = hold3;
	//update affected layers
		updateTop();
		updateEquator();
		updateBottom();
		updateFront();
		updateSlice();
		updateBack();
		System.out.print("M, ");
	}
	
	public static void Mp() {
	//shift
		char hold1 = middleLayer[0];
		char hold2 = middleLayer[1];
		char hold3 = middleLayer[2];
		for(int i=0; i<LENGTH-3; i++) {
			middleLayer[i] = middleLayer[i+3];			
		}
		middleLayer[9] = hold1;
		middleLayer[10] = hold2;
		middleLayer[11] = hold3;
	//update affected layers
		updateTop();
		updateEquator();
		updateBottom();
		updateFront();
		updateSlice();
		updateBack();
		System.out.print("M', ");
	}

	public static void S() {
	//shift
		char hold1 = sliceLayer[9];
		char hold2 = sliceLayer[10];
		char hold3 = sliceLayer[11];
		for(int i=LENGTH-1; i>=3; i--) {
			sliceLayer[i] = sliceLayer[i-3];			
		}
		sliceLayer[0] = hold1;
		sliceLayer[1] = hold2;
		sliceLayer[2] = hold3;
	//update affected layers
		updateLeft();
		updateMiddle();
		updateRight();
		updateTop();
		updateEquator();
		updateBottom();
		System.out.print("S, ");
	}
	
	public static void Sp() {
	//shift
		char hold1 = sliceLayer[0];
		char hold2 = sliceLayer[1];
		char hold3 = sliceLayer[2];
		for(int i=0; i<LENGTH-3; i++) {
			sliceLayer[i] = sliceLayer[i+3];			
		}
		sliceLayer[9] = hold1;
		sliceLayer[10] = hold2;
		sliceLayer[11] = hold3;
	//update affected layers
		updateLeft();
		updateMiddle();
		updateRight();
		updateTop();
		updateEquator();
		updateBottom();
		System.out.print("S', ");
	}
	
	public static void E() {
	//shift
		char hold1 = equatorLayer[9];
		char hold2 = equatorLayer[10];
		char hold3 = equatorLayer[11];
		for(int i=LENGTH-1; i>=3; i--) {
			equatorLayer[i] = equatorLayer[i-3];			
		}
		equatorLayer[0] = hold1;
		equatorLayer[1] = hold2;
		equatorLayer[2] = hold3;
	//update affected layers
		updateLeft();
		updateMiddle();
		updateRight();
		updateFront();
		updateSlice();
		updateBack();
		System.out.print("E, ");
	}
	
	public static void Ep() {
	//shift
		char hold1 = equatorLayer[0];
		char hold2 = equatorLayer[1];
		char hold3 = equatorLayer[2];
		for(int i=0; i<LENGTH-3; i++) {
			equatorLayer[i] = equatorLayer[i+3];			
		}
		equatorLayer[9] = hold1;
		equatorLayer[10] = hold2;
		equatorLayer[11] = hold3;
	//update affected layers
		updateLeft();
		updateMiddle();
		updateRight();
		updateFront();
		updateSlice();
		updateBack();
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

//Solve
//First Layer
	public static void cross() {
		//Begins by counting how many cross edges are already correctly placed
		int count=0;
		if((middleLayer[6] == W) && (middleLayer[5] == R)) { count++; }
		if((middleLayer[8] == W) && (middleLayer[9] == O)) { count++; }
		if((sliceLayer[6] == W) && (sliceLayer[5] == G))   { count++; }
		if((sliceLayer[8] == W) && (sliceLayer[9] == B))   { count++; }
		
		System.out.println(count);
		//Loop while cross is not complete
		//Loops through each layer looking for white, then placing it accordingly
		//Counts how many cross edges have been placed, breaks after layer has been checked if i==4
		while( ! ((middleLayer[6] == W) && (middleLayer[8] == W) && (sliceLayer[6] == W) && (sliceLayer[8] == W)) ) {
			//Check for cross edges that are oriented correctly but in the wrong spot
			//If it's wrong, moves it, brings correct slot over and replaces it
			for(int i=1; i<=4; i++) {
				if((middleLayer[6] == W) && (middleLayer[5] != middleLayer[4])) {
					Fp();
					if(middleLayer[5] == equatorLayer[4]) {
						Dp(); F(); D(); count++;
					}
					else if(middleLayer[5] == equatorLayer[10]) {
						D(); F(); Dp(); count++;
					}
					else if(middleLayer[5] == equatorLayer[4]){
						D2(); F(); D2(); count++;
					}
				}
				Y();
			}
			if(count==4) { break; }
			
			//Checks for flipped edges by identifying if they are in the bottom row, then
			//places them according to their center piece
			for(int i=1; i<=4; i++) {
				if(bottomLayer[1] == W) {
					if(equatorLayer[0] != R) {
						if(middleLayer[6] == equatorLayer[4]) {
							Fp(); Rp(); count++;
						}
						else if(middleLayer[6] == equatorLayer[10]) {
							F(); L(); count++;
						}
						else {
							Fp(); Dp(); Rp(); D(); count++;
						}
					}
				}
				else {
					flipCrossEdge(); count++;
				}
				Y();
			}
			if(count==4) { break; }
			
			//Put red center back in front
			while(equatorLayer[1] != R) { Y(); }
			
			//check second (equator) layer for white edge, insert
			for(int i=1; i<=4; i++) {
				if(equatorLayer[0] == W) {
					if(equatorLayer[11] == R) {
						Dp(); L(); D(); count++;
					}
					else if(equatorLayer[11] == G) {
						D2(); L(); D2(); count++;
					}
					else if(equatorLayer[11] == O) {
						D(); L(); Dp(); count++;
					}
					else {
						L(); count++;
					}
				}
				if(equatorLayer[2] == W) {
					if(equatorLayer[3] == O) {
						Dp(); Rp(); D(); count++;
					}
					else if(equatorLayer[3] == B) {
						D2(); Rp(); D2(); count++;
					}
					else if(equatorLayer[3] == R) {
						D(); Rp(); Dp(); count++;
					}
					else {
						Rp(); count++;
					}
				}
				if(equatorLayer[3] == W) {
					if(equatorLayer[2] == G) {
						Dp(); F(); D(); count++;
					}
					else if(equatorLayer[2] == O) {
						D2(); F(); D2(); count++;
					}
					else if(equatorLayer[2] == B) {
						D(); F(); Dp(); count++;
					}
					else {
						F(); count++;
					}
				}
				if(equatorLayer[5] == W) {
					if(equatorLayer[6] == B) {
						Dp(); Bp(); D(); count++;
					}
					else if(equatorLayer[6] == R) {
						D2(); Bp(); D2(); count++;
					}
					else if(equatorLayer[6] == G) {
						D(); Bp(); Dp(); count++;
					}
					else {
						Bp(); count++;
					}
				}
				if(equatorLayer[6] == W) {
					if(equatorLayer[5] == O) {
						Dp(); R(); D(); count++;
					}
					else if(equatorLayer[5] == B) {
						D2(); R(); D2(); count++;
					}
					else if(equatorLayer[5] == R) {
						D(); R(); Dp(); count++;
					}
					else {
						R(); count++;
					}
				}
				if(equatorLayer[8] == W) {
					if(equatorLayer[9] == R) {
						Dp(); Lp(); D(); count++;
					}
					else if(equatorLayer[9] == G) {
						D2(); Lp(); D2(); count++;
					}
					else if(equatorLayer[9] == O) {
						D(); Lp(); Dp(); count++;
					}
					else {
						Lp(); count++;
					}
				}
				if(equatorLayer[9] == W) {
					if(equatorLayer[8] == B) {
						Dp(); B(); D(); count++;
					}
					else if(equatorLayer[8] == R) {
						D2(); B(); D2(); count++;
					}
					else if(equatorLayer[8] == G) {
						D(); B(); Dp(); count++;
					}
					else {
						B(); count++;
					}
				}
				if(equatorLayer[11] == W) {
					if(equatorLayer[0] == G) {
						Dp(); Fp(); D(); count++;
					}
					else if(equatorLayer[0] == O) {
						D2(); Fp(); D2(); count++;
					}
					else if(equatorLayer[0] == B) {
						D(); Fp(); Dp(); count++;
					}
					else {
						Fp(); count++;
					}
				}
			}
			if(count==4) { break; }
			
			//check third (top) layer for white edge, insert
			//loop to put edge in front so that it can recognize where the colors go
			for(int i=0; i<4; i++) {
				U();
				if(topLayer[1] == W) {
					if(frontLayer[1] == equatorLayer[4]) {
						F(); Rp(); Fp(); count++; continue;
					}
					else if(frontLayer[1] == equatorLayer[10]) {
						Fp(); L(); F(); count++; continue;
					}
					else if(frontLayer[1] == equatorLayer[1]) {
						U(); Rp(); F(); R(); count++; continue;
					}
					else if(frontLayer[1] == equatorLayer[7]) {
						U(); R(); Bp(); Rp(); count++; continue;
					}
				}
			}
			if(count==4) { break; }
			
			//check top face for white edges, insert
			//loop to compare color next to white piece to centers
			for(int i=0; i<4; i++) {
				U();
				if(frontLayer[1] == W) {
					if(topLayer[1] == equatorLayer[4]) {
						Up(); R2(); count++; continue;
					}
					else if(topLayer[1] == equatorLayer[10]) {
						Up(); L2(); count++; continue;
					}
					else if(topLayer[1] == equatorLayer[1]) {
						F2(); count++; continue;
					}
					else if(topLayer[1] == equatorLayer[7]) {
						U2(); B2(); count++; continue;
					}
				}
			}
			if(count==4) { break; }
		}
	}
	
//Corners
	public static void corners() {
		//Begins by counting how many corners are already correctly placed
		//Logic: checks if colors next to cross edges match, only the correct corner matches both
		int count=0;
		if((bottomLayer[0] == bottomLayer[1]) && (bottomLayer[11] == bottomLayer[10])) { count++; }
		if((bottomLayer[2] == bottomLayer[1]) && (bottomLayer[3] == bottomLayer[4]))   { count++; }
		if((bottomLayer[5] == bottomLayer[4]) && (bottomLayer[6] == bottomLayer[7]))   { count++; }
		if((bottomLayer[8] == bottomLayer[7]) && (bottomLayer[9] == bottomLayer[10]))  { count++; }
		
		while(count != 4) {
			//Check for corners that are oriented correctly but in the wrong spot
			//If it's wrong, moves correct slot under, places corner: pinhole method (sort of)
			//correct slot is based on matching side of corner with its cross edge
			for(int i=1; i<=4; i++) {
				if((frontLayer[8] == W) && (bottomLayer[0] != bottomLayer[1])) {
					Lp(); Up(); L();
					while(frontLayer[2] != bottomLayer[1]) {
						Dp();
					}
					Lp(); U(); L();	count++;			
				}
				Dp();
			}
			if(count==4) { break; }
			
			//Check bottom layer for corners, places them where they should be
			//while loop until none of the bottomLayer pieces are W
			while( ! ((bottomLayer[0]==W) || (bottomLayer[2]==W) || (bottomLayer[3]==W) || (bottomLayer[5]==W)
				  || (bottomLayer[6]==W) || (bottomLayer[8]==W) || (bottomLayer[9]==W) || (bottomLayer[11]==W)) ) {
				//check bottom left corner
				if(bottomLayer[0] == W) {
					Lp(); U(); L(); Up();
					while(topLayer[2] != bottomLayer[1]) {
						D();
					}
					R(); U(); Rp(); count++;
				}
				//check bottom right corner
				else if(bottomLayer[2]== W){
					R(); Up(); Rp(); U();
					while(topLayer[0] != bottomLayer[4]) {
						D();
					}
					R(); Up(); Rp(); count++;
				}
				D();
			}
			if(count==4) { break; }
			
			//check top layer for white corner, matches it with its cross edge, insert
			while( ! ((topLayer[0] == W) || (topLayer[2] == W) || (topLayer[3] == W) || (topLayer[5] == W)
				  || (topLayer[6] == W) || (topLayer[8] == W) || (topLayer[9] == W) || (topLayer[11] == W)) ) {
				//check top left corner
				if(topLayer[0] == W) {
					while(topLayer[11] != bottomLayer[1]) {
						Dp();
					}
					Up(); R(); U(); Rp(); count++;
				}
				//check top right corner 
				if(topLayer[2] == W) {
					while(topLayer[3] != bottomLayer[4]) {
						Dp();
					}
					Fp(); Up(); F(); count++;
				}
				U();
			}
			if(count==4) { break; }
			
			//check top face for corners
			while( ! (frontLayer[0] == W) || (frontLayer[2] == W) || (backLayer[0] == W) || (backLayer[2] == W) ) {
				//check if top-face bottom left corner is white --> insert
				if(frontLayer[0] == W) {
					while(topLayer[0] != bottomLayer[1]) {
						D();
					}
					R(); U2(); Rp(); U(); R(); Up(); Rp(); count++;
				}
				//Moves on to next corner
				U();
			}
			if(count==4) { break; }
		
		//At this point, if "count" isn't 4 yet, it will loop back and try the whole process again
		//If count reached 4 at any point before the end of the loop iteration, it will have broken out
		}
	}
	
//Second Layer
	public static void secondLayer() {
		//Start by counting how many edges are already in place
		//Next, will check top layer for edges and place them, will continue looping until top has no edges
		//Next, will take out and place incorrectly placed or flipped edges
		int count=0;
		if((equatorLayer[0] == equatorLayer[1]) && (equatorLayer[11] == equatorLayer[10])) { count++; }
		if((equatorLayer[2] == equatorLayer[1]) && (equatorLayer[3] == equatorLayer[4]))   { count++; }
		if((equatorLayer[5] == equatorLayer[4]) && (equatorLayer[6] == equatorLayer[7]))   { count++; }
		if((equatorLayer[8] == equatorLayer[7]) && (equatorLayer[9] == equatorLayer[10]))  { count++; }
		
		//check top layer for edges --> insert
		while( ! (topLayer[1] == Y) || (topLayer[4] == Y) || (topLayer[7] == Y) || (topLayer[10] == Y)
				|| (frontLayer[1] == Y) || (sliceLayer[0] == Y) || (sliceLayer[2] == Y) || (backLayer[1] == Y) ) {
			//check if front edge doesn't have yellow, then place it
			if( (topLayer[1] != Y) && (frontLayer[1] != Y) ) {
				while(!(topLayer[1] != equatorLayer[1])) {
					E();
				}
				if(frontLayer[1] == equatorLayer[11]) {
					insertLeftEdge(); count++;
				}
				if(frontLayer[1] == equatorLayer[3]) {
					insertRightEdge(); count++;
				}
			}
			if(count==4) { break; }
			//rotate to put next edge in front and repeat
			//keep repeating until there are no edges ontop
			U();
		}
		
		//check second layer for incorrect edges --> take out+insert correctly one at a time
		while(count != 4) {
			if( (equatorLayer[1] != equatorLayer[2]) && (equatorLayer[3] != equatorLayer[4]) ) {
				//take out edge, line up equator layer, insert edge
				insertRightEdge();
				while(backLayer[1] != equatorLayer[1]) {
					E();
				}
				if(topLayer[7] == equatorLayer[4]) {
					altInsertRightEdge(); count++;
				}
				else if(topLayer[7] == equatorLayer[10]) {
					Ep(); U2(); insertLeftEdge(); count++;
				}
			}
			E();
		}
		//reorient bottom layer
		while(bottomLayer[1] != equatorLayer[1]) {
			D();
		}
	}
	
//OLL
	public static void oll() {
		firstLookOll();
		secondLookOll();
	}
	
	//1st look
	public static void firstLookOll() {
		//Dot case
		if( (frontLayer[1] != Y) && (sliceLayer[0] != Y) && (sliceLayer[2] != Y) && (backLayer[1] != Y) ) {
			dot2look();
		}
		//Bar case
		else if( (frontLayer[1] != Y) && (sliceLayer[0] == Y) && (sliceLayer[2] == Y) && (backLayer[1] != Y) ) {
			bar2look();
		}
		//Incorrectly rotated bar case
		else if( (frontLayer[1] == Y) && (sliceLayer[0] != Y) && (sliceLayer[2] != Y) && (backLayer[1] == Y) ) {
			U(); bar2look();
		}
		//L case: it can be oriented 4 ways, so loop until it is correct
		else {
			for(int i=0; i<4; i++) {
				if( (frontLayer[1] == Y) && (sliceLayer[0] != Y) && (sliceLayer[2] == Y) && (backLayer[1] != Y) ) {
					dot2look(); 
					break;
				}
				else {
					U();
				}
			}
		}
	}
	
	//2nd look
	public static void secondLookOll() {
		//Check all 7 cases, then rotate so that it checks them all at once
		//Do this by checking corners, edges will be oriented in every case
		//Also check topLayer to identify exactly what case it is
		for(int i=0; i<4; i++) {
			//sune
			if( ((frontLayer[0] == Y) && (frontLayer[2] != Y) && (backLayer[0] != Y) && (backLayer[2] != Y))
				&& ((topLayer[2] == Y) && (topLayer[5] == Y) && (topLayer[8] == Y)) ) {
				sune(); 
				break;
			}
			//anti-sune
			if( ((frontLayer[0] != Y) && (frontLayer[2] != Y) && (backLayer[0] != Y) && (backLayer[2] == Y) )
				&& ((topLayer[0] == Y) && (topLayer[3] == Y) && (topLayer[9] == Y)) ){
				antiSune(); 
				break;
			}	
			//double headlight cross cross
			if( ((frontLayer[0] != Y) && (frontLayer[2] != Y) && (backLayer[0] != Y) && (backLayer[2] != Y)) 
				&& ((topLayer[0] == Y) && (topLayer[2] == Y) && (topLayer[6] == Y) && (topLayer[8] == Y)) ) {
				doubleHeadlightCross(); 
				break;
			}
			//other cross
			if( ((frontLayer[0] != Y) && (frontLayer[2] != Y) && (backLayer[0] != Y) && (backLayer[2] != Y))
				&& ((topLayer[2] == Y) && (topLayer[6] == Y) && (topLayer[9] == Y) && (topLayer[11] == Y)) ) {
				headlightCross(); 
				break;
			}
			//headlights
			if( ((frontLayer[0] != Y) && (frontLayer[2] != Y) && (backLayer[0] == Y) && (backLayer[2] == Y))
				&& ((topLayer[0] == Y) && (topLayer[2] == Y)) ) {
				headlights(); 
				break;
			}
			//sidelights
			if( ((frontLayer[0] != Y) && (frontLayer[2] == Y) && (backLayer[0] != Y) && (backLayer[2] == Y))
				&& ((topLayer[0] == Y) && (topLayer[8] == Y)) ) {
				sidelights(); 
				break;
			}
			//diagonal thing
			if( ((frontLayer[0] != Y) && (frontLayer[2] == Y) && (backLayer[0] == Y) && (backLayer[2] != Y))
				&& ((topLayer[0] == Y) && (topLayer[5] == Y)) ) {
				diagonalThing(); 
				break;
			}
		}
				
	}

//PLL
	public static void pll() {
		firstLookPll();
		secondLookPll();
		//AUF
		while(topLayer[1] != equatorLayer[1]) {
			U();
		}
	}
	
	//1st look
	public static void firstLookPll() {		
		//Search for only 1 pair of corners in the back
		for(int i=0; i<4; i++) {
			if( (topLayer[6] == topLayer[8]) && (topLayer[0] != topLayer[2]) ) {
				AaPerm(); break;
			}
			U();
		}
		
		//when there are no corner pairs
		if( (topLayer[6] != topLayer[8]) && (topLayer[0] != topLayer[2]) ) {
			EPerm();
		}
	}	
		
	//2nd look
	public static void secondLookPll() {
		//check them all at the same time, then rotate to find next orientation
		for(int i=0; i<4; i++) {
			//Ua perm
			if( (topLayer[0] == topLayer[1]) && (topLayer[4] == topLayer[9]) ) {
				UaPerm(); 
				break;
			}
			//Ub perm
			if( (topLayer[0] == topLayer[1]) && (topLayer[10] == topLayer[3]) ) {
				UbPerm(); 
				break;
			}
			//H perm
			if( (topLayer[1] == topLayer[6]) && (topLayer[4] == topLayer[9]) ) {
				HPerm(); 
				break;
			}
			//Z perm
			if( (topLayer[1] == topLayer[3]) && (topLayer[7] == topLayer[9]) ) {
				ZPerm(); 
				break;
			}
			U();
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
	public static void altInsertRightEdge() {
		Fp(); sexy(); Rp(); F(); R();
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
		R();	U2();	Rp();	Up();	R();	Up();	Rp();
	}
	public static void sune() {
		R();	U();	Rp();	U();	R();	U2();	Rp();	
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
	public static void AaPerm() {
		X(); Rp(); U(); Rp(); D2(); R(); Up(); Rp(); D2(); R2(); Xp(); 
	}
	public static void EPerm() {
		Xp(); R(); Up(); Rp(); D(); R(); U(); Rp(); U2(); E2(); Rp(); U(); R(); D(); Rp(); Up(); R(); Xp();
	}
	//2nd look
	public static void UbPerm() {
		L(); Up(); L(); U(); L(); U(); L(); Up(); Lp(); Up(); L2(); 
	}
	public static void UaPerm() {
		Rp(); U(); Rp(); Up(); Rp(); Up(); Rp(); U(); R(); U(); R2(); 
	}
	public static void HPerm() {
		M2(); U(); M2(); U2(); M2(); U(); M2(); 
	}
	public static void ZPerm() {
		M2(); U(); M2(); U(); Mp(); U2(); M2(); U2(); Mp();
	}
}