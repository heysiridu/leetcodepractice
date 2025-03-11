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
/*
Here's a clear, step-by-step walkthrough of your provided Java code using a specific example.  
I'll visualize a Binary Search Tree (BST) of height 3, and demonstrate the deletion when the key is found on `root.left`.

---

## 🔍 **Step 1: Initial BST (Height = 3)**

Here's our clearly visualized BST example:

```
        10
       /  \
      5    15
     / \     \
    3   7     18
       /
      6
```

- **Height clearly defined**: `3` (number of edges on longest path: 10→5→7→6).

Let's say we want to delete the node with **key = 5**, clearly located at `root.left`.

---

## 🔍 **Step 2: Start executing `deleteNode(root, 5)`**

- `root` clearly points to `10`.
- Clearly, `key = 5` is less than `10`, so we enter:
```java
if (key < root.val) {
    if (root.left != null && root.left.val == key) {
        root.left = helper(root.left);
        break;
    }
}
```
- Clearly, `root.left.val` is exactly `5`.  
  Thus, we call:
```java
root.left = helper(root.left);
```

Now clearly:
- Node `5` is passed to `helper()`.

---

## 🔍 **Step 3: Inside `helper(root)` (node `5`)**

Current subtree clearly visualized:
```
    5
   / \
  3   7
     /
    6
```

- Node `5` has clearly both left and right children. We enter:
```java
TreeNode right = root.right;  // right is node 7
TreeNode left = root.left;    // left is node 3
```

### 🔍 **Step 3.1: Find the largest node in the left subtree**
- Clearly, left subtree is just node `3`.
- Node `3` has **no right child**, so it is clearly the largest node on the left.

### 🔍 **Step 3.2: Attach the right subtree to the largest left node**
- Clearly set:
```java
largestLeft.right = right;  // Node 3's right is now Node 7
```

Now clearly visualize the subtree after helper method:
```
   3
    \
     7
    /
   6
```

- Clearly return node `3`.

---

## 🔍 **Step 4: Return from helper and reconnect to main tree**

Now, back in `deleteNode()` method, we've set clearly:
```java
root.left = [3→7→6]
```

Now, clearly the BST structure becomes:
```
        10
       /  \
      3    15
       \     \
        7     18
       /
      6
```

---

## ✅ **Final BST after Deletion (clearly visualized):**

```
        10
       /  \
      3    15
       \     \
        7     18
       /
      6
```

- The node **`5`** has clearly been deleted.
- BST properties clearly maintained:
  - All left descendants < parent node.
  - All right descendants > parent node.

---

## 🎯 **Summary of each step (clearly):**

| Step | Action (clearly explained)                                 | BST change clearly                  |
|------|------------------------------------------------------------|-------------------------------------|
| 1    | Start `deleteNode(10, 5)`                                  | Finds clearly `root.left = 5`       |
| 2    | Calls `helper(5)`                                          | Moves to clearly handle node `5`    |
| 3    | Finds largest clearly in left subtree (node `3`)           | Identifies node clearly as largest  |
| 4    | Attaches right subtree clearly (node `7`) to largest node  | Connects clearly `3 → 7 → 6`        |
| 5    | Returns node `3` clearly to original BST                   | Clearly reconnects subtree to root  |

This step-by-step visualization clarifies clearly **exactly** how your code deletes a node from a BST.

*/
