import java.util.Stack;

public class Stock_span {
    public static void StockSpan(int stocks[],int span[]){
        int n = stocks.length;
        Stack<Integer> s = new Stack<Integer>();
        span[0]=1;
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && stocks[s.peek()] < stocks[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            }
            else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
                        
    }
    public static void main(String[] args) {
        int stocks[]={100,80,60,70,60,85,100};
        int span[]=new int[stocks.length];
        StockSpan(stocks,span);
        for(int i=0;i<span.length;i++){
            System.out.println("Stocks at day "+(i+1)+" has span of "+span[i]);
        }
    }
}
