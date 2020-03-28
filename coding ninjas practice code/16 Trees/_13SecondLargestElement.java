import java.util.Queue;
import java.util.LinkedList;
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
			}else if(secondLargest == null && largest.data.intValue() != current.data.intValue()){
					secondLargest = current;
			}else if(secondLargest != null  && current.data.intValue() > secondLargest.data.intValue()){
					secondLargest = current;
			}

			for(TreeNode<Integer> ithChild : current.children)
				q.offer(ithChild);

		}
		return secondLargest;
	}
	public static void main(String[] args){
		TreeUse tree = new TreeUse();
		TreeNode<Integer> root = tree.takeInputLevelWise();
		System.out.println(findSecondLargest(root).data); // add null check
	}
}