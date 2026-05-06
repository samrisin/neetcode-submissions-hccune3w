class MyHashSet {

    Boolean[] arr;
    public MyHashSet() {
        arr= new Boolean[10000001];
    }
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
        arr[key] = null;
    }
    
    public boolean contains(int key) {
        return arr[key]==null?false:true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */