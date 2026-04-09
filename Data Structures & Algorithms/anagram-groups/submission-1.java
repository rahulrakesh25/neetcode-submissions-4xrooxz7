class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> resMap = new HashMap<>();
        for (String str : strs) {
            char [] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            System.out.println(sortedStr);
            List<String> list = resMap.getOrDefault(sortedStr, new ArrayList<>());
            System.out.println(list.toString());
            list.add(str);
            resMap.put(sortedStr, list);
        }
        System.out.println(resMap.values().toString());
        return new ArrayList<>(resMap.values());
    }
}
