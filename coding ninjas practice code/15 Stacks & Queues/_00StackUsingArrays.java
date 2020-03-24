public class _00StackUsingArrays{
	private int data[];
	private int top ;
	//default constructor
	public _00StackUsingArrays(){
		data = new int[10];
		top = -1;
	}
	//parameterized constructor
	public _00StackUsingArrays(int capacity){
		data = new int[capacity];
		top = -1;
	}
	public int size(){
		return top+1;
	}
	public int top()throws StackEmptyException{
		if(top == -1){
			throw new StackEmptyException();
		}
		return data[top];
	}
	public void push(int element) throws StackFullException{
		if(top == data.length -1){
			throw new StackFullException();
		}
		data[++top] = element;
	}
	public int pop() throws StackEmptyException{
		if(top == -1){
			throw new StackEmptyException();
		}
		int value  = data[top--];
		return value;
	}

}
class StackEmptyException extends Exception{
	
}
class StackFullException extends Exception{
	
}
class StackUse{
	public static void main(String[] args)throws StackEmptyException,StackFullException{
		_00StackUsingArrays stack = new _00StackUsingArrays();
		int arr[] = {1,2,3};
		// try{
			for(int a :arr){
				System.out.println(stack.size());
				stack.push(a);
			}
			System.out.println(stack.top());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			// System.out.println(stack.pop());
		// }catch(StackFullException e){
		// 	System.out.println("StackFull !!!");
		// }catch(StackEmptyException e){
		// 	System.out.println("Stack Empty");
		// }
	}
}