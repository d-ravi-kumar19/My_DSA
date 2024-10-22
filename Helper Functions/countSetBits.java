import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        
        for(int t=0; t<T; t++){
            long N = sc.nextLong();
            long count =0;
            
            // considering 64 bit machine
            for(int i=0; i<64; i++){
                count += ((N>>i) &1);
            }
            System.out.println(count);
        }
    
    }
}