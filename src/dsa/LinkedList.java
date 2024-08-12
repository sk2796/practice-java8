package dsa;

import java.util.Scanner;

public class LinkedList {
    public static void main(String[] args) {
//        Node<Integer> node1 = new Node<>(10);

        Node<Integer> head = input();
//        increment(head);
        print(head);

    }

    public static Node<Integer> input() {
        Node<Integer> head = null, tail = null;
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        while(data!=-1) {
            Node<Integer> newNode = new Node<>(data);
            if(head==null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode; //tail // = tail.next;
            }
            data = s.nextInt();
        }
        return head;
    }

    private static void increment(Node<Integer> head) {
        while(head!=null) {
            head.data++;
            head = head.next;
        }
    }

    private static void print(Node<Integer> head) {
        System.out.println("PRINTING");
        while(head !=null) {
            System.out.println(head.data +" "+head.next);
            head = head.next;
        }
    }
}
