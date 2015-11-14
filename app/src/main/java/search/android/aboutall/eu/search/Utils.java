package search.android.aboutall.eu.search;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Utils {

    public static Set<String> loadWords(Context context) throws IOException {
        final Resources resources = context.getResources();
        InputStream inputStream = resources.openRawResource(R.raw.wordlist);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        Set<String> result = new HashSet<>();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() < 1) continue;
                result.add(line);
            }
        } finally {
            reader.close();
        }

        return result;
    }

}