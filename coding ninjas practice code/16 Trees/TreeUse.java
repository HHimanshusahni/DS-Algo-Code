import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
class TreeNode<T>{
	T data ;
	ArrayList<TreeNode<T>> children;
	public TreeNode(T data){
		this.data = data;
		this.children = new ArrayList<TreeNode<T>>();
	}
}
public class TreeUse{
	public TreeNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		System.out.print("Enter root data :");
		int data = s.nextInt();
		TreeNode<Integer> root = new TreeNode<>(data);
		System.out.println("Enter number of child of the root"+root.data);
		int numChild = s.nextInt();
		for(int i = 0;i<numChild;i++){
			System.out.println("Enter "+i+"th "+" of"+root.data);
			TreeNode<Integer> ithChild= takeInput();
			root.children.add(ithChild);
		}
		return root;
	}
	public TreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		Queue <TreeNode<Integer>> queue = new LinkedList<>();
		System.out.println("Enter root data");
		int data = s.nextInt();
		TreeNode<Integer> root = new TreeNode<>(data);
		queue.offer(root);
		while(queue.peek() != null){
			TreeNode<Integer> treeNode = queue.poll();
			System.out.println("Enter no of child for "+treeNode.data);
			int numChild = s.nextInt();
			for(int i = 0;i<numChild;i++){
				 data = s.nextInt();
				TreeNode<Integer> child = new TreeNode<>(data);
				queue.offer(child);
				treeNode.children.add(child);
			}
		}
		return root;
	}
	public void print(TreeNode<Integer> root){
		if(root == null)
			return;
		System.out.print(root.data+" ");
		for(int i = 0;i<root.children.size();i++)
			print(root.children.get(i));
		
		return;
	}
	public static void main(String[] args){
		TreeUse tree = new TreeUse();
		// TreeNode<Integer> root = tree.takeInput();
	    TreeNode<Integer> root = tree.takeInputLevelWise();
	 	tree.print(root);
	}
}