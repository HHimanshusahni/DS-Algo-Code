import java.util.Scanner;
public class _05FindNodeinTree{
		
	public static boolean isNodePresent(BinaryTreeNode<Integer> root,int x){
		if(root == null)
			return false;
		if(root.data.intValue() == x)  // or if( root.data.equal(x));
			return true;
		return isNodePresent(root.left ,x) || isNodePresent(root.right,x);
	}
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		System.out.println("Enter node to find");
		int x = s.nextInt();
		System.out.println(isNodePresent(root,x));
	}
}