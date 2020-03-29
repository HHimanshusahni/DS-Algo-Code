import java.util.Scanner;
public class _04NodesGreaterThanX{
	public static int numNodesGreaterX(BinaryTreeNode<Integer> root,int x){
		//Base Case
		if(root == null)
			return 0;
		//Small Calculation
		int count = 0;
		if(root.data.intValue()>x)
			count++;
		//Recursive Case
		count += numNodesGreaterX(root.left,x);
		count += numNodesGreaterX(root.right,x);
		return count;
	}
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter  X: ");
		int x = s.nextInt();
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		System.out.println(numNodesGreaterX(root,x));
	}
}