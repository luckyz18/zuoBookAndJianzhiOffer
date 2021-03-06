package a3_jianzhi_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 不分行从上到下打印二叉树
 */
public class code_32_1 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!= null){
                queue.offer(node.left);
            }
            if (node.right!= null){
                queue.offer(node.right);
            }
        }
        return list;
    }
}
