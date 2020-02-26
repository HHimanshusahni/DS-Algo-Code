import java.util.Scanner;
public class SecondLargest{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);	
		int N = s.nextInt();
		int max =Integer.MIN_VALUE,secondMax =Integer.MIN_VALUE;
		for(int i = 1;i<=N;i++){
			int element = s.nextInt();
			if(element>max){
				secondMax = max;
				max = element;	
			}else if(element!=max && element>secondMax)
				secondMax = element;
			
		}
			System.out.println(secondMax);
	}
}