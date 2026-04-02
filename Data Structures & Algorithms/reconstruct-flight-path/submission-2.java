class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> adjList = new HashMap<>();
         tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        for(var ticket:tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            adjList.computeIfAbsent(from,k->new ArrayList<>()).add(to);
        }

        List<String> result = new ArrayList<>();
        result.add("JFK");
        if(dfs("JFK",adjList,result,tickets.size()+1)) return result;

        return new ArrayList<>();
    }

    public boolean dfs(String start, Map<String,List<String>> adj,List<String> res, int targetLen){
        if(res.size()==targetLen) return true;

        if(!adj.containsKey(start)) return false;

        List<String> temp = adj.get(start);

        for(int i=0;i<temp.size();i++){
            String v = temp.get(i);
            res.add(v);
            temp.remove(i);
            if(dfs(v,adj,res,targetLen)) return true;
            temp.add(i,v);
            res.remove(res.size()-1);
        }
        return false;
    }
}
