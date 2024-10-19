int[] findNSEE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];

        for(int i=n-1; i>= 0 ; i-- ){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            nse[i] = st.isEmpty() ? n-i : st.peek() - i;
            st.push(i);
        }

        return nse;
    }    