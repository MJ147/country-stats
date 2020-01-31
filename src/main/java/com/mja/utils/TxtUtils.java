package com.mja.utils;

import java.io.*;
import java.util.List;
import java.util.StringJoiner;

public class TxtUtils {

    private static boolean isFirstUseOfMethod = true;

    public static void covertListToTxt(List<String> list, String listName) throws IOException {

        StringJoiner listInString = new StringJoiner(", ", listName + ": ", "");
        for (String s : list) {
            listInString.add(s);
        }
        String path = "src\\main\\resources\\results.txt";

        File file = new File(path);

        FileWriter fw = new FileWriter(path, !isFirstUseOfMethod);
        isFirstUseOfMethod = false;
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter writer = new PrintWriter(bw);
        writer.println(listInString);
        writer.close();
    }
}
