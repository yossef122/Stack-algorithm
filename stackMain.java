package Stack;

public class stackMain {

    public static void main(String[] args) {
        Stack stack = new Stack(false);
        System.out.println(stack.isEmpty() + "is empty");

        stack.push(0);
        stack.push(1);
        stack.push(3);
        stack.push(2);

//        System.out.println(stack.isEmpty());
//        System.out.println("length"+stack.lengthStack());
//        
//        stack.print();
//        stack.pop();
//        System.out.println("length"+stack.lengthStack());
//        System.out.println(stack.lengthStack());
//        System.out.println("peek "+        stack.peek());
        while (!stack.isEmpty()) {
            System.out.println("pop " + stack.pop());

            System.out.println("length " + stack.lengthStack());
            System.out.println("----------------");

        }
    }

}

class Stack {

    private LinkedList datalist;

    Stack(boolean unique) {
        this.datalist = new LinkedList(unique);
    }

    void push(int _data) {
        this.datalist.insertFirst(_data);
    }

    int pop() {
        int head_Data;
        head_Data = this.datalist.head.data;
        this.datalist.deleteHead();
        return head_Data;
    }

    int peek() {
        return this.datalist.head.data;
    }

    boolean isEmpty() {
        if (this.datalist.length <= 0) {
            return true;
        }
        return false;
    }

    void print() {
        this.datalist.printList();
    }

    int lengthStack() {
        return this.datalist.length;
    }
}

class Node {

    public int data;
    public Node next;

    Node(int data) {
        this.data = data;
    }
}

class LinkedList {

    public Node head = null;
    public Node tail = null;
    public boolean unique;

    LinkedList(boolean unique    ) {
        this.length = 0;
        this.unique = unique == true ? unique : false;
    }
    public int length;

    linkedListIterator begin() {
        linkedListIterator itr = new linkedListIterator(this.head);
        return itr;
    }

    boolean canInsert(int data) {

        if (this.unique
                && this.isExist(data)) {
            System.out.println("this data => " + data + " is already exist");
            return false;
        } else {
            return true;
        }
    }


    void printList() {
        for (linkedListIterator itr = this.begin(); itr.current() != null; itr.next()) {
            System.out.println(itr.data() + " ");
        }

    }
    boolean isExist(int data) {
        if (this.find(data) != null) {
            return true;
        } else {
            return false;
        }
    }

    Node find(int _data) {
        for (linkedListIterator itr = this.begin(); itr.current() != null; itr.next()) {
            if (itr.data() == _data) {
                return itr.current();
            }
        }
        return null;
    }

    void insertAfter(Node oldNode, int data) {
        if (this.canInsert(data) == false) {
            return;
        }
        Node newNode = new Node(data);
        newNode.next = oldNode.next;
        oldNode.next = newNode;
        if (this.tail == null || newNode.next == null) {
            this.tail = newNode;
        }

        this.length++;
    }

    void insertFirst(int data) {
        if (this.canInsert(data) == false) {
            return;
        }
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;

    }

    void deleteHead() {
        if (this.head == null) {
            return;
        }
        this.head = this.head.next;
        this.length--;
    }
}

class linkedListIterator {

    private Node current;

    public linkedListIterator() {
        this.current = null;
    }

    public linkedListIterator(Node node) {
        this.current = node;
    }

    int data() {
        return this.current.data;
    }

    linkedListIterator next() {
        this.current = this.current.next;
        return this;
    }

    Node current() {
        return this.current;
    }

}
