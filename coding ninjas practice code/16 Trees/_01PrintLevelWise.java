import java.util.LinkedList;
import java.util.Queue;
class _01PrintLevelWise{
	public static void printLevelWise(TreeNode<Integer> root){
		if(root == null)
			return;
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while(true){
			TreeNode<Integer> treeNode = q.poll();
			if(treeNode == null){ // we have printed all the nodes of the level
				if(q.isEmpty())// If no other element is present then that means it is the last element
					break;
				System.out.println();
				q.offer(null); // inserting null in the list to mark the ending of one level
			}else{
				System.out.print(treeNode.data+" ");
				//Add all the children to the queue
				for(int i =  0;i<treeNode.children.size();i++)
			  		q.offer(treeNode.children.get(i));
			}
		}
	}
	public static void main(String[]args){
		TreeUse tree = new TreeUse();
		TreeNode<Integer>root = tree.takeInputLevelWise();
		printLevelWise(root);
	}
}