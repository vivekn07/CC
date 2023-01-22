
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author VivekN7
 */

public class TCPClient {
    
    public static void main (String[] args) throws IOException
    {
        Socket cs = new Socket("localhost",8001);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int a = sc.nextInt();

        DataOutputStream out = new DataOutputStream(cs.getOutputStream());
        out.writeInt(a);

        DataInputStream in = new DataInputStream(cs.getInputStream());
        System.out.println(in.readUTF());
        
        
    }
    
}
