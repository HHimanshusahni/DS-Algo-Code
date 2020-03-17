import java.io.*;
import java.util.Arrays;
public class PrintArrayIntersection{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String strArr1[] = str.split(" ");
		int arr1[] = new int[N];
		for(int i =0;i<N;i++){
			arr1[i] = Integer.parseInt(strArr1[i]);
		}

		int M = Integer.parseInt(br.readLine());
	    str = br.readLine();
		String strArr2[] = str.split(" ");
		int arr2[] = new int[M];
		for(int i =0;i<M;i++){
			arr2[i] = Integer.parseInt(strArr2[i]);
		}
		Solver solver = new Solver();
		solver.printArrayIntersection(arr1,arr2);
	}

}
class Solver {
		public void printArrayIntersection(int arr1[],int arr2[]){
				Arrays.sort(arr1);
				Arrays.sort(arr2);
				for(int i =0,j=0;i<arr1.length && j<arr2.length;){
						if(arr1[i]==arr2[j]){
							System.out.println(arr1[i]);
								i++;
								j++;
						}else if(arr1[i]<arr2[j]){
								i++;
						}else{
								j++;
						}
				}

		}
}