class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] cnt=new int[26];
        for(char c:s.toCharArray()) cnt[c-'a']++;

        int n=s.length(),i=0;

        while(i<n){
            int x=target.charAt(i)-'a';
            if(cnt[x]==0) break;
            cnt[x]--;
            i++;
        }

        if(i<n){
            int x=target.charAt(i)-'a';
            for(int j=x+1;j<26;j++){
                if(cnt[j]>0){
                    cnt[j]--;
                    StringBuilder r=new StringBuilder();

                    for(int p=0;p<=i;p++){
                        if(p<i) r.append(target.charAt(p));
                        else r.append((char)('a'+j));
                    }

                    for(int j2=0;j2<26;j2++){
                        while(cnt[j2]>0){
                            r.append((char)('a'+j2));
                            cnt[j2]--;
                        }
                    }
                    return r.toString();
                }
            }
        }

        for(int p=i-1;p>=0;p--){
            cnt[target.charAt(p)-'a']++;
            int x=target.charAt(p)-'a';

            for(int j=x+1;j<26;j++){
                if(cnt[j]>0){
                    cnt[j]--;

                    StringBuilder r=new StringBuilder();
                    for(int q=0;q<p;q++) r.append(target.charAt(q));
                    r.append((char)('a'+j));

                    for(int q=0;q<26;q++){
                        while(cnt[q]>0){
                            r.append((char)('a'+q));
                            cnt[q]--;
                        }
                    }
                    return r.toString();
                }
            }
        }

        return "";
    }
}