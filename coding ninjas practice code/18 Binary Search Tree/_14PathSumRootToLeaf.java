import java.io.*;
public class _14PathSumRootToLeaf{
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		rootToLeafPathsSumToK(root,k,0,"");
	}
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer>root,int k,int sum,String path){
		//Base Case
		if(root == null)
			return;
		sum += root.data;
		path = path + root.data +" ";
		if(root.left == null && root.right == null && sum == k){
			System.out.println(path);
			return;
		}
		 if(root.left != null)
			rootToLeafPathsSumToK(root.left,k,sum,path);
		 if(root.right != null)
		 	rootToLeafPathsSumToK(root.right,k,sum,path);

	}
	public static void main(String[]args) throws IOException{
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int k = Integer.parseInt(br.readLine());
			rootToLeafPathsSumToK(root,k);
	}
}