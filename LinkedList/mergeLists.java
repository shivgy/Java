Node mergeLists(Node headA, Node headB){
  if(headA == null){
    return headB;
  }
  
  if(headB == null){
    return headA;
  }
  
  /*Using recursive method*/
  if(headA.data < headB.data){
    headA.next = mergeLists(headA.next,headB);
    return headA;
  }
  else{
    headB.next = mergeLists(headB.next,headA);
    return headB;
  }
  
}
