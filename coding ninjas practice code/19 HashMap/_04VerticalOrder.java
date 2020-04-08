import java.io.*;
import java.util.*;
public class _04VerticalOrder{//Time Complexity : O(n) , Space Complexity : O(n)
	public static void printBinaryTreeVerticalOrder(BinaryTreeNode<Integer> root){
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		printBinaryTreeVerticalOrder(root,0,map);
		for(Integer key: map.keySet()){
			ArrayList<Integer> list = map.get(key);
			for(Integer j : list)
				System.out.print(j+" ");
			System.out.println();
		}

	} //Recurrence : T(n) = 2T(n/2) + 1 , By master theorem O(n)
	public static void printBinaryTreeVerticalOrder(BinaryTreeNode<Integer> root,int order,
										 HashMap<Integer,ArrayList<Integer>> map){
		//Base Case
		if(root == null)
			return;
		//Small Calculation
		if(map.containsKey(order)){
			ArrayList list = map.get(order);
			list.add(root.data);
		}else{
			ArrayList<Integer> list = new ArrayList<>();
			list.add(root.data);
			map.put(order,list);
		}
		//Recursive Calls
		printBinaryTreeVerticalOrder(root.left,order - 1,map);
		printBinaryTreeVerticalOrder(root.right,order +1, map);
	}

	public static void main(String[]args){
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		printBinaryTreeVerticalOrder(root);	

	}	
}