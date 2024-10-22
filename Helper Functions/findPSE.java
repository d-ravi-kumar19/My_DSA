int[] findPSE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];

        for(int i= 0; i < n ; i++ ){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            pse[i] = st.isEmpty() ? i + 1 : i - st.peek() ;
            st.push(i);
        }

        return pse;
}    