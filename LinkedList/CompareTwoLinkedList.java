/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int CompareLists(Node headA, Node headB) {
  if(headA == null && headB == null){
    return 1;
  }else if(headA != null && headB == null){
    return 0;
  }else if(headA == null && headB != null){
    return 0;
  }
  
  while(headA != null && headB != null){
    if(headA.data != headB.data)
      return 0;
    headA = headA.next;
    headB = headB.next;
  }
  
  return 1;
}
