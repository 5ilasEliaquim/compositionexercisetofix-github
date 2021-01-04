package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrdemItem;
import entities.Order;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter the cliete data");
		System.out.print("Name ");
		String name = sc.next();
		System.out.print("Email:");
		String email = sc.next();
		System.out.println("BirthDate (DD/MM/YYYY)");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email,birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		System.out.println("How many items to this order? ");
		int N = sc.nextInt();
		
		Order order = new Order(new Date(), status, client);
		
		for(int i = 0; i <N; i++) {
			System.out.println("Enter #"+ (i+1) + "item data");
			System.out.print("Product name ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price ");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrdemItem it = new OrdemItem(quantity, productPrice, product);
			order.addItem(it);
			
		}
	
		System.out.println(order);
		
		
		sc.close();
	}

}
