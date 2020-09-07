package utility;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

public class Timer {
    static StopWatch watch = new StopWatch();

    public static void printTime(StopWatch watch) {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
        String methodName = e.getMethodName();
        System.out.println("Method: " + methodName + " execution time is: " + watch.getTime(TimeUnit.MILLISECONDS)+ " "+ TimeUnit.MILLISECONDS.name());
    }

    public static void printTime(StopWatch watch, TimeUnit unit) {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
        String methodName = e.getMethodName();
        System.out.println("Method: " + methodName + " execution time is: " + watch.getTime(unit) + " "+ unit.name());
    }

    public static void printTime() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
        String methodName = e.getMethodName();
        System.out.println("Method: " + methodName + " execution time is: " + watch.getTime(TimeUnit.MILLISECONDS) +" "+ TimeUnit.MILLISECONDS.name());
    }

    public static void printTime(TimeUnit unit) {
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
