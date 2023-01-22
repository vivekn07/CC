
import java.io.*;
import java.net.*;

/**
 *
 * @author VivekN7
 */

public class TCPServer {
    
    public static void main(String[] args) throws IOException
    {
        ServerSocket ss = new ServerSocket(8001);
        System.out.println("Server is Connecting...");

        Socket s = ss.accept();
        System.out.print("Server is Connected\n");

        DataInputStream in = new DataInputStream(s.getInputStream());
        int num1 = in.readInt();

        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        
        int i, flag = 0;
        
        if (num1 == 1)
        {
            
            out.writeUTF(num1+" is not a Prime Number\n");
            
        }
        else if (num1 == 2)
        {
            
            out.writeUTF(num1+" is a Prime Number\n");
                  
        }
        else
        {
        
        for (i = 2; i < num1; i++)
        {
            if (num1 % i == 0)
            {
              
               out.writeUTF(num1+" is not a Prime Number\n");
               flag = 1;
               break;
               
            }
            
        }
        }
        if (flag == 0)
        {
            
            out.writeUTF(num1+" is a Prime Number\n");
            
        }
        
        
    }
    
}
