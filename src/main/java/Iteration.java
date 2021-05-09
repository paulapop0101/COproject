

public class Iteration {
    private int digits;
    private long time;
    public Iteration(){

    }
    public Iteration(int d, long t){
        digits=d;
        time=t;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }
    public int getDigits() {
        return digits;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
