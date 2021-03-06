import java.util.Scanner;
import java.util.Stack;

 public class _04ReverseStack{

	public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2) {
		reverseStackHelp(s1,s2);
		while(!s2.empty())
			s1.push(s2.pop());
		return ;
		
	}	
	public static void reverseStackHelp(Stack<Integer>s1 ,Stack<Integer>s2){
		//Base Case
		if(s1.empty())
			return;
		int element = s1.pop();
		//Recursive Call
			reverseStackHelp(s1,s2);
		s2.push(element);
		return;
	}

	//Approch Without extra function
	public static void reverseStack_2(Stack<Integer> s1, Stack<Integer> s2) {
		//Base Case 
		if(s1.size() == 0 || s1.size() == 1)
			return;
		int element = s1.pop();
		reverseStack_2(s1,s2);
		while(!s1.empty())
			s2.push(s1.pop());
		s1.push(element);
		while(! s2.empty())
			s1.push(s2.pop());
		return;			
	}
	public static void main(String args[]){
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		while(data != -1){
			s1.push(data);
			data = s.nextInt();
		}
		reverseStack_2(s1,s2);
		while(!s1.empty())
			System.out.print(s1.pop()+" ");
	}
}