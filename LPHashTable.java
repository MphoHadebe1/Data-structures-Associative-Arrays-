/**
 * Simple hash table implementation using linear probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 * 
 * Mpho Hadebe
 * HDBMPH001
 * 20/04/2026
 */

public class LPHashTable extends HashTable {
   
    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     */
    public LPHashTable() { super();
    }

    /**
     * Create an LPHashTable with the given default size table.
     */
    public LPHashTable(final int size) { super(size); }

    /**
     * Find the index for entry: if entry is in the table, then returns its position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    protected int findIndex(String key) {
		// Implement using linear probing.
            int intial_index = hashFunction(key);
           int i =0;
         
              while (i<table.length ){
                       incProbeCount();// increment everytime we check slot
                      int  index = (intial_index + i) % table.length; // move i by +1 
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
