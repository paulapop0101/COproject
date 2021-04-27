package bench.CPU;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import timer.Timer;
import logging.TimeUnit;

import java.io.IOException;

public class DigitsOfPi  {

        private static final int SCALE = 10000;
    private static final int ARRINIT = 2000;

    public static void Digits(int digits){

        StringBuffer pi = new StringBuffer();
        int[] arr = new int[digits + 1];
        int carry = 0;

        for (int i = 0; i <= digits; ++i)
            arr[i] = ARRINIT;

        for (int i = digits; i > 0; i-= 14) {
            int sum = 0;
            for (int j = i; j > 0; --j) {
                sum = sum * j + SCALE * arr[j];
                arr[j] = sum % (j * 2 - 1);
                sum /= j * 2 - 1;
            }

            pi.append(String.format("%04d", carry + sum / SCALE));
            carry = sum % SCALE;
        }
        //System.out.println( pi.toString());

    }
}
