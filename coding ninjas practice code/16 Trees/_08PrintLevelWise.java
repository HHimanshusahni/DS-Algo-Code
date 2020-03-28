import java.util.Queue;
import java.util.LinkedList;
public class _08PrintLevelWise{
	public static void printLevelWise(TreeNode<Integer> root){
		if(root == null)
			return;
		Queue <TreeNode<Integer>> q = new LinkedList<>();
		TreeNode<Integer> node = null,ithChild = null;
		q.offer(root);
		while(!q.isEmpty()){
		    node = q.poll();
			System.out.print(node.data+":");
			for(int i = 0;i<node.children.size();i++){
				 ithChild = node.children.get(i);
				 if(i != 0)
				 	System.out.print(","); 
				 System.out.print(ithChild.data);
				 q.offer(ithChild);
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		TreeUse tree = new TreeUse();
		TreeNode<Integer> root = tree.takeInputLevelWise();
		printLevelWise(root);
	}
}