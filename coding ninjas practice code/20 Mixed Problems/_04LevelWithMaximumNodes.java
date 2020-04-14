import java.util.*;
import java.io.*;
public class _04LevelWithMaximumNodes{
	
	public static int maxLevel(TreeNode<Integer> root){
		Queue<TreeNode<Integer>>  queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		int maxLevelNodes = 1;
		int maxLevel = 0,currentLevel = 0 ,currentLevelNodes = 0;
		while(true){
			TreeNode<Integer> currentNode = queue.poll();
			if(currentNode == null){
				if(currentLevelNodes > maxLevelNodes){
					currentLevel++;
					maxLevel = currentLevel ;
					maxLevelNodes = currentLevelNodes;
				
					currentLevelNodes = 0;
				}
				if(queue.isEmpty()){
					break;
				}
				queue.offer(null);
			}else{
				for(int i = 0; i< currentNode.children.size();i++){
					queue.offer(currentNode.children.get(i));
					currentLevelNodes++;
				}
			}
		} 
		return maxLevel;
	}
	public static void main(String[]args){
		_03RemoveAllLeafNodes obj = new _03RemoveAllLeafNodes();
		TreeNode<Integer> root = obj.inputLevelWise();
		System.out.println(maxLevel(root));

	}
}