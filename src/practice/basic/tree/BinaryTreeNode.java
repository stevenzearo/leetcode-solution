package practice.basic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Steve Zou
 */
public class BinaryTreeNode<T>  implements BinaryTree<T> {
    T value;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    @Override
    public List<T> preorderTraversal() {
        ArrayList<T> ls = new ArrayList<>();
        preorderTravel(ls, this);
        return ls;
    }

    @Override
    public List<T> inorderTraversal() {
        ArrayList<T> ls = new ArrayList<>();
        inorderTravel(ls, this);
        return ls;
    }

    @Override
    public List<T> postorderTraversal() {
        ArrayList<T> ls = new ArrayList<>();
        postorderTravel(ls, this);
        return ls;
    }

    @Override
    public List<List<T>> levelTraversal() {
        LinkedList<BinaryTreeNode<T>> linkedList = new LinkedList<>();
        linkedList.offer(this);
        List<List<T>> ls = new LinkedList<>();
        while (!linkedList.isEmpty()) {
            LinkedList<T> lse = new LinkedList<>();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<T> node = linkedList.poll();
                if (node.left != null) linkedList.offer(node.left);
                if (node.right != null) linkedList.offer(node.right);
                lse.add(node.value);
            }
            ls.add(lse);
        }
        return ls;
    }

    private void preorderTravel(List<T> ls, BinaryTreeNode<T> root) {
        if (root == null) return;
        ls.add(root.value);
        preorderTravel(ls, root.left);
        preorderTravel(ls, root.right);
    }

    private void inorderTravel(List<T> ls, BinaryTreeNode<T> root) {
        if (root == null) return;
        inorderTravel(ls, root.left);
        ls.add(root.value);
        inorderTravel(ls, root.right);
    }

    private void postorderTravel(List<T> ls, BinaryTreeNode<T>root) {
        if (root == null) return;
        postorderTravel(ls, root.left);
        postorderTravel(ls, root.right);
        ls.add(root.value);
    }
}
