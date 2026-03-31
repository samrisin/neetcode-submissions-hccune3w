class Solution {
    public int[] findRedundantConnection(int[][] edges) {
       List<List<Integer>> adjList = new ArrayList<>();
       int n = edges.length;
       for(int i=0;i<=n;i++){
        adjList.add(new ArrayList<>());
       }
     
       for(var edge:edges){
        adjList.get(edge[0]).add(edge[1]);
        adjList.get(edge[1]).add(edge[0]);
               boolean[] visited = new boolean[n+1];
            if(dfs(-1,edge[0],adjList,visited)) return edge;

           
       }
        return new int[0];
    }

       private boolean dfs(int parent,int node, List<List<Integer>> adjList, boolean[] visited){

            if(visited[node]) return true;

            visited[node] = true;
            for(int nei:adjList.get(node)){
                if(nei==parent)continue;

                if(dfs(node,nei,adjList,visited)) return true;
            }

            return false;
       }
       
    }

