class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> resMap = new HashMap<>();
        for (String str : strs) {
            char [] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            List<String> list = resMap.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            resMap.put(sortedStr, list);
        }
        return new ArrayList<>(resMap.values());
    }
}
