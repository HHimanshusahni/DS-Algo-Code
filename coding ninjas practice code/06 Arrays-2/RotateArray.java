import java.io.*;
public class RotateArray{
	public static void main(String [] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =  Integer.parseInt(br.readLine());
		String str = br.readLine();
		String strArr[] = str.split(" ");
		int input[] = new int[n];
		for(int i = 0;i<n;i++){
			input[i] = Integer.parseInt(strArr[i]);
		}
		int d = Integer.parseInt(br.readLine());
		Solver solver = new Solver();
		solver.rotateArray3(input,d);
		for(int i = 0;i<n;i++){
			System.out.print(input[i]+" ");
		}
	}

}
class Solver{
	// approach 1 : shift every element to the left 0(n*d) 
	public void rotateArray1(int arr[],int d){
		for(int i = 0;i<d;i++){
			int temp = arr[0];
			int j =1;
			for( j =0;j<arr.length-1;j++ ){
				arr[j] =arr[j+1];
			}
			arr[j] = temp;
		}

	}
	// approach 2 : by using extra array of 0(d) space time complexity 0(n)
	public void rotateArray2(int arr[],int d){
		int tempar[] = new int[d];
		for(int i =0;i<d;i++){
			tempar[i] = arr[i];
		}
		for(int i=0;i<arr.length-d;i++){
			arr[i] = arr[i+d];
		}
		for(int i = 0;i<d;i++){
			arr[arr.length-d+i] = tempar[i];
		}

	}
	// approach 3 without extra space by reversing the whole array then 
	public void rotateArray3(int arr[],int d){

		reverseArr(arr,0,arr.length-1);
		reverseArr(arr,0,arr.length-d-1);
		reverseArr(arr,arr.length-d,arr.length-1);

	}
	private void reverseArr(int arr[],int startIndex, int endIndex){
		int temp ;
		while(startIndex<endIndex){
			temp = arr[startIndex];
			arr[startIndex] = arr[endIndex];
			arr[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
	}
	// approach 4 kadan's algorithm
	
}