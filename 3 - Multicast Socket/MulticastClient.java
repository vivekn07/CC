import java.net.*; 
import java.io.*; 
class MulticastClient
{
public static final int PORT = 1200;
public static void main(String args[]) throws Exception{ 
MulticastSocket socket;
DatagramPacket packet; 
InetAddress address;
address = InetAddress.getByName(args[1]); 
socket = new MulticastSocket(PORT);
byte[] data = new byte[1024];
packet = new DatagramPacket(data,data.length); 
while(true){
socket.receive(packet);
String str = new String(packet.getData());
System.out.println(" Time signal received from"+ packet.getAddress() + " Time is : " +str);
}
}
}
