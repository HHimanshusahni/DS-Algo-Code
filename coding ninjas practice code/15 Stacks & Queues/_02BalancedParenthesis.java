import java.util.Stack;
public class _02BalancedParenthesis{
	public static boolean checkBalanced(String input) {
		char ch,ch2 ;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0;i<input.length();i++){
			ch = input.charAt(i);
			if(ch == '(' || ch == '{' || ch == '['){
				stack.push(ch);
			}else if(ch == ')' || ch == '}' || ch == ']'){
				 ch2 = stack.pop();
				if( ch == ')' && ch2 !='(')
					return false;
				else if(ch ==']' && ch2 != '[')
					return false;
				else  if(ch =='}' && ch2 != '{')
					return false;
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args){
		System.out.println(checkBalanced("{ a + [ b+ (c + d)] + (e + f) }"));
		System.out.println(checkBalanced("{ a + [ b - c } ]")); 
	}

}
