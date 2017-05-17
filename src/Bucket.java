 
public class Bucket {
    
    private Bucket next;
    private String data;
    
    public Bucket(String s){
        this.data = s;
    }
    
    
  
   public Bucket getNext(){
       return this.next;
   }
   
   public void setNext(Bucket ok){
       this.next = ok;
   }
    
   public String getData(){
       return this.data;
   }
    
    
    
    
   

}

