import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface WeatherAnalyzer {

    static double averageTemperatureForMonth(List<WeatherRecord> records, int month) {
        OptionalDouble avg = records.stream()
                .filter(r -> r.date().getMonthValue() == month)
                .mapToDouble(WeatherRecord::temperature)
                .average();
        return avg.orElse(Double.NaN);
    }

    static List<WeatherRecord> daysAboveThreshold(List<WeatherRecord> records, double threshold) {
        Predicate<WeatherRecord> aboveThreshold = r -> r.temperature() > threshold;
        return records.stream()
                .filter(aboveThreshold)
                .collect(Collectors.toList());
    }

    static long countRainyDays(List<WeatherRecord> records) {
        return records.stream()
                .filter(WeatherRecord::isRainy)
                .count();
    }

    static Map<String, Long> summarizeByCategory(List<WeatherRecord> records) {
        return records.stream()
                .collect(Collectors.groupingBy(WeatherRecord::category, Collectors.counting()));
    }
}

