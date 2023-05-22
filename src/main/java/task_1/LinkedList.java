package task_1;

import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (item == null){
            return;
        }
        if (this.head == null) {
            this.head = item;
        }else {
            this.tail.next = item;
        }
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node current = this.head;
        Node previous = null;
        while (current != null) {
            if (current.value == _value) {
                if (current == head) {
                    if (head == tail) {
                        clear();
                    } else {
                        head = head.next;
                    }
                } else if (current == tail) {
                    tail = previous;
                    previous.next = null;
                } else {
                    previous.next = current.next;
                }
                current.next = null;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        boolean success;
        do {
            success = remove(_value);
        } while (success);
    }

    public void clear() {
        Node current = this.head;
        while (current != null) {
            Node previous = current;
            current = current.next;
            previous.next = null;
        }
        head = tail = null;
    }

    public int count() {
        int counter =  0;
        Node node = this.head;
        while (node != null) {
            node = node.next;
            counter ++;
        }
        return counter;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeToInsert == null){
            return;
        }
        if (_nodeAfter == null) {
            if (head == null) {
                addInTail(_nodeToInsert);
            } else {
                _nodeToInsert.next = head;
                head = _nodeToInsert;
            }

        } else {
            if (_nodeAfter == tail) {
                tail = _nodeToInsert;
            }
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
        }
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}