
import java.io.*;
import java.net.*;

class TCPClient
{
public static void main(String args[]) throws IOException

{
Socket s = new Socket("Localhost",8001); 
BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
DataOutputStream out = new DataOutputStream(s.getOutputStream());
DataInputStream in = new DataInputStream(s.getInputStream());
String msg;
System.out.println("To stop chatting with server type STOP");
System.out.print("Client Says: "); 
while((msg = br.readLine()) != null)
{
out.writeBytes(msg+"\n");
if(msg.equals("STOP"))
break;
System.out.println("Server Says : "+in.readLine());
System.out.print("Client Says : ");
}
}
}
        
        
        
        
        
     
        
        
    
    

