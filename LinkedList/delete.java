/*Hackerrank delete*/
Node delete(Node head, int position){
  if(position == 0){
    head = head.next;
    return head;
  }
  
  Node n = new Node();
  n = head;
  
  while(--position > 0){
    n = n.next;
  }
  
  n.next = n.next.next;
  return head;
}

