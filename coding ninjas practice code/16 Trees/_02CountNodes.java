public class _02CountNodes{
		public static int countNodes(TreeNode<Integer> root){
				//Base Case
			if(root == null)
				return 0;
			int count = 1;
			for(int i = 0;i<root.children.size();i++)
				count += countNodes(root.children.get(i)); //Recursive Case
			return count;
			
		}
		public static void main(String[] args) {
			TreeUse tree = new TreeUse();
			TreeNode<Integer> root = tree.takeInputLevelWise();
			System.out.println(countNodes(root));
		}
}
