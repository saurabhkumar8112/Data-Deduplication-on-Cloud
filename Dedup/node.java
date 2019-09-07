package javaapplication161;
public class node<E>{
     E data;
    private node next;
    private node prev;
    public node(E data, node next, node prev)
    {
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
    public node(E data)
    {
        this.data=data;
        this.next=null;
        this.prev=null;
    }
    public void setData(E data)
    {
        this.data=data;
    }
    public E getData(){
        return data;
    }
    public node getNext(){
        return next;
    }
    public void setNext(node next){
        this.next=next;
    }
    public void setPrev(node prev){
        this.prev=prev;
    }
    public node getPrev(){
        return prev;
    }
    
}
