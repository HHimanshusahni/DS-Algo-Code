class PairUse{
	Integer sum;
	TreeNode<Integer> maxNode;
	PairUse(){
		sum = 0;
		maxNode = null;
	}
	PairUse(Integer sum, TreeNode<Integer> maxNode){
		this.sum = sum;
		this.maxNode = maxNode;
	}
}
public class _09NodesWithHighestSumOfChildrenAndItself{
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		return maxSumNodeHelper(root).maxNode;
	}
	public static PairUse maxSumNodeHelper(TreeNode<Integer> root){
		//Base Case
		if(root == null)
			return new PairUse(0,null);

		//Small Calculation
		PairUse ithPair ;
		PairUse maxPair = new PairUse();
		PairUse rootPair = new PairUse(root.data,root);
		for(TreeNode<Integer> ithChild : root.children){
			rootPair.sum += ithChild.data;
			ithPair = maxSumNodeHelper(ithChild);   //Recursive Case
			if(maxPair.sum.intValue() < ithPair.sum.intValue())
				maxPair = ithPair;
		}
		if(maxPair.sum.intValue() < rootPair.sum.intValue())
			maxPair  = rootPair;
		return maxPair;
	}
	public static void main(String[]args){
		TreeUse tree = new TreeUse();
		TreeNode<Integer> root = tree.takeInputLevelWise();
		System.out.println(maxSumNode(root).data);
	}
}