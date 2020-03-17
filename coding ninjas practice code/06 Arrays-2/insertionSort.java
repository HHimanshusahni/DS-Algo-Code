import java.io.*;
public class InsertionSort{
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
		solver.insertionSort(arr);
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
 class Solver{
 	// The solution is correct but no need to do swapping everytime just shifting the elements is enough
	// void insertionSort(int arr[]){
	// 	for(int i = 0;i<arr.length;i++){
	// 		int j = i;
	// 		while(j>0){
	// 			if(arr[j]<arr[j-1]){
	// 				int temp = arr[j];
	// 				arr[j] = arr[j-1];
	// 				arr[j-1] = temp;
	// 				j--;
	// 			}else{
	// 				break;
	// 			}
	// 		}
	// 	}
	// }
	void insertionSort(int arr[]){
		for(int i =1;i<arr.length;i++){
			int key = arr[i];
			int j = i-1;
			while(j>=0&&arr[j]>key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
}