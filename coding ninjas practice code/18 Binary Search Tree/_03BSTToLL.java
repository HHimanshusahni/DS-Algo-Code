class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	LinkedListNode(T data){
		this.data = data;
	}
}
public class _03BSTToLL{
	//Approach 1
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
	public static void main(String[]args){
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		LinkedListNode<Integer> head = BSTToSortedLL(root), temp = null;
		temp = head;

		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
}