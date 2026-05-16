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
| `String.stripIndent()` | Java 15 | `WeatherReporter` |
| Lambdas and Streams | Java 8+ | `WeatherAnalyzer`, `WeatherParser` |
| `var` local type inference | Java 10+ | `WeatherParser` |
| Markdown Javadoc | Java 18+ | All files |
| Functional Interfaces (`@FunctionalInterface`) | Java 8+ | `WeatherParser` |

> No explicit classes are used. The design leverages only `record`, `interface`, and functional constructs.

---

## Project Structure

```
CSC311_Mod4_WeatherDataAnalyzer/
├── data/
│   └── Weather.csv
├── src/
│   ├── Main.java
│   ├── WeatherAnalyzer.java
│   ├── WeatherParser.java
│   ├── WeatherRecord.java
│   └── WeatherReporter.java
└── README.md
```

---

## CSV File Format

The application reads from `data/Weather.csv`. The file must follow this format:

```
date,temperature,humidity,precipitation
2024-07-01,28.5,65.0,0.0
2024-07-02,22.3,70.0,5.2
2024-07-03,15.0,80.0,12.1
```

| Column | Type | Description |
|---|---|---|
| `date` | `YYYY-MM-DD` | The date of the record |
| `temperature` | `double` | Temperature in Celsius |
| `humidity` | `double` | Humidity percentage |
| `precipitation` | `double` | Precipitation in millimeters |

---

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/GarcaA6100/CSC311_Weather_Data_Analyzer.git
   ```

2. **Open the project in IntelliJ IDEA**

3. **Ensure you are using Java 21 or later**

4. **Make sure `data/Weather.csv` exists** in the project root (see format above)

5. **Run `Main.java`**

---

## Sample Output

```
+======================================+
|    WEATHER DATA ANALYZER REPORT      |
+======================================+

Analysis Parameters
-------------------
    Month Analyzed : July
    Threshold      : 25.0 C
    Total Records  : 365

Temperature Analysis
--------------------
    Avg Temp (July) : 29.14 C
    Days Above 25 C : 18 day(s)

Precipitation
-------------
    Rainy Days : 87 day(s)

Days by Weather Category
------------------------
    Cold       ## (2)
    Cool       ####### (7)
    Hot        ########## (10)
    Warm       ################## (18)

Days Above Threshold (25.0 C)
------------------------------
    2024-07-01  ->  28.5 C  [Hot]  0.0 mm
    2024-07-04  ->  31.2 C  [Hot]  2.3 mm
    ...

+======================================+
  Report complete. Total days: 365
+======================================+
```

---

## Weather Categories

Categories are determined by the enhanced `switch` expression in `WeatherRecord.category()`:

| Category | Temperature Range |
|---|---|
| Freezing | Below 0°C |
| Cold | 0°C – 9°C |
| Cool | 10°C – 17°C |
| Warm | 18°C – 25°C |
| Hot | Above 25°C |

---

## Design Decisions

- **No explicit classes** — all types are either `record` or `interface`
- **`WeatherParser`** is a `@FunctionalInterface`, allowing it to be used as a lambda
- **`WeatherAnalyzer`** and **`WeatherReporter`** are interfaces with only `static` methods, replacing utility classes
- **`WeatherRecord`** is a Java `record`, providing immutable data with auto-generated constructors, getters, `equals`, and `hashCode`
- **Streams and lambdas** handle all data processing — no explicit loops

---

## Author

Ana Garcia — CSC311, Module 4  
[GitHub: GarcaA6100](https://github.com/GarcaA6100)
