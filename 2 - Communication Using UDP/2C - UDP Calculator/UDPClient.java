
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
        System.out.println("Enter 1st Number: ");
        String num1 = sc.nextLine();
        
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter 2nd Number: ");
        String num2 = sc1.nextLine();
        
        Scanner sc2= new Scanner(System.in);
        System.out.println("Enter the operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        String op1 = sc2.nextLine();
      
     
        byte b[] = new byte[1024];
        b = num1.getBytes();
        DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 8001);
        ds.send(dp);
        byte b1[] = new byte[1024];
        b1 = num2.getBytes();
        DatagramPacket dp1 = new DatagramPacket(b1, b1.length, InetAddress.getLocalHost(), 8001);
        ds.send(dp1);
        byte b2[] = new byte[1024];
        b2 = op1.getBytes();
        DatagramPacket dp2 = new DatagramPacket(b2, b2.length, InetAddress.getLocalHost(), 8001);
        ds.send(dp2);
        
        byte b3[] = new byte[1024];
        DatagramPacket dp3 = new DatagramPacket(b3, b3.length);
        ds.receive(dp3);
        
        String str = new String(dp3.getData(), 0, dp3.getLength());
        System.out.println("Result: "+str);
    }
    
}
