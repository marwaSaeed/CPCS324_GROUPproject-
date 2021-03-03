/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floydworshall;

import java.util.*;
import java.lang.*;
import java.io.*;

public class FloydWorshall {

      // Floyd Warshall 
     //Group Project Phase1 
    // Marwa , Haya, Intesar
    final static int inf = 99999;
    static char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    /////////////////////////////////////////////////////////////////////////////
    
    
    //this function prints the alphabetprints the alphabet horizontally
    static void printAlpha() {
        System.out.println();
    
        //For formating
        System.out.printf(" %-5s", " ");
        
        for (int i = 0; i < 10; i++) {
            System.out.printf(" %-5c", alpha[i]);
        }
        System.out.println();
        System.out.println();
    }
    //////////////////////////////////////////////////////////////////////////////

    
    // This function prints matrix 
    static void printMatrix (int dist[][]) {
        for (int i = 0; i < 10; ++i) {
            //prints the alphabet vertically
            System.out.printf(" %-5c", alpha[i]);
            for (int j = 0; j < 10; ++j) {
                if (dist[i][j] == inf) {
                    System.out.printf(" %-5s", "inf");
                } else {
                    System.out.printf(" %-5d", dist[i][j]);
                }
            }
            System.out.println();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////
    

    //Floyd's Algorithm
    static void Floyd(int graph[][]) {
        
        int i, j, k;// initialize i,j,k
        System.out.println("Floyd's algorithm implementation \n");
        System.out.println("Weighted matrix ");
        // k is an intermediate vertex in shortest path from i to j.
        for (k = 0; k < 10; k++) {
            // one by one pick all vertices as source
            for (i = 0; i < 10; i++) {

                for (j = 0; j < 10; j++) {
                    //We update the value of graph[i][j] as graph[i][k] + graph[k][j] if graph[i][j] > graph[i][k] + graph[k][j]
                                      graph[i][j]=Math.min( graph[i][j],graph[i][k] + graph[k][j]);
                }
            }

            if (k == 9) //last steps
            {
                System.out.println("\n\nThe following matrix shows the shortest distances between every pair of vertices");
            }
            //
            System.out.println("\n D " + (k + 1) + ": \n" + "_________________________________________________________________");

            
            printAlpha();
            //print solution
            printMatrix (graph);
        }
    }

    public static void main(String[] args) {
        // initialize matrix based on graph 
        int graph[][] = {
            {0, 10, inf, inf, inf, 5, inf, inf, inf, inf},//A
            {inf, 0, 3, inf, 3, inf, inf, inf, inf, inf},//B
            {inf, inf, 0, 4, inf, inf, inf, 5, inf, inf},//C
            {inf, inf, inf, 0, inf, inf, inf, inf, 4, inf},//D
            {inf, inf, 4, inf, 0, inf, 2, inf, inf, inf},//E
            {inf, 3, inf, inf, inf, 0, inf, inf, inf, 2},//F
            {inf, inf, inf, 7, inf, inf, 0, inf, inf, inf},//G
            {inf, inf, inf, 4, inf, inf, inf, 0, 3, inf},//H
            {inf, inf, inf, inf, inf, inf, inf, inf, 0, inf},//I
            {inf, 6, inf, inf, inf, inf, 8, inf, inf, 0},//J
        };

        //send matrix to floyd worshal algorithm 
        Floyd(graph);

    }

}
