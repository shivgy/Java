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

  
  /*Remove duplicates from unsorted Linked List*/
  void deleteDups(Node head){
    Hashtable<Integer, Boolean> ht = new Hashtable<>();
    Node prev = head;
    while(head.next != null){
      if(ht.containsKey(head.data)) prev.next = head.next;
      else{
        ht.put(head.data, true);
        prev = head;
      }
      head = head.next;
    }
  }
  
  
  /*Remove duplicates from unsorted Linked List without using temp buffer*/
void deleteDups2(Node head){
  Node prev = head;
  Node cur = prev.next;
  while(cur != null){
    Node run = head;
    while(run != cur){
      if(run.data == cur.data){
        Node temp = cur.next;
        prev.next = temp;
        cur = temp;
        break;
      }
      run = run.next;
    }
    if(run == cur){
      prev = cur;
      cur = cur.next;
    }
  }
}
