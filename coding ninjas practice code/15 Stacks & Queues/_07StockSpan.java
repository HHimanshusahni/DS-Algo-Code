import java.io.*;
import java.util.Stack;
// https://www.youtube.com/watch?v=AKN3Hq_aGOc
public class _07StockSpan{
	// //Brute force Approach 1 O(n^2) time and O(1) space but giving wrong answer
	// public static int[] stockSpan_1(int[] price){
	// 	int span[] = new int[price.length];
	// 	for(int i = 0;i<price.length;i++){
	// 		span[i] = 1;
	// 		for(int j = i-1;j>=0;j--){
	// 			if(price[i]>=price[j]){
	// 				span[i] = span[i]+1;
	// 			}else 
	// 				break;
	// 		}
	// 	}
	// 	return span;

	// }

	//Stack Approach O(n) time and O(n) space
	public static int[] stockSpan(int[] price) {
		int span[] = new int[price.length];
		Stack<Integer> stack = new Stack<Integer>();
		span[0] = 1;
		stack.push(0);
		for(int i = 1;i<price.length;i++){
			span [i] = 1;
			while(!stack.empty()){
				if(price[stack.peek()]>=price[i]){
					span[i] = i - stack.peek();
					stack.push(i);
					break;
				}
				else
					stack.pop();
			}
			if(stack.empty()){
				span[i] = i+1;
				stack.push(i);
			}
		}
		return span;
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int price[] = new int[n];
		String str[] = br.readLine().split(" ");
		for(int i = 0;i<n;i++){
			price[i] = Integer.parseInt(str[i]);
		}
		int span[] = stockSpan_1(price);
		for(int x : span)
			System.out.print(x+" ");
	}	
}