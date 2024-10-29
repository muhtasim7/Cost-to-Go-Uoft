# Cost-to-Go-Uoft

This Java application assists users in planning their study abroad experience by connecting them to tailored university programs, flights, and accommodations. By creating an account and filling out personal information, users can discover study abroad options that match their preferences and make informed decisions about studying overseas. The program provides a seamless process from program selection to flight and accommodation booking and allows users to receive their final itinerary via email.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
- [API Integrations](#api-integrations)
- [Usage](#usage)
- [License](#license)

## Features

- **User Account Management**: Users create an account to store their preferences and personal details.
- **Program Filtering**: Based on provided details, the program filters and presents suitable study abroad options.
- **Sorting by Cost**: Users can sort study abroad programs by cost to find options within their budget.
- **University Selection**: After selecting a program, users are guided to resources for flights and accommodations in the university's city.
- **Flight and Accommodation Booking**: The app recommends flights and Airbnb accommodations based on user preferences.
- **Itinerary Summary and Email Option**: Users receive a comprehensive summary of their chosen university, flight, and accommodation and can choose to email the itinerary to themselves.

## Getting Started

### Prerequisites

1. **Java Development Kit (JDK)** – Make sure to have Java JDK 11 or later installed.
2. **API Keys** – Obtain API keys for:
   - Airbnb API (accommodation data)
   - Google Flights API (flight data)
   - Google Mail API (emailing itinerary)

3. **Dependencies** – The APIs might require specific libraries for API calls, JSON handling, etc.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/study-abroad-program-finder.git
   cd study-abroad-program-finder
   ```

2. Configure API keys in `config.properties`:
   - Airbnb API Key
   - Google Flights API Key
   - Google Mail API Key

   Add these keys in the `config.properties` file located in the `resources` folder.

### Running the Program


## API Integrations

This project integrates with the following APIs to provide a full-service experience for users:

1. **Airbnb API**  
   Provides data on available accommodations in the program's city. Users can browse accommodation options based on preferences (e.g., cost, proximity to campus).  

2. **Google Flights API**  
   Supplies information on available flights from the user’s location to the university city. It filters flights to recommend the best options based on the user's preferences.  

3. **Google Mail API**  
   Allows users to email the final itinerary (university, flight, accommodation details) to their own email address, providing a convenient summary.  

### API Integration Guide

#### Airbnb API
- **Endpoint**: `/locations/search`
- **Method**: GET
- **Usage**: Retrieves a list of accommodations based on the university city and user preferences.
- **Note**: Configure the Airbnb API settings in `AirbnbService.java`.

#### Google Flights API
- **Endpoint**: `/search`
- **Method**: GET
- **Usage**: Fetches flight options based on the user’s starting location and destination.
- **Note**: Set up the API credentials in `GoogleFlightsService.java`.

#### Google Mail API
- **Endpoint**: `/send`
- **Method**: POST
- **Usage**: Sends an email with the user’s itinerary details to the user’s specified email address.
- **Note**: Configure API keys and email settings in `GoogleMailService.java`.

## User story

1. **Create an Account**: Register an account and fill in personal details. - Alisa 
2. **Select and Sort Program**: View and filter study abroad programs based on suitability. - Muhtasim 
3. **Google Flight API call**: Calling the Google Flight API and giving the user a list of options to choose from - Sanyukta
4. **Accommodations**: Call the AIRBNB API and give the user a list of options to choose from - Rosa 
5. **Email Itinerary**: Review the final summary and email it for easy reference. - Ariuntuya

## Branch Protection Guidelines
- All code changes to the `main` branch must go through a pull request.
- Each pull request must have at least one approval from another team member before merging.
- Remember to keep the `main` branch protected by following these guidelines.


## License
This project was developed as part of a course at the University of Toronto and is intended solely for educational purposes. Redistribution or commercial use of the code is not permitted without permission.

This project is licensed under the MIT License. See the LICENSE file for more details.
