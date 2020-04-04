import java.io.*;
import java.util.ArrayList;
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
	// Approach 2
	public static void rootToLeafPathsSumToK_2(BinaryTreeNode<Integer>root,int k ){
		ArrayList <Integer> list = new ArrayList<>();
		rootToLeafPathsSumToK_2(root,k,0,list);
	}
	public static void rootToLeafPathsSumToK_2(BinaryTreeNode<Integer>root,int k,int sum,ArrayList<Integer> list){
		if(root == null)
			return;
		sum += root.data;
		list.add(root.data);
		if(root.left == null && root.right == null){
			if(sum == k ){
				for(Integer i :list)
					System.out.print(i+" ");
				System.out.println();
			}
		    list.remove(list.size()-1);
			return;
		}
		 if(root.left != null){
			rootToLeafPathsSumToK_2(root.left,k,sum,list);
		}
		 if(root.right != null){
			rootToLeafPathsSumToK_2(root.right,k,sum,list);
		}
		list.remove(list.size()-1);
	}
	public static void main(String[]args) throws IOException{
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int k = Integer.parseInt(br.readLine());
			rootToLeafPathsSumToK_2(root,k);
	}
}