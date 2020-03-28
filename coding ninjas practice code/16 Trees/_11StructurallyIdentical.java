public class _11StructurallyIdentical{
		
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
		//Base Case
		if(root1 == null && root2 == null)
			return true;
		 if(root1 == null || root2 == null)
            return false;
		//Small Calculation
		if(!root1.data.equals(root2.data))
			return false;
		if(root1.children.size() != root2.children.size())
			return false;
		//Recursive Case
		for(int i = 0;i<root1.children.size();i++)
			if(!checkIdentical(root1.children.get(i),root2.children.get(i)))
				return false;
		return true;
		
	}
	public static void main(String[] args){
		TreeUse tree = new TreeUse();
		TreeNode<Integer> root1 = tree.takeInputLevelWise();
		TreeNode<Integer> root2 = tree.takeInputLevelWise();
		System.out.println(checkIdentical(root1,root2));
	}
}