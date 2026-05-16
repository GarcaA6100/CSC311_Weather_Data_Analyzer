import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Path csvPath = Path.of("data/weather.csv");
            List<WeatherRecord> records = WeatherParser.fromCSV(csvPath);

            int month = 7;           // Analyze July
            double threshold = 25.0; // Days above 25 C

            WeatherReporter.printFullReport(records, month, threshold);

        } catch (Exception e) {
            String errorMsg = """
                    Error loading weather data:
                        %s

                    Make sure 'data/weather.csv' exists and is formatted as:
                        date,temperature,humidity,precipitation
                        2024-07-01,28.5,65.0,0.0
                    """.formatted(e.getMessage());
            System.err.println(errorMsg);
        }
    }
}

