/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heila
 */
public class Encrypt {
    private String cleartext;
    private String cipherText;
            
       public Encrypt(String clr){
        cleartext = clr;
        cipherText = PBox(clr);
        
    }
       public String PBox(String shift){
        String pbox = ""; //the key will be 4321 
        int m = shift.length();
        int count = 0 ;
     for(int i = 0 ; i < 4 ; i++){
     if(m%4 != 0 ){
     shift += "*";m++;
     }
     else break;
     }
     while(m >0 ){
     char a =shift.charAt(count++);
     char b = shift.charAt(count++);
     char c = shift.charAt(count++);
     char d = shift.charAt(count++);
     
    pbox += Character.toString(d)+Character.toString(c)+Character.toString(b)+Character.toString(a);
    m = m-4; 
    
     }
      
      
        
        
        return Swap(pbox);
    }
    
    public String Swap(String clr){
        String swap= "";       //change later
        swap+=clr.substring(clr.length()/2,clr.length());
        swap+=clr.substring(0,clr.length()/2); 
     
        return shift(swap);            //send swap to Shift
    }
    
    public String shift (String swap){
        String shift = "";    //change later
       
        shift = swap.substring(swap.length()-3);
        shift += swap.substring(0,swap.length()-3);
       
        return shift2(shift);        //send shift to PBox
    }
    
    
     public String shift2 (String swap){
        String shift = "";    //change later
       
        shift = swap.substring(swap.length()-3);
        shift += swap.substring(0,swap.length()-3);
       
        return Swap2(shift);        //send shift to PBox
    }
     
      public String Swap2(String clr){
        String swap= "";       //change later
        swap+=clr.substring(clr.length()/2,clr.length());
        swap+=clr.substring(0,clr.length()/2); 
     
        return PBox2(swap);            //send swap to Shift
    }
     
    public String PBox2(String shift){
        String pbox = ""; //the key will be 1324
        int m = shift.length();
        int count = 0 ;
     for(int i = 0 ; i < 4 ; i++){
     if(m%4 != 0 ){
     shift += "*";m++;
     }
     else break;
     }
     while(m >0 ){
     char a =shift.charAt(count++);
     char b = shift.charAt(count++);
     char c = shift.charAt(count++);
     char d = shift.charAt(count++);
     
    pbox += Character.toString(a)+Character.toString(c)+Character.toString(b)+Character.toString(d);
    m = m-4; 
    
     }
      
      
        
        
        return pbox;
    }
    
   
    
    public String getCipherText(){
        return cipherText;
    
}
}
