//PROBLEM URL: https://leetcode.com/problems/first-unique-character-in-a-string/description/

class Solution {
    public int firstUniqChar(String s) {

        //Create an array to store characters as we parse through the test string
        int[] a = new int[s.length()];
        
        for(int i=0; i<s.length(); i++){

            //Create a boolean variable that keeps track whether the character is already encountered or not
            boolean notFound = true;
            for(int j=0; j<i; j++){
                if(s.charAt(i) == s.charAt(j)){

                    //If it is a repeating character, set the values at its index and the index of its first occurence as 0
                    notFound = false;
                    a[i] = 0;
                    a[j] = 0;

                    //Reduces the time complexity from O(lg n**2)
                    break;
                }
            }

            //If it is not a repeating character, set its index value as 1
            if(notFound){
                a[i] = 1;
            }
        }

        for(int k=0; k<s.length(); k++){

            //Returns the first index that has the value 1
            if(a[k] != 0){
                return k;
            }
        }

        return -1;
    }
}