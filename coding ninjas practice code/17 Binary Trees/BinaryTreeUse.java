import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class BinaryTreeNode<T>{
	T data;
	BinaryTreeNode<T>left;
	BinaryTreeNode<T>right;
    BinaryTreeNode(T data){
		this.data = data;
	}
}
public class BinaryTreeUse{

	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner s  = new Scanner(System.in);
		Queue <BinaryTreeNode<Integer>> q = new LinkedList<>();
		BinaryTreeNode<Integer> temp = null;
		System.out.println("Enter root data");
		int data = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
		q.offer(root);
		while(!q.isEmpty()){
			temp = q.poll();
			System.out.println("Enter Left child : of "+temp.data);
			data = s.nextInt();
			if(data == -1)
				temp.left = null;
			else
				temp.left = new BinaryTreeNode<Integer>(data);
			System.out.println("Enter Right child : of "+temp.data);
			data = s.nextInt();
			if(data == -1)
				temp.right = null;
			else
				temp.right = new BinaryTreeNode<Integer>(data);
			if(temp.left != null)
				q.offer(temp.left);
			if(temp.right != null)
				q.offer(temp.right);
		
		}
		return root;
	}
	public static void print(BinaryTreeNode<Integer> root){
		if(root == null)
			return;
		System.out.print(root.data +": ");
		if(root.left != null)
			System.out.print(root.left.data + ",");
		else
			System.out.print(-1+",");
		if(root.right != null)
			System.out.println(root.right.data );
		else
			System.out.println(-1);

		print(root.left);
		print(root.right);
	}
	public static void main(String []args){
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		print(root);
	}
}
