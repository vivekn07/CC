
import java.io.*;
import java.net.*;
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
        
        Scanner sc1 = new Scanner(System.in);
         System.out.println("Select the operation:");
        System.out.println("1. Square");
        System.out.println("2. Square Root");
        System.out.println("3. Cube");
        System.out.println("4. Cube Root");
        String op1 = sc.nextLine();
        
        byte b[] = new byte[1024];
        b = num1.getBytes();
        DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 8001);
        ds.send(dp);
        
        byte b1[] = new byte[1024];
        b1 = op1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length, InetAddress.getLocalHost(), 8001);
        ds.send(dp1);
        
        byte b2[] = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(b2, b2.length);
        ds.receive(dp2);
        
        String str = new String(dp2.getData(), 0, dp2.getLength());
        System.out.println("Result: "+str);
        
    }
    
}
