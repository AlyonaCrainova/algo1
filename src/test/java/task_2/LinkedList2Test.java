package task_2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedList2Test {
    private final LinkedList2 list = new LinkedList2();

    @Test
    void find_in_empty_list() {
        Node node = list.find(1);

        assertNull(node);
    }

    @Test
    void find_in_non_empty_list() {
        Node node_1 = new Node(1);
        Node node_2 = new Node(1);
        Node node_3 = new Node(3);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);
        Node node = list.find(1);

        assertEquals(node_1, node);
    }

    @Test
    void remove_from_empty() {
        boolean success = list.remove(3);

        assertFalse(success);
        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(list.count(), 0);
    }

    @Test
    void remove_from_single_node_list_success() {
        Node node = new Node(1);
        list.addInTail(node);

        boolean success = list.remove(1);

        assertTrue(success);
        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(list.count(), 0);
    }

    @Test
    void remove_from_single_node_list_fail() {
        Node node = new Node(5);
        list.addInTail(node);

        boolean success = list.remove(1);

        assertFalse(success);
        assertEquals(node, list.head);
        assertEquals(node, list.tail);
        assertEquals(list.count(), 1);
    }

    @Test
    void remove_from_head_multiple_node_list_success() {
        Node node_1 = new Node(1);
        Node node_2 = new Node(1);
        Node node_3 = new Node(3);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);

        boolean success = list.remove(1);

        assertTrue(success);
        assertEquals(list.head, node_2);
        assertNull(list.head.prev);
        assertEquals(list.head.next, node_3);
        assertEquals(list.tail, node_3);
        assertEquals(list.tail.prev, node_2);
        assertNull(list.tail.next);
        assertEquals(list.count(), 2);
    }

    @Test
    void remove_from_tail_multiple_node_list_success() {
        Node node_1 = new Node(1);
        Node node_2 = new Node(1);
        Node node_3 = new Node(3);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);

        boolean success = list.remove(3);

        assertTrue(success);
        assertEquals(list.head, node_1);
        assertEquals(list.head.next, node_2);
        assertNull(list.head.prev);
        assertEquals(list.tail, node_2);
        assertEquals(list.tail.prev, node_1);
        assertNull(list.tail.next);
        assertNull(node_3.prev);
        assertNull(node_3.next);
        assertEquals(list.count(), 2);
    }

    @Test
    void remove_from_middle_multiple_node_list_success() {
        Node node_1 = new Node(1);
        Node node_2 = new Node(2);
        Node node_3 = new Node(3);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);

        boolean success = list.remove(2);

        assertTrue(success);
        assertEquals(list.head, node_1);
        assertEquals(list.head.next, node_3);
        assertNull(list.head.prev);
        assertEquals(list.tail, node_3);
        assertEquals(list.tail.prev, node_1);
        assertNull(list.tail.next);

        assertEquals(list.count(), 2);
    }

    @Test
    void remove_from_multiple_node_list_fail() {
        Node node_1 = new Node(1);
        Node node_2 = new Node(1);
        Node node_3 = new Node(3);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);

        boolean success = list.remove(4);

        assertFalse(success);
        assertEquals(list.head, node_1);
        assertEquals(list.tail, node_3);
        assertEquals(list.count(), 3);
    }

    @Test
    void removeAll_from_empty() {
        list.removeAll(3);

        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(list.count(), 0);
    }

    @Test
    void removeAll_from_single_node_list_success() {
        Node node = new Node(1);
        list.addInTail(node);

        list.removeAll(1);

        assertNull(list.head);
        assertNull(list.tail);
        assertNull(node.prev);
        assertNull(node.next);
        assertEquals(list.count(), 0);
    }

    @Test
    void removeAll_from_single_node_list_fail() {
        Node node = new Node(5);
        list.addInTail(node);

        list.removeAll(1);

        assertEquals(node, list.head);
        assertEquals(node, list.tail);
        assertNull(node.next);
        assertNull(node.prev);
        assertEquals(list.count(), 1);
    }

    @Test
    void removeAll_from_head_multiple_node_list_success() {
        Node node_1 = new Node(1);
        Node node_2 = new Node(1);
        Node node_3 = new Node(3);

        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);

        list.removeAll(1);

        assertEquals(list.head, node_3);
        assertEquals(list.tail, node_3);
        assertNull(node_3.next);
        assertNull(node_3.prev);
        assertEquals(list.count(), 1);
    }

    @Test
    void removeAll_from_tail_multiple_node_list_success() {
        Node node_1 = new Node(1);
        Node node_2 = new Node(1);
        Node node_3 = new Node(3);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);

        list.removeAll(3);

        assertEquals(list.head, node_1);
        assertNull(list.head.prev);
        assertEquals(list.head.next, node_2);
        assertEquals(list.tail, node_2);
        assertEquals(list.tail.prev, node_1);
        assertNull(node_2.next);
        assertNull(node_3.prev);
        assertNull(node_3.next);
        assertEquals(list.count(), 2);
    }

    @Test
    void removeAll_multiple_node_list_fail() {
        Node node_1 = new Node(1);
        Node node_2 = new Node(1);
        Node node_3 = new Node(3);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);

        list.removeAll(4);

        assertEquals(list.head, node_1);
        assertNull(list.head.prev);
        assertEquals(list.head.next, node_2);
        assertEquals(node_2.prev, node_1);
        assertEquals(node_2.next, node_3);
        assertEquals(list.tail, node_3);
        assertEquals(node_3.prev, node_2 );
        assertNull(node_3.next);
        assertEquals(list.count(), 3);
    }

    @Test
    void clear_empty() {
        list.clear();

        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(list.count(), 0);
    }

    @Test
    void clear_non_empty() {
        Node node_1 = new Node(1);
        list.addInTail(node_1);
        Node node_2 = new Node(2);
        list.addInTail(node_2);

        list.clear();

        assertNull(list.head);
        assertNull(list.tail);
        assertNull(node_1.next);
        assertNull(node_1.prev);
        assertNull(node_2.next);
        assertNull(node_2.prev);
        assertEquals(list.count(), 0);
    }

    @Test
    void findAll_in_empty(){
        ArrayList<Node> result = list.findAll(1);

        assertEquals(result, new ArrayList<Node>());
    }

    @Test
    void findAll_single_node_list_success(){
        Node node = new Node(1);
        list.addInTail(node);
        ArrayList<Node> expected = new ArrayList<>();
        expected.add(node);

        ArrayList<Node> result = list.findAll(1);

        assertEquals(result, expected);
    }

    @Test
    void findAll_single_node_list_fail(){
       Node node = new Node(1);
        list.addInTail(node);

        ArrayList<Node> result = list.findAll(2);

        assertEquals(result, new ArrayList<>());
    }

    @Test
    void findAll_multiple_node_list_success(){
        Node node_1 = new Node(1);
        Node node_2 = new Node(3);
        Node node_3 = new Node(1);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);
        ArrayList<Node> expected = new ArrayList<>();
        expected.add(node_1);
        expected.add(node_3);

        ArrayList<Node> result = list.findAll(1);

        assertEquals(result, expected);
    }

    @Test
    void findAll_multiple_node_list_fail(){
        Node node_1 = new Node(1);
        Node node_2 = new Node(3);
        Node node_3 = new Node(1);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);

        ArrayList<Node> result = list.findAll(2);

        assertEquals(result, new ArrayList<Node>());
    }

    @Test
    void count_empty_list(){
        assertEquals(list.count(), 0);
    }

    @Test
    void count_multiple_node_list(){
        Node node_1 = new Node(1);
        Node node_2 = new Node(3);
        Node node_3 = new Node(1);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);

        assertEquals(list.count(), 3);
    }

    @Test
    void insertAfter_insert_null_node(){
        Node node = new Node(1);
        list.addInTail(node);

        list.insertAfter(node, null);

        assertEquals(list.head, node);
        assertNull(list.head.next);
        assertNull(list.head.prev);
        assertEquals(list.tail, node);
        assertEquals(list.count(), 1);
    }

    @Test
    void insertAfter_after_null_empty_list(){
        Node node = new Node(1);

        list.insertAfter(null, node);

        assertEquals(list.head, node);
        assertEquals(list.tail, node);
        assertNull(list.head.next);
        assertNull(list.head.prev);
        assertEquals(list.count(), 1);
    }

    @Test
    void insertAfter_after_null_non_empty(){
        Node node_1 = new Node(2);
        list.addInTail(node_1);
        Node node_2 = new Node(1);

        list.insertAfter(null, node_2);

        assertEquals(list.head, node_2);
        assertNull(list.head.prev);
        assertEquals(list.head.next, node_1);
        assertEquals(list.tail, node_1);
        assertEquals(list.tail.prev, node_2);
        assertNull(list.tail.next);
        assertEquals(list.count(), 2);
    }

    @Test
    void insertAfter_tail(){
        Node node_1 = new Node(1);
        Node node_2 = new Node(3);
        Node node_3 = new Node(1);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);
        Node nodeToInsert = new Node(7);

        list.insertAfter(list.tail, nodeToInsert);

        assertEquals(list.tail, nodeToInsert);
        assertEquals(node_3.next, nodeToInsert);
        assertEquals(nodeToInsert.prev, node_3);
        assertNull(nodeToInsert.next);
        assertEquals(list.count(), 4);
    }

    @Test
    void insertAfter_head(){
        Node node_1 = new Node(1);
        Node node_2 = new Node(3);
        Node node_3 = new Node(1);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);
        Node nodeToInsert = new Node(7);

        list.insertAfter(list.head, nodeToInsert);

        assertEquals(list.head.next, nodeToInsert);
        assertEquals(nodeToInsert.next, node_2);
        assertEquals(nodeToInsert.prev, node_1);
        assertEquals(nodeToInsert, node_2.prev);
        assertEquals(list.count(), 4);
    }

    @Test
    void insertAfter_in_middle(){
        Node node_1 = new Node(1);
        Node node_2 = new Node(3);
        Node node_3 = new Node(1);
        list.addInTail(node_1);
        list.addInTail(node_2);
        list.addInTail(node_3);
        Node nodeToInsert = new Node(7);

        list.insertAfter(node_2, nodeToInsert);

        assertEquals(node_2.next, nodeToInsert);
        assertEquals(nodeToInsert.next, node_3);
        assertEquals(nodeToInsert.prev, node_2);
        assertEquals(nodeToInsert, node_3.prev);
        assertEquals(list.count(), 4);
    }

    @Test
    void AddToHead_null_node(){
        Node node = new Node(1);
        list.addInTail(node);

        list.addToHead(null);

        assertEquals(list.head, node);
        assertNull(list.head.next);
        assertNull(list.head.prev);
        assertEquals(list.tail, node);
        assertEquals(list.count(), 1);
    }

    @Test
    void AddToHead_empty_list(){
        Node node = new Node(1);

        list.addToHead( node);

        assertEquals(list.head, node);
        assertEquals(list.tail, node);
        assertNull(list.head.next);
        assertNull(list.head.prev);
        assertEquals(list.count(), 1);
    }

    @Test
    void AddToHead_non_empty(){
        Node node_1 = new Node(2);
        list.addInTail(node_1);
        Node node_2 = new Node(1);

        list.addToHead(node_2);

        assertEquals(list.head, node_2);
        assertNull(list.head.prev);
        assertEquals(list.head.next, node_1);
        assertEquals(list.tail, node_1);
        assertEquals(list.tail.prev, node_2);
        assertNull(list.tail.next);
        assertEquals(list.count(), 2);
    }

}
