/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program_2;

/**
 *
 * @author rjpls
 */
public class Data { //Data constructor
    
    private double data;
    private Date date;
    
    public Data(Date date, String data){
        
        this.data = Double.parseDouble(data);
        this.date = date;
    }
    
    public Double getData(){ //gets Data
        return data;
    }
    public Date getDate(){ //gets Date
        return date;
    }
    public Double convertToF(){
        Double r = Math.round((data*1.8)*100.00)/100.00; //converts Temperature read in to Fahrenheit
        return (r);
    }
    
}
