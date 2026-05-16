import java.time.LocalDate;

public record WeatherRecord(
        LocalDate date,
        double temperature,
        double humidity,
        double precipitation
) {

    public String category() {
        Integer temp = (int) temperature;
        return switch (temp) {
            case Integer i when i < 0  -> "Freezing";
            case Integer i when i < 10 -> "Cold";
            case Integer i when i < 18 -> "Cool";
            case Integer i when i < 26 -> "Warm";
            default                    -> "Hot";
        };
    }

    public boolean isRainy() {
        return precipitation > 0.0;
    }
}

