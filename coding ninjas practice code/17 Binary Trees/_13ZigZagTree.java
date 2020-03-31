import java.util.Queue;
import java.util.Stack;
public class _13ZigZagTree{
	//Approach 1 Using Two stacks 
	public  static void printZigZag(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;
		Stack<BinaryTreeNode<Integer>> s1 = new Stack<BinaryTreeNode<Integer>>();
		Stack<BinaryTreeNode<Integer>> s2 = new Stack<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> current = null;
		s1.push(root);
		while(!(s1.isEmpty() && s2.isEmpty())){
			while(!s1.isEmpty()){
				current = s1.pop();
				System.out.print(current.data+" ");
				if(current.left != null)  //Pushing elements in the left to right manner in the s2 stack
					s2.push(current.left);
				if(current.right != null)
					s2.push(current.right);
				if(s1.isEmpty())
					System.out.println();
			}
			while(!s2.isEmpty()){
				current = s2.pop();
				System.out.print(current.data+" ");
				if(current.right != null) //Pushing elements in the right to left manner in the s1 stack
					s1.push(current.right);

				if(current.left != null)  
					s1.push(current.left);
				if(s2.isEmpty())
					System.out.println();
			}
		}

	}	
	
	public static void main(String[]args){
		BinaryTreeUse tree = new BinaryTreeUse();
		BinaryTreeNode<Integer>root  = tree.takeInputLevelWise();
		printZigZag(root);
	}
}