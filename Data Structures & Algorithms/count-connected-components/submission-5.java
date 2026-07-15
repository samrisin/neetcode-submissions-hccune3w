class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU ds = new DSU(n);
        int components = n;
        for(var edge:edges){
            if(ds.union(edge[0],edge[1])){
                components--;
            }
        }
    return components;
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
