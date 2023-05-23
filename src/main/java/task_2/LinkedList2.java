package task_2;

import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
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
        while (current != null) {
            if (current.value == _value) {
                removeNode(current);
                current.prev = current.next = null;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node current = this.head;
        while (current != null) {
            Node next = current.next;
            if (current.value == _value) {
                removeNode(current);
                current.prev = current.next = null;
            }
            current = next;
        }
    }

    public void clear() {
        Node current = this.head;
        while (current != null) {
            Node previous = current;
            current = current.next;
            previous.prev = previous.next = null;
        }
        head = tail = null;
    }

    public int count() {
        int counter = 0;
        Node node = this.head;
        while (node != null) {
            node = node.next;
            counter++;
        }
        return counter;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeToInsert == null) {
            return;
        }
        if (_nodeAfter == null) {
            if (head == null) {
                addInTail(_nodeToInsert);
            } else {
                _nodeToInsert.next = head;
                head.prev = _nodeToInsert;
                _nodeToInsert.prev = null;
                head = _nodeToInsert;
            }
        } else {

            _nodeToInsert.next = _nodeAfter.next;
            _nodeToInsert.prev = _nodeAfter;
            _nodeAfter.next = _nodeToInsert;

            if (_nodeAfter == tail) {
                tail = _nodeToInsert;
                return;
            }

            _nodeToInsert.next.prev = _nodeToInsert;
        }
    }

    public void AddToHead(Node _nodeToAdd) {
        if (_nodeToAdd == null) {
            return;
        }
        if (head == null) {
            addInTail(_nodeToAdd);
        } else {
            _nodeToAdd.next = head;
            head.prev = _nodeToAdd;
            _nodeToAdd.prev = null;
            head = _nodeToAdd;
        }
    }

    private void removeNode(Node node){
        if (node == head) {
            if (head == tail) {
                clear();
            } else {
                head = head.next;
                head.prev = null;
            }
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}