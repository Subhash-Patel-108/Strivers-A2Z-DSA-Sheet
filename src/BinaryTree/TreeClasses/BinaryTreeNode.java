package BinaryTree.TreeClasses;

public class BinaryTreeNode <T> {
    public T data ;
    public BinaryTreeNode<T> left ;
    public BinaryTreeNode<T> right ;

    //Constructor
    public BinaryTreeNode (T data) {
        this.data = data ;
        this.left = null ;
        this.right = null ;
    }
};
