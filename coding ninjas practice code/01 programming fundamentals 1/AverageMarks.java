import java.util.Scanner;
class AverageMarks{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		char name = scan.next().charAt(0);
		int test1 = scan.nextInt();
		int test2 = scan.nextInt();
		int test3 = scan.nextInt();
		int avg = (int)((test1+test2+test3)/3);
		System.out.println(name);
		System.out.println(avg);
	}
}