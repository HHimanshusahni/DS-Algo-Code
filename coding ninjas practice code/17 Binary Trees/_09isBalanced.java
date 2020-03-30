public class _09isBalanced{
	//Approch 1 Check Balanced
	public static boolean checkBalanced(BinaryTreeNode<Integer> root){
		//Base Case
		// if(root == null)
		// 	return true;
		// if(!checkBalanced(root.left))
		// 	return false;
		// if(!checkBalanced(root.right))
		// 	return false;
		// if(Math.abs(depthOfTree(root.left) - Math.depthOfTree(root.right)) > 1 )
		// 	return false;
		// return true;

		return root == null ? true : checkBalanced(root.left) &&
									 checkBalanced(root.right) &&
									(Math.abs(depthOfTree(root.left) -depthOfTree(root.right)) <= 1) ;
	}
	public static int depthOfTree(BinaryTreeNode<Integer> root){
		return root == null ? 0 : 1 +Math.max(depthOfTree(root.left),depthOfTree(root.right));
	}
	public static void main(String[]args){
		BinaryTreeUse tree = new BinaryTreeUse();
		BinaryTreeNode<Integer> root = tree.takeInputLevelWise();
		System.out.println(checkBalanced(root));
	}
}