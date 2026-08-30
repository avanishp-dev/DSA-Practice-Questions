class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        long total=0;
        int i=prices.length-1;
        int j=discounts.length-1;
        while(i>=0 && j>=0){
            total += (long)prices[i] * (100-discounts[j]);
            i--;
            j--;
    }
    while(i>=0){
        total+=(long)prices[i]*100;
        i--;
    }
        return total/100.0;
   }
}