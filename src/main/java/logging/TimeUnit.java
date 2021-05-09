package logging;

public enum TimeUnit {

    Nano, Micro, Milli, Sec;


    public static double toTimeUnit(long time, TimeUnit unit) {
        switch (unit) {
            case Nano:
                return time;
            case Micro:
                return time / 1000.0;
            case Milli:
                return time / 1000000.0;
            case Sec:
                return time / 1000000000.0;
            default:
                return time;
        }
    }
}


