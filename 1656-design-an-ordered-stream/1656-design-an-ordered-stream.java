class OrderedStream {
    
    int ptr;
    String streams[];

    public OrderedStream(int n) {
        streams = new String[n + 1];
        ptr = 1;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        streams[idKey] = value;
        while (ptr < streams.length && streams[ptr] != null) {
            result.add(streams[ptr]);
            ptr++;
        }
        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */