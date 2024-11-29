# Cost-to-Go-UofT

## Summary

Cost-to-Go-UofT is a comprehensive tool designed to assist users in planning their study abroad experience. The tool not only helps users find a suitable university program but also provides recommendations for flights and accommodations. Users can receive a final itinerary summarizing all the relevant information to simplify their study abroad journey.

The idea for this application originated from feedback regarding the University of Toronto's study abroad page, which many users found condensed and unhelpful. It failed to provide a complete picture, such as details about rental and flight costs. Cost-to-Go-UofT addresses these gaps by offering an end-to-end solution.

---

## Group Members

- **Muhtasim Khan** ([muhtasim7](https://github.com/muhtasim7))
- **Alisa Iskakova** ([alisa-isk](https://github.com/alisa-isk))
- **Ariuntuya Ganbold** ([ambutsa](https://github.com/ambutsa))
- **Sanyukta Negi** ([sanyuktanegi](https://github.com/sanyuktanegi))
- **Rosa Martinez** ([rosamartinezz](https://github.com/rosamartinezz))

---

## Table of Contents

1. [Features](#features)
2. [Getting Started](#getting-started)
3. [API Integrations](#api-integrations)
4. [Usage](#usage)
5. [Feedback and Contributions](#feedback-and-contributions)
6. [License](#license)

---

## Features

- **User Account Management**: Users can create an account to store preferences and personal details.
  ![Signup page](docs/images/signup_page.png)
  ![Signup page](docs/images/login_page.png)
- **University Selection**: Provides resources for flights and accommodations in the university's city.
- **Flight**: Recommends flights tailored to the user's preferences
- **Accommodation Booking**:  Airbnb accommodations tailored to the user's preferences.
  ![Airbnb page](docs/images/airbnb_page.png)
- **Itinerary Summary**: Generates a comprehensive itinerary.

---

## Getting Started

### Prerequisites

1. **Java Development Kit (JDK)**: Ensure Java JDK 11 or later is installed.
2. **API Keys**: Obtain the following:
   - Airbnb API Key
   - Google Flights API Key
   - Ninja API Key for Airport Codes
3. **Dependencies**:
   - Libraries for JSON parsing, API calls, and HTTP requests.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/study-abroad-program-finder.git
   cd study-abroad-program-finder
   ```

2. Configure API keys:
   - Add your keys to the `config.properties` file located in the `resources` folder.

3. Update file paths (if on Windows):
   - Modify the file path in `app.MainWithFile` (line 64):
     ```java
     final FileUserDataAccessObject userDataAccessObject = 
         new FileUserDataAccessObject("C:\\Users\\YourUsername\\path\\to\\users.csv");
     ```
   ![Change user filePath](docs/images/Change_user_file.png)
   - Modify the file path in `data_access.airbnb` (line 20):
     ```java
     private static final String FILE_PATH = 
         "C:\\Users\\YourUsername\\path\\to\\jsonformatter.txt";
     ```
   ![Change jsonformatter filePath](docs/images/Change_jasonformatter_filepath.png)

4. Run the program:
   - Open the project in an IDE (e.g., IntelliJ IDEA).
   - Execute the main class.

---

## API Integrations

1. **Airbnb API**
   - Retrieves accommodation options based on user preferences.
   - **Endpoint**: `/locations/search`
   - **Method**: GET

2. **Google Flights API**
   - Provides flight options for selected destinations.
   - **Endpoint**: `/search`
   - **Method**: GET

3**AirportCode API**
   - Serves as a helper function for the Google Flights API by retrieving airport codes (IATA) for a given city name.
   - **Endpoint**: `/airports?name=<city>`
   - **Method**: GET
   - **Implementation**:
      - This feature ensures that users can search for flights using the correct IATA airport codes, enhancing the reliability of the flight recommendation process.

> All API configurations can be updated in their respective service classes (`AIRBNB.java`, `FLIGHT.java`, `AirportCode.java`).

---

## Usage

1. **Create an Account**:
   - Register and provide personal details.
   ![Signup page](docs/images/signup_page.png)
   ![Signup page](docs/images/login_page.png)
2. **Select Programs**:
   - Browse filtered programs and sort them by cost.
3. **View Accommodations and Flights**:
   - Choose accommodations 
4. **Flights from the recommended options:**:
   - Choose flights
   ![Airbnb page](docs/images/airbnb_page.png)
5. **Itinerary**:
   - Generate the final itinerary.

---

## Technical Details

- **Java Version**: Requires JDK 11 or higher.
- **Required Packages**:
   - OkHttp for HTTP requests.
   - JSON libraries for parsing API responses.
- **Platform-Specific Instructions**:
   - Update file paths if running on Windows as detailed in the [Getting Started](#getting-started) section.

---

## Feedback and Contributions

### Feedback

- Submit feedback via [GitHub Discussions](https://github.com/yourusername/study-abroad-program-finder/discussions).

### Contributions

1. Fork the repository:
   ```bash
   git fork https://github.com/yourusername/study-abroad-program-finder.git
   ```

2. Create a branch for your changes:
   ```bash
   git checkout -b feature-name
   ```

3. Submit a pull request:
   - Ensure your changes are well-documented and tested.

---

## License

This project is licensed under the MIT License.

---