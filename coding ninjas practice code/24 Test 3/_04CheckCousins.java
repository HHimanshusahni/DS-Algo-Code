import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
class BinaryTreeNode<T>{
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	BinaryTreeNode(T data){
		this.data = data;
		left = null;
		right = null;
	}
}
public class _04CheckCousins{

	/*  Approach 1:
		Below is the level order traversal approach 
		
		Approach 2:
		We can also use the recursive appraoch in which we first find the level of the nodes recursively
		if the nodes are the same level then we check wheather they are having different parent node or not recursively
		https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
	*/
	//Time Complexity : O(N) Space Complexity : O(N) 
	public	static boolean isCousin(BinaryTreeNode<Integer> root,int p ,int q){
		Queue<BinaryTreeNode<Integer>> queue  = new LinkedList<>();
		if(root !=null && (root.data == p || root.data == q) )
			return false;
		queue.offer(root);
		queue.offer(null);
		boolean pFind = false,qFind = false;
		while(true){
			BinaryTreeNode<Integer> current = queue.poll();
			if(current == null){
				if(pFind && qFind)
					return true;
				else if((pFind && !qFind) || (!pFind && qFind))
					return false;
				if(queue.isEmpty())
					break;
				else
					queue.offer(null);
			}else{
				BinaryTreeNode<Integer>leftChild = current.left,rightChild = current.right;
				if(leftChild != null && rightChild != null && 
					((leftChild.data == p && rightChild.data == q) ||(leftChild.data == q && rightChild.data == p)))
						return false;
				
				if(leftChild != null ){
					queue.offer(leftChild);
					if(leftChild.data == p )
						pFind = true;
					else if(leftChild.data == q )
						qFind = true;
				}
				if(rightChild != null){
					queue.offer(rightChild);
					if(rightChild.data == p)
						pFind = true;
					else if(rightChild.data == q)
						qFind = true;
				}
			}
		}
		return false;
	}
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner scanner = new Scanner(System.in);
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		int data = scanner.nextInt();
		if(data == -1)
			return null;
		BinaryTreeNode<Integer>root = new BinaryTreeNode<>(data);
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTreeNode<Integer>current = queue.poll();
				data = scanner.nextInt();

				if(data == -1)
					current.left = null;
				else{
					BinaryTreeNode<Integer>leftNode = new BinaryTreeNode<Integer>(data);
					current.left = leftNode;
					queue.offer(leftNode);
				}
				data = scanner.nextInt();
				if(data == -1)
					current.right = null;
				else{
					BinaryTreeNode<Integer>rightNode  = new BinaryTreeNode<Integer>(data);
					current.right = rightNode;
					queue.offer(rightNode);
				}
			
		}
		return root;
	}
	public static void main(String[]args){
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		Scanner scanner = new Scanner(System.in);
		int p = scanner.nextInt();
		int q = scanner.nextInt();
		System.out.println(isCousin(root,p,q));
	}
}