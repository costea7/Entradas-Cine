package practica1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestCine {
	
	
	 public static void main(String[] args) throws FileNotFoundException, IOException {

	    int asientosTotales=0;
            Platea platea = new Platea("platea");
            
                FileInputStream fstream = new FileInputStream("src/practica1/array.txt");
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                int numAsientos = Integer.parseInt(br.readLine());
                
                initStudent(numberStudent);

                for (int i = 0; i < numberStudent; i++) {

                    String line = br.readLine();
                    int numberCourse = Integer.parseInt(line.split(" ")[2]);
                    students[i].name = line.split(" ")[0];
                    students[i].id = line.split(" ")[1];
                    students[i].numberCourses = numberCourse;
                    students[i].courses = new course[numberCourse];
                    initCourse(i, numberCourse);
                }
                platea.setAsientosTotales(asientosTotales);
            }	 	 
        
}
	

