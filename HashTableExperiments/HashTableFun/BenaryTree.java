import java.util.*;

public class BenaryTree<K, V> {

  private int treeSize = 0;
  private Node root = null;

  public class Node {
    Entry data;
    Node left, right;

    public Node(Entry data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }

    public Node(Node left, Node right, Entry data) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public boolean insert(Entry entry) {

    root = insert(root, entry);
    treeSize++;
    return true;

  }

  // Recursive. Arbitrary decision rule: if entry is greater than or equal
  // to node, then right; else, left.
  private Node insert(Node node, Entry entry) {

    if (node == null) {
      node = new Node(entry);
      return node;
    }

    int comparison = entry.compareTo(node.data);

    if (comparison == -1) {
      node.left = insert(node.left, entry);
    }

    else {
      node.right = insert(node.right, entry);
    }

    return node;

  }

  public boolean remove(Entry data) {

    if (contains(data)) {
      root = remove(root, data);
      treeSize--;
      return true;
    }

    return false;

  }

  // coin flip whether to pull right or left up in the case of two subtrees at
  // removed node
  private Node remove(Node node, Entry data) {

    if (node == null) {
      return null;
    }

    if (node.data.equals(data)) {

      if (node.left == null && node.right == null) {
        node = null;
      }

      else if (node.left == null && node.right != null) {
        node = node.right;
      }

      else if (node.left != null && node.right == null) {
        node = node.left;
      }

      else {

        double rand = Math.random();

        if (rand > 0.5) {
          Node leaf = node.right;
          while (leaf.left != null) {
            leaf = leaf.left;
          }
          node = leaf;
        }

        else {
          Node leaf = node.left;
          while (leaf.right != null) {
            leaf = leaf.right;
          }
          node = leaf;
        }

      }

    }

    else {

      int comparison = data.compareTo(node.data);

      if (comparison == -1) {
        node.left = remove(node.left, data);
      }

      else {
        node.right = remove(node.right, data);
      }

    }

    return node;

  }

  public boolean contains(Entry data) {

    if (contains(root, data)) {
      return true;
    }

    return false;

  }

  private boolean contains(Node node, Entry data) {

    if (node == null) {
      return false;
    }

    else if (node.data.equals(data)) {
      return true;
    }

    else {
      int comparison = node.data.compareTo(data);

      if (comparison == -1) {
        return contains(node.left, data);
      }

      else {
        return contains(node.right, data);
      }

    }

  }

  public int numberOfNodes() {
    return treeSize;
  }

  public ArrayList<Node> getAllNodes() {
    ArrayList<Node> listOfNodes = new ArrayList<Node>();
    int n = treeSize;
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    Node currentNode;
    int count = 0;

    while (count < n) {

      currentNode = queue.poll();
      listOfNodes.add(currentNode);

      if (currentNode.left != null) {
        queue.add(currentNode.left);
      }

      if (currentNode.right != null) {
        queue.add(currentNode.right);
      }

      count++;
    }

    return listOfNodes;
  }

  public ArrayList<Entry> getAllEntries() {

    ArrayList<Node> listOfNodes = getAllNodes();
    ArrayList<Entry> listOfEntries = new ArrayList<Entry>();

    for (int i = 0; i < listOfNodes.size(); i++) {
      listOfEntries.add(listOfNodes.get(i).data);
    }

    return listOfEntries;

  }

  public void treePrint() {

    for (Node node : getAllNodes()) {
      System.out.print("\n" + node.data.toString() + ": ");

      if (node.left != null) {
        System.out.print(node.left.data.toString() + ", ");
      } else {
        System.out.print("null, ");
      }

      if (node.right != null) {
        System.out.print(node.right.data.toString());
      } else {
        System.out.print("null");
      }
    }

  }

  /*
   * 
   * public LinkedHashMap<String, String[]> treeMap(){
   * 
   * LinkedHashMap<String, String[]> map = new LinkedHashMap<String, String[]>();
   * 
   * int n = treeSize; Queue<Node> queue = new LinkedList<Node>();
   * queue.add(root); Node currentNode; int count=0;
   * 
   * while(count<n-1){
   * 
   * currentNode = queue.poll(); String key = currentNode.data.toString();
   * String[] values = new String[2];
   * 
   * if(currentNode.left!=null){ queue.add(currentNode.left);
   * values[0]=currentNode.left.data.toString(); }else {values[0]="null";}
   * 
   * if(currentNode.right!=null){ queue.add(currentNode.right);
   * values[1]=currentNode.right.data.toString(); }else {values[1]="null";}
   * 
   * map.put(key, values);
   * 
   * count++; }
   * 
   * return map;
   * 
   * }
   * 
   */

}
