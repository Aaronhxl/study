//package Java0205;
//
//
///**
// * 题意：将类似于 2->3->5和 6->4->8->9这样的链表相加
// * @author hl
// *
//
//class Node{
//    int data;
//    Node next;
//    Node(int data){
//        this.data = data;
//    }
//}
//
//public class Test01 {
//    public static void main(String[] args) {
//        //这里随机构建链表
//        Node head1 = new Node((int) (Math.random()*10));
//        Node present = head1;
//        for(int i=0;i<5;i++){
//            Node node = new Node((int) (Math.random()*10));
//            present.next = node;
//            present = node;
//        }
//        present.next = null;
//
//        Node head2 = new Node((int)(Math.random()*10));
//        present = head2;
//        for(int i=0;i<6;i++){
//            Node node = new Node((int)(Math.random()*10));
//            present.next = node;
//            present = node;
//        }
//        present.next = null;
//
//        //这里开始处理链表
//        Node head = Add(head1,head2);
//
//        while(head1!=null){
//            System.out.print(head1.data);
//            head1 = head1.next;
//        }
//        System.out.println();
//        while (head2!=null){
//            System.out.print(head2.data);
//            head2 = head2.next;
//        }
//        System.out.println();
//        head = head.next;
//        while(head!=null){
//            System.out.print(head.data);
//            head = head.next;
//        }
//
//    }
//
//    public static Node Add(Node head1,Node head2){
//
//        Node head = new Node(-1);
//        Node present = head;
//        int data = 0,value = 0;
//        while (head1 != null && head2 != null){
//            data = (head1.data + head2.data + value)%10 ;
//            value = (head1.data +head2.data + value)/10;
//            Node node = new Node(data);
//            present.next = node;
//            present = node;
//            head1 = head1.next;
//            head2 = head2.next;
//        }
//        if(head1 == null && head2 != null){
//            while (head2!=null){
//                data = (head2.data + value)%10;
//                value = (head2.data + value)/10;
//                Node node = new Node(data);
//                present.next = node;
//                present = node;
//                head2 = head2.next;
//            }
//            present.next = null;
//        }else if (head1 != null && head2 == null){
//            while (head1!=null){
//                data = (head1.data + value)%10;
//                value = (head1.data + value)/10;
//                Node node = new Node(data);
//                present.next = node;
//                present = node;
//                head1 = head1.next;
//            }
//            present.next = null;
//        }
//        if(value!=0){
//            Node node = new Node(value);
//            present.next = node;
//            present = node;
//            present.next = null;
//        }
//        return head;
//    }
//}
