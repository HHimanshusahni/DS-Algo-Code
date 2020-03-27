public class _07CountLeafNodes{
	public static int countLeafNodes(TreeNode<Integer> root){
		//Base Case
		if(root == null)
			return 0;
		if(root.children.size() == 0 )
			return 1;

		int count = 0;
		//Recursive Case
		for(int i = 0;i<root.children.size();i++)
			count += countLeafNodes(root.children.get(i));
		
		return count;
	}
	public static void main(String[]args){
		TreeUse tree = new TreeUse();
		TreeNode<Integer> root = tree.takeInputLevelWise();
		System.out.println(countLeafNodes(root));
	}
}