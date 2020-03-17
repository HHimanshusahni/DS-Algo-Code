import java.util.Scanner;
public class TotalSalary{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int basicSalary = s.nextInt();
		char grade = s.next().charAt(0);
		int allow;
		if(grade=='A'){
			allow = 1700;

		}else if(grade =='B'){
			allow = 1500;
		}else{
			allow = 1300;
		}
		double totalSalary = basicSalary
							 +0.20*basicSalary
							 +0.50* basicSalary
							 +allow
							 -0.11*basicSalary;
		System.out.println((int)(totalSalary+0.5));

	}
}