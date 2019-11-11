package month9;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//3812. 호중이의 큐브색칠
public class Solution_3812 {
    public static void main (String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
        	int x=sc.nextInt();//위치
        	int y=sc.nextInt();
        	int z=sc.nextInt();
        		
        	int a=sc.nextInt();//센터
        	int b=sc.nextInt();
        	int c=sc.nextInt();
        		
        	int n=sc.nextInt();//mod N
        	
            long[] color=getColor(x,y,z,a,b,c,n);
            System.out.print("#"+tc+" ");
            for(int i=0; i<color.length; i++) {
                System.out.print(color[i] + " ");
            }             
            System.out.println("");
        }
        sc.close();
    }
    public static long[] getColor(int x,int y,int z,int a,int b,int c,int n) {
        long[] cache=new long[n];
        long[] oneside=getOneSideColor(y,z,b,c,n);
         
        int up_set   =(x-a)/n;
        int up_rest  =(x-a)%n;
         
        int down_set =(a+1)/n;
        int down_rest=(a+1)%n;
         
        long sum=0;
        for(int i=0; i<oneside.length; i++){
            sum+=oneside[i];
        }
         
        if(up_set>0 || down_set>0){
            for(int i=0; i<cache.length; i++){
                cache[i]=sum*(up_set+down_set);
            }
        }

        for(int i=0; i<up_rest; i++){
            for(int j=0; j<cache.length; j++){
                cache[(i+j)%n]+=oneside[j];
            }
        }         
        for(int i=0; i<down_rest; i++){
            for(int j=0; j<cache.length; j++){
                cache[(i+j)%n]+=oneside[j];
            }
        }
        
        for(int i=0; i<cache.length; i++){
            cache[i]-=oneside[i];
        }
         
        return cache;
    }
    public static long[] getOneSideColor(int y,int z,int b,int c,int n){
        long[] cache=new long[n];
        long[] onecolor=getOneColor(z,c,n);
         
        int up_set   =(y-b)/n;
        int up_rest  =(y-b)%n;
         
        int down_set =(b+1)/n;
        int down_rest=(b+1)%n;
        
        long sum=0;
        for(int i=0; i<onecolor.length; i++){
            sum+=onecolor[i];
        }

        if(up_set>0 || down_set>0){
            for(int i=0; i<cache.length; i++){
                cache[i]=sum*(up_set+down_set);
            }
        }      
         
        for(int i=0; i<up_rest; i++){
            for(int j=0; j<cache.length; j++){
                cache[(i+j)%n]+=onecolor[j];
            }
        }         
        for(int i=0; i<down_rest; i++){
            for(int j=0; j<cache.length; j++){
                cache[(i+j)%n]+=onecolor[j];
            }
        }
         
        for(int i=0; i<cache.length; i++){
            cache[i]-= onecolor[i];
        }
         
        return cache;
    }     
    public static long[] getOneColor(int z,int c,int n){
        long[] cache=new long[n];
         
        int up_set   =(z-c)/n;
        int up_rest  =(z-c)%n;
         
        int down_set =(c+1)/n;
        int down_rest=(c+1)%n;
         
        Arrays.fill(cache, up_set+down_set);         
         
        for(int i=0; i<up_rest; i++){
            cache[i]++;
        }         
        for(int i=0; i<down_rest; i++){
            cache[i]++;
        }
        
        cache[0]--;
         
        return cache;         
    }
}