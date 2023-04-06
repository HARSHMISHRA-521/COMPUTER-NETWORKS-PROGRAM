package CNLAB_prgrm;
import java.util.*;
public class Bellman_ford {
    int nv;
    int distance[];
    static final int max_val=999;
    Bellman_ford(int nv){
        this.nv=nv;
        distance = new int[nv+1];
    }
    void bellman_evaluation(int source,int am[][]){
        for(int node=1;node<=nv;node++){
            distance[node]=max_val;
        }
        distance[source]=0;
        for(int node =1;node<=nv-1;node++) {
            for (int snode = 1; snode <= nv; snode++) {
                for (int dnode = 1; dnode <= nv; dnode++) {
                    if (am[snode][dnode] != max_val) {
                        if (distance[dnode] > distance[snode] + am[snode][dnode]) {
                            distance[dnode] = distance[snode] + am[snode][dnode];
                        }
                    }
                }
            }
            for (int snode = 1; snode <= nv; snode++) {
                for (int dnode = 1; dnode <= nv; dnode++) {
                    if (am[snode][dnode] != max_val) {
                        if (distance[dnode] > distance[snode] + am[snode][dnode]) {
                            System.out.println("matrix contains negative edge cycle");
                        }
                    }
                }
            }

        }
        for (int vertex = 1; vertex <= nv; vertex++) {
            System.out.println("The distance of source " + source + "to " + vertex + " is " + distance[vertex]);
        }
    }

    public static void main(String[]args){
        int nv=0;
        int source;
        int am[][];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertex");
        nv=sc.nextInt();
        am= new int[nv+1][nv+1];
        System.out.println("Enter the adjacency matrix :");
        for(int i=1;i<=nv;i++){
            for(int j=1;j<=nv;j++){
                am[i][j]=sc.nextInt();
                if(i==j){
                    am[i][j]=0;
                    continue;
                }
                if(am[i][j]==0){
                    am[i][j]=max_val;
                }
            }
        }
        System.out.println("Enter the source vertex");
        source=sc.nextInt();
        Bellman_ford bf =new Bellman_ford( nv);
        bf.bellman_evaluation(source,am);
        sc.close();

    }

}