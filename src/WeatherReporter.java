import java.util.List;
import java.util.Map;

public interface WeatherReporter {

    static void printFullReport(List<WeatherRecord> records, int month, double threshold) {
        double avgTemp = WeatherAnalyzer.averageTemperatureForMonth(records, month);
        List<WeatherRecord> hotDays = WeatherAnalyzer.daysAboveThreshold(records, threshold);
        long rainyDays = WeatherAnalyzer.countRainyDays(records);
        Map<String, Long> categories = WeatherAnalyzer.summarizeByCategory(records);

        String header = """
                +======================================+
                |    WEATHER DATA ANALYZER REPORT      |
                +======================================+
                """;

        System.out.println(header);

        String monthName = java.time.Month.of(month).getDisplayName(
                java.time.format.TextStyle.FULL, java.util.Locale.ENGLISH);

        String summary = """
                Analysis Parameters
                -------------------
                    Month Analyzed : %s
                    Threshold      : %.1f C
                    Total Records  : %d
                """.formatted(monthName, threshold, records.size());

        System.out.println(summary);

        String tempSection = """
                Temperature Analysis
                --------------------
                    Avg Temp (%s) : %.2f C
                    Days Above %.0f C : %d day(s)
                """.formatted(monthName, avgTemp, threshold, hotDays.size());

        System.out.println(tempSection);

        String rainSection = """
                Precipitation
                -------------
                    Rainy Days : %d day(s)
                """.formatted(rainyDays);

        System.out.println(rainSection);

        System.out.println("Days by Weather Category");
        System.out.println("------------------------");
        categories.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> {
                    String bar = "#".repeat(e.getValue().intValue());
                    System.out.printf("    %-10s %s (%d)%n", e.getKey(), bar, e.getValue());
                });

        System.out.println();

        if (!hotDays.isEmpty()) {
            String hotHeader = """
                    Days Above Threshold (%.1f C)
                    ------------------------------
                    """.formatted(threshold).stripIndent();
            System.out.print(hotHeader);
            hotDays.forEach(r ->
                    System.out.printf("    %s  ->  %.1f C  [%s]  %.1f mm%n",
                            r.date(), r.temperature(), r.category(), r.precipitation())
            );
            System.out.println();
        }

        String footer = """
                +======================================+
                  Report complete. Total days: %d
                +======================================+
                """.formatted(records.size());

        System.out.println(footer);
    }
}
