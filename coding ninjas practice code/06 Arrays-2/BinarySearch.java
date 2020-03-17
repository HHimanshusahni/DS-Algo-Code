import java.io.*;
public class BinarySearch{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String strArr[] = str.split(" ");
		int input[] = new int[n];
		for(int i = 0;i<n;i++){
			input[i] = Integer.parseInt(strArr[i]);
		}
		int element = Integer.parseInt(br.readLine());
		Solver solver = new Solver();
		int index = solver.binarySearch(input,element);
		System.out.println(index);
	}
}
class Solver{
	public int binarySearch(int arr[],int num){
		int start = 0,end = arr.length-1;
		while(start<=end){
			int mid = (start+end)/2;
			if(arr[mid]==num){
				return mid;
			}else if(arr[mid]<num){
				start = mid+1;
			}else{
				end = mid-1;
			}

		}
		return -1;
	}
}