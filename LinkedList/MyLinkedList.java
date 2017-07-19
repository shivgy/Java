public class MyLinkedList{
  public static void main(String[] args){
    LinkedListT ll = new LinkedListT();
    ll.insertFirst(15);
    ll.insertFirst(20);
    ll.insertFirst(25);
    ll.insertFirst(30);
    
    ll.insertLast(100);
    ll.insertLast(90);
    ll.insertLast(80);
    
    ll.print(ll.head);
  }
}

class Node{
  int data;
  Node next;
  Node(int data){
    this.data = data;
    this.next = null;
  }
}

class LinkedListT{
  public Node head;
  
  public void LinkedListT(){
    head = null;
  }
  
  /*Method to print the linked list*/
  public void print(Node head){
    if(head == null){
      return;
    }else{
      while(head.next != null){
        System.out.print(head.data + "-->");
        head = head.next;
      }
    }
  }
  
  /*Insert a node at first place*/
  public void insertFirst(int data){
    Node n = new Node(data);
    n.next = head;
    head = n;
  }
  
  /*Insert a node at the last*/
  public void insertLast(int data){
    Node n = new Node(data);
    n.next = null;
    if(head == null){
      head = n;
    }
    Node curNode = head;
    while(curNode.next != null){
      curNode = curNode.next;
    }
    curNode.next = n;
  }
}
