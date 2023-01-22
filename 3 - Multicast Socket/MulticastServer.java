import java.io.*; 
import java.net.*; 
import java.util.*; 
class MulticastServer
{
public static final int destPORT = 1200;
public static void main(String args[]) throws Exception { 
MulticastSocket socket;
DatagramPacket packet;
InetAddress address= InetAddress.getByName("224.1.1.1"); 
socket = new MulticastSocket();

byte[] data = new byte[1024]; 
while(true)
{ 
Thread.sleep(5000); 
System.out.println("Sending ");
String str = (new Date()).toString(); 
data = str.getBytes();
packet = new DatagramPacket(data, str.length(), address, destPORT); 
socket.send(packet);
}
}
}
