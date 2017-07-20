/*Method insert a Node at the given position*/
void insertNth(int pos, int data){
  Node n = new Node(data);
  
  /*If the Linked List is empty, insert the Node at the first place*/
  if(head == null){
    head = n;
  }
  
  /*If they ask to insert at the zeroth position*/
  if(pos == 0){
    n.next = head;
  }
  
  /*For all the remaining conditions, iterate through the given position*/
  Node next = head;
  Node prev = head;
  
  for(int i = 0; i < pos; i++){
    prev = next;
    next = next.next;
  }
  
  prev.next = n;
  n.next = next;
}  
