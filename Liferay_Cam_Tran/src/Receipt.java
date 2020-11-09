 /*
 * Written by Cam Tran
 * 11/08/2020
 * For liferay 
 */

import java.util.Vector;
import java.lang.Math;

// Print Receipt with taxed amounts included
public class Receipt {

	private double pretax_total;
	private double postax_total;
	private Vector<Item> to_print_info;

	/*
	 * Constructor to receive a vector of items
	 */
	public Receipt(Vector<Item> object)
	{
		to_print_info = object;
		pretax_total = pretaxTotal(object);
		postax_total = posttaxPost(object);
	}
	
	/*
	 * Method to print receipt 
	 */
	public void Print() 
	{
		System.out.println("                Sales Receipt             ");
		System.out.println("==========================================");
		for (int i = 0; i < to_print_info.size() - 1; i++) 
		{

			System.out.printf("%-3d%-30s%8.2f \n", to_print_info.get(i).getQuantity(),
					to_print_info.get(i).getDescription(), to_print_info.get(i).getTaxedItemPrice());
		}

		// Calculation to round last item on transaction to nearest .05 cents
		int last_item_postion = to_print_info.size() - 1;
		double last_item = to_print_info.get(last_item_postion).getTaxedItemPrice();
		double rounded = Math.ceil(last_item * 20) / 20;
	
		System.out.printf("%-3d%-30s%8.2f \n", to_print_info.get(last_item_postion).getQuantity(),
				to_print_info.get(last_item_postion).getDescription(), rounded);

		// Total of transaction with last item rounded to nearest 5 cents on the transaction 
		double post_tax_final = postax_total + rounded;
		double sales_tax = post_tax_final - pretax_total;

		System.out.printf("Sales Taxes: %.2f\n", sales_tax);
		System.out.printf("Total: %.2f\n", post_tax_final);
	}

	/*
	 * Sums up pre-tax amount
	 */
	public double pretaxTotal(Vector<Item> object) 
	{
		double total = 0;

		for (int i = 0; i < object.size(); i++) 
		{
			total = total + object.get(i).getOrginalItemPrice();
		}

		return total;

	}

	/*
	 * Sums up post tax amount expect for the last item
	 */
	public double posttaxPost(Vector<Item> object) 
	{
		double total = 0;

		for (int i = 0; i < object.size() - 1; i++) 
		{
			total = total + object.get(i).getTaxedItemPrice();
		}
		return total;

	}

}

 