package circularDoublyLinkedList;

import node.Node;

/**
 * Created by IntelliJ IDEA.
 * User: Abhinav Bhardwaj
 * Date: 27-07-2021
 * Time: 22:14
 */

public class CircularDoublyLinkedList {
    private int length;
    private Node start, end;



    // To get length or say no. of elements present the LinkedList
    public int getLength() {
        return length;
    }



    // To insert a new element at the start
    public void insertAtStart (int data) {
        Node newNode = new Node(data);
        length++;

        if(start == null) {
            start = newNode;
            start.setNextNode(start);
            start.setPreviousNode(start);
            end = start;
            return;
        }
        else if(length == 1) {
            newNode.setNextNode(start);
            newNode.setPreviousNode(start);
            start.setNextNode(newNode);
            start.setPreviousNode(newNode);
            start = newNode;
            return;
        }

        newNode.setNextNode(start);
        newNode.setPreviousNode(end);
        start.setPreviousNode(newNode);
        start = newNode;
        end.setNextNode(start);
    }



    // To insert new element after end or say between end and start
    public void insertAtEnd (int data) {
        Node newNode = new Node(data);
        length++;

        if(start == null) {
            start = newNode;
            start.setNextNode(start);
            start.setPreviousNode(start);
            end = start;
            return;
        }
        else if(length == 1) {
            newNode.setNextNode(start);
            newNode.setPreviousNode(end);
            end.setNextNode(newNode);
            start.setPreviousNode(newNode);
            end = newNode;
            return;
        }

        newNode.setNextNode(start);
        newNode.setPreviousNode(end);
        start.setPreviousNode(newNode);
        end.setNextNode(newNode);
        end = newNode;
    }
}
