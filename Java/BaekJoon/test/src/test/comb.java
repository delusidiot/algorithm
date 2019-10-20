package test;

public class comb {
	
	public static void main(String[] args) {
		int bit;
		int n=6, m=3;
		int[] tr = new int[100];
//		for (int i = 0; i < tr.length; i++) {
//			tr[i]=i;
//		}
		bit = (1<<m) -1;
		while(bit <(1<<n)) {
			func(bit,n);
			int temp = bit | ((bit & -bit) - 1);
	        bit = (temp + 1) | (((~temp & -~temp) - 1) >> (getZeros(bit) + 1));
		}
	}
	public static void func(int bit, int n)
	{
	    int msb = 1 << (n - 1);
	    while (msb>0)
	    {
	        System.out.print(((msb & bit)>0?"1":"0")+" ");
	        
	        msb >>= 1;
	    }
	    System.out.println();
	}
	public static int getZeros(int n)
	{
	    int num = 0;
	    while ((n & 1) == 0)
	    {
	        num++;
	        n >>= 1;
	    }
	    return num;
	}
}
