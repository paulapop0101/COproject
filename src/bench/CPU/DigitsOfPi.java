package bench.CPU;
import timer.Timer;
import logging.TimeUnit;

public class DigitsOfPi {
    public static void main(String [] args){
        Timer timer=new Timer();
        timer.start();
        System.out.println("3.14");
        System.out.println("15");
        long p=timer.pause();
        System.out.println(p);
        int t=0;
        timer.resume();
        for(int i=0;i<100;i++) t++;
        long end=timer.stop();
        System.out.println(end);
        TimeUnit timeUnit=TimeUnit.Sec;
        double ti=timeUnit.toTimeUnit(end,timeUnit);
        System.out.println(ti);
    }
}
