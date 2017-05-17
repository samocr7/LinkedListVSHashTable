import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws FileNotFoundException{  
        // TODO Auto-generated method stub
    	LinkedListTester lTest = new LinkedListTester();
    	HashTableTester hTest = new HashTableTester();
        
        Scanner input = new Scanner(System.in);
        
        int question = input.nextInt();
        
        switch(question){
        
        case 1: //At what size (number of elements) does it take the same amount of time to perform
                //10,000 operations on your chosen data structure and a hash table.
            break;
            
        case 2: //How many unique words can you add to your chosen data structure in one second?
        	lTest.addInOneSecond();
            break;
            
        case 3: //How many words can you add to a hash table in one second?
            hTest.addInOneSecond();
            break;
        
        case 4: //How many unique words can you add to your chosen data structure in one minute?
            lTest.addInOneMinute();
            break;
           
        case 5: //Graph the time it takes to perform 10,000 operations on the data structure of your choice
                //for a large variety of sizes (from 200 to 200,000, for example). Does the timing seem to
                //match the theoretical growth rate you would expect for that data structure?
        	lTest.manyOperations();
            break;
            
        case 6: //Graph the time it takes to perform 10,000 operations on on a hash table for a large variety
                //of sizes (from 200 to 200,000, for example). Does the timing seem to match the
                //theoretical growth rate you would expect for a hash table?
            hTest.manyOperations();
            break;
        
        }
        
        

        




    }

}
