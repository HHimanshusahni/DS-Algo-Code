class DiameterReturnType<T,V>{
	T height;
	V diameter;
}
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


    //Approch 2 O(n) we will return both height and diameter by using the object of pair class
     public static int diameterOfBinaryTree_2(BinaryTreeNode<Integer> root){
     	return diameterOfBinaryTreeHelp(root).diameter;
     }
     public static DiameterReturnType<Integer,Integer>diameterOfBinaryTreeHelp(BinaryTreeNode<Integer> root){
     	DiameterReturnType<Integer,Integer> ans = new DiameterReturnType<>();
     	//Base Case
     	if(root == null){
     		ans.height = 0; 
     		ans.diameter = 0;
     		return ans;
     	}
     	DiameterReturnType<Integer,Integer> leftAns = diameterOfBinaryTreeHelp(root.left);
     	DiameterReturnType<Integer,Integer> rightAns = diameterOfBinaryTreeHelp(root.right);
		int option1 = 1 + leftAns.height + rightAns.height;
     	int option2 = leftAns.diameter;
     	int option3 = rightAns.diameter;

  		ans.height = 1 +Math.max(leftAns.height,rightAns.height);
  		ans.diameter = Math.max(option1,Math.max(option2,option3));
  		return ans;
     }
	public static void main(String[]args){
		BinaryTreeUse bt = new BinaryTreeUse();
		BinaryTreeNode<Integer> root = bt.takeInputLevelWise();
		System.out.println(diameterOfBinaryTree_2(root));

	}
}