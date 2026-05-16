# Weather Data Analyzer

A command-line Java application that parses weather CSV data and performs
statistical analysis using modern Java features from Java 15 to Java 23.

---

## Features

- Parse weather data (temperature, humidity, precipitation) from a CSV file
- Calculate average temperature for a specific month
- List days above a temperature threshold
- Count rainy days
- Classify days using an enhanced switch expression (Hot / Warm / Cool / Cold / Freezing)
- Group and summarize days by weather category

---

## Modern Java Features Used

| Feature | Java Version | Used In |
|---|---|---|
| Records | Java 16 | `WeatherRecord` |
| Enhanced switch with pattern matching | Java 21 | `WeatherRecord.category()` |
| Text Blocks | Java 15 | `WeatherReporter`, `Main` |
| String.stripIndent() | Java 15 | `WeatherReporter` |
| Lambdas and Streams | Java 8+ | `WeatherAnalyzer`, `WeatherParser` |
| var local type inference | Java 10+ | `WeatherParser` |
| Markdown Javadoc | Java 18+ | All files |
| Functional Interfaces | Java 8+ | `WeatherParser` |

No explicit classes are used. The design uses only record, interface, and functional constructs.

---

## Project Structure