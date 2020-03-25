import java.io.*;
import java.util.Stack;
public class _06CheckRedundantBrackets{
	public static boolean  checkRedundantBrackets(String input) {
		Stack<Character> stack = new Stack<Character>();
		boolean flag = false;
		for(int i = 0;i<input.length();i++){
			char ch = input.charAt(i);
			if(ch == ')'){
				flag = false;
				while(stack.peek() != '('){
					flag = true;
					stack.pop();
				}
				if(!flag)
					return true;
				stack.pop();
			}else{
				stack.push(ch);
			}
		}
		return false;
	}
	public static void  main(String[]args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input ="";
		try{
		  input = br.readLine();
		}catch(IOException io){

		}
		System.out.println(checkRedundantBrackets(input));
	}
}