class Solution {
    public List<String> braceExpansionII(String expression) {
        return new ArrayList<>(solve(expression));
    }
    Set<String> solve(String s) {
        Set<String> res=new TreeSet<>();
        int level=0,start=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='{') level++;
            else if(c=='}') level--;
            if(c==','&&level==0){
                res.addAll(solve(s.substring(start,i)));
                start=i+1;
            }
        }
        if(start>0){
            res.addAll(solve(s.substring(start)));
            return res;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'){
                level=1;
                int j=i+1;
                while(level>0){
                    if(s.charAt(j)=='{') level++;
                    else if(s.charAt(j)=='}') level--;
                    j++;
                }
                Set<String> left=solve(s.substring(0,i));
                Set<String> mid=solve(s.substring(i+1,j-1));
                Set<String> right=solve(s.substring(j));
                if(left.isEmpty()) left.add("");
                if(right.isEmpty()) right.add("");
                for(String a:left)
                    for(String b:mid)
                        for(String c:right)
                            res.add(a+b+c);
                return res;
            }
        }
        res.add(s);
        return res;
    }
}