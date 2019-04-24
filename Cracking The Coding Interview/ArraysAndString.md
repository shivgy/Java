# Algorithm to determine if a String has all the unique characters. 

For simplicity we will assume that char set is ASCII.

1. because there are 128 unique characters in ASCII if the string length is more than 128, this implies that the string contains duplicate characters.

2. Create a boolean array of length 128 and all the elements of the array will be false by default.

```
public boolean isUniqueCharacters(String string){
  if(string.length() > 128){
    return false;
  }
  
  boolean[] bool = new boolean[128];
  for(int i = 0; i < string.length(); i++){
    int val = string.charAt(i);
    if(bool[val]){
      return false;
    }
    bool[val] = true;
  }
  return true;
}
```

Time complexity is O(n)

## Alternate Method with less time complexity

```
private static boolean containsUniqueCharsLessSpace(String string) {
  int checker = 0;

  for (int i = 0; i < string.length(); ++i) {
    int val = string.charAt(i) - 'a';
    if ((checker & (1 << val)) > 0) {
      return false;
    }
    checker |= (1 << val);
  }
  return true;
}
  ```
