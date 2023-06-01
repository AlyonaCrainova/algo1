package task_7;

import java.util.*;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        int compare = 0;
        if (v1 instanceof String) {
            compare = (((String) v1).trim()).compareTo(((String) v2).trim());
        } else if (v1 instanceof Integer) {
            compare = Integer.compare((int) v1, (int) v2);
        }
        return Integer.compare(compare, 0);
    }

    public void add(T value) {
        if (head == null) {
            head = tail = new Node<>(value);
            return;
        }
        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        while (current != null) {
            int compare = compare(value, current.value);
            if (compare == 0) {
                insertAfter(current, newNode);
                return;
            }
            if ((_ascending && compare == 1 || !_ascending && compare == -1) && current == tail) {
                addInTail(newNode);
            } else if (_ascending && compare == 1 || !_ascending && compare == -1) {
                current = current.next;
                continue;
            } else {
                insertAfter(current.prev, newNode);
            }
            return;
        }
    }

    public Node<T> find(T val) {
        Node<T> current = head;
        while (current != null) {
            int compare = compare(val, current.value);
            if (compare == 0) {
                return current;
            }
            if (_ascending && compare == 1 || !_ascending && compare == -1) {
                current = current.next;
            } else {
                return null;
            }
        }
        return null;
    }

    public void delete(T val) {
        Node<T> foundValue = find(val);
        if (foundValue != null) {
            removeNode(foundValue);
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        Node<T> node = head;
        while (node != null) {
            removeNode(node);
            node = node.next;
        }
        head = tail = null;
    }

    public int count() {
        int counter = 0;
        Node<T> node = head;
        while (node != null) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    private void addInTail(Node<T> _item) {
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
    private void insertAfter(Node<T> _nodeAfter, Node<T> _nodeToInsert) {
        if (_nodeToInsert == null) {
            return;
        }
        if (_nodeAfter == null && head == null || _nodeAfter != null && _nodeAfter == tail) {
            addInTail(_nodeToInsert);
        } else if (_nodeAfter == null) {
            addToHead(_nodeToInsert);
        }else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeToInsert.prev = _nodeAfter;
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.next.prev = _nodeToInsert;
        }
    }

    private void addToHead(Node<T> _nodeToAdd) {
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

    private void removeNode(Node<T> node){
        if (node == head && node == tail) {
            node.prev = node.next = head = tail = null;
        } else if (node == head){
            head = head.next;
            head.prev = null;
        }else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}