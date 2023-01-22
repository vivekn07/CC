
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author VivekN7
 */

public class UDPClient {
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException
    {
        
        DatagramSocket ds = new DatagramSocket(9999);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        String num1 = sc.nextLine();
        
        byte b[] = new byte[1024];
        b = num1.getBytes();
        DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 8001);
        ds.send(dp);
        
        byte b1[] = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
        ds.receive(dp1);
        
        String str = new String(dp1.getData(), 0, dp1.getLength());
        System.out.println("The Factorial of "+num1+" is "+str);
    }
    
}
