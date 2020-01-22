package com.example.flickr_mvvm_architectural_component.utils;

import java.io.InputStream;
import java.io.OutputStream;

import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;

import com.example.flickr_mvvm_architectural_component.R;

/**
 * Created by Mohit on 25/08/18.
 */
public class Utils {
    public static void copyStream(InputStream is, OutputStream os) {
        final int buffer_size = 1024;
        try {
            byte[] bytes = new byte[buffer_size];
            for (; ; ) {
                int count = is.read(bytes, 0, buffer_size);
                if (count == -1)
                    break;
                os.write(bytes, 0, count);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Spannable getStyledText(Resources resources, String query) {

        String searchQuery = resources.getString(R.string.results_string) + " " + query;
        Spannable spannable = new SpannableString(searchQuery);
        int color = resources.getColor(android.R.color.holo_blue_dark);

        int end = searchQuery.indexOf(query) + query.length();
        spannable.setSpan(new ForegroundColorSpan(color), searchQuery.indexOf(query), end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new RelativeSizeSpan(1.2f), searchQuery.indexOf(query), end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }
}
