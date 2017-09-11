# Remove the duplicate elements from the given list in constant space and O(n)

## Constraints
* Do not use any extra space
* Solve the problem in O(n) time complexity

## Sample Input Output

**Input**
[2,3,3,4,5,6]
**Output**
[2,3,3,4,5,6]

**Input**
[2,4,4,4,6,7,7,7,7,8]
**Output**
[2,4,4,6,7,7,8]

**Input**
[2,2,2,2,2,2]
**Output**
[2,2]


## In case given array is not sorted
```
public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < number; i++){
			list.add(sc.nextInt());
		}
		System.out.println(list.toString());
		
    for(int i = 0; i < list.size(); i++){
			for(int j = i+1; j < list.size(); j++){
				if(list.get(i).equals(list.get(j))){
					count++;
					if(count > 1){
						list.remove(j);
						j--;
					}
				}
			}
      count = 0;
    }
		System.out.println(list.toString());
	}
```

## In case given array is sorted
```
public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < number; i++){
			list.add(sc.nextInt());
		}
		System.out.println(list.toString());
		
			for(int j = 1; j < list.size(); j++){
				if(list.get(j-1).equals(list.get(j))){
					count++;
					if(count > 1){
						list.remove(j);
						j--;
					}
				}
				else count = 0;
			}
		System.out.println(list.toString());
	}
```
