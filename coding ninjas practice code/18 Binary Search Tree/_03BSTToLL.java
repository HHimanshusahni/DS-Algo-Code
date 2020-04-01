class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}
class Pair{
	LinkedListNode<Integer> head;
	LinkedListNode<Integer> tail;
}
public class _03BSTToLL{
	//Approach 1 Time Complexity O(n * h) : h is height  of the tree
	public static LinkedListNode<Integer> BSTToSortedLL(BinaryTreeNode<Integer> root){
		if(root == null)
			return null;
		LinkedListNode<Integer> leftHead = BSTToSortedLL(root.left);
		LinkedListNode<Integer> rightHead = BSTToSortedLL(root.right);
		LinkedListNode<Integer> leftTail = leftHead;
		if(leftHead != null){
			while(leftTail.next != null){
				leftTail = leftTail.next;
			}
		} 
		LinkedListNode <Integer> current = new LinkedListNode<Integer>(root.data);
		if(leftHead != null){
			leftTail.next = current;
			current.next = rightHead;
			return leftHead;
		}else{
			current.next = rightHead;
			return current;
		}
	}

	//Approach 2 O(n) by returning the head of linkedlist and the tail in the recursive call
	public static LinkedListNode<Integer> BSTToSortedLL_better(BinaryTreeNode<Integer> root){
		Pair pair= BSTToSortedLL_betterHelper(root);
		return pair != null ? pair.head : null; 
	}
	public static Pair BSTToSortedLL_betterHelper(BinaryTreeNode<Integer> root){
		//Base Case
		if(root == null)
		    return null;
		Pair ans = new Pair();
		LinkedListNode<Integer> current = new LinkedListNode<>(root.data);
		current.next = null;
		Pair left = BSTToSortedLL_betterHelper(root.left);
		Pair right = BSTToSortedLL_betterHelper(root.right);
		if(left != null){
			ans.head = left.head;
			left.tail.next = current;
		}
		else{
			ans.head = current;

		}
		if(right != null ){
			ans.tail = right.tail ;
			current.next = right.head;
		}else{
			ans.tail = current;
		}

		return ans;
	}
	public static void main(String[]args){
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		LinkedListNode<Integer> head = BSTToSortedLL_better(root), temp = null;
		temp = head;

		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
}