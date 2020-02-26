//using bufferedreader for taking input
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
public class input{
	public static void main(String[]args)throws IOException{
	/*	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println("You entered the String"+str);
		System.out.println("Enter integer for square");
		int a = Integer.parseInt(br.readLine());
		System.out.println("Square is:"+a*a);
		System.out.println("Enter the value of double in decimals");
		double d = Double.parseDouble(br.readLine());
		System.out.println("The double value you entered  is:"+d);
		System.out.println("Enter a character");
		char c = (char)br.read();
		System.out.println("Character entered is"+c);*/
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		scan.nextLine();
		String str = scan.nextLine();
		System.out.println("You entered Integer"+a+"String is "+str);

	}
}