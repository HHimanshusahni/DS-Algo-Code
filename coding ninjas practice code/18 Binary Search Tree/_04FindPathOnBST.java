import java.util.ArrayList;
import java.util.Scanner;
public class _04FindPathOnBST{
	//Time complexity O(height)
	public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root, int data){
		//Base Case
		if(root == null)
		 	return null;
		 ArrayList<Integer> smallAns = null;
		if(root.data.intValue() == data){
			smallAns = new ArrayList<>();
			smallAns.add(root.data);
			return smallAns;
		}else if(root.data.intValue()>data)
			smallAns = findPath(root.left,data);
		else
			smallAns = findPath(root.right,data);
		if(smallAns != null)
			smallAns.add(root.data); // Adding elements to the front of the arraylist 
		return smallAns;

	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		System.out.println("Enter k: ");
		ArrayList<Integer> path = findPath(root,s.nextInt());
		if(path == null)
			System.out.println("K is absent in tree");
		else
			for(Integer i : path){
				System.out.print(i+" ");
			}
	}
}