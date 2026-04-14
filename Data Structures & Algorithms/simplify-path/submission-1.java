class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String curr = "";
        for (char ch : (path + "/").toCharArray()) {
            if (ch == '/') {
                if (curr.equals("..")) {
                    if (stack.size() > 0) {
                        stack.pop();
                    }
                } else if(!curr.isEmpty() && !curr.equals(".")) {
                    stack.push(curr);
                }
                curr = "";
            } else {
                curr += ch;
            }
        }

        return "/" + String.join("/", stack);
        
    }
}