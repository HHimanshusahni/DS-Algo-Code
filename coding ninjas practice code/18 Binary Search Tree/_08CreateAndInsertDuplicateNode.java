public class _08CreateAndInsertDuplicateNode{

	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		root = insertDuplicateNodeHelp(root);
	}
	public static BinaryTreeNode<Integer> insertDuplicateNodeHelp(BinaryTreeNode<Integer> root){
		//Base Case
		if(root == null)
			return null;
		//Small Calculation
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
		//Recursive Case
		newNode.left = insertDuplicateNodeHelp(root.left);
		root.left = newNode;
		root.right = insertDuplicateNodeHelp(root.right);
		return root;
	}
	//Approach 2 : Better way of writing code without helper functi
	public static void insertDuplicateNode_2(BinaryTreeNode<Integer>root){
		if(root == null)
			return;
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data),rootLeft = root.left;
		root.left = newNode;
		newNode.left = rootLeft;
		insertDuplicateNode_2(newNode.left);
		insertDuplicateNode_2(root.right);
	}
	public static void main(String[]args){
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		insertDuplicateNode_2(root);
		_00BinaryTreeUse.printLevelWise(root);

	}
}