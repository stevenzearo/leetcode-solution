package practice.basic.tree;

import java.util.List;

/**
 * @author Steve Zou
 */
public interface BinaryTree<T> {

    List<T> preorderTraversal();
    List<T> inorderTraversal();

    List<T> postorderTraversal();
    List<List<T>> levelTraversal();


}
