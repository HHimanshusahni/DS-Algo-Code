public class _03SumOfAllNodes{
	public static int sumOfAllNode(TreeNode<Integer> root){
			//Base case 
			if(root == null)
				return 0;
			int sum = root.data;
			for(int i = 0;i<root.children.size();i++)
				sum += sumOfAllNode(root.children.get(i));
			return sum;
	}
	public static void main(String []args){
		TreeUse tree = new TreeUse();
		TreeNode<Integer> root =  tree.takeInputLevelWise();
		System.out.println(sumOfAllNode(root));
	}
}