package utility;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * How to use:
 *
 * You can use it in any method like this:
 * <code>Timer.start();<code/>
 * ----YOUR_LOGIC_HERE----
 * <code>Timer.stop();<code/>
 * <code>Timer.print();<code/>
 */
public class Timer {
    static StopWatch watch = new StopWatch();

    public static void print(StopWatch watch) {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
        String methodName = e.getMethodName();
        System.out.println("Method: " + methodName + " execution time is: " + watch.getTime(TimeUnit.MILLISECONDS)+ " "+ TimeUnit.MILLISECONDS.name());
    }

    public static void print(StopWatch watch, TimeUnit unit) {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
        String methodName = e.getMethodName();
        System.out.println("Method: " + methodName + " execution time is: " + watch.getTime(unit) + " "+ unit.name());
    }

    public static void print() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
        String methodName = e.getMethodName();
        System.out.println("Method: " + methodName + " execution time is: " + watch.getTime(TimeUnit.MILLISECONDS) +" "+ TimeUnit.MILLISECONDS.name());
    }

    public static void print(TimeUnit unit) {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
        String methodName = e.getMethodName();
        System.out.println("Method: " + methodName + " execution time is: " + watch.getTime(unit)+ " "+ unit.name());
    }

    public static void start() {
        watch.reset();
        watch.start();
    }

    public static void stop() {
        watch.stop();
    }
}
