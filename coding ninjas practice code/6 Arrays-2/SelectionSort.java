import java.io.*;
public class SelectionSort{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String str = br.readLine();
		String strArr[] = str.split(" ");
		for(int i =0;i<n;i++){
			arr[i] = Integer.parseInt(strArr[i]);
		}
		Solver solver = new Solver();
		solver.selectionSort(arr);
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
 class Solver{
	void selectionSort(int arr[]){

		for(int i=0;i<arr.length-1;i++){
			int minIndex = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minIndex]){
					minIndex = j;
				}
			}
			if(i!=minIndex){
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
	}
}