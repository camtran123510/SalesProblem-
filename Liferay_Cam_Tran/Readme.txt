Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. 
Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), 
finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate
of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

Write an application that prints out the receipt details for these shopping baskets...

INPUT:
Input 1:

1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Input 2:

1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

Input 3:

1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25

OUTPUT
Output 1:

1 book : 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83

Output 2:

1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15

Output 3:

1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68

Introduction
This project was developed for Liferay

How to Run
Compile the project into a jar, or load the .java files into your favorite IDE and run the main method found in the Main class.
Make sure that the input txt files are the root of the project directory. 

Assumption:
The user will enter the infomation manually or enter textfile name. 

Input Files:
sample1.txt
sample2.txt
sample3.txt

Here is a overview of the program

Main Class

Main Class
	ItemAdd()
	main(String[])
	YesOrNo(char)

Item Class
	exempt_import : double
	exempt_non_import : double
	exempt_status : char
	import_status : char
	item_description : String
	non_exempt_import : double
	non_exempt_non_import : double
	priceOfItem : double
	quantity : int
	tax_rate : double
	Item(String, int, char, char, double)
	Item(String[])
	getDescription()
	getExempt_status()
	getImport_status()
	getOrginalItemPrice()
	getQuantity()
	getTax_rate()
	getTaxedItemPrice()
	setDescription(String)
	setExempt_status(char)
	setImport_status(char)
	setOrginalItemPrice(double)
	setQuantity(int)
	setTaxRate(char, char)

ParceInfo.java
	Process(String)
	ParceInfo()

Receipt.java
	postax_total : double
	pretax_total : double
	to_print_info : Vector<Item>
	Receipt(Vector<Item>)
	posttaxPost(Vector<Item>)
	pretaxTotal(Vector<Item>)

Input_Validation
	exemptStatus()
	importStatus()
	nameInput()
	priceInput()
	quantityInput()
	YesOrNo(char)
I	Input_Validation()

The main method creates a receipt object The receipt object creates Product objects which are created using the information from the input text file These products are put into a list field of the receipt object The receipt object can then calculate the sales tax and total The receipt object can print the output in a nice format
