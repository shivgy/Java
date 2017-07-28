/*This will remove the duplicates from a sorted Linked List*/

Node RemoveDuplicates(Node head){
  Node newNode = head;
  
  if(head == null){
    return null;
  }
  
  while(head.next != null){
    if(head.data == head.next.data){
      head.next = head.next.next;
    }
    else{
      head = head.next;
    }
  return newNode;
}
