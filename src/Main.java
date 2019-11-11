import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

     public static void main(String[] args) {

         TreeNode root   = new TreeNode(4);
         root.left       = new TreeNode(2);
         root.right      = new TreeNode(5);
         root.left.left  = new TreeNode(1);
         root.left.right = new TreeNode(3);

         System.out.println( closestKValues(root,3.714286,2) );

    }

    //Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
    public static List<Integer> closestKValues(TreeNode root, double target, int k) {

            Deque<Integer> dq = new LinkedList<>();
            inorder(root, dq);
            while (dq.size() > k) {
                if (Math.abs(dq.peekFirst() - target) > Math.abs(dq.peekLast() - target))
                    dq.pollFirst();
                else
                    dq.pollLast();
            }

            return new ArrayList<>(dq);
     }

    public static void inorder(TreeNode root, Deque<Integer> dq) {
            if (root == null) return;
            inorder(root.left, dq);
            dq.add(root.val);
            inorder(root.right, dq);
     }

}
