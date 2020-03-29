public class _00TreeTraversals{
	
	public static void preOrder(TreeNode<Integer> root){
		if(root == null)
			return;
		System.out.print(root.data+" ");
		for(TreeNode<Integer> child : root.children)
			preOrder(child);
	}
	public static void postOrder(TreeNode<Integer> root){
		if(root == null)
			return;
		for(int i = root.children.size()-1;i>=0;i--)
			postOrder(root.children.get(i));
		System.out.print(root.data+" ");
	}
	public static void main(String[]args){
		TreeUse tree  = new TreeUse();
		TreeNode<Integer>root = tree.takeInputLevelWise();
		System.out.print("Pre Order traversal  ");
		preOrder(root);
		System.out.println("");
		System.out.print("Post Order traversal  ");
		postOrder(root);
	}
}