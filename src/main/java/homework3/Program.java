package homework3;
public class Program {
    public static void main(String[] args) {
        DoublyLinkedList myLinkedList = new DoublyLinkedList();
        myLinkedList.addFirst(5);
        System.out.println(myLinkedList);
        myLinkedList.addFirst(8);
        System.out.println(myLinkedList);

        myLinkedList.delFirst();
        System.out.println(myLinkedList);

        myLinkedList.addLast(88);
        System.out.println(myLinkedList);

        myLinkedList.addLast(99);
        System.out.println(myLinkedList);

        myLinkedList.delLast();
        System.out.println(myLinkedList);
        myLinkedList.addLast(19);
        System.out.println(myLinkedList);
        myLinkedList.addLast(34);
        System.out.println(myLinkedList);

        myLinkedList.sort();
        System.out.println(myLinkedList);

        myLinkedList.revert();
        System.out.println(myLinkedList);
    }
}

