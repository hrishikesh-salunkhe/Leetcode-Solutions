//PROBLEM URL: https://leetcode.com/problems/moving-average-from-data-stream/description/

class MovingAverage {

    double[] a;
    int counter = 0;
    int size;

    public MovingAverage(int size) {
        a = new double[size];
        this.size = size;
    }
    
    public double next(int val) {
        a[counter%size] = val;
        counter++;
        double summ = 0;
        for(int i=0; i<size; i++){
            summ = summ + a[i];
        }

        System.out.println(summ);
        if(counter < size){
            return (summ/(counter));
        }
        else{
            return (summ/size);
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */