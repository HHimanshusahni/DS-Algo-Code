import java.util.Queue;
import java.util.LinkedList;
public class _13ZigZagTree{
	public  static void printZigZag(BinaryTreeNode<Integer> root) {
		if(root == null)
			return ;
		boolean flag = true;
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while(true){
			BinaryTreeNode<Integer> node = q.poll();
			if(node == null){
				if(q.isEmpty())
					break;
				flag = !flag;
				System.out.println();
				q.offer(null);
			}else{
				System.out.print(node.data+" ");
				if(flag){ 
					if(node.right != null)
					    q.offer(node.right);
					if(node.left != null)
						q.offer(node.left);
				}else{
					if(node.left != null)
						q.offer(node.left);
					if(node.right != null)
						q.offer(node.right);
				}
			}
		}

	}	
	public static void main(String[]args){
		BinaryTreeUse tree = new BinaryTreeUse();
		BinaryTreeNode<Integer>root  = tree.takeInputLevelWise();
		printZigZag(root);
	}
}