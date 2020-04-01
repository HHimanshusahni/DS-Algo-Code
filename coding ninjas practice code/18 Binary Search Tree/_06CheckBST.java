public class _06CheckBST{
	//Approach 1 O(n^2)
	public static boolean isBST(BinaryTreeNode<Integer> root){
    	if(root == null)
    		return true;
    	BinaryTreeNode<Integer> leftSubTreeLargest = largest(root.left);
    	BinaryTreeNode<Integer> rightSubTreeSmallest = smallest(root.right);
    	if((leftSubTreeLargest != null && leftSubTreeLargest.data.intValue() > root.data.intValue() )||
 		   	  (rightSubTreeSmallest  != null && root.data.intValue() > rightSubTreeSmallest.data.intValue()   )                                )
    		return false;
    	else
    		return isBST(root.left) && isBST(root.right);
    }
    public static BinaryTreeNode<Integer> smallest(BinaryTreeNode<Integer>root){
    	if(root == null)
    		return null;
    	return  root.left == null ? root : smallest(root.left);
    }
    public static BinaryTreeNode<Integer> largest(BinaryTreeNode<Integer> root){
    	if(root == null)
    		return null;
    	return root.right == null? root : largest(root.right);
    }

    // 8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
    //Approach2 
	public static void main(String[]args){
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		System.out.println(isBST(root));
		
	}
}