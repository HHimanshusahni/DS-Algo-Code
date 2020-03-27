import java.util.LinkedList;
import java.util.Queue;
class _01PrintLevelWise{
	public static void printLevelWise(TreeNode<Integer> root){
		if(root == null)
			return;
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		System.out.println(root.data);
		q.offer(root);
		while(q.peek() != null){
			TreeNode<Integer> treeNode = q.poll();
			for(int i =  0;i<treeNode.children.size();i++){
				System.out.print(treeNode.children.get(i).data+" ");
				q.offer(treeNode.children.get(i));
			}
			if(treeNode.children.size() != 0)
				System.out.println();
		}

	}
	public static void main(String[]args){
		TreeUse tree = new TreeUse();
		TreeNode<Integer>root = tree.takeInputLevelWise();
		printLevelWise(root);
	}
}