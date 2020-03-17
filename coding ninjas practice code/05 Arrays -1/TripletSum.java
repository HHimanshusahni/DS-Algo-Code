	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.io.IOException;
	import java.util.Arrays;
	public class TripletSum{
		public static void main(String args[])throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			String str = br.readLine();
			String strArr[] = str.split(" ");
			for(int i = 0;i<n;i++){
				arr[i] = Integer.parseInt(strArr[i]);
			}
			int sum = Integer.parseInt(br.readLine());
			Solver solver = new Solver();
			solver.solve2(arr,sum);
		}
	}
	class Solver{
		public void solve(int arr[],int num){
			// 0(n^3)
			int n = arr.length;
			int temp;
			for(int i = 0;i<n-2;i++){
				for(int j = i+1;j<n-1;j++){
					for(int k = j+1;k<n;k++){
						if(arr[i]+arr[j]+arr[k]==num){
							int low = arr[i];
							int mid = arr[j];
							int high= arr[k];
							if(low>mid){
								temp = low;
								low = mid;
								mid = temp;
							}
							if(mid>high){
								temp = mid;
								mid = high;
								high = temp;
							}
							if(low>mid){
								temp = low;
								low = mid;
								mid = temp;
							}

							System.out.println(low+" "+mid+" "+high);
						}
					}
				}
			}
		}
		// 2nd approach of 0(n^2)
		public void solve2(int arr[],int num){
			//sort the array
			Arrays.sort(arr);

			for(int i =0;i<arr.length-2;i++){
				int sum = num-arr[i];
				int start =i+1, end = arr.length-1;
				// pair sum wala approach he laga diya phir
				while(start<end){

					if(arr[start]+arr[end]<sum){
					    	start++;
				    }
			    	else if(arr[start]+arr[end]>sum) {
				    	end--;
				    }else{

				    	if(arr[start]==arr[end]){
					    	int n = end-start+1;
					     for(int k=1;k<=((n*(n-1))/2);k++)
							System.out.println(arr[i]+" "+arr[start]+" "+arr[start]);
						 break;
					    }
					    int count1 = 1,count2=1;
						while(start<end&&arr[start]==arr[start+1]){
							start++;
							count1++;
						}

						while(start<end && arr[end]==arr[end-1]){
							end--;
							count2++;
						}
						for(int k=1;k<=count1*count2;k++)
							System.out.println(arr[i]+" "+arr[start]+" "+arr[end]);
						start++;
						end--;
					}
				}

			}
 		}
    }

