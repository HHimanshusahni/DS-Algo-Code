class Pair{
	boolean isbalanced;
	int height;
}
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


	//Approach 2 --> O(n) time complexity 
	public static boolean checkBalanced_2(BinaryTreeNode<Integer> root){
		return checkBalanced_help(root).isbalanced;
	}
	public static Pair checkBalanced_help(BinaryTreeNode<Integer>root){
		//Base Case
		if(root == null){
			Pair p  = new Pair();
			p.isbalanced = true;
			p.height = 0;
			return p;
		}
		Pair p1 = checkBalanced_help(root.left);
		Pair ans = new Pair();
		if(p1.isbalanced){
			Pair p2 = checkBalanced_help(root.right);
			if(p2.isbalanced){
				if(Math.abs(p1.height - p2.height) <=1){
					ans.isbalanced = true;
					ans.height = 1 + Math.max(p1.height,p2.height);
				}else
					ans.isbalanced  = false;			
			}else
				ans.isbalanced = false;
		}else
			ans.isbalanced = false;

		return ans; 
	}
	public static void main(String[]args){
		BinaryTreeUse tree = new BinaryTreeUse();
		BinaryTreeNode<Integer> root = tree.takeInputLevelWise();
		System.out.println(checkBalanced_2(root));
	}
	
}