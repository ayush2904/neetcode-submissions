class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arrl = new int[n];
        int[] arrp = new int[n];
        arrl[0]=arrp[n-1]=1;
        for(int i=1;i<n;i++) {
            if(ratings[i] > ratings[i-1]) {
                arrl[i]=arrl[i-1]+1;
            } else {
                arrl[i]=1;
            }
          //  System.out.print(arrl[i]+" ");
        }

        //System.out.println();

        for(int i=n-2;i>=0;i--) {
            if(ratings[i] > ratings[i+1]) {
                arrp[i]=arrp[i+1]+1;
            } else {
                arrp[i]=1;
            }
            //System.out.print(arrp[i]+" ");
        }
        int ans = 0;
        for(int i=0; i<n ;i++) {
         ans = ans + Math.max(arrl[i],arrp[i]);
        }

    return ans;
    }
}