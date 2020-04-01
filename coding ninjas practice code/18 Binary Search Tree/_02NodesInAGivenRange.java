import java.util.Scanner;
public class _02NodesInAGivenRange{
	public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root,int k1,int k2){
		//Base Case
		if(root == null)
			return;

		if(root.data.intValue() > k1)
			printNodeFromK1ToK2(root.left,k1,k2);//Recursive Case

		//Small Calculation
			if(root.data.intValue()>=k1 && root.data.intValue() <= k2)
				System.out.print(root.data+" ");
		
		if(root.data.intValue() <= k2) //<= because we take the assumption that equal elements to the root are in the right subtree
			printNodeFromK1ToK2(root.right,k1,k2);//Recursive Case
	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		System.out.println("Enter k1");
		int k1 = s.nextInt();
		System.out.println("Enter k2");
		int k2 = s.nextInt();
		printNodeFromK1ToK2(root,k1,k2);
	}
}