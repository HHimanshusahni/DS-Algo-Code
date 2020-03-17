import java.io.*;
public class BinarySearchRecursive{
	public static int binarySearch(int input[], int element){
		return binarySearch(input,element,0,input.length-1);

	}
	public static int binarySearch(int input[],int element, int startIndex, int endIndex){
		//base case;
		if(startIndex>endIndex)
			return -1;

		int mid = (startIndex + endIndex)/2;
		if(input[mid]==element)
			return mid;
		return element<input[mid]? binarySearch(input,element,startIndex,mid-1) :
								    binarySearch(input,element,mid+1,endIndex); 
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String strArr[] = br.readLine().split(" ");
		for(int i = 0;i<n;i++)
			input[i] = Integer.parseInt(strArr[i]);

		int x = Integer.parseInt(br.readLine());
		System.out.println(binarySearch(input,x));
	}
}