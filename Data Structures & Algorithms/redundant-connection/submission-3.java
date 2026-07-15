class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length+1;
        DSU ds = new DSU(len);

        for(var edge:edges){
            if(!ds.union(edge[0],edge[1])) return edge;
        }

    return new int[]{};
    }
}

class DSU{
    int[] parent;
    public DSU(int n){
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }

    }

    public int find(int x){
        if(parent[x]==x){
            return x;
        }

        parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px==py) return false;
        
        parent[px]=py;
        return true;
    }
}
