public class _13ReplaceWithSumOfGreaterNodes{
	//Approach 1: time complexity O(n) we go in reverse inorder mannter ie right root left
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		replaceWithLargerNodesSum(root,0);
	}	
	public static int replaceWithLargerNodesSum(BinaryTreeNode<Integer> root, int sum){
		//Base Case
		if(root == null)
			return sum;
		//Recursive Case
		sum = replaceWithLargerNodesSum(root.right,sum);
		sum += root.data;
		root.data = sum;
		return replaceWithLargerNodesSum(root.left,sum);
	}

	public static void main(String[]args){
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		replaceWithLargerNodesSum(root);
		_00BinaryTreeUse.printLevelWise(root);		
	}
}