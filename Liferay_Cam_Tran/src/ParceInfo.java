 /*
 * Written by Cam Tran
 * 11/08/2020
 * For liferay 
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ParceInfo {

	public ParceInfo() {
	}

	public static Vector<Item> Process(String filename) throws IOException 
	{
		Vector<Item> transaction = new Vector<Item>();

		Vector<String[]> tempString = new Vector<String[]>();

		File temp = new File(filename);

		if (!temp.exists()) 
		{
			System.out.println("The file " + filename + " does not exist.");

			// Exit the program.
			System.exit(0);
		}

		Scanner file = new Scanner(temp);

		while (file.hasNext()) 
		{
			// Read the next name.
			String readItem = file.nextLine();

			// Display the last name read.
			// System.out.println(readItem);

			String[] splitStr = readItem.split("\\s+");

			// i = 0; while (splitStr.length > i) { System.out.println(splitStr[i]); i++; }

			tempString.add(splitStr);
		}

		// Close the file.
		file.close();


		for (int j = 0; j < tempString.size(); j++) 
		{
			String[] temp3 = tempString.get(j).clone();
			
			// Adding object to vector 
			Item itemToAdd = new Item(temp3);
			transaction.add(itemToAdd);

		} // end of for

		return transaction;
	}// end of Method

}
