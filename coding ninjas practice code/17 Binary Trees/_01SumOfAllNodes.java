public class _01SumOfAllNodes{
	
	public static int sum(BinaryTreeNode<Integer> root){
		// if(root == null)
		// 	return 0;
		// return root.data + sum(root.left) + sum(root.right);
		return root == null ? 0 : root.data + sum(root.left) + sum(root.right); 
	}
	public static void main(String[] args){
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		System.out.println(sum(root));
	}
}