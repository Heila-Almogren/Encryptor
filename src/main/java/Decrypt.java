/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heila
 */
public class Decrypt {
    private String cipherText;
    private String clearText;
            
    public Decrypt(String ct){
        cipherText = ct;
        clearText = unPBox(ct);
        
    }
    
    
        public String unPBox(String shift){
        String pbox = "";      //the key 1324
        int m = shift.length();
        int count = 0 ;
        while(m >0 ){
        char d = shift.charAt(count++);
        char c = shift.charAt(count++);
        char b = shift.charAt(count++);
        char a = shift.charAt(count++);
         pbox += Character.toString(d)+Character.toString(b)+Character.toString(c)+Character.toString(a);
        m = m-4 ;
     
        }
    
       
        
        return unSwap(pbox);
    }
  public String unSwap(String clr){
        String swap= "";       //change later
       if(clr.length()%2!=0){
           swap+=clr.substring(clr.length()/2+1,clr.length());
        swap+=clr.substring(0,clr.length()/2+1);
       }
       else{
        swap+=clr.substring(clr.length()/2,clr.length());
        swap+=clr.substring(0,clr.length()/2);}
       

        return unshfit(swap);            //send swap to Shift
    }
        
         public String unshfit(String swap){
        String shift = "";    //change later
       
        shift +=swap.substring(swap.length()-(swap.length()-3));
         shift +=swap.substring(0,3);
        
               

       
        return unshfit2(shift);        //send shift to PBox
    }   
        
    public String unshfit2(String swap){
        String shift = "";    //change later
       
        shift +=swap.substring(swap.length()-(swap.length()-3));
         shift +=swap.substring(0,3);
                

       
        return unSwap2(shift);        //send shift to PBox
    }   
    
    public String unSwap2(String clr){
        String swap= "";       //change later
       if(clr.length()%2!=0){
           swap+=clr.substring(clr.length()/2+1,clr.length());
        swap+=clr.substring(0,clr.length()/2+1);
       }
       else{
        swap+=clr.substring(clr.length()/2,clr.length());
        swap+=clr.substring(0,clr.length()/2);}
       
                 

        return unPBox2(swap);            //send swap to Shift
    }
  
        
         
        
    public String unPBox2(String shift){

        String pbox = "";      //the key 
        int m = shift.length();
        int count = 0 ;
        while(m >0 ){
        char d = shift.charAt(count++);
        char c = shift.charAt(count++);
        char b = shift.charAt(count++);
        char a = shift.charAt(count++);
         pbox += Character.toString(a)+Character.toString(b)+Character.toString(c)+Character.toString(d);
        m = m-4 ;
        
        } 
       pbox = pbox.replace("*", "");
              

        
        return pbox;
    }
    public String getClearText(){
        return clearText;
    
}
}
