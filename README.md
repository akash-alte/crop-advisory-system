CROP ADVISORY SYSTEM USING JAVA

Project purpose

A beginner-friendly, menu-driven Java application that gives rule-based crop
suggestions using four inputs:

1. Soil type
2. Soil pH
3. Macronutrient indicator percentage
4. Season (Kharif, Rabi, or Zaid)

The application checks all rules for the selected season. It does not force a
recommendation: if no crop matches all conditions, it clearly reports that no
suitable crop was found.

How to run

1. Install a JDK (Java 8 or later).
2. Extract this ZIP.
3. Open Command Prompt/Terminal in this folder.
4. Compile:
javac \*.java
5. Run:
java Main

Menu

1. Get crop recommendations
2. View crop list by season
3. View saved history
4. Exit

Input validation

* Soil type: select a number from 1 to 6.
* pH: any numeric value from 0 to 14.
* Macronutrient indicator percentage: any numeric value from 0 to 100.
* Season: select a number from 1 to 3.
* Text, out-of-range values, NaN and Infinity are rejected and re-prompted.

Fertility groups

* Low: 0 to 33%
* Medium: above 33 to 66%
* High: above 66 to 100%

Crops and simplified rules

Kharif: Rice, Maize, Cotton
Rabi: Wheat, Chickpea, Mustard
Zaid: Watermelon, Cucumber, Green Gram (Moong)

Each crop has its own accepted soil types, pH range, and fertility groups.
Chickpea and Green Gram allow all three fertility groups in this project.

Important limitation

This is an educational rule-based demonstration, not a scientifically validated
farm decision system. The percentage is a simplified combined macronutrient
indicator, not a laboratory measurement of nitrogen, phosphorus, and potassium.
Real recommendations depend on separate N, P and K soil-test values, crop
variety, irrigation, climate, local region and agricultural extension guidance.
The soil/pH/fertility rules are simplified for demonstrating Java concepts and
should not be used as real-world agronomic advice.

OOP and rubric mapping

* Encapsulation: SoilData and Crop use private fields and public methods.
* Interface: CropAdvisor defines a common set of advisor operations.
* Abstraction: SeasonalAdvisor is an abstract base class.
* Inheritance: KharifAdvisor, RabiAdvisor and ZaidAdvisor extend SeasonalAdvisor.
* Polymorphism: Main stores all season advisors as CropAdvisor references and
calls the same methods on different implementations.
* File handling: FileManager appends history with FileWriter/BufferedWriter and
reads it with FileReader/BufferedReader.
* Exception handling: file errors and invalid numeric input are handled.



Test cases

1. Alluvial, pH 6.5, 50%, Kharif -> Rice, Maize, Cotton.
2. Black, pH 7.0, 20%, Rabi -> Chickpea.
3. Sandy, pH 6.5, 50%, Kharif -> No suitable crop found.
4. Black, pH 7.0, 90%, Rabi -> Chickpea.
5. Clayey, pH 6.5, 50%, Zaid -> No suitable crop found.
6. Enter pH 15 -> program asks again.
7. Enter percentage -5 or 101 -> program asks again.
8. Enter "abc" for a numeric field -> program asks again.

The project uses no external libraries.



Team

\- Akash Alte

\- Chaitanya Jadhav

\- Ashish Hasure



Built as a group project at PCCOE Pune, B.Tech IT.

