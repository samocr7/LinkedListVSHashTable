import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.*;

public class HashTableTester {
    String[] words = new String[600000];
    
    public HashTableTester() throws FileNotFoundException{
        File k = new File("word.txt");
        Scanner reader = new Scanner(k);
            for (int i = 0; (i < 600000 && reader.hasNext()); i++) {
                //System.out.println(i);
                words[i] = reader.nextLine();
                // System.out.println(words[i]);
            }
            reader.close();
    }
	
	public void addInOneSecond(){
		HashTable table;
        double itemsAdded = 0;
        int i = 0;
        int tests = 1;
        long startTime;
		for(tests = 1; tests<11; tests++){ //runs 10 times.
            System.out.println("Run number "+tests);
            table = new HashTable(10000); //makes a new empty hash table each test run
            startTime = System.currentTimeMillis();
        for(i=0; System.currentTimeMillis() - startTime <= 1000; i++){ //loop stops when 1 second has passed.
            table.add(words[i]); //unique item each time since i is being incremented
        }
        table = null; //sets the table to null so it can be garbage collected.
        itemsAdded += i; //running total of how many items have been added over the 10 tests
        }
        itemsAdded = itemsAdded/10; //divides the total items added by 10 to get the average.
        System.out.println(itemsAdded + " items were added in one second.");
	}
	/**
	public void addInOneMinute(){
		HashTable table;
        double itemsAdded = 0;
        int i = 0;
        int tests = 1;
        long startTime;
		for(tests = 1; tests<6; tests++){ //runs 5 times.
            System.out.println("Run number "+tests);
            table = new HashTable(10000); //makes a new empty table each test run
            startTime = System.currentTimeMillis();
        for(i=0; System.currentTimeMillis() - startTime <= 60000; i++){ //loop stops when 60 seconds has passed.
            table.add(words[i]); //unique item each time since i is being incremented
        }
        table = null; //sets the table to null so it can be garbage collected.
        itemsAdded += i; //running total of how many items have been added over the 5 tests
        }
        itemsAdded = itemsAdded/5; //divides the total items added by 5 to get the average.
        System.out.println(itemsAdded + " items were added in one minute.");
        //142848.2
	}
	**/
	
	public void manyOperations() throws FileNotFoundException { 
	   PrintWriter write = new PrintWriter(new File("HashTable.csv")); //csv file to import into excel and generate a graph
		HashTable table = new HashTable(10000); //array of size 10k
		int items = 0; //items in total
		for(int x= 0; x<1000; x++){ //1000 x 200 = 200 000. Adds 200k items
		for(int i=0; i<200; i++, items++){ //adds 200 items at once
			table.add(words[items]); //adds a word
		}
		System.out.println(timeTest(table, words.length)+"ms for " + items+" items."); //prints time taken to do 10k operations + the amount of items
		write.print(timeTest(table, words.length) +","); //prints time to csv file
		write.println(items); //prints amount of items to csv file
		}
		write.close();
	}
	
	public double timeTest(HashTable table, int size){
		Random rand = new Random();
		long startTime = 0, endTime = 0;
		double timeTaken = 0.0;
		for(int i = 0; i<10000; i++){
			int findThis =rand.nextInt(size -1);
			 startTime = System.nanoTime();
			table.find(words[findThis]);
			 endTime = System.nanoTime();
			 timeTaken += (endTime - startTime) / 1000000.0;
		}
		
		return timeTaken;
	}
	

}
