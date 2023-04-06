package CNLAB_prgrm;
import java.io.*;
import java.net.*;
class client_udp{
    public static void main(String []args)throws Exception{
        BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientsocket=new DatagramSocket();
        InetAddress ipaddress =  InetAddress.getByName("local host");

        byte[]senddata=new byte[100];
        byte[]receivedata=new byte[100];

        while(true){
            System.out.println("Client:");
            String sentence =input.readLine();
            senddata =sentence.getBytes();
            DatagramPacket sendpacket =new DatagramPacket(senddata,senddata.length,ipaddress,3780);
            clientsocket.send(sendpacket);

            DatagramPacket receivepacket =new DatagramPacket(receivedata,receivedata.length);
            clientsocket.receive(receivepacket);
            String msentence =new String(receivepacket.getData());
            System.out.println("Server :"+msentence);


        }
    }
}
