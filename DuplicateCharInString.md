# Find Duplicate Characters in a given string.
There are 128 ASCII characters and therefore if the length of given string is greater than 128 it means, atleast one character has got a duplicate. Therefore, our first check is based on the length of the given string.

`boolean[] bool = new boolean[128]` will create a boolean array of size 128 with initial value as false for each array element.

```
private static boolean containsDuplicate(String string){
  if(string.length() > 128){
    return false;
  }
  
  boolean[] bool = new boolean[128];
  int val = 0;
  for(int i = 0; i < string.length(); i++){
    val = string.charAt(i);
    if(bool[val]){
      return false;
    }
    bool[val] = true;
  }
  return true;
}
```
