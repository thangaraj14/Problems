package geeksforgeeks;
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        
        Map<Node,Node> map= new HashMap<>();
        
        Queue<Node> queue= new ArrayDeque<>();
        queue.offer(node);
        map.put(node,new Node(node.val));
        
        while(!queue.isEmpty()){
            Node current= queue.poll();
            
            for(Node neighbors: current.neighbors){
                if(!map.containsKey(neighbors)){
                    Node neighborClone= new Node(neighbors.val);
                    map.put(neighbors,neighborClone);
                    queue.offer(neighbors);
                }
                
                map.get(current).neighbors.add(map.get(neighbors));
            }
        }
        
        return map.get(node);
       
    }
    

}