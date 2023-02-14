class Solution {
    public int findJudge(int n, int[][] trust) {

        //Edge Case: If there is only person in town and trust array is empty, then that one person is the judge
        if(trust.length < 1 && n == 1){
            return 1;
        }

        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> aCount = new ArrayList<Integer>();
        int counter = 0;

        //Store all the trusted people along with their trustee counts
        for(int i=0; i<trust.length; i++){
            boolean notFound = true;
            for(int j=0; j<a.size(); j++){
                if(trust[i][1] == a.get(j)){
                    notFound = false;
                    aCount.set(j, aCount.get(j)+1);
                }
            }
            if(notFound){
                a.add(trust[i][1]);
                aCount.add(1);
                counter++;
            }
        }

        //If the trusted person trusts someone else, it is not the judge and thus remove it 
        for(int i=0; i<trust.length; i++){
            for(int j=0; j<a.size(); j++){
                if(trust[i][0] == a.get(j)){
                    a.remove(j);
                    aCount.remove(j);
                }
            }
        }

        //If among the trusted people, if a person is trusted by exactly n-1 people, then that's the judge
        for(int k=0; k<a.size(); k++){
            if(aCount.get(k) == n-1){
                return a.get(k);
            }
        }

        return -1;
    }
}