
public class LinkedList {
    Node head;
    Node tail;
    int size =0;
    public LinkedList() {
        head = null;
    }


    public void addNode(String data){
        if (head == null){
            head = new Node(data);
            size++;

        }else if(tail == null){
            tail = new Node(data);
            head.setNext(tail);
            size++;
        }else{
            Node tempTail = new Node(data);
            tail.setNext(tempTail);
            tail = tempTail;
            size++;
        }
    }

    public void addUniqueNode(String data){
        Node current = head;
        if (current == null){
            head = new Node(data);
        }else{
            while(current.getNext() != null){
                if(current.getData().equals(data)){
                    return;
                }else{
                current = current.getNext();
                }
            }
            current.setNext(new Node(data));
        }
        size++;
    }
    
    public void findNode(String data){
    	Node curr = head;
    	while(curr != null){
    	if(curr.getData() == data){
    		break;
    	}else if(curr.getNext() != null){
    		curr = curr.getNext();
    	}else if(curr.getNext() == null){
    		break;
    	}
    	}
    }

    public int getSize(){
        return this.size;
    }

    public void printList(){
        Node curr = head;
        while(curr != null){
         System.out.println(curr.getData());
         curr = curr.getNext();
        }
    }

}

