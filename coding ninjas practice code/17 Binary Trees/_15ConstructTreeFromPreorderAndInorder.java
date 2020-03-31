import java.util.Scanner;
public class _15ConstructTreeFromPreorderAndInorder{
	public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre,int[] in){
			return getTreeFromPreorderAndInorder(pre,in,0,pre.length-1,	0,in.length-1);
	}
	public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[]pre,int in[],int pS,int pE, int iS,int iE){
		//Base Case
		if(iS >iE){ 
			return null;  
		}
		//Small Calculation
		int data = pre[pS];
		BinaryTreeNode<Integer> root = new BinaryTreeNode(data);
		int index = 0;
		//Find the index of the rootData in the inOrder
		for(int i = iS;i <= iE;i++){
			if(in[i] == data){
				index = i;
				break;
			}
		}

		//Recursive case
		root.left  = getTreeFromPreorderAndInorder(pre,in,pS+1,pS+index-iS,iS,index-1);
		root.right = getTreeFromPreorderAndInorder(pre,in,pS+index-iS+1,pE,index+1,iE);
		return root;

	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no of nodes in a tree");
		int n = s.nextInt();
		int pre[] = new int[n];
		int in[] = new int[n];
		System.out.println("Enter preorder traversal of the tree");
		for(int i = 0;i<n;i++)
			pre[i] = s.nextInt();
		System.out.println("Enter indorder traversal of the tree");
		for(int i = 0;i<n;i++)
			in[i] = s.nextInt();
		BinaryTreeNode<Integer> root = getTreeFromPreorderAndInorder(pre,in);
		_08PrintLevelWise obj = new _08PrintLevelWise();
		obj.printLevelWise(root);
	}
}