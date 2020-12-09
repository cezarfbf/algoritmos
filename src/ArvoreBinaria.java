import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArvoreBinaria {

    public static void main(String[] args) {

        Thee<Integer> thee = new Thee<>();

        thee.add(10);
        thee.add(5);
        thee.add(5);
        thee.add(145234);

        thee.posOrder(thee.getRoot());

    }
}

class Thee<T extends Comparable> {
    private Node<T> root;

    public Thee() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (root == null)
            this.root = node;
        else
            verifyNode(node);
    }

    private void verifyNode(Node<T> node) {
        Node curr = this.root; // inicia a verredura pelo root
        while (true) {
            // Numeros menores a esquerda
            if (node.getValue().compareTo(curr.getValue()) == -1) // Se novo Node for menor que o atual
                if (curr.getLeft() != null)
                    curr = curr.getLeft();
                else {
                    curr.setLeft(node);
                    break;
                }
            else // Se for maior ou igual
                if (curr.getRight() != null)
                    curr = curr.getRight();
                else {
                    curr.setRight(node);
                    break;
                }
        }
    }

    public void inOrder(Node node){
        if (node != null){
            inOrder(node.getLeft());
            System.out.println(node.getValue());
            inOrder(node.getRight());
        }
    }

    public void preOrder(Node node){
        if (node != null){
            System.out.println(node.getValue());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void posOrder(Node node){
        if (node != null){
            posOrder(node.getLeft());
            posOrder(node.getRight());
            System.out.println(node.getValue());
        }
    }

    public Node<T> insert(Node<T> root, T data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data.compareTo(root.getValue()) < 1 ) {
                cur = insert(root.getLeft(), data);
                root.setLeft(cur);
            } else {
                cur = insert(root.getRight(), data);
                root.setRight(cur);
            }
            return root;
        }
    }

}

class Node<T> {

    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

}
