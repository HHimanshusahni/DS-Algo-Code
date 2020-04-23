import java.util.Queue;
import java.util.LinkedList;
public class _08PrintLevelWise{
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			BinaryTreeNode<Integer> current = q.poll();
			System.out.print(current.data+":");
			if(current.left != null){
				q.add(current.left);
				System.out.print("L:"+current.left.data+",");
			}
			else
				System.out.print("L:-1,");
			if(current.right != null){
				q.add(current.right);
				System.out.println("R:"+current.right.data);
			}
			else
				System.out.println("R:-1");

		
		}
	}

	public static void main(String[]args){
		BinaryTreeUse bt = new BinaryTreeUse();
		BinaryTreeNode<Integer> root = bt.takeInputLevelWise();
		printLevelWise(root);
	}
}