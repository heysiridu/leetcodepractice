class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        if (root.val == key) {
            return helper(root);
        }

        TreeNode curr = root;
        while (root != null) {
            if (key < root.val) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                }
                root = root.left;
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                }
                root = root.right;
            }
        }
        return curr;
    }

    private TreeNode helper(TreeNode root) {
        if (root.right == null) {
            return root.left;
        }
        if (root.left == null) {
            return root.right;
        }

        TreeNode right = root.right;
        TreeNode left = root.left;
        // find largest on left
        TreeNode largestLeft = left;
        while (largestLeft.right != null) {
            largestLeft = largestLeft.right;
        }
        largestLeft.right = right;
        return left;
    }
}
