package application;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil<T> {
    final Class<T> typeParameterClass;

    public CsvUtil(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public List<T> readCsv(String filePath) {
        List<T> beans = new ArrayList<>();

        try (Reader reader = new FileReader(filePath)) {
            beans = new CsvToBeanBuilder(reader)
                    .withType(typeParameterClass)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .build()
                    .parse();

            System.out.println("READ CSV WITH TYPE " + typeParameterClass);
            beans.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return beans;
    }

    public void writeCsv(List<T> beans, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            CustomMappingStrategy<T> mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(typeParameterClass);

            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withMappingStrategy(mappingStrategy)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(';')
                    .build();

            // Write list to StatefulBeanToCsv object
            beanToCsv.write(beans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class CustomMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {
        private static final String[] HEADER = new String[]
                { "id", "Nama", "Age", "Balanced", "No 2b Thread-No", "No 3 Thread-No", "Previous Balanced",
                        "Average Balanced", "No 1 Thread-No", "Free Transfer", "No 2a Thread-No" };

        @Override
        public String[] generateHeader(T bean) {
            try {
                super.generateHeader(bean);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return HEADER;
        }
    }
}
