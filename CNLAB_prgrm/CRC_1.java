package CNLAB_prgrm;
import java.util.Scanner;
import java.io.*;

public class CRC_1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

//        input data

        System.out.println("Enter the message bits:");
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

//        calculate crc

        for(int i=0;i<message.length();i++) {
            if (data[i] == 1) {
                for (int j = 0; j < generator.length(); j++) {
                    data[i + j] ^= divisor[j];
                }
            }
        }

//        display

        System.out.println("The checksum code is :");
        for(int i=0;i<message.length();i++){
            data[i]=Integer.parseInt(message.charAt(i)+"");
        }
        for(int i=0;i<(message.length()+generator.length()-1);i++){
            System.out.print(data[i]);
        }
        System.out.println();

//        check for input crc code

        System.out.println("Enter the checksum code:");
         message = s.nextLine();
        System.out.println("Enter the generator:");
         generator = s.nextLine();

        for(int i=0;i<message.length();i++){
            data[i]=Integer.parseInt(message.charAt(i)+"");
        }
        for(int i=0;i<generator.length();i++){
            divisor[i]=Integer.parseInt(generator.charAt(i)+"");
        }


//        calculation of remainder
        for(int i=0;i<message.length();i++) {
            if (data[i] == 1) {
                for (int j = 0; j <= generator.length(); j++) {
                    data[i + j] ^= divisor[j];
                }
            }
        }

//        display validity
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
