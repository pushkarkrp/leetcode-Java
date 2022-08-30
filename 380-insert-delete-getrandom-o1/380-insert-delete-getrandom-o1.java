class RandomizedSet {
    
    Map<Integer, Integer> valToIdx;
    List<Integer> list;

    public RandomizedSet() {
        valToIdx = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(valToIdx.containsKey(val)) return false;
        list.add(val);
        valToIdx.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valToIdx.containsKey(val)) return false;
        int index = valToIdx.get(val);
        valToIdx.put(list.get(list.size() -1), index);
        Collections.swap(list, index, list.size() -1);
        list.remove(list.size() - 1);
        valToIdx.remove(val);
        return true;
    }
    
    public int getRandom() {
        /*int size = list.size();
        int randomIndex = (int) Math.random() * (size);
        return list.get(randomIndex);*/
        int max = list.size();
        int min = 0;
        int ind = (int)(Math.random() * (max - min) + min);
        return list.get(ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */