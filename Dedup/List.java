package javaapplication161;
public class List<E> implements methods<E>
{
    node head; private node tail;   // this will keep the track at front end and at the back end
    private int size;
    public List(){
        head=null; tail=null; size=0;
    }
    public int size()
    {
        return  size;
    }
    public void insertFirst(E data)
    {
        node p= new node(data);
        if(head==null || tail==null)
        {
        head=p;
        tail=p;
        size++;
        return;
        }
        else
        {
        p.setNext(head);
        head.setPrev(p);
        head=p;
        size++;
        return;
        }
    }
    public void insertLast(E data)
    {
        node p= new node(data);
         if(head==null || tail==null)
        {
        head=p;
        tail=p;
        size++;
        return;
        }else{
             p.setPrev(tail);
             tail.setNext(p);
             tail=p;
             size++;
             return;
         }
    }
    public String toString()
    {
        String str="["; node p= head;
        if(p==null)
        {
            str+="]"; return str;
        }else{
            do
            {
                str+=p.getData();
                str+=", ";
                p=p.getNext();
            }while(p!=null);
            str=str.substring(0, str.length()-2);
            str+="]";
            return str;
        }
    }
    public void printList()
    {
        node p=head;
        if(p==null) return;
        while(p.getNext()!=null)
        {
            System.out.print(p.getData()+" ");
            p=p.getNext();
        }
        System.out.println();
    }
    public void deleteFirst() throws EmptyListException
    {
        if(size==0) throw new EmptyListException("");
     if(head==tail)
     {
         size--;
         head=null;
         tail=null;
     }
     else{
         head=head.getNext();
         head.setPrev(null);
         size--;
     }
    }
    public void delete(node p)
    {
        if(p==head)
        {
            try{
                deleteFirst(); 
            }catch(Exception e)
            {
                
            }
        }else if(p==tail){
           try{
               deleteLast(); 
            }catch(Exception e)
            {
                
            }  
        }else{
            p.getPrev().setNext(p.getNext());
            p.getNext().setPrev(p.getPrev());
            size--;
            p=p.getPrev();
        }
    }
    public void deleteLast() throws EmptyListException
    {
        if(size==0) throw new EmptyListException("");
         if(head==tail)
     {
         size--;
         head=null;
         tail=null;
     }else{
             tail= tail.getPrev();
             tail.setNext(null);
             size--;
         }
    }
}
