import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

   static HashMap<Integer, ArrayList<Integer>> nodes=new HashMap<>();
   //static HashSet<Integer> points=new HashSet<>();
   
    static void setGraph(int N)
    {
        for(int i=1;i<=2*N;i++)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                nodes.put(i, list);
                
        }
    }
    
   static void edge(int a, int b){
       ArrayList<Integer> v1=nodes.get(a);
       ArrayList<Integer> v2=nodes.get(b);
       //points.add(a);
       //points.add(b);
       if(v1!=v2){
           //System.out.println("v1 : "+v1+", v2 = "+v2);
           //System.out.println("Before nodes.get("+v1.get(0)+") :  "+nodes.get(v1.get(0)));
           v1.addAll(v2);
           //System.out.println("after add v1 : "+v1);
           //System.out.println("After nodes.get("+v1.get(0)+") :  "+nodes.get(v1.get(0)));
           for(int i:v2){
               nodes.put(i,v1);
               //System.out.println("nodes.get("+i+") :  "+nodes.get(i));
           }
       }
   }
    
    public static void componentsInGraph(int n,List<List<Integer>> gb) {
    setGraph(n);
    for(int i=0;i<n;i++)
    {
        edge(gb.get(i).get(0),gb.get(i).get(1));
    }
    ArrayList<Integer> count=new ArrayList<Integer>();
    
  
    for(int i=n+1; i<=(2*n); ++i)
    {
        ArrayList<Integer> list=nodes.get(i);
        if(list.size()>1)
            count.add(list.size());
       
    }
    
    System.out.println(Collections.min(count)+" "+Collections.max(count));
    
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
   
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> gb = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            
            List<Integer> gbRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
               
                gbRowItems.add(sc.nextInt());
            }

            gb.add(gbRowItems);
        }

         Result.componentsInGraph(n,gb);
    
    
        
    }
}
