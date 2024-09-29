class AllOne {

    HashMap<String, Integer> map1;

    TreeMap<Integer, HashSet<String>> map2;
    
    public AllOne() {
        map1 = new HashMap<>();
        map2 = new TreeMap<>();
    }
    
    public void inc(String key) {
            int count = map1.getOrDefault(key,0);
            if(count != 0){
                HashSet<String> temp = map2.get(count);
                temp.remove(key);
                if(temp.size() == 0)
                    map2.remove(count);
            }
                
            
            if(!map2.containsKey(count+1)){
                map2.put(count+1,new HashSet<>());
            }
            map2.get(count+1).add(key);
            map1.put(key,count+1);

    }
    
    public void dec(String key) {
        int count = map1.get(key);
        HashSet<String> temp = map2.get(count);
        temp.remove(key);
        if(temp.size() == 0)
            map2.remove(count);
        if(count == 1){
            map1.remove(key);
            return;
        }
        if(!map2.containsKey(count-1)){
            map2.put(count-1,new HashSet<>());
        }
        map2.get(count-1).add(key);
        map1.put(key,count-1);
    }
    
    public String getMaxKey() {
        if(map2.isEmpty())
            return "";
        for(String s:map2.get(map2.lastKey())){
            return s;
        }
        return "";
    }
    
    public String getMinKey() {
        if(map2.isEmpty())
            return "";
        for(String s:map2.get(map2.firstKey())){
            return s;
        }
        return "";
        
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
