import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class ArraySum{
	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine()); // size of array
		String str = br.readLine();
		String input[] = str.split(" ");
		int arr[] = new int [input.length];
		for(int i = 0;i<input.length;i++){
			arr[i] =Integer.parseInt(input[i]);
			System.out.print(arr[i]);

		}
		System.out.println();
		Solver solve = new Solver();
		int sum = solve.sum(arr);
		System.out.println("The sum is "+sum);

	}


}
class Solver{
	public static int sum(int [] input){
		int sum = 0;
		for(int i=0;i<input.length;i++ )
			sum +=input[i];
		return sum
	;	
	}
}
