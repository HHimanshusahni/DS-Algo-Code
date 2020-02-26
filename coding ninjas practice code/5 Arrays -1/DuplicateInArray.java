import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class DuplicateInArray{
	public static void main(String args[] )throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String strArr[] = str.split(" ");
			int arr[] = new int[n];
			for(int i =0;i<n;i++){
				arr[i] = Integer.parseInt(strArr[i]);

			}
			Solver solver = new Solver();
			System.out.println(solver.findDuplicate(arr));
	}
}
class Solver{
	public int findDuplicate(int arr[]){
		int n = arr.length;
		int sumN = ((n-1)*(n-2))/2;
		int sum =0;
		for(int i = 0;i<n;i++){
			sum = sum+arr[i];
		}
		return sum - sumN;
	}
}