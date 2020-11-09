 /*
 * Written by Cam Tran
 * 11/08/2020
 * For liferay 
 */

import java.util.Scanner;

public class Input_Validation 
{
	public Input_Validation() {}

	/*
	 * Check for string input 
	 */
	public static String nameInput() 
	{

		String item_name = "";
		int string_length = 0;

		// create an object of Scanner
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		while (string_length == 0) 
		{

			// take input from the user
			System.out.print("Please Enter Item Description: ");
			item_name = input.nextLine();

			// Check that user has entered a description
			string_length = item_name.length();

		}

		return item_name;
	}

	/*
	 * Check for integer input 
	 */
	public static int quantityInput() 
	{
		int quantity = 0;

		while (quantity < 1)
		{
			// create an object of Scanner
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);

			// take input from the user
			System.out.print("Please enter a whole postive quantity: ");
			if (input.hasNextInt()) 
			{
				quantity = input.nextInt();
			} 
			else 
			{
				quantity = 0;
			}
		}

		return quantity;
	}

	/*
	 * Check for double input 
	 */
	public static double priceInput() 
	{
		double price = 0;

		while (price <= 0) 
		{
			// create an object of Scanner
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);

			// take input from the user
			System.out.print("Please enter item price: ");
			if (input.hasNextDouble()) 
			{
				price = input.nextDouble();
			} 
			else 
			{
				price = 0;
			}
		}

		return price;
	}

	/*
	 * Check for char input for exempt status 
	 */
	public static char exemptStatus() 
	{
		char status = 'Z';
		boolean isItAChar = YesOrNo(status);

		while (isItAChar == false) 
		{
			// create an object of Scanner
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);

			// take input from the user
			System.out.print("Is this item a book, food or medical supply (Y/N) ?: ");
			status = Character.toUpperCase(input.next().charAt(0));
			if (YesOrNo(status) == true) 
			{
				break;
			}
		}

		return status;
	}
	
	/*
	 * Check for char input for import
	 */
	public static char importStatus() 
	{
		char status = 'Z';
		boolean isItAChar = YesOrNo(status);

		while (isItAChar == false) 
		{
			// create an object of Scanner
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);

			// take input from the user
			System.out.print("Is this item imported (Y/N) ?: ");
			status = Character.toUpperCase(input.next().charAt(0));
			if (YesOrNo(status) == true)
			{
				break;
			}
		}

		return status;
	}

	/*
	 * Check for Yes/No input 
	 */
	public static boolean YesOrNo(char userEntered) 
	{
		char upper_userEntered = Character.toUpperCase(userEntered);
		if (upper_userEntered == 'Y' | upper_userEntered == 'N')
			return true;
		return false;
	}
}
