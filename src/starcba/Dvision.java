package starcba;

import static java.lang.Math.abs;

public class Dvision {

    public  double divide(double x, double y)
    {

        if (y == 0) {
            return Double.MAX_VALUE;		// return infinity
        }


        double left = 0.0, right = Double.MAX_VALUE;

        // set accuracy of the result
        double precision = 0.001;

        // store sign of the result
        int sign = 1;
        if (x * y < 0) {
            sign = -1;
        }

        // make both input numbers positive
        x = abs(x);
        y = abs(y);

        while (true) {
            // calculate mid
            double mid = (left +right)/2;

            // if y*mid is almost equal to x, return mid
            if (abs(y * mid - x) <= precision) {
                return mid * sign;
            }else

            // if y*mid is less than x, update left to mid
            if (y * mid < x) {
                left = mid;
            }
            else {
                // if y*mid is more than x, update right to mid
                right = mid;
            }
        }
}}
