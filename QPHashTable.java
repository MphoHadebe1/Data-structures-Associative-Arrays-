/**
 * Simple hash table implementation using quadratic probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 * 
 * Mpho Hadebe
 * HDBMPH001
 * 20/04/2026
 */

public class QPHashTable  extends HashTable {


    /**
     * Create an QPHashTable with DEFAULT_SIZE table.
     */
    public QPHashTable() { super(); }

    /**
     * Create an QPHashTable with the given default size table.
     */
    public QPHashTable(final int size) { super(size); }

    /**
     * Find the index for entry: if entry is in the table, then returns its position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    protected int findIndex(String key) {
		// Implement using quadratic probing.
           int initial_index = hashFunction(key);
           int i =0;
         
              while (i<table.length ){
                       incProbeCount();// increment everytime we check slot
                      int  index = (initial_index + i*i) % table.length;// move by squaring i 
                      // ( here im treating it as like i have already detected collision to make things quick)
                      
                      //for empty slot return it 
                      if(table[index]== null){return index;}
                      
                      //key is found return it
                      if(key.equals(table[index])){
                       
                        return index;}
                      i++;
                      
                     
              }
              return -1;
                
            
    }
}
