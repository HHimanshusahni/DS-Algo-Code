import java.io.*;
public class  ArrayEquilibrium{
	 public static int arrayEquilibrium(int[] arr){ 
	 	int sumRight = 0,sumLeft = 0;
	 	for(int i = 0;i<arr.length ;i++)
	 		sumRight += arr[i];

	 	for(int i = 0;i<arr.length;i++){
	 		sumRight -= arr[i]; 
	 		if(sumLeft == sumRight)
	 			return  i ;
	 		sumLeft += arr[i];
	 	} 
	 	return -1 ;
	 }
	 public static void main(String[]args)throws IOException{
	 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	int n = Integer.parseInt(br.readLine());
	 	int input[] = new int[n];
	 	String sArr[] = br.readLine().split(" ");
	 	for(int i =0;i<n;i++)
	 		input[i] = Integer.parseInt(sArr[i]);

	 	System.out.println(arrayEquilibrium(input));
	 }

}