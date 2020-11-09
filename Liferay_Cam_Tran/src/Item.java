 /*
 * Written by Cam Tran
 * 11/08/2020
 * For liferay 
 */

import java.lang.String;

public class Item {
	
	private String item_description;												// item description 
	private int quantity;															// quantity 
	private char exempt_status;														// Exempt Status 
	private char import_status;														// Import Status 
	private double tax_rate;														// tax rate base on exempt status and import status 
	private double priceOfItem;														// Price of item

	// // tax rate base on exempt status and import status 
	private double exempt_non_import = 0;
	private double exempt_import = .05;
	private double non_exempt_non_import = .10;
	private double non_exempt_import = .15;

	/*
	 * Constructor to set private variables 
	 */
	public Item(String uDescript, int uQuantity, char uES, char uIS, double UpriceOfItem) 
	{
		item_description = uDescript;
		quantity = uQuantity;
		char upperCase_Exempt_Status = Character.toUpperCase(uES);						
		char upperCase_Import_Status = Character.toUpperCase(uIS);

		exempt_status = upperCase_Exempt_Status;	
		import_status = upperCase_Import_Status;

		tax_rate = setTaxRate(upperCase_Exempt_Status,upperCase_Import_Status);

		priceOfItem = UpriceOfItem;
	}
	
	public Item(String[] array) {
		quantity = Integer.parseInt(array[0]);
		priceOfItem = Double.parseDouble(array[array.length - 1]);

		String fullString = "";
		int k = 1;
		char exempt_status = 'N';						
		char import_status = 'N';

		String keywords[] = { "book", "books", "medical", "food", "chocolate","chocolates", "pills", "imported" };

		while ((array.length - 2) > k) 
		{
			fullString = fullString + array[k] + " ";

			for (int i = 0; i< keywords.length-1 ;i++ )
			{
				if (keywords[i].equals(array[k])) 
				{
					exempt_status = 'Y';	
					//System.out.println("exempt"); 
				}
			}
			
			if (keywords[7].equals(array[k])) 
			{
				import_status = 'Y';	
				//System.out.println("IMPORTED"); 
			}
			  k++;
		}

		item_description = fullString;
		tax_rate =setTaxRate(exempt_status, import_status);

	}

	public void setDescription(String uDescript) {item_description = uDescript;}		// lets user set Item description 
	public String getDescription() {return item_description;}							// lets user access get Item description 
 
	public void setQuantity(int uQuantity) {quantity = uQuantity;}						// lets user set quantity 
	public int getQuantity() {return quantity;}											// lets user get quantity 

	public void setExempt_status(char uES) {exempt_status = uES;}						// lets user set exempt status 
	public char getExempt_status() {return exempt_status;}								// lets user get exempt status

	public void setImport_status(char uES) {import_status = uES;}						// lets user set import status 
	public char getImport_status() {return import_status;}								// lets user get import status

	public void setOrginalItemPrice(double UpriceOfItem) {priceOfItem = UpriceOfItem;}	// lets user set price
	public double getOrginalItemPrice() {return priceOfItem;}							// lets user get un-taxed price
	
	private double setTaxRate(char exemptSat,char import_stat)
	{
		double tax; 
		if (exemptSat == 'Y' && import_stat == 'N') 										// If item is exempt and not a import, tax rate assigned to 0%
		{
			tax = exempt_non_import;
		} 
		else if (exemptSat == 'Y' && import_stat == 'Y') 									// If item is exempt and is a import, tax rate assigned to 5%
		{
			tax = exempt_import;
		} else if (exemptSat == 'N' && import_stat == 'N') 									// If item is not exempt and is not a import, tax rate assigned to 10%
		{
			tax = non_exempt_non_import;
		} 																					// If item is not exempt and is a import, tax rate assigned to 15%
		else 																			
		{
			tax = non_exempt_import;
		}
		
		return tax; 
	}
	public double getTax_rate() {return tax_rate;}										// lets user get tax rate for item

	
	public double getTaxedItemPrice() 
	{
		double price = priceOfItem * (1 + tax_rate);									// lets user get taxed price for item 
		return price;
	}
}// End of class
