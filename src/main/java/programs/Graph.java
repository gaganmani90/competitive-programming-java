package programs;

import java.util.*;

/**
 * This class models a simple, undirected graph using an 
 * incidence list representation. Vertices are identified 
 * uniquely by their labels, and only unique vertices are allowed.
 * At most one Edge per vertex pair is allowed in this Graph.
 * 
 * Note that the Graph is designed to manage the Edges. You
 * should not attempt to manually add Edges yourself.
 * 
 * @author Michael Levet
 * @date June 09, 2015
 */
public class Graph {
    
    private HashMap<String, Vertex> vertices;
    private HashMap<Integer, Edge> edges;
    
    public Graph(){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
    }
    
    /**
     * This constructor accepts an ArrayList<Vertex> and populates
     * this.vertices. If multiple Vertex objects have the same label,
     * then the last Vertex with the given label is used. 
     * 
     * @param vertices The initial Vertices to populate this Graph
     */
    public Graph(ArrayList<Vertex> vertices){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
        
        for(Vertex v: vertices){
            this.vertices.put(v.getLabel(), v);
        }
        
    }
    
    /**
     * This method adds am edge between Vertices one and two
     * of weight 1, if no Edge between these Vertices already
     * exists in the Graph.
     * 
     * @param one The first vertex to add
     * @param two The second vertex to add
     * @return true iff no Edge relating one and two exists in the Graph
     */
    public boolean addEdge(Vertex one, Vertex two){
        return addEdge(one, two, 1);
    }
    
    
    /**
     * Accepts two vertices and a weight, and adds the edge 
     * ({one, two}, weight) iff no Edge relating one and two 
     * exists in the Graph.
     * 
     * @param one The first Vertex of the Edge
     * @param two The second Vertex of the Edge
     * @param weight The weight of the Edge
     * @return true iff no Edge already exists in the Graph
     */
    public boolean addEdge(Vertex one, Vertex two, int weight){
        if(one.equals(two)){
            return false;   
        }
       
        //ensures the Edge is not in the Graph
        Edge e = new Edge(one, two, weight);
        if(edges.containsKey(e.hashCode())){
            return false;
        }
       
        //and that the Edge isn't already incident to one of the vertices
        else if(one.containsNeighbor(e) || two.containsNeighbor(e)){
            return false;
        }
            
        edges.put(e.hashCode(), e);
        one.addNeighbor(e);
        two.addNeighbor(e);
        return true;
    }
    
    /**
     * 
     * @param e The Edge to look up
     * @return true iff this Graph contains the Edge e
     */
    public boolean containsEdge(Edge e){
        if(e.getOne() == null || e.getTwo() == null){
            return false;
        }
        
        return this.edges.containsKey(e.hashCode());
    }
    
    
    /**
     * This method removes the specified Edge from the Graph,
     * including as each vertex's incidence neighborhood.
     * 
     * @param e The Edge to remove from the Graph
     * @return Edge The Edge removed from the Graph
     */
    public Edge removeEdge(Edge e){
       e.getOne().removeNeighbor(e);
       e.getTwo().removeNeighbor(e);
       return this.edges.remove(e.hashCode());
    }
    
    /**
     * 
     * @param vertex The Vertex to look up
     * @return true iff this Graph contains vertex
     */
    public boolean containsVertex(Vertex vertex){
        return this.vertices.get(vertex.getLabel()) != null;
    }
    
    /**
     * 
     * @param label The specified Vertex label
     * @return Vertex The Vertex with the specified label
     */
    public Vertex getVertex(String label){
        return vertices.get(label);
    }
    
    /**
     * This method adds a Vertex to the graph. If a Vertex with the same label
     * as the parameter exists in the Graph, the existing Vertex is overwritten
     * only if overwriteExisting is true. If the existing Vertex is overwritten,
     * the Edges incident to it are all removed from the Graph.
     * 
     * @param vertex
     * @param overwriteExisting
     * @return true iff vertex was added to the Graph
     */
    public boolean addVertex(Vertex vertex, boolean overwriteExisting){
        Vertex current = this.vertices.get(vertex.getLabel());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }
            
            while(current.getNeighborCount() > 0){
                this.removeEdge(current.getNeighbor(0));
            }
        }
        
        
        vertices.put(vertex.getLabel(), vertex);
        return true;
    }
    
    /**
     * 
     * @param label The label of the Vertex to remove
     * @return Vertex The removed Vertex object
     */
    public Vertex removeVertex(String label){
        Vertex v = vertices.remove(label);
        
        while(v.getNeighborCount() > 0){
            this.removeEdge(v.getNeighbor((0)));
        }
        
        return v;
    }
    
    /**
     * 
     * @return Set<String> The unique labels of the Graph's Vertex objects
     */
    public Set<String> vertexKeys(){
        return this.vertices.keySet();
    }
    
    /**
     * 
     * @return Set<Edge> The Edges of this graph
     */
    public Set<Edge> getEdges(){
        return new HashSet<Edge>(this.edges.values());
    }
    
}

/**
 * This class models an undirected Edge in the Graph implementation.
 * An Edge contains two vertices and a weight. If no weight is
 * specified, the default is a weight of 1. This is so traversing
 * edges is assumed to be of greater distance or cost than staying
 * at the given vertex.
 * 
 * This class also deviates from the expectations of the Comparable interface
 * in that a return value of 0 does not indicate that this.equals(other). The
 * equals() method only compares the vertices, while the compareTo() method 
 * compares the edge weights. This provides more efficient implementation for
 * checking uniqueness of edges, as well as the fact that two edges of equal weight
 * should be considered equitably in a pathfinding or spanning tree algorithm.
 * 
 * @author Michael Levet
 * @date June 09, 2015
 */
 class Edge implements Comparable<Edge> {

    private Vertex one, two;
    private int weight;
    
    /**
     * 
     * @param one The first vertex in the Edge
     * @param two The second vertex in the Edge
     */
    public Edge(Vertex one, Vertex two){
        this(one, two, 1);
    }
    
    /**
     * 
     * @param one The first vertex in the Edge
     * @param two The second vertex of the Edge
     * @param weight The weight of this Edge
     */
    public Edge(Vertex one, Vertex two, int weight){
        this.one = (one.getLabel().compareTo(two.getLabel()) <= 0) ? one : two;
        this.two = (this.one == one) ? two : one;
        this.weight = weight;
    }
    
    
    /**
     * 
     * @param current
     * @return The neighbor of current along this Edge
     */
    public Vertex getNeighbor(Vertex current){
        if(!(current.equals(one) || current.equals(two))){
            return null;
        }
        
        return (current.equals(one)) ? two : one;
    }
    
    /**
     * 
     * @return Vertex this.one
     */
    public Vertex getOne(){
        return this.one;
    }
    
    /**
     * 
     * @return Vertex this.two
     */
    public Vertex getTwo(){
        return this.two;
    }
    
    
    /**
     * 
     * @return int The weight of this Edge
     */
    public int getWeight(){
        return this.weight;
    }
    
    
    /**
     * 
     * @param weight The new weight of this Edge
     */
    public void setWeight(int weight){
        this.weight = weight;
    }
    
    
    /**
     * Note that the compareTo() method deviates from 
     * the specifications in the Comparable interface. A 
     * return value of 0 does not indicate that this.equals(other).
     * The equals() method checks the Vertex endpoints, while the 
     * compareTo() is used to compare Edge weights
     * 
     * @param other The Edge to compare against this
     * @return int this.weight - other.weight
     */
    public int compareTo(Edge other){
        return this.weight - other.weight;
    }
    
    /**
     * 
     * @return String A String representation of this Edge
     */
    public String toString(){
        return "({" + one + ", " + two + "}, " + weight + ")";
    }
    
    /**
     * 
     * @return int The hash code for this Edge 
     */
    public int hashCode(){
        return (one.getLabel() + two.getLabel()).hashCode(); 
    }
    
    /**
     * 
     * @param other The Object to compare against this
     * @return ture iff other is an Edge with the same Vertices as this
     */
    public boolean equals(Object other){
        if(!(other instanceof Edge)){
            return false;
        }
        
        Edge e = (Edge)other;
        
        return e.one.equals(this.one) && e.two.equals(this.two);
    }   
}


 /**
  * This class models a vertex in a graph. For ease of 
  * the reader, a label for this vertex is required. 
  * Note that the Graph object only accepts one Vertex per label,
  * so uniqueness of labels is important. This vertex's neighborhood
  * is described by the Edges incident to it. 
  * 
  * @author Michael Levet
  * @date June 09, 2015
  */
  class Vertex {

     private ArrayList<Edge> neighborhood;
     private String label;
     
     /**
      * 
      * @param label The unique label associated with this Vertex
      */
     public Vertex(String label){
         this.label = label;
         this.neighborhood = new ArrayList<Edge>();
     }
     
     
     /**
      * This method adds an Edge to the incidence neighborhood of this graph iff
      * the edge is not already present. 
      * 
      * @param edge The edge to add
      */
     public void addNeighbor(Edge edge){
         if(this.neighborhood.contains(edge)){
             return;
         }
         
         this.neighborhood.add(edge);
     }
     
     
     /**
      * 
      * @param other The edge for which to search
      * @return true iff other is contained in this.neighborhood
      */
     public boolean containsNeighbor(Edge other){
         return this.neighborhood.contains(other);
     }
     
     /**
      * 
      * @param index The index of the Edge to retrieve
      * @return Edge The Edge at the specified index in this.neighborhood
      */
     public Edge getNeighbor(int index){
         return this.neighborhood.get(index);
     }
     
     
     /**
      * 
      * @param index The index of the edge to remove from this.neighborhood
      * @return Edge The removed Edge
      */
     Edge removeNeighbor(int index){
         return this.neighborhood.remove(index);
     }
     
     /**
      * 
      * @param e The Edge to remove from this.neighborhood
      */
     public void removeNeighbor(Edge e){
         this.neighborhood.remove(e);
     }
     
     
     /**
      * 
      * @return int The number of neighbors of this Vertex
      */
     public int getNeighborCount(){
         return this.neighborhood.size();
     }
     
     
     /**
      * 
      * @return String The label of this Vertex
      */
     public String getLabel(){
         return this.label;
     }
     
     
     /**
      * 
      * @return String A String representation of this Vertex
      */
     public String toString(){
         return "Vertex " + label;
     }
     
     /**
      * 
      * @return The hash code of this Vertex's label
      */
     public int hashCode(){
         return this.label.hashCode();
     }
     
     /**
      * 
      * @param other The object to compare
      * @return true iff other instanceof Vertex and the two Vertex objects have the same label
      */
     public boolean equals(Object other){
         if(!(other instanceof Vertex)){
             return false;
         }
         
         Vertex v = (Vertex)other;
         return this.label.equals(v.label);
     }
     
     /**
      * 
      * @return ArrayList<Edge> A copy of this.neighborhood. Modifying the returned
      * ArrayList will not affect the neighborhood of this Vertex
      */
     public ArrayList<Edge> getNeighbors(){
         return new ArrayList<Edge>(this.neighborhood);
     }
     
 }

