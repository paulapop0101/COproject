package timer;

public class Timer {
    long start;
    long end;
    long pause=0;

    public void start(){
        start=System.nanoTime();
    }
    public long pause(){
        pause+=System.nanoTime()-start;
        return pause;
    }

    public void resume(){
        start();
    }

    public long stop(){
        end=System.nanoTime();
        return end-start+pause;
    }
}
