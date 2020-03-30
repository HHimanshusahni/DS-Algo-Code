public class _07FindDiameter{
	//Approach 1 https://www.youtube.com/watch?v=rrXAISjtbAA --> defination in this approach doesn't include the leaf node inclusive
	//Time Complexity is O(n*h) where h is height of tree
	//for normal tree of height log n --> O(nlogn)
	//for linked like tree of height h --> O(n)

	 public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
			if(root == null)
				return 0 ;
			int option1 = height(root.left)+height(root.right)+1;  // if the nodes are in different subtree
			int option2 = diameterOfBinaryTree(root.left);	// If both the nodes are in the left subtree
			int option3 = diameterOfBinaryTree(root.right);	// If both  the nodes are in the right subtree
			return Math.max(option1,Math.max(option2,option3)); //find the maximum of all the options
     }
     //Time complexity is O(n) as we are visiting every node once doing constant work
     // Recurrence relation : T(n) = 2(T(n/2)) + 1 ===> O(n)
     public static int height(BinaryTreeNode<Integer> root) {
     	if(root == null)
     		return 0;
     	return 1 + Math.max(height(root.left),height(root.right));
     }
	public static void main(String[]args){
		BinaryTreeUse bt = new BinaryTreeUse();
		BinaryTreeNode<Integer> root = bt.takeInputLevelWise();
		System.out.println(diameterOfBinaryTree(root));

	}
}