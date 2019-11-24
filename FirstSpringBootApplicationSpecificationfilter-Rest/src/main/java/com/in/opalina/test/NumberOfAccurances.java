package com.in.opalina.test;

public class NumberOfAccurances {

	/*
	 * public Page<TbSpelAFecCnxn> getAllTbSpelAFecCnxns(Map<String, String>
	 * filterParameter, Pageable pageable) {
	 * 
	 * if (filterParameter == null || filterParameter.isEmpty()) { return
	 * this.tbSpelAFecCnxnDao.findAll(pageable); }
	 * 
	 * return this.tbSpelAFecCnxnDao.findAll(new
	 * FilterUtil<TbSpelAFecCnxn>().getSpecification(filterParameter), pageable); }
	 */

	public static void main(String arg[]) {
		String str = "codi project is the  best is codi Bank is codi";
		String ch[] = str.split(" ");
		int count = 0;
		for (int s1 = 0; s1 < ch.length - 1; s1++) {
			for (int m = s1 + 1; m < ch.length; m++) {

				if (ch[s1] != null && ch[s1].equals(ch[m])) {
					ch[m] = null;
				}

			}

		}
		for (int a = 0; a < ch.length; a++) {

			if (ch[a] != null) {
				System.out.print(ch[a] + " ");
			}

		}
		int[] arr= {2,3,5,8,13,44,16,19};
		for(int x=0;x<arr.length;x++)
		{
			for(int y=x+1;y<arr.length;y++)
			{
				for(int z=0;z<arr.length;z++)
				if(arr[x]+arr[y]==arr[z])
				{
					System.out.println("--------->"+arr[x]+" "+arr[y]);
				}
			}
		}
	}

	/*
	 * To find out the number of accurances at a time static final int MAX_CHAR =
	 * 256;
	 * 
	 * static void getOccuringChar(String str) { int count[] = new int[MAX_CHAR];
	 * 
	 * int len = str.length();
	 * 
	 * for (int i = 0; i < len; i++) count[str.charAt(i)]++;
	 * 
	 * char ch[] = new char[str.length()]; for (int i = 0; i < len; i++) { ch[i] =
	 * str.charAt(i); int find = 0; for (int j = 0; j <= i; j++) {
	 * 
	 * if (str.charAt(i) == ch[j]) find++; }
	 * 
	 * if (find == 1) System.out.println("Number of Occurrence of " + str.charAt(i)
	 * + " is:" + count[str.charAt(i)]); } } public static void main(String[] args)
	 * {
	 * 
	 * String str = "codi project for test codi"; getOccuringChar(str); }
	 */
}
