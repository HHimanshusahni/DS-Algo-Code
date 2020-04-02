import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
public class _09PairSumBinaryTree{
	//Approach 1
	//O(n^2) time complexity and the  solution make changes in the binary Tree itself and not works for the duplicate values
	public static void nodesSumToS_1(BinaryTreeNode<Integer> root,int sum) {
		nodesSumToS_1(root,root,sum);
	}
	public static void nodesSumToS_1(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> current,int sum) {
		//Base Case
		if(current == null)
			return;
		if(current.data.intValue() != Integer.MIN_VALUE){
			int currentData = current.data;
			current.data = Integer.MIN_VALUE;

 			if(find(root,sum-currentData)){
 				int small = Math.min(currentData,sum-currentData);
 				int large = Math.max(currentData,sum-currentData);
 				System.out.println(small+" "+large); 		
 			}
		}
		nodesSumToS_1(root,current.left,sum);
		nodesSumToS_1(root,current.right,sum);  
	}
	public static boolean find(BinaryTreeNode<Integer> root, int value){
		if(root == null)
			return false;
		if(root.data.intValue()==value){
		    root.data = Integer.MIN_VALUE;
			return true;
		}
		else
			return find(root.left,value) || find(root.right,value); 
	}
	//Approach 2
	// I Convert Binary Tree to arraylist by using any traveral --> O(n)
	// II Sort the ArrayList --> O(nlog n)
	// III now use to pointer from start and end and compare the element -->O(n)
	// Total Space : O(n) for extra arraylist && Total  time O(n log n)

	public static void nodesSumToS_2(BinaryTreeNode<Integer> root,int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		convertTreeToList(root,list);

		Collections.sort(list);

		int i = 0, j = list.size()-1,temp,count,a ,b;
		int x,y;
		while(i < j){
			x = list.get(i);
			y = list.get(j);
			temp = x+y;
			if(temp == sum){
			   count = 1;
			   a = 1;
			   b = 1;
			   while(i< j && list.get(i).equals( list.get(i+1))){
			   	i++;
			   	a++;
			   }
			  
			   	while(i< j && list.get(j).equals(list.get(j-1))){
			   		j--;
			   		b++;
			   	}
			   	if(i == j)
			   	 count  = (a*(a-1))/2;
			   	else
			   	 count = a * b;
			   for(int k = 0;k<count;k++)
				   System.out.println(Math.min(x,y) +" "+Math.max(x,y)); 
				i++;
				j--;
									   
			}else if(temp < sum)
					i++;
			  else
					j--;
		}
	}
	public static void convertTreeToList(BinaryTreeNode<Integer> root,ArrayList<Integer> list){
		if(root == null)
			return;
		list.add(root.data);
		convertTreeToList(root.left,list);
		convertTreeToList(root.right,list);
	}


	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		nodesSumToS_1(root,s.nextInt());
	}	
}
