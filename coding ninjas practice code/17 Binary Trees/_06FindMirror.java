public class _06FindMirror{
	
	public static void mirror(BinaryTreeNode<Integer> root){
		//Base Case
		if(root == null)
			return;
		//Recursive call
		mirror(root.left);
		mirror(root.right);
		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;

	}
	public static void main(String[]args){
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		mirror(root);
	}
}