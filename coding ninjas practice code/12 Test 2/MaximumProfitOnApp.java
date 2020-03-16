import java.io.*;
import java.util.Arrays;
public class MaximumProfitOnApp{
	//Time Complexity : 0(nlog(n))
	public static int maximumProfit(int budget[]){
		Arrays.sort(budget);// Time : nlog(n)
		int maxProfit = 0;
		int tempProfit = 0;
		for(int i = 0;i<budget.length;i++){  // 0(n)
			tempProfit = (budget.length - i ) * budget[i];
			if(tempProfit > maxProfit )
				maxProfit = tempProfit;
		}
		return maxProfit;
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int budget[] = new int[n];
		String strArr[] = br.readLine().split(" ");
		for(int i = 0;i<budget.length;i++){
			budget[i] = Integer.parseInt(strArr[i]);
		}
		System.out.println(maximumProfit(budget));
	}
}