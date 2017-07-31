public class BinarySearch{
  public static void main(String[] args){
    int[] arr = {2,5,67,88,93,101,652};
    
    Boolean result = binarySearchIT(arr,45);
    System.out.printl(result.toString());
  }
  
  /*This method is iterative and works for sorted array only*/
  public static Boolean binarySearchIT(int[] arr, int num){
    int low = 0;
    int high = arr.length - 1;
    
    while(high - low >= 0){
      int mid = low + (high - low)/2;
      if(arr[mid] == num) return true;
      else if(arr[mid] > num)
        high = mid - 1;
      else
        low = mid + 1;
    }
    return false;
  }
  
  /*Recursive method*/
  public static Boolean binarySearchRec(int[] arr, int low, int high, int num){
    int mid = low + (high - low)/2;
    if(low <= high){
      if(arr[mid] == num) return true;
      else if(arr[mid] < num)
        return binarySearchRec(arr,low,mid-1,num);
      else
        return binarySearchRec(arr,mid+1,high,num);
    }
    return false;
  }
  
}
