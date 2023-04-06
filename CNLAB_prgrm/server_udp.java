package CNLAB_prgrm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.io.*;
import java.net.InetAddress;

public class server_udp {
    public static void main(String [] args) throws  Exception {
        DatagramSocket serversocket = new DatagramSocket(3780);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("SERVER IS READY >>>>>>");
        byte [] senddata =new byte[100];
        byte [] receivedata =new byte[100];

        while(true){
            DatagramPacket receivepacket = new DatagramPacket(receivedata,receivedata.length);
            serversocket.receive(receivepacket);
            String sentence = new String(receivepacket.getData());
            System.out.println("CLIENT : "+ sentence);

            InetAddress ipaddress = receivepacket.getAddress();
            int port = receivepacket.getPort();
            System.out.println("SERVER : ");
            String m = input.readLine();
            senddata =m.getBytes();
            DatagramPacket sendpacket = new DatagramPacket(senddata,senddata.length,ipaddress,port);
            serversocket.send(sendpacket);
        }
    }
}
