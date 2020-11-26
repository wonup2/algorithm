import java.util.Arrays;
import java.util.Scanner;

public class B12920 {
	static int val[] = new int[10]; 
	static int happy[] = new int[10]; 
	static int MaxVal[] = new int[10]; 
	static int n,m;
	public static void main(String[] args)	{
		Scanner in = new Scanner(System.in);
	    int ct=0;
	    n = in.nextInt();
	    m = in.nextInt();
	    for(int j=0;j<n;j++){
	        int v=in.nextInt();
	        int c=in.nextInt();
	        int k=in.nextInt();
	        int tot=0;
	        boolean flag=true;
	        for(int i=1;tot<k && flag; i*=2) {
	    	    //System.out.println(j+" "+i+" val"+Arrays.toString(val));
	    	    //System.out.println(j+" "+i+" happy"+Arrays.toString(happy));
	            tot+=i;
	            if(tot>=k) {
	                tot-=i;
	                i=k-tot;
	                flag=false;
	            }
	            val[ct]=v*i;
	            happy[ct]=c*i;
	            ct++;
	        }
	    }

	    for(int i=0;i<ct;++i) {
	        for(int j=m;j>=val[i];j--)
	            MaxVal[j]=Math.max(MaxVal[j],MaxVal[j-val[i]]+happy[i]);
	    }
	    
	    System.out.println(Arrays.toString(val));
	    System.out.println(Arrays.toString(happy));
	    System.out.println(Arrays.toString(MaxVal));

	    System.out.println(MaxVal[m]);
	}
}


/*
2 3
2 7 1
1 9 3

*/