//==========================================================
// 
// Animation.java      CS112
// 
// Author: P. Darius Vaillancourt            Email: phaelan.vaillancourt@yale.edu 
// 
// Class: Cashier 7 Hours
// 
// ---------------------------------------------------------
//   Tells you how much you owe or how much change you are owed.
//==========================================================



import java.util.Scanner;


// beginning of method class Cashier
public class Cashier {
	
	static Scanner console = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		
		// Produces inputs and text necessary to run the program
		
		System.out.println("Welcome to Cashier!\n");
		
		System.out.print("Enter unit price : ");
		final double UNIT_PRICE = console.nextDouble(); // sets variable for amount owed
		
		System.out.print("Enter the quantity : ");
		final  double QTY = console.nextDouble();
		
		System.out.print("Enter the tax rate : ");
		final  double TAX = console.nextDouble();
		
		System.out.print("The total amount owed : " + UNIT_PRICE*QTY*( 1 + TAX/100));
		//final  double PRICE = UNIT_PRICE*QTY*( 1 + TAX/100); // Right now it's not displaying
		
		final double PRICE = (UNIT_PRICE*QTY*( 1 + TAX/100)); 
		
		System.out.println();
		
		System.out.print("Enter the paid amount : ");
		
		final  double TENDERED = console.nextDouble(); // sets variable for amount tendered
		
		//final  double CHANGE = (int) (TENDERED - PRICE)*100/100; // variable for difference between price and tendered
		
		final  double CHANGE = (TENDERED - PRICE);
		calculator(TENDERED, PRICE, CHANGE);
	
	}// end of main
	
	// calculator is a method that determines weather the amount paid is greater, smaller, or equal to the amount owed.
	public static void calculator( double TENDERED, double PRICE, double CHANGE)  {
		
		
		// If statement if amount paid is greater than the amount owed then it provides the optimal (largerst domination of change).
		if(TENDERED > PRICE) {
				//casts from double to integer back to double!
				System.out.print("Your change of " + (double) (int) (CHANGE*100 + 0.5) / 100 + " is given as:\n");
				
				int remainder = (int) (CHANGE * 100);
			 	if ((remainder)/(50*100)  >= 1 ) { 
				System.out.print((remainder)/(50*100) + " 50 Dollars");
				remainder = remainder % (5000);
			 	System.out.println();
			 	}
			 	
				if ((remainder)/(20*100) >= 1) {
				System.out.print((remainder)/(20*100) + " 20 Dollars");
				remainder = remainder % 2000;
				System.out.println();
				}
				
				if ((remainder)/(10*100) >= 1) {
				System.out.print((remainder)/(10*100) + " 10 Dollars");
				remainder = remainder % 1000;
				System.out.println();
				}
				
				if ((remainder)/(5*100) >= 1) {
				System.out.print((remainder)/(5*100) + " 5 Dollars");
				remainder = remainder % 500;
				System.out.println();
			
				}
						
				if ((remainder)/(1*100) >= 1) {
				System.out.print((remainder)/(1*100) + " 1 Dollar");
				remainder = remainder % 100;
				System.out.println();
				
				}		
				
				
				if (remainder/25 >= 1) {
				System.out.print(remainder/25 + " Quarters");// int remainder5 = remainder4 % 0.25;
				remainder = remainder % 25;
				System.out.println();
				}
				if (remainder/10 >= 1) {
					System.out.print(remainder/10 + " Dimes");
				
				System.out.println();
				}
	
				if (remainder/5 >= 1) {
					System.out.print(remainder/5 + " Nickles");
					remainder = remainder % 5;
				
				System.out.println();
				}
				
				if (remainder/1 >= 1) {
					System.out.print(remainder/1 + " Pennies");
					remainder = remainder % 1;
				
				System.out.println();
				}
				
		} // end of if statement
		
		// else if statement that tells you how much you still owe if your tendered amount is less than the amount owed to vendor.
				
		else if (TENDERED <  PRICE) {
		
			System.out.print("You still owe" + " $ " + (double) (int)(-1*CHANGE*100 + 0.5)/100);
			
		} // end of else if statement
		
		//else statement that thanks you if you pay the exact amount owed.
		else { 
		
			System.out.print("Thank you for paying the exact amount!");
			System.out.println();
		}
	} // end of calculator method
		 
	
  } // end of class


			