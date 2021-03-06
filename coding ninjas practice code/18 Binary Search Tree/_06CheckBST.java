import java.util.ArrayList;
class Triplet{
	boolean bool;
	int largest;
	int smallest;
}
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
    //Approach2 O(n) Better approach
    public static boolean isBST_2(BinaryTreeNode<Integer> root){
    	return isBST_2Help(root).bool;
    }
    public static Triplet isBST_2Help(BinaryTreeNode<Integer> root){
    	if(root == null)
    		return null;
    	Triplet leftAns = isBST_2Help(root.left);
    	Triplet rightAns = isBST_2Help(root.right);
    	Triplet ans = new Triplet();
    	if(leftAns != null && (leftAns.largest > root.data.intValue()|| leftAns.bool == false)){
    		ans.bool = false;
    		return ans;
    	}else if(rightAns != null && (rightAns.smallest < root.data.intValue() || rightAns.bool == false)){
    		ans.bool = false;
    		return ans;
    	}
    	ans.bool = true;
    	ans.smallest = root.data;
    	ans.largest = root.data;
    	if(leftAns != null)
    		ans.smallest = leftAns.smallest;
    	if(rightAns != null)
    		ans.largest =  rightAns.largest;
    	return ans;
    }
    //Approach 3 Best approach O(n) but simple implementation
    public static boolean isBST_3(BinaryTreeNode<Integer> root){
    	return isBST_3Help(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static boolean isBST_3Help(BinaryTreeNode<Integer> root,int smallest,int largest){
    	if(root == null)
    		return true;
    	if(root.data < smallest || root.data > largest)
    		return false;
    	else{
    		boolean leftAns = isBST_3Help(root.left,smallest,root.data -1);
    		boolean rightAns = isBST_3Help(root.right,root.data+1 ,largest);
    		return leftAns  && rightAns;
    	}

    }

    //Approach 4 : Inorder approach O(n) : Inorder traversal of the BST must be in the increasing order
     public static boolean isBST_4(BinaryTreeNode<Integer> root){
     	ArrayList<Integer> list = new ArrayList<Integer>();
     	isBST_4Help(root,list);
     	for(int i = 1;i<list.size();i++){
     		if(list.get(i-1) > list.get(i))
     			return false;
     	}
     	return true;
     }
    public static void isBST_4Help(BinaryTreeNode<Integer>root,ArrayList<Integer> list){
    	if(root == null)
    		return ;
    	isBST_4Help(root.left, list);
    	list.add(root.data);
    	isBST_4Help(root.right,list);
    	return;
    }
	public static void main(String[]args){
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		System.out.println(isBST_4(root));
		
	}
}