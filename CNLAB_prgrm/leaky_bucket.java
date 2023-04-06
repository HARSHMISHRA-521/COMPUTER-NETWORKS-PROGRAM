package CNLAB_prgrm;
import java.util.*;
public class leaky_bucket {
    public static int min(int m,int n){
        if(m<n){
            return m;
        }
            return n;
    }
    public static void main (String []args){
        int bktsize,oprate=0,nsec;
        Scanner s =new Scanner(System.in);
        System.out.println("Enter the bucket size");
        bktsize=s.nextInt();
        System.out.println("Enter the operation rate");
        oprate =s.nextInt();
        System.out.println("Enter the total sec:");
        nsec= s.nextInt();
        int pktrecv[]=new int[nsec];
        for(int i=0;i<nsec;i++){
            System.out.println("Enter the packet entering at "+(i+1)+"sec:");
            pktrecv[i]=s.nextInt();
        }

        int sec,recv,sent,left,dropped;
        sec=recv=sent=left=dropped=0;
        System.out.println("sec\t recv\t sent\t left\t dropped ");
        for( sec=0;sec<nsec;sec++){
            dropped=0;
            left+=pktrecv[sec];
            if(left>bktsize){
                dropped=left-bktsize;
                left=bktsize;
            }
            sent=min(left,oprate);
            left =left-sent;

            System.out.println(sec+"  \t"+pktrecv[sec]+"  \t"+sent+"  \t"+left+"  \t"+dropped);
        }

        while(left!=0){
            sec++;
            dropped=0;
            if(left>bktsize){
                dropped=left-bktsize;
                left=bktsize;
            }
            sent=min(left,oprate);
            left =left-sent;

            System.out.println(sec+"\t"+0+"\t"+sent+"\t"+left+"\t"+dropped);


        }
    }
}
