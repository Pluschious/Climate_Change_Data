/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package program_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author rjpls
 */
public class Program_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        // TODO code application logic here
        File file = new File("C:\\Users\\rjpls\\OneDrive\\Desktop\\Fall 2022\\CSCI 232\\Program_2\\src\\program_2\\co2.csv"); // reads in file
        if(!file.exists()){  // checks if file exists
            System.err.println("File does not exsist");
                    System.exit(-1);
        }
        Scanner c = new Scanner(new FileReader(file)); // scanner to read in file
        String line = c.nextLine();
        
        RedBlackBST<Date, Data> datetoCo2BST = new RedBlackBST<>(); //creates first RB Tree
        RedBlackBST<Double, Data>  dataCo2BST = new RedBlackBST<>(); //creates second RB Tree
        while(c.hasNextLine()){
                line = c.nextLine();
                String[] parts = line.split(","); //Splits into array using "," because its a CSV file
                if(parts[0].toLowerCase().equals("world")){ //makes sure its only world data
                    Date date = new Date(parts[2]); //splits data into array
                    Data d = new Data(date,parts[3]);  // splits data into array
                    datetoCo2BST.put(date, d); //puts data into BST
                    dataCo2BST.put(d.getData(), d); //puts data into BST
                }            
        }
        //------------------------------------------------------------------
        file = new File("C:\\Users\\rjpls\\OneDrive\\Desktop\\Fall 2022\\CSCI 232\\Program_2\\src\\program_2\\sea_level.csv"); //reads in file
        if(!file.exists()){
            System.err.println("File does not exsist"); // check for file
                    System.exit(-1);
        }
        c = new Scanner(new FileReader(file)); //scanner to read in file
        line = c.nextLine();
        
        RedBlackBST<Date, Data> datetoSeaLevelBST = new RedBlackBST<>(); //creates first RB Tree
        RedBlackBST<Double, Data>  dataSeaLevelBST = new RedBlackBST<>(); //creates second RB Tree
        while(c.hasNextLine()){
                line = c.nextLine();
                String[] parts = line.split(","); // Splits into array using "," because its a CSV file
                if(parts[0].toLowerCase().equals("world")){ //makes sure its only reading data from "world"
                    Date date = new Date(parts[2]); //splits data into array
                    Data d = new Data(date,parts[3]); //splits data into array
                    datetoSeaLevelBST.put(date, d); //puts data into BST
                    dataSeaLevelBST.put(d.getData(), d); //outs data into BST
                }
        }
        
        file = new File("C:\\Users\\rjpls\\OneDrive\\Desktop\\Fall 2022\\CSCI 232\\Program_2\\src\\program_2\\temperature_anomaly.csv");
        if(!file.exists()){
            System.err.println("File does not exsist");
                    System.exit(-1);
        }
        c = new Scanner(new FileReader(file));
        line = c.nextLine();
        
        RedBlackBST<Date, Data> datetoTempBST = new RedBlackBST<>();
        RedBlackBST<Double, Data>  dataTempBST = new RedBlackBST<>();
        while(c.hasNextLine()){
                line = c.nextLine();
                String [] parts = line.split(",");
                if(parts[0].toLowerCase().equals("world")){
                    Date date = new Date(parts[2]);
                    Data d = new Data(date,parts[3]); 
                    datetoTempBST.put(date, d);
                    dataTempBST.put(d.getData(), d);
                }
        
    }
        
        PrintWriter writer = new PrintWriter("lab2.txt", "UTF-8"); //writes to file
        Data co2Max = dataCo2BST.get(dataCo2BST.max()); //sets maxCo2 
        Data co2Min = dataCo2BST.get(dataCo2BST.min()); //sets minC02
        Data seaLevelMax = dataSeaLevelBST.get(dataSeaLevelBST.max()); //sets Max Sea Level
        Data seaLevelMin = dataSeaLevelBST.get(dataSeaLevelBST.min()); //sets Min Sea Level
        Data tempMax = dataTempBST.get(dataTempBST.max()); //sets Max Temperature
        Data tempMin = dataTempBST.get(dataTempBST.min()); //sets Min Temperature
        String newline = System.lineSeparator(); //line seporator
        
        writer.println("Lowest Temerature Anomaly (F): " + tempMin.convertToF() + " on " + tempMin.getDate()); //print line to display data
        if(datetoSeaLevelBST.contains(tempMin.getDate())){
            writer.println("On this average Sea Level rise was "+datetoSeaLevelBST.get(tempMin.getDate()).getData()); //print line to display data
            writer.println(newline);
        }
        if(datetoCo2BST.contains(tempMin.getDate())){
            writer.println("On this date the average Co2 was " + datetoCo2BST.get(tempMin.getDate()).getData()); //print line to display data
            writer.println(newline);
        }
        
        writer.println("Highest Temerature Anomaly (F): " + tempMax.convertToF() + " on " + tempMax.getDate()); //print line to display data
        if(datetoSeaLevelBST.contains(tempMax.getDate())){
            writer.println("On that same date, the Temperature Amomaly (F) was  " + datetoSeaLevelBST.get(tempMax.getDate()).getData()); //print line to display data
        }
        if(datetoCo2BST.contains(tempMax.getDate())){
            writer.println("On that same date, the Average Co2 concentration was " + datetoCo2BST.get(tempMax.getDate()).getData()); //print line to display data
        }
        
        
        writer.println("Lowest Sea level Rise: " + seaLevelMin.getData() + " on " + seaLevelMin.getDate()); //print line to display data
        if(datetoTempBST.contains(seaLevelMin.getDate())){
            writer.println("On that same date, the Temperature Anomaly (F) was "+ datetoTempBST.get(seaLevelMin.getDate()).convertToF()); //print line to display data
        }
        if(datetoCo2BST.contains(seaLevelMin.getDate())){
            writer.println("On that same date, the Temperature Anomaly (F) was " + datetoCo2BST.get(seaLevelMin.getDate()).convertToF()); //print line to display data
        }
        
       
        writer.println("Highest Sea level Rise: " + seaLevelMax.getData() + " on " + seaLevelMax.getDate()); //print line to display data
        if(datetoTempBST.contains(seaLevelMax.getDate())){
            writer.println("On that same date, the Temperature Anomaly (F) was "+ datetoTempBST.get(seaLevelMax.getDate()).convertToF()); //print line to display data
        }
        if(datetoCo2BST.contains(seaLevelMax.getDate())){
            writer.println("On that same date, the Average Co2  concentration was " + datetoCo2BST.get(seaLevelMax.getDate()).convertToF()); //print line to display data
        }
        
        
        writer.println("Lowest Average Co2 Concentration: " + co2Min.getData() + " on " + co2Min.getDate()); //print line to display data
        if(datetoSeaLevelBST.contains(co2Min.getDate())){
            writer.println("On that same date, the Temperature Anomaly (F) was "+ datetoSeaLevelBST.get(co2Min.getDate()).getData()); //print line to display data
        }
        if(datetoTempBST.contains(co2Min.getDate())){
            writer.println("On that same date, the Temperatuer Anomaly (F) was  " + datetoTempBST.get(co2Min.getDate()).convertToF()); //print line to display data
        }
        
        
        writer.println("HighestCo2 Concentration: " + co2Max.getData() + " on " + co2Max.getDate()); //print line to display data
        if(datetoSeaLevelBST.contains(co2Max.getDate())){
            writer.println("On that same date, the Temperature Anomaly (F) was "+ datetoSeaLevelBST.get(co2Max.getDate()).getData()); //print line to display data
        }
        if(datetoTempBST.contains(co2Max.getDate())){
            writer.println("On that date, the Temperature Anomaly (F) was " + datetoTempBST.get(co2Max.getDate()).convertToF()); //print line to display data
        }
        
        
        writer.close(); // closes the writer
        c.close(); // closes the ssanner
    }
}

