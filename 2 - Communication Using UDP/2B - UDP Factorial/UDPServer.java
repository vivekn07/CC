
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
        
        String str = new String(dp.getData(), 0, dp.getLength());
        int num1 = Integer.parseInt(str);
        
        String s = new String();
        
        int fact = 1;
        for (int i = 1; i <= num1; i++)
        {
            
            fact = fact*i;
        }
        
        s = Integer.toString(fact);
        byte b1[] = new byte[1024];
        b1 = s.getBytes();
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length, InetAddress.getLocalHost(), 9999);
        ds.send(dp1);
        
    }
}