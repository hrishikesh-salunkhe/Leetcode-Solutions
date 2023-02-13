//PROBLEM URL: https://leetcode.com/problems/first-unique-character-in-a-string/description/

class Solution {
    public int firstUniqChar(String s) {
        int[] a = new int[s.length()];
        
        for(int i=0; i<s.length(); i++){
            boolean notFound = true;
            for(int j=0; j<i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    notFound = false;
                    a[i] = 0;
                    a[j] = 0;
                    break;
                }
            }
            if(notFound){
                a[i] = 1;
            }
        }

        for(int k=0; k<s.length(); k++){
            if(a[k] != 0){
                return k;
            }
        }

        return -1;
    }
}