import java.io.*;
public class MergeTwoSortedArrays{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String strArr[] = str.split(" ");
		int arr1[] = new int[m];
		int i ;
		for(i = 0;i<m;i++){
			arr1[i] = Integer.parseInt(strArr[i]);
		}

		int n = Integer.parseInt(br.readLine());
	    str = br.readLine();
	    String strArr2[] = str.split(" ");
		int arr2[] = new int[n];
		for(i = 0;i<n;i++){
			arr2[i] = Integer.parseInt(strArr2[i]);
		}
		int arrMerged[] = mergeArray(arr1,arr2);
		for(i=0;i<arrMerged.length;i++){
			System.out.print(arrMerged[i]+" ");
		}

	}
	 static int[] mergeArray(int arr1[],int arr2[]){
		int m = arr1.length;
		int n = arr2.length;
		int arr[] = new int[m+n];
		int i =0,j=0,k=0;
		for(k=0;i<m && j<n;k++){
			if(arr1[i]<=arr2[j])
				arr[k] = arr1[i++];
			else 
				arr[k] = arr2[j++];
		} 

		while(i<m)
			arr[k++] = arr1[i++];
		
		while(j<n)
			arr[k++] = arr2[j++];
		return arr;	
	}
}