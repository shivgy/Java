public class BinarySearch{
  public static void main(String[] args){
    int[] arr = {2,5,67,88,93,101,652};
  }
  
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
}
