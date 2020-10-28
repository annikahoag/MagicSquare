import java.util.Scanner;

public class MagicSquare {

	
		//instance variables 
		Scanner myObj = new Scanner(System.in);
		int magicSquare [][] = new int [8][8];
		int genMagicSquare [][] = new int [9][9];
		private int arraySize;
		private int endIndex;
		private int magicConstant;
		int midNum;
		
		
		
		//constructor
		public MagicSquare(){
			 arraySize=0;
			 endIndex=0;
			 magicConstant=0;
			 midNum=0;
			
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
						System.out.println("Error. This position will be filled in as 0.");
					}
			

				}//end of inner for loop
				
			}//end of outer for loop
			

		}
		
		
		//print magic square
		public void printMagic() {
		
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
		
		//returns magic constant
		public int constant() {
			return magicConstant;
		}
		
		//asks the user if they want to run again
		public boolean runAgain() {
			int run;
			System.out.println("Would you like to run again? Type 1 for yes and 2 for no.");
			run = myObj.nextInt();
			
			if (run ==2) {
				System.out.println("Program is ending.");
				return false;
			}else if(run != 1 && run != 2) {
				System.out.println("Invalid input. Program will run again.");
				return true;
			}else {
				System.out.println("Program is restarting.");
				return true;
			}//end of else
		}
		
		
		//set array elements to 0
		public void clearArray () {
			for (int i = 0; i <= endIndex; i++) {
				for (int j = 0; j <= endIndex; j++) {
					genMagicSquare[i][j] = 0;
				}//end of inner
			}//end of outer
		}
		
		
		//sets given number as the middle number of top row
		public void setGiveNum(int n) {
			
			midNum = endIndex / 2;
		
		}
		
		
		//finds the rest of the magic square
		public void findMagic(int num) {
			
			int numTotal = arraySize * arraySize;
			int numCounter = 0;
			int n = num;
			int rowIndex = 0;
			int tempRowIndex = 0;
			int columnIndex = midNum;
			int tempColIndex = 0;
			
			while (numCounter < numTotal) {
			
				genMagicSquare[rowIndex][columnIndex] = n;
				tempRowIndex = rowIndex;
				tempColIndex = columnIndex;
				
				rowIndex = rowIndex - 1;
				columnIndex = columnIndex + 1;
				
				
				if (rowIndex == -1) {
					rowIndex = endIndex;
				}
				if (columnIndex == arraySize) {
					columnIndex = 0;
				}
					
			
				
				if (genMagicSquare[rowIndex][columnIndex] != 0){
					rowIndex = tempRowIndex + 1;
					columnIndex = tempColIndex;
					
					if (rowIndex == arraySize) {
						rowIndex = 0;
					}
					
				}
					

				n ++;
				numCounter ++; 	
			}//end of while
		
		}
		
		
		//print magic square
		public void printGenMagic() {
		
			for (int i = 0; i <= endIndex; i++) {
				System.out.print("\n");
				for (int j = 0; j <= endIndex; j++) {
					System.out.print(genMagicSquare[i][j] + " ");
				}//end of inner
			}//end of outer
		}

		

}
