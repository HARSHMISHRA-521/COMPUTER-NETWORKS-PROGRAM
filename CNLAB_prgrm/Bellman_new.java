package CNLAB_prgrm;
import java.util.*;
public class Bellman_new
{
    public static void main(String args[]) throws Exception
    {
        int n,maxx=999,s=0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of nodes : ");
        n=in.nextInt();
        System.out.print("Enter source node : ");
        s=in.nextInt();
        System.out.print("Enter adj matrix : ");
        int d[]=new int[n+1],adj[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++)
        {
            d[i]=maxx;
            for(int j=1;j<=n;j++)
            {
                adj[i][j]=in.nextInt();
                if(i==j)
                    adj[i][j]=0;
                if(adj[i][j]==0)
                    adj[i][j]=999;
            }
        }
        d[s]=0;
        for(int sn=1;sn<=n;sn++)
        {
            for(int dn=1;dn<=n;dn++)
            {
                if(d[dn]>(d[sn]+adj[sn][dn]))
                    d[dn]=d[sn]+adj[sn][dn];
            }
        }

        for(int sn=1;sn<=n;sn++)
        {
            for(int dn=1;dn<=n;dn++)
            {
                if(d[dn]>(d[sn]+adj[sn][dn]))
                {
                    System.out.println("The graph contains a -ve edge");
                    System.exit(0);
                }
            }
        }
        for(int i=1;i<=n;i++)
        {
            System.out.println("Distance from "+s+" to "+i+" is "+d[i]);
        }




    }
}