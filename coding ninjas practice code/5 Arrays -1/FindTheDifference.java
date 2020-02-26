import java.io.*;
public class FindTheDifference{
	public static void main(String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String strArr[] = str.split(" ");
		int arr[] = new int[strArr.length];
		for(int i = 0;i<strArr.length;i++){
			arr[i] = Integer.parseInt(strArr[i]);
		}
		Solver solver = new Solver();
		solver.findDiff(arr);
		System.out.println(solver.findDiff(arr));
	}

}
class Solver{
	public static int findDiff(int input[]){
		int ans=0;
		for(int i = 0;i<input.length;i++){
			if(i%2==0)
				ans +=input[i];
			else
				ans -=input[i];
		}
		return ans
	}
}