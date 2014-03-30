import java.util.*;


public class GraphTraversal{
  
  Node root;
  Graph g;
  Boolean[] visited;
  Boolean[] visitedbfs;import java.util.*;


public class GraphTraversal{
  
  Node root;
  Graph g;
  Boolean[] visited;
  Boolean[] visitedbfs;
  Boolean[] visitedDfsStack;
  
  public GraphTraversal(int size){
      visited = new Boolean[size];
      visitedbfs = new Boolean[size];
      visitedDfsStack = new Boolean[size];
      Arrays.fill(visited, false);
      Arrays.fill(visitedbfs, false);
      Arrays.fill(visitedDfsStack,false);
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
    
    List<Integer> getAdjNodesValues(Node n){
      return edges[n.value];
    }
    
    List<Node> getAdjNodes(Node n){
      List<Node> nodes = new ArrayList<Node>();
      for(Integer e : edges[n.value]){
        nodes.add(this.nodes[e]);
      }
      return nodes;
    }
    
  }
  
  public void dfs(Node r){
    if(r==null)
      return;
    if(visited[r.value] == true)
      return;
    
    visited[r.value] = true;
    System.out.println("visited node \t"+r.value);  
    List<Integer> adj = g.getAdjNodesValues(r);
    System.out.format("Adj nodes for node:%d are:\n",r.value);
    Iterator i = adj.listIterator(0);
    while(i.hasNext()){
      System.out.println(i.next());
    }
    for(Integer n : adj){
      dfs(g.nodes[n]);
    }
  }
  
  public void dfs_Stack(Node r){
    System.out.println("Starting DFS using Stack");
    Stack<Node> s = new Stack<Node>();
    visitedDfsStack[r.value]=true;
    System.out.println("Visited root node:"+r.value);
    s.push(r);
    
    while(!s.isEmpty()){
      Node top = s.pop();
      if(visitedDfsStack[top.value]!=true){
        visitedDfsStack[top.value]=true;
        System.out.println("visited node:"+top.value);
      }
      List<Node> adj = g.getAdjNodes(top);
      for(Node n : adj){
        if(visitedDfsStack[n.value]!=true)
          s.push(n);
        }
    }
  }
    
  public void bfs(Node r){
    System.out.println("Starting BFS");
    Queue<Node> q = new LinkedList<Node>();
    visitedbfs[r.value] = true;
    System.out.println("Visited root node:"+r.value);
    q.add(r); //add root
    
    while(!q.isEmpty()){
      Node n = q.remove();
      List<Node> adj = g.getAdjNodes(n);
      for( Node node : adj ){
        if(visitedbfs[node.value]==false){
          visitedbfs[node.value]=true;
          System.out.println("visited node:"+node.value);
          q.add(node);
        }
      }
    }
  }
  
    public static void main(String[] args){
      GraphTraversal gt = new GraphTraversal(6);      
      gt.dfs(gt.root);
      gt.dfs_Stack(gt.root);
      gt.bfs(gt.root);
    }
    
  }
  
  public GraphTraversal(int size){
      visited = new Boolean[size];
      visitedbfs = new Boolean[size];
      Arrays.fill(visited, false);
      Arrays.fill(visitedbfs, false);
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
    
    List<Integer> getAdjNodesValues(Node n){
      return edges[n.value];
    }
    
    List<Node> getAdjNodes(Node n){
      List<Node> nodes = new ArrayList<Node>();
      for(Integer e : edges[n.value]){
        nodes.add(this.nodes[e]);
      }
      return nodes;
    }
    
  }
  
  public void dfs(Node r){
    if(r==null)
      return;
    if(visited[r.value] == true)
      return;
    
    visited[r.value] = true;
    System.out.println("visited node \t"+r.value);  
    List<Integer> adj = g.getAdjNodesValues(r);
    System.out.format("Adj nodes for node:%d are:\n",r.value);
    Iterator i = adj.listIterator(0);
    while(i.hasNext()){
      System.out.println(i.next());
    }
    for(Integer n : adj){
      dfs(g.nodes[n]);
    }
  }
    
  public void bfs(Node r){
    System.out.println("Starting BFS");
    Queue<Node> q = new LinkedList<Node>();
    visitedbfs[r.value] = true;
    System.out.println("Visited root node:"+r.value);
    q.add(r); //add root
    
    while(!q.isEmpty()){
      Node n = q.remove();
      List<Node> adj = g.getAdjNodes(n);
      for( Node node : adj ){
        if(visitedbfs[node.value]==false){
          visitedbfs[node.value]=true;
          System.out.println("visited node:"+node.value);
          q.add(node);
        }
      }
    }
  }
  
    public static void main(String[] args){
      GraphTraversal gt = new GraphTraversal(6);      
      gt.dfs(gt.root);
      gt.bfs(gt.root);
    }
    
  }
