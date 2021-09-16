package dp.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PrintRightViewOfBinaryTree {

  public static void main(String args[]) {

    Node tree = new Node(1);
    tree.left = new Node(2);
    tree.right = new Node(3);
    tree.left.left = new Node(4);
    tree.left.right = new Node(5);
    tree.right.left = new Node(6);
    tree.right.right = new Node(7);
    tree.right.left.right = new Node(8);

    MaxLevel maxLevel = new MaxLevel();
    printRightView(tree, 1, maxLevel);

  }

  /**
   * We need to use a reference as maxLevel value can be changed by multiple methods
   */
  private static class MaxLevel {
    int maxLevel;
  }

  private static void printRightView(Node root, int level, MaxLevel maxLevel) {
    if(root == null) {
      return;
    }

    if(maxLevel.maxLevel < level) {
      System.out.println(root.getValue());
      maxLevel.maxLevel = level;
    }

    printRightView(root.right, level+1, maxLevel);

    printRightView(root.left, level+1, maxLevel);
  }


}