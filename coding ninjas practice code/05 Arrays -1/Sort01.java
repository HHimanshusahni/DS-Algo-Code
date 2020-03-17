import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Sort01{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String str = br.readLine();
		String strArr[] = str.split(" ");
		for(int i = 0;i<n;i++){
			input[i] = Integer.parseInt(strArr[i]);
		}
		Sort01 sort01 = new Sort01();
		sort01.sort(input);
		for(int i = 0;i<n;i++)
			System.out.print(input[i]+" ");
	}

	void sort(int arr[]){
		//method1 0(n)
		/*int slow = -1,fast =0;
		while(fast<arr.length){
			if(arr[fast]==0){
				slow++;
				int temp = arr[slow];
				arr[slow] = arr[fast];
				arr[fast] = temp;
			}
			fast++;
		}*/
		int left =0,right = arr.length-1;
		while(left<right){
			while(arr[left]==0)
				left++;
			while(arr[right]==1)
				right--;
			if(left<right){
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
	}

}