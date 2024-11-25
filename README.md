# Cost-to-Go-UofT

This Java application assists users in planning their study abroad experience by connecting them to tailored university programs, flights, and accommodations. By creating an account and filling out personal information, users can discover study abroad options that match their preferences and make informed decisions about studying overseas. The program provides a seamless process from program selection to flight and accommodation booking and allows users to receive their final itinerary via email.

## Group Members

- **Alisa Iskakova** ([alisa-isk](https://github.com/alisa-isk))
- **Ariuntuya Ganbold** ([ambutsa](https://github.com/ambutsa))
- **Muhtasim Khan** ([muhtasim7](https://github.com/muhtasim7))
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

- **User Account Management**: Users create an account to store their preferences and personal details.
- **Program Filtering**: Based on provided details, the program filters and presents suitable study abroad options.
- **Sorting by Cost**: Users can sort study abroad programs by cost to find options within their budget.
- **University Selection**: After selecting a program, users are guided to resources for flights and accommodations in the university's city.
- **Flight and Accommodation Booking**: The app recommends flights and Airbnb accommodations based on user preferences.
- **Itinerary Summary and Email Option**: Users receive a comprehensive summary of their chosen university, flight, and accommodation and can choose to email the itinerary to themselves.

---

## Getting Started

### Prerequisites

1. **Java Development Kit (JDK)**: Ensure Java JDK 11 or later is installed.
2. **API Keys**: Obtain the following:
   - Airbnb API Key
   - Google Flights API Key
   - Google Mail API Key

3. **Dependencies**:
   - Libraries for JSON parsing and API calls.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/study-abroad-program-finder.git
   cd study-abroad-program-finder
   ```

2. Configure API keys:
   - Add your keys to the `config.properties` file located in the `resources` folder.

3. Update file paths:
   - In `src/main/java/usecases/AuthService.java`, change the file path to match the location of your `users.csv` file.

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

3. **Google Mail API**  
   - Sends a summary of the user's itinerary.
   - **Endpoint**: `/send`
   - **Method**: POST

> All API configurations can be updated in their respective service classes (`AirbnbService.java`, `GoogleFlightsService.java`, `GoogleMailService.java`).

---

## Usage

1. **Create an Account**:
   - Run the program and register an account.
2. **Select Programs**:
   - Browse filtered programs and sort by cost.
3. **View Accommodations and Flights**:
   - Choose options from recommended accommodations and flights.
4. **Email Itinerary**:
   - Generate and email the final itinerary for future reference.

---

## Feedback and Contributions

### Feedback

- Submit feedback via [GitHub Discussions](https://github.com/yourusername/study-abroad-program-finder/discussions).
- Include detailed suggestions or bug reports.

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

This project was developed as part of a course at the University of Toronto and is licensed under the MIT License. Redistribution or commercial use is not permitted without permission.
