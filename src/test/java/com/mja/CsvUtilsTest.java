package com.mja;

import com.mja.models.DataModel;
import com.mja.utils.CsvUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CsvUtilsTest {

    private DataModel dataModel = new DataModel();
    private CsvUtils csvUtils = new CsvUtils(dataModel);

    @Test
    void convertCsvToModelTest() throws IOException {
        csvUtils.covertCsvToModel();
        Assertions.assertEquals(dataModel.getCountries().get(57).getName(), "Japan");
    }
}
