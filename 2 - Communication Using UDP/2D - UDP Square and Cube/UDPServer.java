
import java.io.*;
import java.net.*;


/**
 *
 * @author VivekN7
 */
public class UDPServer {
    
    public static void main(String[] args) throws SocketException, IOException
    {
        
        DatagramSocket ds = new DatagramSocket(8001);
        byte b[] = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        ds.receive(dp);
        
        byte b1[] = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
        ds.receive(dp1);
        
        String str = new String(dp.getData(), 0, dp.getLength());
        int num1 = Integer.parseInt(str);
        
        String str1 = new String(dp1.getData(), 0, dp1.getLength());
        double op1 = Double.parseDouble(str1);
        
        String s = new String();
        
        if (op1 == 1)
        {
            
            op1 = num1 * num1;
            s = Double.toString(op1);
               
        }
        
        else if (op1 == 2)
        {
            
            op1 = Math.sqrt(num1);
            s = Double.toString(op1);
            
        }
        
        else if (op1 == 3)
        {
            
            op1 = num1 * num1 * num1;
            s = Double.toString(op1);
            
        }
        
        else if ( op1 == 4)
        {
            
            op1 = Math.cbrt(num1);
            s = Double.toString(op1);
            
        }
        else 
        {
            
            s = "Invalid Operation";
            
        }
        
        
        byte b2[] = new byte[1024];
        b2 = s.getBytes();
        DatagramPacket dp2 = new DatagramPacket(b2, b2.length, InetAddress.getLocalHost(), 9999);
        ds.send(dp2);
        
                
        
    }
    
}
