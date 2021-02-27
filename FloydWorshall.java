	import java.util.*;
		import java.lang.*;
		import java.io.*;
public class FloydWorshall {


	// Floyd Warshall 
	//Group Project Phase1 
	// Marwa , Haya, Intesar


	    final static int inf = 99999;
	    /////////////////////////////////////////////////////////////////////////////
	    static void printAlpha()
	    {
	    
	       char[] alpha = 
	    		   {'A','B','C','D','E','F','G','H','I','J'};
	       System.out.println();
	       System.out.printf (" %-5s"," ");
	      for(int i=0;i<10;i++) {
	    	  
	    	  System.out.printf (" %-5c",alpha[i]);
	      }
	     System.out.println();
	     System.out.println();
	    }
	    //////////////////////////////////////////////////////////////////////////////
	   static void printSolution(int dist[][])
	    {
		   char[] alpha = 
    		   {'A','B','C','D','E','F','G','H','I','J'};
    		   
      ;
	        for (int i=0; i<10; ++i)
	        {
	            System.out.printf (" %-5c",alpha[i]);
	            for (int j=0; j<10; ++j)
	            {
	            	  
	                if (dist[i][j]==inf)
	                 
	                System.out.printf (" %-5s",  "inf");
	                else
	              
	                System.out.printf (" %-5d",  dist[i][j]);
	            }
	            System.out.println();
	        }
	    }
	 ///////////////////////////////////////////////////////////////////////////////
	   //Algorithm
	   static void Floyd(int distance[][] ,int graph[][])
	    {
	      
		   int i, j, k;
			 
	        for ( i = 0; i < 10; i++)
	            for ( j = 0; j < 10; j++)
	            	distance[i][j] = graph[i][j];
	        
	 // k is an intermediate vertex in shortest path from i to j.
	        for (k = 0; k < 10; k++)
	        {
	        	// one by one pick all vertices as source
	           for (i = 0; i < 10; i++)
	            {
	        	
	                for (j = 0; j < 10; j++)
	                {
	 //We update the value of distance[i][j] as distance[i][k] + distance[k][j] if distance[i][j] > distance[i][k] + distance[k][j]
	                    if (distance[i][k] + distance[k][j] < distance[i][j])
	                    	distance[i][j] = distance[i][k] + distance[k][j];
	                }
	            }
	            System.out.println("\n\n D "+(k+1)+": \n"+"_________________________________________________________________");
	            //fist line 
	            printAlpha();
	            if(k==10)
	            	//last steps
	            	System.out.println("The following matrix shows the shortest distances between every pair of vertices");
	            //print solution
	            printSolution(distance);
	        }
	  
		   
		   
		   
		   
	    }
	    
	    /////////////////////////////////////////////////////////////////////////
	   	    public static void main (String[] args)
	    {
	   // initialize matrix based on graph 
	        int graph[][] = { 
	        		
	        		 {0,10,inf, inf ,inf,5,inf,inf,inf,inf},//A
	        		 {inf,0,3, inf ,3,inf,inf,inf,inf,inf},//B
	        		 {inf,inf,0,4 ,inf,inf,inf,5,inf,inf},//C
	        		 {inf,inf,inf,0,inf,inf,inf,inf,4,inf},//D
	        		 {inf,inf,4, inf ,0,inf,2,inf,inf,inf},//E
	        		 {inf,3,inf, inf ,inf,0,inf,inf,inf,2},//F
	        		 {inf,inf,inf,7,inf,inf,0,inf,inf,inf},//G
	        		 {inf,inf,inf,4,inf,inf,inf,0,3,inf},//H
	        		 {inf,inf,inf,inf ,inf,inf,inf,inf,0,inf},//I
	        		 {inf,6,inf,inf ,inf,inf,8,inf,inf,0},//J
	                        };
	     
	        int dist[][] = new int[10][10];
	        //send dist and matrix to floyd worshal 
	       	        Floyd(dist ,graph);
	       
	
	      
	    
	  }
	
	    
	    
	    
	
	
	
}
