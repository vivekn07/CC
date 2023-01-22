
import java.io.*;
import java.net.*;

/**
 *
 * @author VivekN7
 */

public class UDPServer {
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException
    {
        
        DatagramSocket ds = new DatagramSocket(8001);
        
        byte b[] = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        ds.receive(dp);
        
        String str = new String(dp.getData(), 0, dp.getLength());
        int num1 = Integer.parseInt(str);
        
        String out = new String();
        
        if (num1 % 2 == 0)
        {
            out = "It is an Even Number";
        }
        else
        {
            out = "It is a Odd Number";
        }
        
       
        byte b1[] = new byte[1024];
        b1 = out.getBytes();
        
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length, InetAddress.getLocalHost(), 9999);
        ds.send(dp1);
    }
    
}
