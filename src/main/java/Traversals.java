import java.util.List;
import java.util.ArrayList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

  /**
   * DO NOT ADD ANY GLOBAL VARIABLES!
   */

  private void checkPreorder(ArrayList<T> list, TreeNode<T> node) {
    if (node == null) {
      return;
    }
    list.add(node.getData());
    checkPreorder(list, node.getLeft());
    checkPreorder(list, node.getRight());
  }

  private void checkInorder(ArrayList<T> list, TreeNode<T> node) {
    if (node == null) {
      return;
    }
    checkInorder(list, node.getLeft());
    list.add(node.getData());
    checkInorder(list, node.getRight());
  }

  private void checkPostorder(ArrayList<T> list, TreeNode<T> node) {
    if (node == null) {
      return;
    }
    checkPostorder(list, node.getLeft());
    checkPostorder(list, node.getRight());
    list.add(node.getData());
  }

  /**
   * Given the root of a binary search tree, generate a
   * pre-order traversal of the tree. The original tree
   * should not be modified in any way.
   *
   * This must be done recursively.
   *
   * Must be O(n).
   *
   * @param <T>  Generic type.
   * @param root The root of a BST.
   * @return List containing the pre-order traversal of the tree.
   */
  public List<T> preorder(TreeNode<T> root) {
    ArrayList<T> order = new ArrayList<T>();
    checkPreorder(order, root);
    return order;

  }

  /**
   * Given the root of a binary search tree, generate an
   * in-order traversal of the tree. The original tree
   * should not be modified in any way.
   *
   * This must be done recursively.
   *
   * Must be O(n).
   *
   * @param <T>  Generic type.
   * @param root The root of a BST.
   * @return List containing the in-order traversal of the tree.
   */
  public List<T> inorder(TreeNode<T> root) {
    ArrayList<T> order = new ArrayList<T>();
    checkInorder(order, root);
    return order;
  }

  /**
   * Given the root of a binary search tree, generate a
   * post-order traversal of the tree. The original tree
   * should not be modified in any way.
   *
   * This must be done recursively.
   *
   * Must be O(n).
   *
   * @param <T>  Generic type.
   * @param root The root of a BST.
   * @return List containing the post-order traversal of the tree.
   */
  public List<T> postorder(TreeNode<T> root) {
    ArrayList<T> order = new ArrayList<T>();
    checkPostorder(order, root);
    return order;
  }
}