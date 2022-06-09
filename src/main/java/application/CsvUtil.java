package application;

import com.opencsv.bean.CsvToBeanBuilder;
import domain.AccountBeforeEod;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil<T> {
    final Class<T> typeParameterClass;

    public CsvUtil(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public List<T> readCsv(String filePath) {
        List<T> beans = new ArrayList<>();

        try {
            beans = new CsvToBeanBuilder(Files.newBufferedReader(Paths.get(filePath)))
                    .withType(typeParameterClass)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return beans;
    }
}
