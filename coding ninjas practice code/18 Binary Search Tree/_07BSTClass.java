 import java.util.Scanner;
public class _07BSTClass{
	private BinaryTreeNode<Integer> root;

	public boolean search(int input){
		return searchHelp(this.root,input);
	}

	private boolean searchHelp(BinaryTreeNode<Integer> root, int input){
		//Base Case
		if(root == null)
			return false;
		if(root.data.intValue() == input)
			return true;
		else if(root.data.intValue() > input){
			return searchHelp(root.left,input);
		}else{
			return searchHelp(root.right,input);
		}
	}


	public void insertData(int input){
		this.root = insertDataHelp(this.root,input);
	}
	private BinaryTreeNode<Integer> insertDataHelp(BinaryTreeNode<Integer> root,int input){
		//Base Case
		if(root == null){
			BinaryTreeNode<Integer> newNode	= new BinaryTreeNode<>(input);
			return newNode;
		}
		//Recursive Case
		if(root.data.intValue() > input)
		  root.left = insertDataHelp(root.left,input);
	    else
		  root.right = insertDataHelp(root.right,input);
		return root;	
	}



	public void deleteData(int input){
		root = deleteDataHelper(root,input);
	}

	private BinaryTreeNode<Integer> deleteDataHelper(BinaryTreeNode<Integer> root,int input){
		if(root == null)
			return null;
		if(root.data.intValue() == input){
			// leaf node 
			if(root.left == null && root.right == null)
				return null;
			// node with 1 child
			if(root.left != null && root.right == null)
				return root.left;
			
			if(root.left == null && root.right != null)
				return root.right;
			// node with 2 child
			if(root.left != null && root.right != null){
				//find the inoder successor
				BinaryTreeNode<Integer> inorderSucc =  minElement(root.right);
				root.data = inorderSucc.data;
				root.right = deleteDataHelper(root.right,inorderSucc.data);
				return root;
			}

		}else if(root.data.intValue()>input){
			root.left = deleteDataHelper(root.left,input);
		}else{
			root.right = deleteDataHelper(root.right,input);
		}
		return root;
	}

	private static BinaryTreeNode<Integer> minElement(BinaryTreeNode<Integer> root){
		if(root == null)
			return null;
		if(root.left == null)
			return root;
		else
			return minElement(root.left);
	}

	public void printTree(){
		printTreeHelp(this.root);
	}
	private void printTreeHelp(BinaryTreeNode<Integer> root){
		//Base Case
		if(root == null)
			  return ;

		//Small Calculation
		System.out.print(root.data+":");
		if(root.left != null)
		   System.out.print("L:"+root.left.data+",") ;
		if(root.right != null )
		 System.out.print("R:"+root.right.data);
		System.out.println();

		//Recursive Case
		printTreeHelp(root.left);
		printTreeHelp(root.right);

	}

	public static void main(String[]args){
		_07BSTClass bst = new _07BSTClass();
		Scanner s = new Scanner(System.in);
		int choice, input;
		while(true) {
			choice = s.nextInt();
			switch(choice) {
				case 1 : 
					input = s.nextInt();
					bst.insertData(input);
					break;
				case 2 : 
					input = s.nextInt();
					bst.deleteData(input);
					break;
				case 3 : 
					input = s.nextInt();
					System.out.println(bst.search(input));
					break;
				default :
					bst.printTree();
					return;
			}

		}
	}
}