import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
class Node<T> {
	T data;
	Node<T> next;
	Node(T data){
		this.data = data;
	}
}
public class _11LevelWiseLinkedList{
	
	public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
		
		ArrayList<Node<BinaryTreeNode<Integer>>> list = new ArrayList<>();
		if(root == null){
			return list;
		}
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		Node<BinaryTreeNode<Integer>> newNode  = null,temp = null;
		while(true){
			BinaryTreeNode<Integer> treeNode = q.poll();
			if(treeNode == null){
				if(q.isEmpty())
					break;
				q.offer(null);
				temp.next = null;
				temp = null;
			}else{
				newNode = new Node<BinaryTreeNode<Integer>>(treeNode);
				if(temp == null) // first node of the level
					list.add(newNode);//Add it in the arrayList as a head node
				else
					temp.next = newNode;
				temp = newNode;	
			 	
				if(treeNode.left != null)
					q.offer(treeNode.left);
				if(treeNode.right != null)
					q.offer(treeNode.right);
			}
		}
		return list;
	}
	public static void main(String[]args){
		BinaryTreeUse tree = new BinaryTreeUse();
		BinaryTreeNode<Integer>root  = tree.takeInputLevelWise();
		ArrayList<Node<BinaryTreeNode<Integer>>> list = LLForEachLevel(root);

		for(Node<BinaryTreeNode<Integer>> headNode : list ){
			Node<BinaryTreeNode<Integer>> temp = headNode;
			while(temp != null){
				System.out.print(temp.data.data+" ");
				temp = temp.next;
			}
			System.out.println();

		}
	}
}