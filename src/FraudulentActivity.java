import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class FraudulentActivity {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] exp, int d) {
        int[] counts = new int[201];
        for(int i=0; i<d; i++){
            counts[exp[i]]++;
        }

        int l = (int)Math.floor((d-1)/2.0f);
        int r = (int)Math.ceil((d-1)/2.0f);

        int notifCount = 0;
        for(int offset = d; offset < exp.length; offset++){
            int lval=0,rval=0;
            for(int i=0,m=0; m <= l; m+=counts[i], i++) lval = i;
            for(int i=0,m=0; m <= r; m+=counts[i], i++) rval = i;

            double median = (lval + rval) / 2.0f;
            if(exp[offset] >= median*2){
                notifCount++;
            }

            counts[exp[offset-d]]--;
            counts[exp[offset]]++;
        }

        return notifCount;


    }
}
