import java.util.Scanner;
public class RootsOfEqn{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		int D =b*b - 4*a*c;
		int i,result = 0;
		boolean flag = false;
		if(D==0){
			i = 0;
		}else if(D>0){
			i = 1;
			
		}else{
			i = -1;
			flag = true;
		}
		System.out.println(i);
		if(D>=0){
			int x1 = (int)(Math.round((-b+Math.sqrt(D)) / (2.0*a)));
			int x2 = (int)(Math.round((-b-Math.sqrt(D)) / (2.0*a)));
			System.out.print(x1+" "+x2);
		}	




	}
}	