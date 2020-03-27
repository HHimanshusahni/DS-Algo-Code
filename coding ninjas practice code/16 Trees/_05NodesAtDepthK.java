import java.util.Scanner;
public class _05NodesAtDepthK{
	public static void printNodesAtDepthK(TreeNode<Integer> root, int k){ 
		//Base Case
		if(root == null)
			return;
		if(k == 0){
			System.out.print(root.data+" ");
			return;
		}
		//Recursive Case
		for(int i = 0;i<root.children.size();i++){
			printNodesAtDepthK(root.children.get(i),k-1);
		}	
		return ;
	}
	public static void main(String[]args){
		TreeUse tree = new TreeUse();
		TreeNode<Integer> root = tree.takeInputLevelWise();
		System.out.println("Enter depth of the tree");
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		printNodesAtDepthK(root,k);
	}

}