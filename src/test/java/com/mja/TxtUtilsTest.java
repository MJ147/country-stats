package com.mja;

import com.mja.models.DataModel;
import com.mja.utils.CsvUtils;
import com.mja.utils.ModelUtils;
import com.mja.utils.TxtUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TxtUtilsTest {

    private DataModel dataModel = new DataModel();
    private CsvUtils csvUtils = new CsvUtils(dataModel);
    private String array[];
    private BufferedReader br;

    @BeforeEach
    void prepareTest() throws IOException {
        csvUtils.covertCsvToModel();
        array = new String[]{"a","b","c","d","e"};
        TxtUtils.covertListToTxt(Arrays.asList(array), "ABCDE");
        br = new BufferedReader(new FileReader("src\\main\\resources\\results.txt"));
    }

    @Test
    void convertListToTxt() throws IOException {
        Assertions.assertEquals(br.readLine(), "ABCDE: a, b, c, d, e");
    }
}

