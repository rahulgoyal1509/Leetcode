class LRUCache {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            int val = map.get(key);

            map.remove(key);
            map.put(key, val);

            return val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.remove(key);
            map.put(key, value);
            return;
        }
        
        if(map.size() == capacity){
            var eldestKey = map.keySet().iterator().next(); 
            map.remove(eldestKey);
        }

        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */