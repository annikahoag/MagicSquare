import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		MagicSquare magic = new MagicSquare();
		Scanner myObj = new Scanner (System.in);
		int runAgain = 1;
		int size;
		int setSize;
		boolean isMagicSquare;
		int magicSquareConstant;
		
		
		while (runAgain == 1){
			
			System.out.println("\nWhat size do you want for your magic square? \n" 
					+ "Please enter the length of one side as your input (i.e. 2 for 2x2). \n" 
					+ "Please enter nothing less than 2 and nothing greater than 8.");

			size = myObj.nextInt();

			if (size < 2 || size > 8) {
				System.out.println("Invalid size. Program is restarting.");
				runAgain=1;
				
			}else {
				magic.setSize(size);
				
				magic.setNum();
				
				isMagicSquare = magic.isMagicSquare();
				magicSquareConstant = magic.constant();
				
				if (isMagicSquare == true) {
					System.out.println("\nThis is a magic square.");
					System.out.println("The magic square constant is " + magicSquareConstant + ".");
				}else {
					System.out.println("\nThis is not a magic square.");
					
				}
				
				
				System.out.println("Would you like run again? Type 1 for yes and 2 for no.");
				runAgain = myObj.nextInt();
				
				if (runAgain==2) {
					break;
				}else if(runAgain != 1 && runAgain != 2) {
					System.out.println("Invalid input. Program will run again.");
					runAgain=1;
				}
				
			}//end of else
			
			
			 
			
			
		}//end of while loop
		
		

		
		
		
	}

}
