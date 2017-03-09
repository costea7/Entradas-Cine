package practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestCine {
	
	
	 public static void main(String[] args) throws FileNotFoundException {

			    // TODO Auto-generated method stub         
			    try {
			        Scanner input = new Scanner(new File("src/array.txt"));
			        int m = 10;
			        int n = 10;
			        int[][] a = new int[m][n];
			        while (input.hasNextLine()) {
			            for (int i = 0; i < m; i++) {
			                for (int j = 0; j < n; j++) {
			                   try{//    System.out.println("number is ");
			                    a[i][j] = input.nextInt();
			                      System.out.println("number is "+ a[i][j]);
			                    }
			                   catch (java.util.NoSuchElementException e) {
			                       // e.printStackTrace();
			                    }
			                }
			            }         //print the input matrix
			            System.out.println("The input sorted matrix is : ");
			            for (int i = 0; i < m; i++) {
			                for (int j = 0; j < n; j++) {
			                    System.out.println(a[i][j]);

			                }
			            }
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			}
		 
		 
}
	

