class TimeMap {
    HashMap<String, HashMap<Integer, String>> map;
    HashMap<String, ArrayList<Integer>> timestampMap;

    public TimeMap() {
        map = new HashMap<>();
        timestampMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        HashMap<Integer, String> valMap = map.getOrDefault(key, new HashMap<>());
        valMap.put(timestamp, value);
        map.put(key, valMap);
        ArrayList<Integer> list = timestampMap.getOrDefault(key, new ArrayList<>());
        list.add(timestamp);
        timestampMap.put(key, list);
    }
    
    public String get(String key, int timestamp) {
    if (!timestampMap.containsKey(key)) return "";

    ArrayList<Integer> timestamps = timestampMap.get(key);

    int left = 0, right = timestamps.size() - 1;
    int resKey = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midTimestamp = timestamps.get(mid);

        if (midTimestamp <= timestamp) {
            resKey = midTimestamp;   // valid candidate
            left = mid + 1;          // try to find bigger
        } else {
            right = mid - 1;
        }
    }

    if (resKey == -1) return "";

    return map.get(key).get(resKey);
}

}
