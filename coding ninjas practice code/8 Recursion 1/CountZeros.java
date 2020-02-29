import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class CountZeros{
	public static int countZerosRec(int input){
		if(input < 10){
			if(input == 0)
				return 1;
			else 
				return 0 ;
		}
		int smallAns = countZerosRec(input/10);
		return input%10 == 0 ? smallAns+1 : smallAns;
	}

	public static void main (String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(countZerosRec(num));
	}
}