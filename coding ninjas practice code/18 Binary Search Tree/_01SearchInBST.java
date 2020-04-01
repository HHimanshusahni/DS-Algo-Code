import java.util.Scanner;
public class _01SearchInBST{
	 public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root , int k){
	 	if(root == null)
	 		return null;
	 	if(root.data.intValue() == k)
	 		return root;
	 	else if(root.data.intValue()>k)
	 		return searchInBST(root.left,k);
	 	else
	 		return searchInBST(root.right,k);

	 }
	 public static void main(String[]args){
	 	Scanner  s  = new Scanner(System.in);
	 	BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
	 	System.out.println("Enter  k");
	 	int k = s.nextInt();
	 	BinaryTreeNode<Integer> node = searchInBST(root,k);
	 	if(node == null)
	 		System.out.println("Node absent");
	 	else
	 		System.out.println(node.data);
	 }

}