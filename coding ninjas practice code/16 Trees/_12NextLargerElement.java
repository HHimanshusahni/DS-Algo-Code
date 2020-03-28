import java.util.Scanner;
public class _12NextLargerElement{
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		//Base Case
		if(root == null)
			return null;
		TreeNode<Integer> nextLarger = null;
		TreeNode<Integer> currentLarger = null;
		if(root.data.intValue() > n)
			nextLarger = root;
		//Recursive Case;
		for(TreeNode<Integer> ithChild : root.children){
			 currentLarger = findNextLargerNode(ithChild,n);
			 if(currentLarger != null){
			 	if(nextLarger == null)
			 		nextLarger = currentLarger;
			    else if(currentLarger.data.intValue() < nextLarger.data.intValue())
			 	       nextLarger = currentLarger;
			 }
		}
		return nextLarger;
	}
	public static void main(String []args){
		TreeUse tree = new TreeUse();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		TreeNode<Integer> root = tree.takeInputLevelWise();
		System.out.println(findNextLargerNode(root,n).data); // Add null check also
	}
}