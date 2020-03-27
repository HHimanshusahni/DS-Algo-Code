public class _04MaximumData{
	public static TreeNode<Integer> maxDataNode(TreeNode<Integer> root){ 
		//Base Case
		if(root == null)
			return null;
		//Recursive Case
		TreeNode<Integer> maxNode = root;
		for(int i = 0;i<root.children.size();i++){
			TreeNode<Integer> subTreeMaxNode = maxDataNode(root.children.get(i));
			if(subTreeMaxNode != null && maxNode.data.intValue() < subTreeMaxNode.data.intValue())
					maxNode = subTreeMaxNode;
		}
		return maxNode;
		
	}
	public static void main(String[] args){
		TreeUse tree = new TreeUse();
		TreeNode<Integer> root = tree.takeInputLevelWise();
		System.out.println(maxDataNode(root).data);
	}
}