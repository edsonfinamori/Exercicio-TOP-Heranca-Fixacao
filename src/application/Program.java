package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List <Product> list = new ArrayList<> ();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Product #"+ i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char typeProduct = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (typeProduct == 'c') {
			Product prod = new Product(name, price);
			list.add(prod);
			}
			else if (typeProduct == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufDate = sdf.parse(sc.next());
				UsedProduct usedProd = new UsedProduct(name, price, manufDate);
				list.add(usedProd);
			}
			else {
			System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				ImportedProduct impProd = new ImportedProduct(name, price, customsFee);
				list.add(impProd);
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}
}