import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class Node<T> {
    T value;
    Node<T> next;
    Node<T> prev;

    public Node(T value, Node<T> next, Node<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

public class DoublyLinkedList<T> {
    private Node<T> head;
    private  Node<T> tail;
    private int size = 0;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public DoublyLinkedList(Node<T> head, Node<T> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public DoublyLinkedList(T item) {
        head = new Node(item, null, null);
        tail = head;
        size = 1;
    }

    public DoublyLinkedList(Collection<T> items) {
        if(items.size() > 0) {
            Object[] input = items.toArray();
            head = new Node((T)input[0], null, null);
            Node current = head;
            for(int i= 1;i < input.length; i++) {
                tail = current;
                current.next = append((T)input[i]);
                current = current.next;
            }
            size = items.size();
        } else {
            new DoublyLinkedList<T>();
        }
    }

    public Node<T> append(T item) {
        Node newItem = new Node(item, null, this.tail);
        if(head == null) {
            this.head = newItem;
        } else {
            this.tail.next = newItem;
            this.tail = this.tail.next;
        }
        size++;
        return this.tail;
    }

    public Node<T> prepend(T item) {
        Node newItem = new Node(item, this.head, null);
        if(this.head == null) {
            this.head = newItem;
        } else {
            this.head.prev = newItem;
            this.head = this.head.prev;
        }
        size++;
        return this.head;
    }

    public T remove(T item) {
        Node current = this.head;
        while( current != null && current.value != item) {
            current = current.next;
        }
        if(current != null && (T)current.value == item) {
            Node prev = current.prev;
            Node next = current.next;
            prev.next = next;
            next.prev = prev;
            return (T)current.value;
        }
        return null;
    }

    public boolean contains(T item) {
        Node current = this.tail;
        while(current != null && current.value != item) {
            current = current.prev;
        }
        return current != null && current.value == item;
    }

    public void print() {
        Node current = this.head;
        while(current != null) {
            System.out.print(current.value + "  ");
            current = current.next;
        }
    }

    public DoublyLinkedList<T> reverse() {
        Node current = this.tail;
        List<T> resultList = new ArrayList<>();
        while(current != null) {
            resultList.add((T)current.value);
            current = current.prev;
        }
        return new DoublyLinkedList<>(resultList);
    }

    /* implement assuming the list is singly linked list */
    public DoublyLinkedList<T> reverseWOTraversingFromLastV1() {
        List<T> list = new ArrayList<T>();
        fillListInReverse(this.head, list);
        DoublyLinkedList<T> result = new DoublyLinkedList(list);
        return result;
    }

    public DoublyLinkedList<T> reverseWOTraversingFromLastV2() {
        Node current = this.head;
        Node lastVisitedNode = null, previousNode = null, head = null;
        int i = 0;
        while(current != null) {
            lastVisitedNode = current;
            current = current.next;

            lastVisitedNode.next = previousNode;
            previousNode = lastVisitedNode;
            head = previousNode;
            ++i;
        }
        return new DoublyLinkedList(head, null, i);
    }

    private void fillListInReverse(Node<T> head, List<T> result) {
        if(head.next != null) {
            fillListInReverse(head.next, result);
        }
        result.add(head.value);
    }


    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(Arrays.asList(1,2,4));
        System.out.println(list.head.value);
        System.out.println(list.tail.value);
        list.prepend(0);
        list.append(5);
        System.out.println(list.head.value);
        System.out.println(list.tail.value);
        list.print();
        System.out.println();
        System.out.println("Is list contains 2? : " + list.contains(2));
        System.out.println(list.remove(1));
        list.print();

        System.out.println();
        System.out.println("Reversed Queue:");
        DoublyLinkedList reversedList = list.reverse();
        reversedList.print();
        System.out.println();
        System.out.println("Reversed Queue (Assuming input is Singly Linked list):");
        reversedList = reversedList.reverseWOTraversingFromLastV1();
        reversedList.print();

        System.out.println();
        System.out.println("Reversed Queue (Assuming input is Singly Linked list):");
        reversedList.reverseWOTraversingFromLastV2().print();

    }
}
