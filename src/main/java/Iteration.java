

public class Iteration {
    private int digits;
    private double time1;
    private double time2;

    public Iteration(){

    }
    public Iteration(int d, long t){
        digits=d;
        time1=t;
    }
    public void setDigits(int digits) {
        this.digits = digits;
    }
    public int getDigits() {
        return digits;
    }
    public double getTime1() {
        return time1;
    }
    public void setTime1(double time) {
        this.time1 = time;
    }
    public double getTime2() {
        return time2;
    }
    public void setTime2(double time2) {
        this.time2 = time2;
    }

}
