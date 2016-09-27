/**
 @author Jim Mondaix
 @version 1.0.0
 @since 2016-9-12
*/
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class MoneyManger {
	private static double m_Balance;
	private static String m_log;
	private static void PINMethod() throws IOException {
		int enteredPIN = 0;
		boolean InvalidPIN = false;
		int PINretries = 0;
		int PIN = 5678;
		int PIN2 = 8765; 
		Scanner PINinput = new Scanner(System.in);
		do
		{
			System.out.println("Please enter your PIN");
			enteredPIN = Integer.parseInt(PINinput.nextLine());
			if (enteredPIN == PIN){
				InvalidPIN = true;
				System.out.println("Correct Credentials 1");
			}
			else if (enteredPIN == PIN2 ){
				InvalidPIN = true;
				System.out.println("Correct Credentials 2");
				}
			else{
				System.out.println("Invalid Credentials, please try again");
				PINretries++;
				if(PINretries >= 3)
					System.exit(0);
			}
		}
		while (!InvalidPIN);
			InvalidPIN = false;
		System.out.println("Successful login");
	}
	
	public static void menu1() throws IOException{
		String desc2Log = "";
		double inputMoney = 0.0;
		String desc = "";
		Boolean notNegativeNum = true;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the description of earning:");
		desc = input.nextLine();
		
		do{
			System.out.println("Please enter the amount:");
			inputMoney = Double.parseDouble(input.nextLine());
			if (inputMoney < 0.0){
				System.out.println("Number is negative, please try again.");
				notNegativeNum = false;
			}
			else{
				notNegativeNum = true;
			}
		}
		while(!notNegativeNum);
			notNegativeNum = true;
		
		m_Balance += inputMoney;
		desc2Log = "EARNING(" + desc +")" + "AMOUNT($" + inputMoney + ")" + "BALANCE($" + m_Balance + ")";
		m_log += desc2Log;
		
	}
	
	public static void menu2(){
		String desc2Log = "";
		double inputMoney = 0.0;
		String desc = "";
		Boolean notNegativeNum = true; // stole it from menu 1, ezpz
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the description of spending:");
		desc = input.nextLine();
		
		do{
			System.out.println("Please enter the amount:");
			inputMoney = Double.parseDouble(input.nextLine());
			if (inputMoney < 0.0){
				System.out.println("Number is negative, please try again.");
				notNegativeNum = false;
			}
			else if (inputMoney > m_Balance){
				System.out.println("Spending is greater than total balance, please try again.");
				notNegativeNum = false;
			}
			else{
				notNegativeNum = true;
			}
		}
		while(!notNegativeNum);
			notNegativeNum = true;
		
		m_Balance -= inputMoney;
		desc2Log = "Spending(" + desc +")" + "AMOUNT($" + inputMoney + ")" + "BALANCE($" + m_Balance + ")";
		m_log += desc2Log;
		System.out.println(desc2Log);
		
	}
	
	public static void menu3(){
		String log = m_log;
		if (log == null){ 
			System.out.println("Log is empty");
		}
		else{
			System.out.println(m_log);
		}
		
				
	}
	
	public static void menu4() throws IOException{
		Scanner input = new Scanner(System.in);
		System.out.println(m_Balance + "" + m_log);
		System.out.println("Are you sure you wish to exit?");
		String quitResponse = (input.nextLine());
		switch(quitResponse){
		case "y": System.out.println("Exiting Program, thank you for choosing Zen's Money Manager"); 
		System.exit(0);
		break;
		case "Y": System.out.println("Exiting Program, thank you for choosing Zen's Money Manager");
		System.exit(0);
		break;
		case "n": ; break;
		case "N": ; break;
		default: System.out.println("Invalid input"); break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Hello and welcome to Zen's Money Manger");
		Scanner input = new Scanner(System.in);
		PINMethod();
		for(int i = 5; i < 20;){
			System.out.println("Welcome to the main menu.");
			System.out.println("1. Earnings.");
			System.out.println("2. Spending.");
			System.out.println("3. Show logs.");
			System.out.println("4. Exit.");
			int MenuInput = Integer.parseInt(input.nextLine());
			switch(MenuInput){
				case 1: menu1(); break;
				case 2: menu2(); break;
				case 3: menu3(); break;
				case 4: menu4(); break;
				default: System.out.println("Invalid input"); break;
			
			}
		}
	}
}
