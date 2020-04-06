import java.io.*;
import java.util.*;
//Approach 1 
class PathNode{
	BinaryTreeNode<Integer> node;
	Boolean left;
	public PathNode(BinaryTreeNode<Integer>node,Boolean left){
		this.node = node;
		this.left = left;
	}
}
public class _15PrintNodesAtDistanceKFromNode {

	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		ArrayList<PathNode> path = new ArrayList<>();
		nodesAtDistanceK(root,node,k,path);
	}
	public static void nodesAtDistanceK(BinaryTreeNode<Integer>root,int node,int k ,ArrayList<PathNode> path){
		
		//Base Case
		if(root == null)
			return;
		//Small Calculation
		if(root.data == node){
			printNodesAtDepthK(root,k);//printing the childsubtree
			
			--k;
			for(int i = path.size()-1; i>=0 &&k>=0 ;i--){//For printing the nodes which are ancestor or in the parent
				PathNode pNode = path.get(i);
				if(k == 0){
					System.out.println(pNode.node.data);
					--k;
				}
				else if(pNode.left){
					printNodesAtDepthK(pNode.node.right,--k);
				}
				else
					printNodesAtDepthK(pNode.node.left,--k);
				
			}
			return;
		}
		PathNode pathNode = new PathNode(root,true);
		path.add(pathNode);
		nodesAtDistanceK(root.left,node,k,path);
		pathNode.left = false;
		nodesAtDistanceK(root.right,node,k,path);
		path.remove(path.size()-1);
		

	}
	public static void printNodesAtDepthK(BinaryTreeNode<Integer>root,int k){
		//Base Case
		if(root == null )
			return;
		if(k == 0){
			System.out.println(root.data);
			return;
		}
		//Recurive Calls
		printNodesAtDepthK(root.left,k-1);
		printNodesAtDepthK(root.right,k-1);

	}
	
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BinaryTreeNode<Integer> root = _00BinaryTreeUse.takeInputLevelWise();
		System.out.print("Enter Node  : ");
		int node = Integer.parseInt(br.readLine());
		System.out.println("Enter distance k :");
		int k = Integer.parseInt(br.readLine());
		nodesAtDistanceK(root,node,k);

	}
}