int getNode(Node head, int n){
  if(head == null) return -1;
  
  Node temp = head;
  int count = 0;
  
  while(temp.next != null){
    temp = temp.next;
    count++;
  }
  
  temp = head;
  
  for(int i = 0; i < count-n; i++){
    temp = temp.next;
  }
  
  return temp.data;
}
