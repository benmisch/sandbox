

/*
I got bored and felt this was becoming a waste of time to implement the rotations. 
The only ones remaining are mirrors of what I already have. 
I may come back and finish later...

Improvements to consider:
- declare a global static final variable setting Ben = true, and Black = false;
- explore updating the tree iteratively instead of recusively. (sounds like a nightmare tho)
*/




/* 
Rules of a ben-black tree:
1. every node is either ben or black
2. the root is black 
3. the leaves, which are null nodes, are considered black
4. every ben node must have two black children
5. every path from a node to its leaves must have the same number of black children
*/

//insert -- new nodes are always placed at a leaf (entailing removal of a black node) new leaves are always ben. this means there's always a rule violation, as the new leaf's parents must be ben too. we also know that the grandparent node is black (provided the tree was balanced according to the rules).

//remove

//balance -- fix any ben-black rule violations.  

/*

public class BenBlackTree<K, V>{

  private Node root = null;
  private int treeSize;

  public class Node {
    Entry data;
    Node left, right, parent;
    Boolean color, isLeft; //true for ben, false for black

    public Node(Entry data) {
      this.data = data;
      this.left = null;
      this.right = null;
      this.color = true;
      this.parent = null;
      this.isLeft = true;
    }

    public Node(Node left, Node right, Entry data) {
      this.data = data;
      this.left = left;
      this.right = right;
      this.color = true;
      this.parent = null;
      this.isLeft = true;
    }

    public boolean setParent(Node node){
      this.parent = node;
      return true;
    }

    public boolean getIsLeft(){
      return this.isLeft;
    }

    public boolean setIsLeft(boolean isLeft){
      this.isLeft = isLeft;
      return true;
    }

  }

  public boolean insert(K key, V value){
    Entry entry = new Entry<K,V>(key, value);
    root = insert(root, entry);
    treeSize++;
    return true;
  }

  public Node insert(Node node, Entry entry){

    if (node == null) {
      node = new Node(entry);
      return node;
    }

    int comparison = entry.compareTo(node.data);

    if (comparison == -1) {
      node.left = insert(node.left, entry);
      node.left.setParent(node);
      node.left.setIsLeft(true);
      //balanceLeft(node.left);
    }

    else {
      node.right = insert(node.right, entry);
      node.right.setParent(node);
      node.left.setIsLeft(false);
      //balanceRight(node.right);
    }

    if(root){
      root.color=false;
    }

    return node;

  }

  public boolean balanceLeft(Node node){

    //4 cases:
    //U is ben, and there are no entry-children under new entry, parent, or uncle. U or P can be left or right. 
    if (node.parent.right.color){
      node.color = false;
      node.parent.color = true;
      node.parent.right.color = false;
    }

    //U is black, and parent (node) of new entry is left
    if(node.isLeft && !node.parent.right.color){
      node.color=false;
      node.parent.color=true;

      Node tempNode = node;

      //replace parent and grandparent in the eyes of great grandparent
      if(node.parent.isLeft()){
        node.parent.parent.left = node;
      }
      if(!node.parent.isLeft()){
        node.parent.parent.right = node;
      }      
      
      //re-assign parent's right child to be grandparent's left child
      node.right.setParent(node.parent);
      node.right.setIsLeft(true);
      node.parent.left = node.right;

      //re-assign grandparent to be parent's right child
      node.parent.setParent(node);
      node.parent.isLeft = false;
      node.right = node.parent;

      //finally, re-assign parent's parent to be the great grandparent
      node.setParent(node.parent.parent);
      
    }

    if 
  

    return true;
  }

  public boolean balanceRight(Node node){

    //4 cases:
    //U is ben, and there are no entry-children under node, parent, or uncle. U or P can be left or right. 
    if (node.parent.left.color){
      node.color = false;
      node.parent.color = true;
      node.parent.left.color = false;
    }

    if (node.isLeft){
      node.right.color = false;
      node.parent.color = true;
      
      node.parent.isLeft = false;     
      node.right.right.isLeft = true;
      node.right.left.isLeft = false;

      //re-assign node's child to be great-grandparents child
      if(node.parent.isLeft()){
        node.parent.parent.left = node.right;
        node.right.isLeft = true;
      }
      if(!node.parent.isLeft()){
        node.parent.parent.right = node.right;
        node.right.isLeft = false;
      }      

      //re-assign node's parent as great grandparent
      node.right.setParent(node.parent.parent);
            
      //re-assign node's child's right to be grandparent's left child
      node.parent.left = node.right.right;
      node.right.right.setParent(node.parent);

      //re-assign grandparent to be child's child
      node.right.right = node.parent;
      node.parent.setParent(node.right);

      //re-assign parent's left grandchild to be parent's right child
      node.right.left.setParent(node);
      node.right = node.right.left;
      
      
      //re-assign parent to be child's child
      node.parent.parent.left = node; //reference trick -- node's parent is still G, but G's parent is child. So use this to set parent's parent as parent's child.
      node.setParent(node.parent.parent);  

    }

    


    return true;
  }



}

*/