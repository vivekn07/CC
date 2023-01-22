
import java.io.*;
import java.net.*;

class TCPServer
{
public static void main(String args[]) throws IOException
{

ServerSocket ss = new ServerSocket(8001); 
System.out.println("Waiting for client to connect.."); 
Socket s = ss.accept();
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
DataOutputStream out = new DataOutputStream(s.getOutputStream()); 
DataInputStream in = new DataInputStream(s.getInputStream()); 
String receive, send;
while((receive = in.readLine()) != null)
{
if(receive.equals("STOP"))
break;
System.out.println("Client Says : "+receive);
System.out.print("Server Says : ");
send = br.readLine();
out.writeBytes(send+"\n");
}
}
}