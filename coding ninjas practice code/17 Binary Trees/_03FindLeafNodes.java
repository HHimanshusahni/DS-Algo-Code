public class _03FindLeafNodes{
	public static int noOfLeafNodes(BinaryTreeNode<Integer> root){
			//Base Case
			if(root == null)
				return 0;
			//Recursive Case
			int count = noOfLeafNodes(root.left);
			count += noOfLeafNodes(root.right);
			if(root.left == null && root.right == null )
				count += 1;
			return count;
	}
	public static void main(String[]args){
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		System.out.println(noOfLeafNodes(root));
	}
}