
public class Iteration {
    private int digits;
    private double time1;
    private double time2;
    private double score1;
    private double score2;

    public Iteration(){

    }
    public Iteration(int d, long t, double score1, double score2){
        digits=d;
        time1=t;
        this.score1 = score1;
        this.score2 = score2;
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

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }
}
