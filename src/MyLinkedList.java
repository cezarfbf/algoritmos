public class MyLinkedList {
    private Node startNode = null;
    private Node endNode = null;
    private int nodeCounter;

    //A node for the linked list.
    private class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node createNode(int value) {
        nodeCounter++;
        return new Node(value);
    }

    private void insertNodeAtEnd(int value) {
        if (startNode == null) {
            startNode = createNode(value);
            endNode = startNode;
        } else {
            Node node = createNode(value);
            endNode.next = node;
            endNode = node;
        }
    }

    private void insertNodeAtBeginning(int value) {
        Node node = createNode(value);
        node.next = startNode;
        startNode = node;
    }

    private void insertAtMid(int insertAfter, int newValue) {
        Node node = startNode;
        while (node != null) {
            if (node.value == insertAfter) {
                Node newNode = createNode(newValue);
                newNode.next = node.next;
                node.next = newNode;
                break;
            }
            node = node.next;
        }
    }

    private void deleteStartingNode() {
        if (startNode != null) {
            nodeCounter--;
            startNode = startNode.next;
        }
    }

    private void deleteAtEnd() {

        if (startNode == null) {
            return;
        }

        if (startNode == endNode) {
            nodeCounter--;
            startNode = endNode = null;
            return;
        }

        Node node = startNode;
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        endNode = node;
        nodeCounter--;
    }

    private void displayNode() {
        Node node = startNode;
        while (node != null) {
            System.out.println("-->" + node.value);
            node = node.next;
        }
    }

    private void deleteParticularNode(int deleteValue) {
        if (startNode == null) {
            return;
        }

        if (startNode == endNode) {
            if (startNode.value == deleteValue) {
                startNode = endNode = null;
                nodeCounter--;
            } else {
                System.out.print("Value not found");
            }
            return;
        }

        if (startNode.value == deleteValue) {
            deleteStartingNode();
            return;
        }

        Node node = startNode;
        while (node.next != null) {
            if (node.next.value == deleteValue) {
                node.next = node.next.next;
                nodeCounter--;
                break;
            }
            node = node.next;
        }
    }

    public static void main(String args[]) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insertNodeAtEnd(10);
        linkedList.insertNodeAtEnd(20);
        linkedList.insertNodeAtEnd(30);
        linkedList.insertNodeAtEnd(40);
        linkedList.insertNodeAtEnd(45);
        linkedList.insertNodeAtEnd(50);
        linkedList.insertNodeAtEnd(55);
        linkedList.insertNodeAtBeginning(5);
        linkedList.insertNodeAtBeginning(1);
        linkedList.insertAtMid(40, 45);
        linkedList.deleteParticularNode(45);

        linkedList.displayNode();
        System.out.print("Total number of node:" + linkedList.nodeCounter);
    }
}
