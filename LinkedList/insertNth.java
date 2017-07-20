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
  int curPos = 0;
  while(curPos < pos-1 && head.next != null){//Also ensure that the next element to the position is not null
    head = head.next;
    curPos++;
  }
  
  Node curNode = head;
  head.next = n;
  n.next = curNode;
}  
