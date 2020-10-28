import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		MagicSquare magic = new MagicSquare();
		Scanner myObj = new Scanner (System.in);
		boolean runAgain = true;
		int size;
		int setSize;
		boolean isMagicSquare;
		int magicSquareConstant;
		int generateMagicSquare;
		int generateSize;
		int givenNum;
		
		
		while (runAgain == true){
			
			System.out.println("\nWhat size do you want for your magic square? \n" 
					+ "Please enter the length of one side as your input (i.e. 2 for 2x2). \n" 
					+ "Please enter nothing less than 2 and nothing greater than 8.");

			size = myObj.nextInt();

			if (size < 2 || size > 8) {
				System.out.println("Invalid size. Program is restarting.");
				runAgain=true;
				
			}else {
				magic.setSize(size);
				
				magic.setNum();
				
				magic.printMagic();
				
				isMagicSquare = magic.isMagicSquare();
				magicSquareConstant = magic.constant();
				
				if (isMagicSquare == true) {
					System.out.println("\nThis is a magic square.");
					System.out.println("The magic square constant is " + magicSquareConstant + ".");
				}else {
					System.out.println("\nThis is not a magic square.");
					
				}
				
				//extra credit
				System.out.println("Would you like to generate a different magic square? "
						+ "Type 1 for yes and 2 for no.");
				generateMagicSquare = myObj.nextInt();
				if (generateMagicSquare==1) {
					
					System.out.println("Please enter an odd size. Please enter one side length as your input. \n"
							+ "The greatest size you can input is 9.");
					generateSize = myObj.nextInt();
					
					//error check for even, negative size, and greater than 9
					if ( (generateSize%2) == 0 || generateSize < 0 || generateSize > 9){
						System.out.println("Invalid size.");
						runAgain = magic.runAgain();
						if (runAgain == false) {
							break;
						}
						
					//asks user to enter a number	
					}else {
						magic.setSize(generateSize);
						System.out.println("Please enter 1 number for your magic square, it must be positive.");
						givenNum = myObj.nextInt();
						
						if (givenNum <= 0) {
							System.out.println("Invalid input. Please only enter positive numbers.");
							runAgain = magic.runAgain();
							if (runAgain == false) {
								break;
							}
							
						}else {
							magic.clearArray();
							magic.setGiveNum(givenNum);
							magic.findMagic(givenNum);
							magic.printGenMagic();
							
							System.out.println("\n");
							runAgain = magic.runAgain();
						}
						
						
					}
					
				}else if (generateMagicSquare==2) {
					runAgain = magic.runAgain();
					if (runAgain == false) {
						break;
					}
					
				}else {
					System.out.println("Invalid input.");
					runAgain = magic.runAgain();
					if (runAgain == false) {
						break;
					}
				}
				
				
				

				
			}//end of else
			
			
			 
			
			
		}//end of while loop
		
		

		
		
		
	}

}
