import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class FindTheUniqueElement{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String strArr[] = str.split(" ");
		final int arr[] = new int[(2*n)+1];
		for(int i = 0;i<arr.length;i++){
			arr[i] = Integer.parseInt(strArr[i]);
		}
		Solver solve = new Solver();
		System.out.println(solve.findUnique(arr));
	}

}
class Solver {
	public  int findUnique(int arr[]){
		int value=0;
		for(int i=0;i<arr.length;i++){
			value = value^arr[i];
		}
		return value;

	}
}