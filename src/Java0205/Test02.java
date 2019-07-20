package Java0205;

/**
 * 题意：将链表指定n~m的位置内容翻转
 */

//定义节点结构
class Node{
    int data;
    Node next;
    Node(int data){this.data = data;}
}

public class Test02 {
    public static void main(String[] args) {
        Node head = new Node(-1);
        Node present = head;
        //随机生成一个长度为10,数值为随机在1-100之间的单链表
        for(int i=0;i<10;i++){
            Node node = new Node((int)(Math.random()*10));
            present.next = node;
            present = node;
        }
        present.next = null;
        //单链表生成完毕
        Node head1 = head.next;
        while (head1!=null){
            System.out.print(head1.data+" ");
            head1 = head1.next;
        }
        System.out.println();
        Node head2 = reserveList(head.next,2,4);
        while (head2!=null){
            System.out.print(head2.data+" ");
            head2 = head2.next;
        }

    }
    public static Node reserveList(Node head,int n,int m){

        Node pre,new1,old,temp,p;
        p = head;
        //找到需要逆转的pre节点
        int cnt = 1;
        while(cnt<n-1){
            head = head.next;
            cnt++;
        }
        pre = head;
        new1 = head.next;
        old = new1.next;
        int cnt2 = 1;
        while(cnt2<m-n+1){
            temp = old.next;
            old.next = new1;
            new1 = old;
            old = temp;
            cnt2++;
        }
        pre.next.next = old;
        pre.next = new1;
        return p;
    }
}
