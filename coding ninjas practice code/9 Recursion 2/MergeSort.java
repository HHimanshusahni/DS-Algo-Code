import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class MergeSort{
	public static void mergeSort(int arr[]){
		mergeSort(arr,0,arr.length-1);
	}
	public static void mergeSort(int arr[],int start,int end){
		//base case
		if(start>=end)
			return;
		//Recursive case
		int mid = (start+end)/2;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1,end);
		merge(arr,start,end);
	}
	public static void merge(int arr[],int start,int end){
		// Make two temporary arrays
		int mid = (start+end)/2;
		int temp1[] = new int[mid-start+1];
		int temp2[] = new int[end-mid];

		// Copy elements in the two temporary arrays
		for(int i = 0;i<temp1.length;i++)
			temp1[i] = arr[start+i];

		for(int i = 0;i<temp2.length;i++)
			temp2[i] = arr[mid+1+i];

		// merging two temporary arrays into single array

		int i = 0,j = 0,k = start;
		while(i<temp1.length && j<temp2.length){
			if(temp1[i]<temp2[j])
				arr[k++] = temp1[i++];
			else 
				arr[k++] = temp2[j++];
		
		}

		while(i<temp1.length)
			arr[k++] = temp1[i++];
		while(j<temp2.length)
			arr[k++] = temp2[j++];

	}
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[Integer.parseInt(br.readLine())];
		String arrStr[] = br.readLine().split(" ");
		for(int i = 0;i<arr.length;i++)
			arr[i] = Integer.parseInt(arrStr[i]);
		mergeSort(arr);
		for(int i = 0;i<arr.length;i++)
			System.out.print(arr[i]+" ");


	}
}