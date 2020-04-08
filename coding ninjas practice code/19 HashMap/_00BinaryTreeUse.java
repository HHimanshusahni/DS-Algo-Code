import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class BinaryTreeNode<T>{
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	BinaryTreeNode(T data){
		this.data = data;
	}
}
public class _00BinaryTreeUse{
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root:	");
		int data = s.nextInt();
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		BinaryTreeNode<Integer> root = 	new BinaryTreeNode<>(data), current = null;
		q.offer(root);
		while(!q.isEmpty()){
			current = q.poll();
			System.out.println(" Enter Left Child of :  "+current.data+"  ");
			int leftData = s.nextInt();
			if(leftData != -1){
				current.left = new BinaryTreeNode<Integer>(leftData);
				q.offer(current.left);
			}
			System.out.println("Enter right Child of :  "+current.data+" ");
			int rightData = s.nextInt();
			if(rightData != -1){
				current.right = new BinaryTreeNode<Integer>(rightData);
				q.offer(current.right);
			}
			
		}
		return root;
	}
	public static void printLevelWise(BinaryTreeNode<Integer> root){
		if(root == null)
			return ;
		BinaryTreeNode<Integer> current = null;
		Queue <BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while(true){
			current = q.poll();
			if(current == null){
				if(q.isEmpty())
					break;
				System.out.println();
				q.offer(null);
			}else{
				System.out.print(current.data+" ");
				if(current.left != null)
					q.offer(current.left);
				if(current.right != null)
					q.offer(current.right);
			}
		}
	}

	public static void main(String[]args){
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		printLevelWise(root);
	}	
}