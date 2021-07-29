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



    // To insert new element on a particular position
    public void insertAtPosition (int data, int position) {
        if(position > length + 1) {
            System.out.println("Position Should be less than or equal to (length + 1).");
            return;
        }
        else if(position == 1) {
            insertAtStart(data);
            return;
        }
        else if(position == length) {
            insertAtEnd(data);
            return;
        }

        Node newNode = new Node(data);
        length++;

        int count = 1;
        Node currentNode = start;
        while(count < position-1) {
            currentNode = currentNode.getNextNode();
            count++;
        }

        newNode.setNextNode(currentNode.getNextNode());
        newNode.getNextNode().setPreviousNode(newNode);
        currentNode.setNextNode(newNode);
        newNode.setPreviousNode(currentNode);
    }



    // To delete a node from the start position
    public void deleteFromStart () {
        if(start == null) {
            System.out.println("Your Circular Doubly LinkedList is already empty.");
            return;
        }
        else if(length == 1) {
            start = null;
            end = null;
            length--;
            return;
        }

        length--;
        Node newStart = start.getNextNode();
        newStart.setPreviousNode(end);
        end.setNextNode(newStart);
        start = newStart;
    }
}
