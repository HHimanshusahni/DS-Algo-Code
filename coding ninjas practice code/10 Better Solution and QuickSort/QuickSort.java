import java.io.*;
public class QuickSort{
	public static void quickSort(int input[]){
		quickSort(input,0,input.length-1);
	}
	public static void quickSort(int input[],int si, int ei){
		if(si<ei){
			int p = partition(input,si,ei);
			quickSort(input,si,p-1);
			quickSort(input,p+1,ei);
		}
	}
	public static int partition(int input[],int si ,int ei){
		int pivot = input[si];
		//find the position of the pivot element in the array
		int count = 0;	
		for(int i = si+1;i<=ei;i++){

			if(input[i]<=pivot)  // < instead of <= will give wrong result for duplicate values
				count++;
			
		}
		int index = count+ si;
		//Put pivot element in its correct position
		int temp = input[index];
		input[index] = pivot;
		input[si] = temp;

		//Putting the elements which are less than the pivot to left and greater to the right
		int i = si , j = ei;
		while(i<index && j>index){
			if(input[i]<=pivot && input[j]>pivot){
				i++;
				j--;
			}else if(input[i]>pivot && input[j]<=pivot){
				//swap
				 temp = input[i];
				input[i] = input[j];
				input[j] = temp;
				i++;
				j--;
			}else if(input[i]>pivot){
				j--;
			}else{
				i++;
			}
		}
		return index;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String sArr[] = br.readLine().split(" ");
		for(int i = 0;i<n;i++)
			input[i] = Integer.parseInt(sArr[i]);
		quickSort(input);
		for(int i :input)
			System.out.print(i+" ");
	}
}