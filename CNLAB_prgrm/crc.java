package CNLAB_prgrm;
import java.util.Scanner;
import java.io.*;

public class crc {
    static  String message;
    static String generator;
     static int [] data ;
   static  int [] divisor ;

    static void inputdata(char c) {
        if (c == 'm') {
            System.out.println("Enter the message bits:");
        }
        else if(c=='s'){
            System.out.println("Enter the checksum code:");
        }
        Scanner s = new Scanner(System.in);
        String message = s.nextLine();
        System.out.println("Enter the generator:");
        String generator = s.nextLine();
        int data[] =new int[message.length()+generator.length()-1];
        int divisor[] = new int[generator.length()];
        for(int i=0;i<message.length();i++){
            data[i]=Integer.parseInt(message.charAt(i)+"");
        }
           for(int i=0;i<generator.length();i++){
            divisor[i]=Integer.parseInt(generator.charAt(i)+"");
        }
    }

  static  void crccalc(String message,String generator){
        for(int i=0;i<message.length();i++){
            if(data[i]==1){
                for(int j=0;j<generator.length();j++){
                    data[i+j]^=divisor[j];
                }
            }
        }
    }

    static void display(){
        System.out.println("The checksum code is :");
        for(int i=0;i<message.length();i++){
            data[i]=Integer.parseInt(message.charAt(i)+"");
        }
        for(int i=0;i<(message.length()+generator.length()-1);i++){
            System.out.println(data[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){
       inputdata('m');
       crccalc(message,generator);
       display();
       inputdata('s');
       crccalc(message,generator);
        boolean valid=true;
        for(int i=0;i< data.length;i++){
            if(data[i]==1){
                valid = false;
                break;
            }
        }
        if(valid==true){
            System.out.println("data stream is valid");
        }
        else{
            System.out.println("Data stream is invalid.CRC error occured");
        }
    }
}
