import java.util.Scanner;
public class _08ContainElementX{
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
		//Base Case
		if(root == null)
			return false;
		if(root.data.intValue() == x)
			return true;
		//Recursive Case
		for(int i = 0;i<root.children.size();i++)
			if(checkIfContainsX(root.children.get(i),x))
				return true;
		
		return false;
	}
	public static void main(String[]args){
		TreeUse tree = new TreeUse();
		TreeNode<Integer> root = tree.takeInputLevelWise();
		Scanner s = new Scanner(System.in);
		System.out.println(checkIfContainsX(root,s.nextInt()));
	}
}