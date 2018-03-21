/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
	    List<Integer> list = new ArrayList<Integer>();
	    Inorder(root, list);

	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	    for (int i = 0; i < list.size(); i++) {
		    if (map.containsKey(k - list.get(i))) {
			    return true;
		    }
		    map.put(list.get(i), 1);
	    }
	    return false;
    }

    private void Inorder(TreeNode root, List<Integer> list) {
	    if (null != root.left) {
		    Inorder(root.left, list);
	    }
	    list.add(root.val);
	    if (null != root.right) {
		    Inorder(root.right, list);
	    }
    }
}
