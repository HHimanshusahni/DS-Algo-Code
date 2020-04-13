import java.util.Scanner;
import java.util.*;
	class TreeNode<T> {
		T data;
		ArrayList< TreeNode<T> > children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
}
public class _03RemoveAllLeafNodes{

	public static TreeNode<Integer> inputLevelWise(){
			Scanner s = new Scanner(System.in);
			Queue<TreeNode<Integer>> q = new LinkedList<>();
			System.out.println("Enter root data");
			int data = s.nextInt();
			TreeNode<Integer> root = new TreeNode<>(data);
			q.offer(root);
			while(!q.isEmpty()){
			  TreeNode<Integer> currentNode = q.poll();
			  System.out.println("Enter no of children of "+currentNode.data);
			  int n = s.nextInt();
			  for(int i = 0 ;i<n;i++){
			  		TreeNode<Integer> node = new TreeNode<>(s.nextInt());
			  		currentNode.children.add(node);
			  		q.offer(node);
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
	public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
		//Base Case
		if(root == null){
			return null;
		}
		//Small Calculation
		if(root.children.size() == 0) // leaf node
			return null;

		//Recursive Case
		TreeNode<Integer> child;
		for(int i = 0;i<root.children.size();){
		    child = removeLeafNodes(root.children.get(i));
		    if(child != null){
				root.children.set(i,child);
				i++;
			}
			else{
				root.children.remove(i);
			}
		}
		return root;
	}
	public static void main(String[]args){
		_03RemoveAllLeafNodes obj = new _03RemoveAllLeafNodes();
		TreeNode<Integer> root = obj.inputLevelWise();
		root = obj.removeLeafNodes(root);
		obj.print(root);

	}
}