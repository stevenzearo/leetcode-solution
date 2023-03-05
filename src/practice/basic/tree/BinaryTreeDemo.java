package practice.basic.tree;

import java.util.List;
import java.util.Stack;

/**
 * @author Steve Zou
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>();
        n1.value = 1;
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>();
        n2.value = 2;
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>();
        n3.value = 3;
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>();
        n4.value = 4;
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>();
        n5.value = 5;

        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>();
        n6.value = 6;


        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;

//        n1.postorderTraversal().forEach(System.out::println);

        List<List<Integer>> lists = n1.levelTraversal();

        BinaryTreeArray<Integer> treeArray = new BinaryTreeArray<>();
        treeArray.values = new Integer[] {1, 2, 3, 4, 5, 6};
//        treeArray.inorderTravel().forEach(System.out::println);

    }
}
