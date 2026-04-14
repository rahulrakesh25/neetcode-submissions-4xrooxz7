class StockSpanner {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public StockSpanner() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public int next(int price) {
        stack1.push(price);
        int span = 0;
        while (stack1.size() > 0 && price >= stack1.peek()) {
            span++;
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */