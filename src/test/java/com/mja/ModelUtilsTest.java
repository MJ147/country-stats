package com.mja;

import com.mja.models.DataModel;
import com.mja.utils.CsvUtils;
import com.mja.utils.ModelUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class ModelUtilsTest {

        private DataModel dataModel = new DataModel();
        private CsvUtils csvUtils = new CsvUtils(dataModel);
        private ModelUtils modelUtils = new ModelUtils(dataModel);

        @BeforeEach
        void prepareTest() throws IOException {
            csvUtils.covertCsvToModel();
        }

        @Test
        void findCountriesWithHappinessGreatestThenInPolandTest() {
            List<String> list = modelUtils.findCountriesWithHappinessGreatestThenInPoland();
            Assertions.assertEquals(list.get(3), "Iceland");
        }

        @Test
        void findCountriesWithGreatestFreedomTest() {
            String list[] = modelUtils.findCountriesWithGreatestFreedom();
            Assertions.assertEquals(list[2], "Norway");
        }

        @Test
        void findCountriesWithLowestCorruptionTest() {
            String list[] = modelUtils.findCountriesWithLowestCorruption();
            Assertions.assertEquals(list[3], "Finland");
        }

        @Test
        void findCountriesWithGreatestCorruptionTest() {
            List<String> list = modelUtils.findCountriesWithGreatestCorruption();
            Assertions.assertEquals(list.get(4), "Kosovo");
        }

}


