import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.*;

public class LinkedListTester {
	
	public void addInOneSecond(){
		LinkedList list;
        double nodesAdded = 0;
        int i = 0;
        int tests = 1;
        long startTime;
		for(tests = 1; tests<11; tests++){ //runs 10 times.
            System.out.println("Run number "+tests);
            list = new LinkedList(); //makes a new empty list each test run
            startTime = System.currentTimeMillis();
        for(i=0; System.currentTimeMillis() - startTime <= 1000; i++){ //loop stops when 1 second has passed.
            list.addUniqueNode(""+ i); //unique node each time since i is being incremented
        }
        list = null; //sets the list to null so it can be garbage collected.
        nodesAdded += i; //running total of how many nodes have been added over the 10 tests
        }
        nodesAdded = nodesAdded/10; //divides the total nodes added by 10 to get the average.
        System.out.println(nodesAdded + " nodes were added in one second.");
	}
	
	public void addInOneMinute(){
		LinkedList list;
        double nodesAdded = 0;
        int i = 0;
        int tests = 1;
        long startTime;
		for(tests = 1; tests<6; tests++){ //runs 5 times.
            System.out.println("Run number "+tests);
            list = new LinkedList(); //makes a new empty list each test run
            startTime = System.currentTimeMillis();
        for(i=0; System.currentTimeMillis() - startTime <= 60000; i++){ //loop stops when 60 seconds has passed.
            list.addUniqueNode(""+ i); //unique node each time since i is being incremented
        }
        list = null; //sets the list to null so it can be garbage collected.
        nodesAdded += i; //running total of how many nodes have been added over the 5 tests
        }
        nodesAdded = nodesAdded/5; //divides the total nodes added by 5 to get the average.
        System.out.println(nodesAdded + " nodes were added in one minute.");
        //142848.2
	}
	
	public void manyOperations() throws FileNotFoundException { 
	   PrintWriter write = new PrintWriter(new File("LinkedList.csv"));
		LinkedList list = new LinkedList();
		int nodes = 0;
		for(int x= 0; x<1000; x++){ //1000
		for(int i=0; i<200; i++, nodes++){
			list.addNode(""+nodes);
		}
		System.out.println(timeTest(list, nodes)+"ms for " + nodes+" nodes.");
		write.print(timeTest(list, nodes) +",");
		write.println(nodes);
		}
		write.close();
	}
	
	public double timeTest(LinkedList list, int size){
		Random rand = new Random();
		long startTime = 0, endTime = 0;
		double timeTaken = 0.0;
		//long startTime = System.nanoTime();
		for(int i = 0; i<10000; i++){
			String findThis =""+ rand.nextInt(size -1);
			//System.out.println(findThis);
			 startTime = System.nanoTime();
			list.findNode(findThis);
			 endTime = System.nanoTime();
			 timeTaken += (endTime - startTime) / 1000000.0;
		}
		//long endTime = System.nanoTime();
		//double timeTaken = (endTime - startTime) / 1000000.0;
		
		return timeTaken;
	}
	

}
