import java.io.*;
public class SumOfTwoArrays{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr1[] = new int [n];
		String str1 = br.readLine();
		String strArr1[] = str1.split(" ");
		for(int i =0;i<n;i++){
			arr1[i] = Integer.parseInt(strArr1[i]);
		}
		int m = Integer.parseInt(br.readLine());
		int arr2[] = new int[m];
		String str2 = br.readLine();
		String strArr2[] = str2.split(" ");
		for(int i =0;i<m;i++){
			arr2[i] = Integer.parseInt(strArr2[i]);
		}
		int ans[] = sumOfTwoArrays(arr1,arr2);
		for(int i = 0;i<ans.length;i++){
			System.out.print(ans[i]+" ");
		}
	}
	public static int[] sumOfTwoArrays(int[] arr1, int[] arr2){
		int l = Math.max(arr1.length,arr2.length)+1;
		int ans[] = new int[l];
		int value1,value2;
		for(int carryFlag = 0,i=arr1.length-1,j=arr2.length-1,k=ans.length-1;k>=0;i--,j--,k--){
			 value1 = 0;
			 value2 = 0;
			 if(i>=0)
			 	value1 = arr1[i];
			 if(j>=0)
			 	value2 = arr2[j];
			 int sum = value1+value2+carryFlag;
			 ans[k] = sum%10;
			 carryFlag = sum/10;
		}	
		return ans;
	}
}