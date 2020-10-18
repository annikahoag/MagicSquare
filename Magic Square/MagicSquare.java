import java.util.Scanner;

public class MagicSquare {

	
		//instance variables 
		Scanner myObj = new Scanner(System.in);
		int magicSquare [][] = new int [8][8];
		private int arraySize;
		private int endIndex;
		private int magicConstant;
		
		
		
		//constructor
		public MagicSquare(){
			 arraySize=0;
			 endIndex=0;
			 magicConstant=0;
			
		}
		
		
		//sets an array of the inputed size
		public void setSize(int dimensions) {
			arraySize=dimensions;
			endIndex = arraySize - 1;
		}
		
		
		//sets the square
		public void setNum () {
			int num;
			
			for (int i = 0; i <= endIndex; i++) {
				
				for (int j = 0; j <= endIndex; j++) {
					
					System.out.println("Please enter a number (must be positive or 0):");
					num = myObj.nextInt();
					if (num >= 0) {
						magicSquare[i][j] = num;
					}else {
						System.out.println("Error. Please start over");
					}
			

				}//end of inner for loop
				
			}//end of outer for loop
			
		
			//print magic square
			for (int i = 0; i <= endIndex; i++) {
				System.out.print("\n");
				for (int j = 0; j <= endIndex; j++) {
					System.out.print(magicSquare[i][j] + " ");
				}//end of inner
			}//end of outer
		
		}
		
		
		//adds up every set of numbers and returns whether it's 
		//a magic square or not
		public boolean isMagicSquare() {
	
			//sum of rows
			int rowSum=0;
			for (int i = 0; i <= endIndex; i++) {
				rowSum=0;
				for (int j = 0; j <= endIndex; j++) {
					rowSum = rowSum + magicSquare[i][j];
				}//end of inner
				if (i == 0) {
					magicConstant = rowSum;
				}else {
					if (rowSum != magicConstant) {
						return false;
					}
				}
			}//end of outer
			
			
			
			
			//sum of columns
			int columnSum=0;
			for (int j = 0; j <= endIndex; j++) {
				columnSum=0;
				for (int i = 0; i <= endIndex; i++) {
					columnSum = columnSum + magicSquare[i][j];
			
				}//end of inner
				
					if (columnSum != magicConstant) {
						return false;
					}
				
			}//end of outer 
			
			
			//sum of first diagonal
			int sumDiag1=0;
			for (int i = 0; i <= endIndex; i++) {
				for (int j = 0; j <= endIndex; j++) {
					if (i == j) {
						sumDiag1= sumDiag1 + magicSquare[i][j];
					}
				}//end of inner
				
			}//end of outer
			
		
			if (sumDiag1 != magicConstant) {
				return false;
			}
			
			
			
			//sum of second diagonal
			int sumDiag2=0;
			for (int i = 0; i <= endIndex; i++) {
				for (int j = 0; j <= endIndex; j++) {
					if ((i + j) == (endIndex)) {
						sumDiag2 = sumDiag2 + magicSquare[i][j];
					}
					
				}//end of outer
			}//end of inner 
		
			
			if (sumDiag2 != magicConstant) {
				return false;
			}
			
			
			return true;
		}
		
		public int constant() {
			return magicConstant;
		}
		

}
