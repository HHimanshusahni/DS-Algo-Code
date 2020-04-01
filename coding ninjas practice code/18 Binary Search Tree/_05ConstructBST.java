import java.util.Scanner;
public class _05ConstructBST{
	//Time complexity O(n) , Recurrence : T(n) = 2T(n/2) + 1
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr){
		return SortedArrayToBST(arr,0,arr.length-1);
	}	
	public static BinaryTreeNode<Integer>  SortedArrayToBST(int []arr,int s,int e){
		//Base Case
		if(s>e)
			return null;
		int mid = (s + e)/2;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
		root.left = SortedArrayToBST(arr,s,mid -1);
		root.right = SortedArrayToBST(arr,mid +1,e);
		return root;

	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter array size");
		int arr[]  = new int[s.nextInt()];
		for(int i = 0;i<arr.length;i++)
			arr[i] = s.nextInt();
		BinaryTreeNode<Integer> root = SortedArrayToBST(arr);
		_00BinaryTreeUse.printLevelWise(root);
	}
}