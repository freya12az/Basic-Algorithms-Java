import java.util.*;


public class GraphTraversal{
  
  Node root;
  Graph g;
  Boolean[] visited;
  
  public GraphTraversal(int size){
      visited = new Boolean[size];
      Arrays.fill(visited, false);
      root = new Node(0);
      g = new Graph(size, root);
      g.addEdge(0,1);
      g.addEdge(0,2);
      g.addEdge(1,0);
      g.addEdge(1,3);
      g.addEdge(1,4);
      g.addEdge(2,0);
      g.addEdge(3,1);
      g.addEdge(4,1);
      g.addEdge(4,5);
      g.addEdge(5,4);
  }
  
  class Node{
    Integer value;
    public Node(Integer v){
      value = v;
    }
  }
  
  class Graph{
    Node[] nodes;
    Node root;
    LinkedList<Integer>[] edges;
    
    public Graph(int numNodes, Node root){
      nodes = new Node[numNodes];
      for(int i=0;i<numNodes;i++){
        nodes[i] = new Node(i);
      }
      this.root = root;
      //set up the edges as adj list
      edges = (LinkedList<Integer>[])new LinkedList[numNodes];
      for(int i=0; i<numNodes;i++){
        edges[i] = new LinkedList<Integer>();
      }
    }
    
    void addEdge(int i, int j){
      this.edges[i].add(j);
    }
    
    List<Integer> getAdjNodes(Node n){
      return edges[n.value];
    }
    
  }
  
  public void dfs(Node r){
    if(r==null)
      return;
    if(visited[r.value] == true)
      return;
    
    visited[r.value] = true;
    System.out.println("visited node \t"+r.value);  
    List<Integer> adj = g.getAdjNodes(r);
    System.out.format("Adj nodes for node:%d are:\n",r.value);
    Iterator i = adj.listIterator(0);
    while(i.hasNext()){
      System.out.println(i.next());
    }
    for(Integer n : adj){
      dfs(g.nodes[n]);
    }
  }
    
    public static void main(String[] args){
      GraphTraversal gt = new GraphTraversal(6);      
      gt.dfs(gt.root);
    }
    
  }
