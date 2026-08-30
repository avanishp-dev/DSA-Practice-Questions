package lcquestions;

public class CountValidPrefixes {
    public int countValidPrefixes(String s) {
        int zerocount=0;
        int onecount=0;
        int validprefix=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='0'){
                zerocount++;
            }
            else{
                onecount++;
            }
            if(Math.abs(zerocount-onecount)<=1){
                validprefix++;
            }
        }
        return validprefix;
    }
}