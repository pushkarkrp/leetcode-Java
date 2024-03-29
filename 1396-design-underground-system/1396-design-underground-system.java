class UndergroundSystem {
    
    Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();
    Map<String, Pair<Double, Integer>> routeMap = new HashMap<>();

    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkInMap.get(id);
        checkInMap.remove(id);
        
        String key = checkIn.getKey() + "_" + stationName;
        int time = t - checkIn.getValue();
        
        Pair<Double, Integer> route = routeMap.getOrDefault(key, new Pair<>(0.0, 0));
        routeMap.put(key, new Pair<>(time + route.getKey(), route.getValue() + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "_" + endStation;
        Pair<Double, Integer> route = routeMap.get(key);
        return route.getKey() / route.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */