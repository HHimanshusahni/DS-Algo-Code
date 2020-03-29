import java.util.Queue;
import java.util.LinkedList;

	class Pair{
		TreeNode<Integer> largest;
		TreeNode<Integer> secondLargest;
		Pair(){
			largest = null;
			secondLargest = null;
		}
	}

public class _13SecondLargestElement{
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
		if(root == null)
			return null;
		TreeNode<Integer> largest = null , secondLargest = null;
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){
			TreeNode<Integer> current = q.poll();
			if(largest == null)
				largest = current;
			else if(current.data.intValue() > largest.data.intValue()){
				secondLargest = largest ;
				largest = current;
			}else if(largest.data.intValue() == current.data.intValue()){
					continue;
			}else if((secondLargest != null  && current.data.intValue() > secondLargest.data.intValue())||
						secondLargest == null ){
					secondLargest = current;
			}

			for(TreeNode<Integer> ithChild : current.children)
				q.offer(ithChild);

		}
		return secondLargest;
	}
//Approach 2 Using Recursion
	public static TreeNode<Integer> findSecondLargest_2(TreeNode<Integer> root){
		return findSecondLargest_2Help(root).secondLargest;
	}

	public static Pair findSecondLargest_2Help(TreeNode<Integer>root){
		//Base Case
		if(root == null)
			return null;

		Pair pair = new Pair();
		Pair tempPair = null;
		pair.largest = root;
		for(TreeNode<Integer> child : root.children){
			tempPair = findSecondLargest_2Help(child);

			if(pair.largest.data.intValue() > tempPair.largest.data.intValue()){
				if(	(pair.secondLargest == null) || 
				 	 pair.secondLargest.data.intValue() < tempPair.largest.data.intValue()){
                                                

					 pair.secondLargest = tempPair.largest;
				}
			}else if(pair.largest.data.intValue() < tempPair.largest.data.intValue()){
					TreeNode<Integer> x = pair.largest;
					pair.largest = tempPair.largest;
					if( tempPair.secondLargest == null || (x.data.intValue() > tempPair.secondLargest.data.intValue()))
						pair.secondLargest = x;
					else
						pair.secondLargest = tempPair.secondLargest;
			}else{
				
				if(	(pair.secondLargest == null )||
                   tempPair.secondLargest != null && pair.secondLargest.data.intValue() < tempPair.secondLargest.data.intValue())

					pair.secondLargest = tempPair.secondLargest;

			}
		}
   	    return pair;


	}
	public static void main(String[] args){
		TreeUse tree = new TreeUse();
		TreeNode<Integer> root = tree.takeInputLevelWise();
		System.out.println(findSecondLargest_2(root).data); // add null check
	}
}