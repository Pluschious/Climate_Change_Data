/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program_2;

import java.text.SimpleDateFormat;

/**
 *
 * @author rjpls
 */
public class Date implements Comparable<Date> {
    //CompareTo
    
    private Integer day;
    private Integer month;
    private Integer year;
    private String date;
    
    public Date(String date){ //constructor for Date
        this.date = date;
        this.dateFormat(date);
    }

    public void dateFormat(String date){ //constructor for date Format
        String delimiter = new String();
    if(date.indexOf("-") >= 0){
        String[] ymd = date.split("-"); // if date read in has "-", formats to correct date
        year = Integer.parseInt(ymd[0]);
        month = Integer.parseInt(ymd[1]);
        day = Integer.parseInt(ymd[2]);

    }
    else{
        String[] mdy = date.split("/"); // if date read in has "/", formats to correct date
        year = Integer.parseInt(mdy[2]);
        month = Integer.parseInt(mdy[0]);
        day = Integer.parseInt(mdy[1]);
    }
        
    }
    public void setDay(Integer d){ // constructor to set day
        day = d;
    }
    
    public String toString(){ // to string constructor 
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}; // saves months into array to format date
        return months[month-1] + " " + String.valueOf(day) + ", " + String.valueOf(year);
                
    }
    public int compareTo(Date date2){ // compare to constructor
        if(this.year < date2.year){return -1;} // compares years read in for date format and printing data
        else if(this.year > date2.year){return 1;}
        else{
            if(this.month < date2.month){return -1;} // compares months
            else if(this.month > date2.month){return 1;}
            else{
                if(this.day < date2.day){return -1;} //compares days
                else if(this.day > date2.day){return 1;}
                else return 0;
            }
        }
        
    
    
}

    
}
