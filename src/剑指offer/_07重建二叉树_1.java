package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 示例 1:
 *     3
 * /       \
 * 9       20
 *      /       \
 *      15      7
 * Input: preorder(前) = [3,9,20,15,7], inorder(中) = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * 1、前序逐个遍历，第一个是根节点，根节点左右都会next左右根绝点
 * 2、
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class _07重建二叉树_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

}
