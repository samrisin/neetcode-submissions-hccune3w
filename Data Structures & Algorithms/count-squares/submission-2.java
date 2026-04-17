class CountSquares {
    HashMap<List<Integer>,Integer> ptsCount;
    List<int[]> points;
    public CountSquares() {
        points = new ArrayList<>();
        ptsCount = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        ptsCount.put(p, ptsCount.getOrDefault(p, 0) + 1);
        points.add(point);
        
    }
    
    public int count(int[] point) {
        int res=0;
        int px = point[0];
        int py = point[1];

        for(int[] pt:points){
            int x = pt[0];
            int y = pt[1];
            if(Math.abs(px-x)!=Math.abs(py-y) || px==x || py==y){
                continue;
            }

            res+= ptsCount.getOrDefault(List.of(px,y),0) * ptsCount.getOrDefault(List.of(x,py),0);
        }
        return res;
    }
}
