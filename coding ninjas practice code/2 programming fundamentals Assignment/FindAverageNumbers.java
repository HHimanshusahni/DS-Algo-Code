import java.util.Scanner;
public class FindAverageNumbers{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char name = scan.next().charAt(0);
		int test1 = scan.nextInt();
		int test2 = scan.nextInt();
		int test3 = scan.nextInt();
		int avg ;
		if((test1<=test2)&&(test1<=test3)){
			avg = (test2+test3)/2;
		}else if((test2<=test1)&&(test2<=test3)){
			avg = (test1+test3)/2;
		}else{
			avg = (test1+test2)/2;
		}

		System.out.println(name+" "+avg);
	}
}