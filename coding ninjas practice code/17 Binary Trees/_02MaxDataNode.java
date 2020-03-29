public class _02MaxDataNode{
	public static BinaryTreeNode<Integer> maxDataNode(BinaryTreeNode<Integer> root){
		//Base Case
		if(root == null)
			return null;
		//Small Calucution
		BinaryTreeNode<Integer> maxNode = root;
		BinaryTreeNode<Integer> leftMax = maxDataNode(root.left);
		if(leftMax != null && maxNode.data.intValue() < leftMax.data.intValue())
			maxNode = leftMax;
		BinaryTreeNode<Integer> rightMax = maxDataNode(root.right);
		if(rightMax != null && maxNode.data.intValue() < rightMax.data.intValue())
			maxNode = rightMax;
		return maxNode;
	}
	public static void main(String[]args){
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		System.out.println(maxDataNode(root).data);
	}
}