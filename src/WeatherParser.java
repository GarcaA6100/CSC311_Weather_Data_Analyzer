import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface WeatherParser {

    WeatherRecord parse(String csvLine);

    static WeatherParser defaultParser() {
        return csvLine -> {
            String[] parts = csvLine.split(",");
            return new WeatherRecord(
                    LocalDate.parse(parts[0].trim()),
                    Double.parseDouble(parts[1].trim()),
                    Double.parseDouble(parts[2].trim()),
                    Double.parseDouble(parts[3].trim())
            );
        };
    }

    static List<WeatherRecord> fromCSV(Path csvPath) throws IOException {
        WeatherParser parser = defaultParser();
        try (var lines = Files.lines(csvPath)) {
            return lines
                    .skip(1)
                    .filter(line -> !line.isBlank())
                    .map(parser::parse)
                    .collect(Collectors.toList());
        }
    }
}
