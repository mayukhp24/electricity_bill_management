package electricity.billing.system;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{ //Using jframe from swing package
    Thread t; //theead class declare
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg")); //choosing image to display
        Image i2 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT); //awt function
        ImageIcon i3 = new ImageIcon(i2); //jlabel cant take image so converting again to imageicon
        JLabel image = new JLabel(i3);
        add(image);
        setVisible(true); //def visibility is zero so changing it to true
        int x=1;
        for(int i = 2; i<600;i+=4,x+=1){ //to give opening animation
        setSize (i+x,i);  //to make a frame using setSize function of jframe
        setLocation(780-((i+x)/2),400-(i/2)); //def startup location is top left so changing it from left 420, from top 1255
        
        //using multithreading to control animation speed
        try{
            Thread.sleep(4); //millisecond
        } catch (Exception e){
            e.printStackTrace(); //prints error if any
            }
        }
       //cant call run directly else it will work as method
        t = new Thread(this); //thread class object, 'this' gives the reference of current class
        t.start(); //start method internally calls run method as multi-threaded function
        setVisible(true);       
    }
    
    public void run(){
        //exiting the stratup page after desired time
        try {
            Thread.sleep(2000);
            setVisible(false);
            
            //insert login frame
            new Login();
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main (String[] args){
        new Splash();
    }
        
}
