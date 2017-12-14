# Question: Find the time difference
Current Time **R** is entered in HH:mm:ss format After that *N* times are entered as P1,P2...etc. Find the difference between P_i and R


```
public static void main(String[] args) throws Exception
	{
		System.out.println("Enter current Time:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String curr_Time = br.readLine();
		if(!isValid(curr_Time))
			throw new Exception("Invalid Time");
		int num = Integer.valueOf(br.readLine());
		String[] time_arr = new String[num];
		for(int i = 0; i < num; i++)
		{
			time_arr[i] = br.readLine();
			if(!isValid(time_arr[i]))
				throw new Exception("Invalid Time");
			System.out.println(difference(curr_Time,time_arr[i]));
		}
	}

	public static boolean isValid(String str) throws Exception
	{
		String[] st = str.split("\\:");
		if((Integer.valueOf(st[0])>= 0 && Integer.valueOf(st[0])<= 23)&&(Integer.valueOf(st[1]) >= 0 && Integer.valueOf(st[1]) <= 59)&&(Integer.valueOf(st[2])>= 0 && Integer.valueOf(st[2]) <= 59))
			return true;
		else
			throw new Exception("Invalid Time");
	}
	
	public static String difference(String date1, String date2)
	{
		String[] t1 = date1.split("\\:");
		String[] t2 = date2.split("\\:");
		int diff = 0;
		
		if(Integer.valueOf(t1[0]) != Integer.valueOf(t2[0]))
		{
			diff = Math.abs(Integer.valueOf(t1[0])-Integer.valueOf(t2[0]));
			if(diff == 1)
				return diff + " hour ago";
			else
				return diff + " hours ago";
		}
		else if(Integer.valueOf(t1[1]) != Integer.valueOf(t2[1]))
		{
			diff = Math.abs(Integer.valueOf(t1[1])-Integer.valueOf(t2[1]));
			if(diff == 1)
				return diff + " minute ago";
			else
				return diff + " minutes ago";
		}
		else if(Integer.valueOf(t1[2]) != Integer.valueOf(t2[2]))
		{
			diff = Math.abs(Integer.valueOf(t1[2])-Integer.valueOf(t2[2]));
			if(diff == 1)
				return diff + " second ago";
			else
				return diff + " seconds ago";
		}
		return "now";
	}
	
```
