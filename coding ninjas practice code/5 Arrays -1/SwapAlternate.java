import java.io.*;
public class SwapAlternate{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String str = br.readLine();
		String[] strArr =  str.split(" ");
		for(int i = 0;i<n;i++){
			arr[i] = Integer.parseInt(strArr[i]);
		}
		Solver solve = new Solver();
		solve.swap(arr);
		for(int i = 0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
class Solver
{	public void swap(int arr[]){
		int temp ;
		int n = arr.length;
		if(n%2==1)
			n -=1;
		for(int i = 0;i<n;i = i+2){
			temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		}

	}
}