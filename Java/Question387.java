package Java;

class Solution {
    public int firstUniqChar(String s) {
        int ans = Integer.MAX_VALUE;
        for(char c='a'; c<='z';c++){
            int index = s.indexOf(c);
            if(index!=-1&&index==s.lastIndexOf(c)){
                ans = Math.min(ans,index);
            }
        }

        
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}

public class Question387 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "loveleetcode";
        int result = solution.firstUniqChar(s);
        System.out.println("Index of the first non-repeating character: " + result);
    }
}
