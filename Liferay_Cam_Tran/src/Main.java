 /*
 * Written by Cam Tran
 * 11/08/2020
 * For liferay 
 */
import java.util.*;
import java.lang.String; // Needed to use the string class
import java.io.*; // Needed for File and IOException	

public class Main {

	public static void main(String [] args) throws IOException
	{
		System.out.println("Sales Tax Transaction Register");
		System.out.println("==============================");
		System.out.println(" "); 
		
		
		System.out.println("You have two options to calulate in input information.");
		System.out.println("======================================================");
		System.out.println("Option 1: Entering the information manually"); 
		System.out.println("Option 2: Entering the name of the text file"); 
		System.out.println(" "); 
		
		// Vector to store object of items 
		Vector<Item> transaction = new Vector<Item>(); 
		
		boolean transaction_activity = true;
		char AnotherItem = 'Z';
		int number = 1; 
		
		int option = 0; 
		
		// Option Validation 
		while(option < 1 | option > 2  )
		{
			// create an object of Scanner
			@SuppressWarnings("resource")
			Scanner inputOp = new Scanner(System.in);
			
			// take input from the user
			System.out.print("Please enter 1 or 2: ");
			if(inputOp.hasNextInt())
			{
				option = inputOp.nextInt();
			}
			else
			{
				option = 0;
			}
		}
		
		System.out.println(" "); 
	
		
		switch (option) 
		{
		
		// Switch Option 1: User can enter the information manually 
			case 1:
			{
				
				while(transaction_activity == true)
				{
					System.out.println("Item Number # " + number);
					System.out.println("=======================");
					Item product = ItemAdd();
					transaction.add(product); 
					
					// create an object of Scanner
					@SuppressWarnings("resource")
					Scanner input = new Scanner(System.in);
					
					while(YesOrNo(AnotherItem) == false)
					{
						System.out.print("Do you have another item (Y/N)? :");
						AnotherItem =  Character.toUpperCase(input.next().charAt(0));
					}
					
					if(AnotherItem == 'N')
					{
						transaction_activity = false;
					}
					else
					{
						number++; 
						AnotherItem = 'Z';
						System.out.println(" "); 
					}
				}
				number = 0; 
				
				System.out.println(" "); 
				
				Receipt to_print = new Receipt (transaction);
				to_print.Print();
				break;
			}// end Case 1
			
			// Switch Option 2: information will be processed via text file name
			case 2:
			{
				while(transaction_activity == true)
				{
					System.out.println("Transaction Number # " + number);
					System.out.println("=======================");
					
					// create an object of Scanner
					@SuppressWarnings("resource")
					Scanner input = new Scanner(System.in);
					
					System.out.print("Please Enter File Name: ");
					String filename = input.nextLine();
					//input.nextLine();
					
					
					// Getting information from file 
					transaction = (Vector<Item>) ParceInfo.Process(filename);
					
					// Printing vector 
					Receipt to_print2 = new Receipt (transaction);
					to_print2.Print();
					
					while(YesOrNo(AnotherItem) == false)
					{
						System.out.println(" "); 
						System.out.print("Do you have another filename (Y/N)? :");
						AnotherItem =  Character.toUpperCase(input.next().charAt(0));
					}
					
					if(AnotherItem == 'N')
					{
						transaction_activity = false;
					}
					else
					{
						number++; 
						AnotherItem = 'Z';
						System.out.println(" "); 
					}
					

				}
				number = 0; 
				break;
			}// end case 2
		}// end Switch 
		
	
	}


	// Adding object to the vector
	public static Item ItemAdd() {

		String item_description = Input_Validation.nameInput();
		int quantity = Input_Validation.quantityInput();
		char exempt_status = Input_Validation.exemptStatus();
		char import_status = Input_Validation.importStatus();
		double priceOfItem = Input_Validation.priceInput();

		Item itemToAdd = new Item(item_description, quantity, exempt_status, import_status, priceOfItem);

		return itemToAdd;
	}

	// Yes and No validation
	public static boolean YesOrNo(char userEntered) 
	{
		char upper_userEntered = Character.toUpperCase(userEntered);
		if (upper_userEntered == 'Y' | upper_userEntered == 'N')
			return true;
		return false;
	}

}
