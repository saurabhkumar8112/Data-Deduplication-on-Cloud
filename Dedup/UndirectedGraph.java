import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;
public class UndirectedGraph<E>{
    Vector<Vertex<E>> graphVect;  Stack<E> stack= new Stack<>();
    HashMap<E, Integer> marked= new HashMap<>();
    HashMap<E, Integer> graphMap;
    private int vertices, edges, e1;
    public int getVertices()
    {
        return vertices;
    }
    public int getEdges()
    {
        return e1;
    }
    private void printList(List<Edge<E>> list)
    {
    node p= list.head;
    while(p!=null)
    {
        Edge<E> tp= (Edge<E>)p.getData();
        System.out.print("["+tp.getData()+","+tp.getWeight()+"]"+" ");
        p=p.getNext();
    }
        System.out.println();
    }
    public UndirectedGraph()
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
        index=graphMap.get(destination);
        (graphVect.get(index)).getList().insertFirst(new Edge<E>(source, weight));
        edges++;
        e1=edges/2;
    }
    public void printGraph()
    {
        for(int i=0;i<vertices;i++)
        {
            Vertex<E> v= graphVect.get(i);
            System.out.print(v.getData()+" ====> ");
            printList(v.getList());
        }
    }
 
    public boolean isVertex(E vertex)
    {
        if(graphMap.get(vertex)==null) return false;
        else return true;
    }
    public void removeEdge(E source, E destination)
    {
        deleteEdge(source, destination);
        deleteEdge(destination, source);
        e1=edges/2;
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