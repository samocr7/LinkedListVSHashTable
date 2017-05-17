
public class HashTable {

    Bucket[] savage;

    public HashTable(int size) {
        savage = new Bucket[size];

    }

    private long hash(String s) {
        /**
         * long h = 0; for (int i = 0; i < s.length(); i++) { h = (h * 31) +
         * s.charAt(i); }
         */

        int hashN;
        int h = 0;

        for (int i = 0, size = s.length() - 1; i < s.length(); i++, size--) {
            char letter = s.charAt(i);
            hashN = letter;
            h += (hashN * (Math.pow(2, size)));
        }

        return h;
    }

    public boolean add(String insert) {

        // System.out.println("" + hash(insert));
        // long check = hash(insert);
        // System.out.println(check + "");
        long address = (hash(insert) % savage.length); // Hash the string ---

        //System.out.println("" + address);
        int i = (int) address; // cast the long to an int to place it into an
                               // array
        // System.out.println("" + i);
        if (savage[i] == null) {
            savage[i] = new Bucket(insert); // if bucket is empty place item
        } else {
            Bucket temp = savage[i]; // else run through the bucket until the
                                     // end, then add it
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Bucket(insert));
        }

        return true; // item was added

    }

    public int find(String findIt) { // Find the string given
        // pass in string to hash function
        // check the hash value for the bucket
        // check the linked list
        long address = (hash(findIt) % savage.length); // Hash the string
        int i = (int) address;
        Bucket temp = savage[i];
        while (temp != null) { //Go through the bucket
            if (temp.getData().equals(findIt)) //Check each value
                return i; // item found
            else
                temp = temp.getNext();
        }

        return -1; // Return -1 if the string isn't in the hash table
    }

    public String remove(String delete) { // delete a given string
        int check = find(delete); // Check if the string is in the array, if so
                                  // get the bucket
        String back = "k";
        if (check == -1) {
            System.out.println("String not found");

        } else {
            Bucket temp = savage[check]; // Check the bucket of the string
            Bucket prev = temp;
            while (temp != null) { // Run through the bucket to find the string
                if (temp.getData().equals(delete)) {
                    back = temp.getData();
                    break;
                }
                prev = temp;
                temp = temp.getNext();

            }

            if (temp.getNext() == null) { // delete the bucket
                prev.setNext(null);
            } else {
                prev.setNext(temp.getNext());
            }

        }

        return back; // return the previous value
    }

    public void print() { // Print the whole array
        for (int i = 0; i < savage.length; i++) { // Go through all indices
            Bucket temp = savage[i];
            while (temp != null) { // Go through the list in each index
                System.out.println(temp.getData());
                temp = temp.getNext();
            }
        }
    }

}
