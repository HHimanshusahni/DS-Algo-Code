import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class PairSumInArray{
	public static void main(String args[])throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			final int n = Integer.parseInt(br.readLine());
			final String str = br.readLine();
			final String strArr[] = str.split(" ");
			final int arr[] = new int[n];
			for(int i = 0;i<n;i++){
				arr[i] = Integer.parseInt(strArr[i]);
			}
			final int x = Integer.parseInt(br.readLine());
			Solver solver = new Solver();
			solver.pairSum(arr,x);

	}
}
class Solver{
	public void pairSum(int arr[],int num){
		Arrays.sort(arr);
		int i =0,j=arr.length-1;

		while(i<j){
			if(arr[i]+arr[j]==num){
				if(arr[i]==arr[j]){
					int count = 1;
					int n = j-i+1;
					count = (n*(n-1))/2;
					for(int l = 1;l<=count;l++)
						System.out.println(arr[i]+" "+arr[i]);
					break;
				}else{
				 int value1=1 ,value2=1;
				 int val1= arr[i],val2 = arr[j];
				 if(val1>val2){
				    int temp = val1;
				 	val1 = val2;
				 	val2 =val1;
				 }

				 //loops
				 while(i<j&&arr[i]==arr[i+1]){
				 		value1++;
				 		i++;
				 }
				 i++;
				 while(i<j&&arr[j]==arr[j-1]){
				 		value2++;
				 		j--;
				 }
				 j--;

				 for(int count =1;count<=(value1*value2);count++)
				  System.out.println(val1+" "+val2);
			 }
			}else if((arr[i]+arr[j])<num){
					i++;
			}else{
				j--;
			}
		}


	}
}