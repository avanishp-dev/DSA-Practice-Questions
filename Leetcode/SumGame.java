class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?')
                leftQ++;
            else
                leftSum += num.charAt(i) - '0';
        }

        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?')
                rightQ++;
            else
                rightSum += num.charAt(i) - '0';
        }
revb(io).command(instant velocity.inn)        if ((leftQ + rightQ) % 2 == 1)
            return true;

        return leftSum - rightSum != 9 * (rightQ - leftQ) / 2;
    }
}