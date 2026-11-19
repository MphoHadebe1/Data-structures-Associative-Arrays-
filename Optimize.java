import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * a program that finds the weights that minimizes the number of probes for linear probing 
 * Mpho Hadebe
 * HDBMPH001
 * 18/04/2026
 * 
 */

public class Optimize {
    public static void main(String... args){
        try{
         // read from the file 
         File file = new File("mydata.txt");
         Scanner rd = new Scanner(file);
         // arrray to store usernames
         String[] usernames = new String[36]; // store the 36 user names
         int i=0;
       

         while(rd.hasNextLine()){
            usernames[i] = rd.nextLine().trim();
            i++;
         }
        
       
       int[] weights = new int[9];// hold the current weight combination as zeros
    
        // all weights at as zeros inside 
        LPHashTable HashTable = new LPHashTable(37);
        HashTable.setWeights(weights);
        HashTable.resetProbeCount();

         for (String name : usernames){
                HashTable.insert(name); // insert to the hashtable
         }
         // use the first results as the minprobes
         int minProbes = HashTable.getProbeCount(); // use the first probes as minimum
         int combinations =1;// one combination of zeros


        // tryng all the possible combinations
         while(nextCombination(weights)<9){
             // creater a new hashtable for each weight 
            LPHashTable HashTable2 = new LPHashTable(37);
           HashTable2.setWeights(weights);// setting weights to the generated one

           HashTable2.resetProbeCount();
            for (String name : usernames){
                HashTable2.insert(name);
           }
         int numprobes = HashTable2.getProbeCount();
         
         if (numprobes < minProbes){// if this is better 
                minProbes= numprobes;// treat is as the new minimum 
                combinations=1; // new best combination

            }else if (numprobes== minProbes){combinations++;}// another combination with the same number of probes
            
          }

         System.out.println(minProbes + " "+ combinations);



        rd.close();

        }catch(FileNotFoundException e){
            System.out.println("filenotfound");
        }

      }

        
       
     // generate combinations of base 5 
     public static int nextCombination(int[] weights){
        int pos =0;

        // reset positions that reached 4 to 0 ( restart)
        while(pos<9 && weights[pos]==4 ){
            weights[pos]=0;
            pos++;
        }
         // increase the next postion
        if(pos<9) weights[pos]= weights[pos] +1;
        return pos; // return the position wwe changed 
    }

   
   

}