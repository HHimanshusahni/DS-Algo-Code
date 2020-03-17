import java.io.*;
public class LinearSearch{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String str = br.readLine();
		String strArr[] = str.split(" ");	
		for(int i =0;i<n;i++){
			arr[i] = Integer.parseInt(strArr[i]);
		}
		int element = Integer.parseInt(br.readLine());
		Solver solver = new Solver();
		System.out.println(solver.search(arr,element));
		
	}

}
class Solver{
	public int search(int arr[],int element){
		for(int i =0;i<arr.length;i++)
			if(arr[i]==element)
				return  i ;
		return -1;
			
		
	}
}
