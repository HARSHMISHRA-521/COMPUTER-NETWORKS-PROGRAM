package CNLAB_prgrm;

import java.util.*;
import java.io.*;
public class rsa {
    public static int gcd(int m,int n){
        if(m<n){
            int temp=m;
            m=n;
            n=temp;
        }
        while(n!=0){
            int rem=m%n;
            m=n;
            n=rem;
        }
        return m;
    }

    public static void main(String[]args){
        int p,q,n,phi,e=0,d=0;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the message to be encrypted:");
       String m =s.nextLine();
       int len=m.length();
        int num[]=new int[len] , enc[]=new int[len], dec[]=new int[len];
        char msg[]=new char[len], msg1[]=new char[len];
       for(int i=0;i<len;i++){
           msg[i]=m.charAt(i);
           num[i]=(int)msg[i];
       }

        System.out.println("Enter the value of p and q:");
       p=s.nextInt();
       q=s.nextInt();
        n=p*q;
        phi=(p-1)*(q-1);

        for(int i=2;i<phi;i++){
            if(gcd(i,phi)==1){
                e=i;
                break;
            }
        }

        for(int i=1;i<n;i++){
            if(((e*i)-1)%phi==0){
                d=i;
                break;
            }
        }

        System.out.println("The Public Key = {"+e+","+n+"}");
        System.out.println("The Private Key = {"+d+","+n+"}");

        for(int i=0;i<len;i++){
          enc[i]=1;
          for(int j=0;j<e;j++){
              enc[i]=enc[i]*num[i]%n;
          }
        }

        for(int i=0;i<len;i++){
            dec[i]=1;
            for(int j=0;j<d;j++){
                dec[i]=dec[i]*enc[i]%n;
                msg1[i]=(char)dec[i];
            }
        }

        System.out.println("The Encrypted message is:");
        for(int i=0;i<len;i++){
            System.out.println(enc[i]);
        }

        System.out.println();

        System.out.println("The Decrypted message is:");
        for(int i=0;i<len;i++){
            System.out.println(dec[i]);
        }

        System.out.println();

        System.out.println("The Decrypted String message is:");
        for(int i=0;i<len;i++){
            System.out.println(msg1[i]);
        }
    }
}
