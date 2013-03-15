




public class BalancedBianryTree {
	public boolean isBalanced(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(root==null){
			return true;
		}
		int diff = Math.abs(getHeight(root.left)-getHeight(root.right));
		if(diff>1){
			return false;
		}
		return isBalanced(root.left)||isBalanced(root.right);
		
	}
	public int getHeight(TreeNode root){
		if(root==null){
			return 0;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		return Math.max(leftHeight,rightHeight)+1;
	}
	
	
}
