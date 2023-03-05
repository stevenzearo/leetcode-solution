package practice.basic.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steve Zou
 */
public class BinaryTreeArray<T> implements BinaryTree<T> {
    T[] values;

    @Override
    public List<T> preorderTraversal() {
        ArrayList<T> ls = new ArrayList<>();
        preorderTravel(ls, 1);
        return ls;
    }

    @Override
    public List<T> inorderTraversal() {
        return null;
    }

    @Override
    public List<T> postorderTraversal() {
        return null;
    }

    @Override
    public List<List<T>> levelTraversal() {
        return null;
    }

    public void preorderTravel(List<T> ls, int rootInd) {
        int ind = rootInd;
        if (rootInd > values.length) return;
        ls.add(values[rootInd - 1]);
        preorderTravel(ls, nextLeftInd(ind));
        preorderTravel(ls, nextRightInd(ind));
    }

    private int nextLeftInd(int rootInd) {
        return rootInd * 2;
    }

    private int nextRightInd(int rootInd) {
        return rootInd * 2 + 1;
    }
}
