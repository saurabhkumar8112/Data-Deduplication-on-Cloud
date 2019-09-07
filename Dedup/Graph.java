package javaapplication161;
import java.util.*;
class Edge<E>
{
   private E data;
   private int weight;
   public Edge(E data, int weight)
   {
       this.data=data;
       this.weight=weight;
   }
   public void setData(E data)
   {
       this.data=data;
   }
   public void setWeight(int weight){
       this.weight=weight;
   }
   public E getData(){
       return data;
   }
   public int getWeight(){
       return weight;
   }
}
class Vertex<E>
{
    private E data;
    private List<Edge<E>> list;
    public Vertex(E data)
    {
        this.data=data;
        list= new List<>();
    }
    public void setData(E data){
        this.data=data;
    }
    public E getData()
    {
        return data;
    }
    public List<Edge<E>> getList()
    {
        return list;
    }
}
public class Graph<E> implements 
{
    Vector<Vertex<E>> graphVect;  Stack<E> stack= new Stack<>();
    HashMap<E, Integer> marked= new HashMap<>();
    HashMap<E, Integer> graphMap;
    private int vertices, edges;
    public int getVertices()
    {
        return vertices;
    }
    public int getEdges()
    {
        return edges;
    }
    private void printList(List<Edge<E>> list)
    {
    node p= list.head;
    while(p!=null)
    {
        Edge<E> tp= (Edge<E>)p.getData();
        System.out.print(tp.getData()+","+tp.getWeight()+" ");
        p=p.getNext();
    }
        System.out.println();
    }
    public Graph()
    {
        graphVect= new Vector<>();
        graphMap= new HashMap<>();
        vertices=0;
    }
    public void addVertex(E data){
        if(graphMap.get(data)!=null) return;
        graphMap.put(data, vertices);
        vertices++;
        graphVect.add(new Vertex<E>(data));    
    }
    public void addEdge(E source, E destination, int weight)
    {
        if(graphMap.get(source)==null) addVertex(source);
        if(graphMap.get(destination)==null) addVertex(destination);
        int index=graphMap.get(source);
        (graphVect.get(index)).getList().insertFirst(new Edge<E>(destination, weight));
        edges++;
    }
    public void printGraph()
    {
        for(int i=0;i<vertices;i++)
        {
            Vertex<E> v= graphVect.get(i);
            System.out.print(v.getData()+" ====> ");
            printList(v.getList());
        }
        System.out.println();
    }
    public boolean isVertex(E vertex)
    {
        if(graphMap.get(vertex)==null) return false;
        else return true;
    }
   
    public void deleteEdge(E source, E destination)  //deletes all the edges between the vertices pairs
    {
        if(!isVertex(source) || !isVertex(destination)) return;
        int index1=graphMap.get(source);
        int index2=graphMap.get(destination);
       // if(index1==null || index2==null) return;
        List<Edge<E>> list= graphVect.get(index1).getList();
        node p=list.head;
        while(p!=null)
        {
            Edge<E> tp= (Edge<E>)p.getData();
            if(destination.equals(tp.getData())){
                list.delete(p);
                edges--;
            }
            p=p.getNext();
        }
        list= graphVect.get(index2).getList();
        p=list.head;
        while(p!=null)
        {
            Edge<E> tp= (Edge<E>)p.getData();
            if(source.equals(tp.getData())){
                list.delete(p);
                edges--;
            }
            p=p.getNext();
        }
    }
}
