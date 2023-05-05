package com.solvd.deliveryservice.utilities;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyLinkedList<T> {
    private Node head; // list object only knows its start (head)

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void addElement(T data) {
        Node newNode = new Node(data); // creates Node object and assigns data to it, next points to null
        if (this.head == null) {
            this.head = newNode; // in case empty list, new element is head, new element has default reference (null)
        }
        else { Node currentNode = this.head; // in case not empty list, we start iterating from the head towards last node
            while (currentNode.getNext()!=null){ // loop stops once we reach tail element and store it in currentNode
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode); // creates reference of current node to the newNode (we created)
        }
    }

    public void removeElement(T data){ // list can have 0 or more elements
        if(head.getData()==data){ // if we want to delete element that is head of our list
            this.head = head.getNext(); // reassigns head to the next element or null (since next is null for the last el)
        } else { Node currentNode = this.head;  // in case not head, we start iterating from the head towards last node
            while(currentNode.getNext()!=null){ // loop stops once we reach tail element (end of the list)
                if(currentNode.getNext().getData() == data) { // checks if next element is element we want to delete
                    currentNode.setNext(currentNode.getNext().getNext()); // if yes, reassigns reference by skipping 1 el
                    break;
                }
                currentNode = currentNode.getNext(); // moves to the next Node
            }
        }
    }

    public void printEls(){
        if(this.head!=null){
            Node current = this.head;
            while (current != null) {
                System.out.println(current.getData() + " ");
                current = current.getNext();
            }
        }
    }


    private class Node <T>{
        private T data;
        private Node next;

        public Node(T data){
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
