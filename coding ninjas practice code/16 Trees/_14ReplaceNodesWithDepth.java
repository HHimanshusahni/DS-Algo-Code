public class _14ReplaceNodesWithDepth{
	public static void replaceWithDepthValue(TreeNode<Integer> root){
		replaceWithDepthValue(root,0);
	}
	public static void replaceWithDepthValue(TreeNode<Integer> root, int depth){
		if(root == null)
			return ;
		root.data= depth;
		for(TreeNode<Integer>child : root.children)
			replaceWithDepthValue(child,depth+1);
	}
	public static void main(String[] args){
		TreeUse tree  = new TreeUse();
		TreeNode<Integer> root = tree.takeInputLevelWise();
		replaceWithDepthValue(root);
		_01PrintLevelWise.printLevelWise(root);// _01PrintLevelWise
	}
}