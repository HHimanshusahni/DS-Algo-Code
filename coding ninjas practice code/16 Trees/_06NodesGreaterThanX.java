import java.util.Scanner;
public class _06NodesGreaterThanX{
	public static int numNodeGreater(TreeNode<Integer> root,int x){
		//Base Case
		if(root == null)
			return  0;
		int count  = root.data.intValue()>x ? 1 : 0;

		//Rec Case
		for(int i = 0;i<root.children.size();i++)
			count += numNodeGreater(root.children.get(i),x);
			
		return count;
	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter x");
		int x = s.nextInt();
		TreeUse tree = new TreeUse();
		TreeNode<Integer> root = tree.takeInputLevelWise();
		System.out.println(numNodeGreater(root,x));
	}
}