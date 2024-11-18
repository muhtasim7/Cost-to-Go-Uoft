package usecases;

import entities.User;
import java.io.*;
public class AuthService {
    private static final String FILE_PATH = "\\Users\\alisa.isk\\IdeaProjects\\Cost-to-Go-Uoft\\Data\\users.csv";// update this line with actual file path

    /**
     * This is used to input the new user's data into the databse
     * @param user the new user's object which has their user_name and password
     * @return true if successful else false
     */
    public boolean signUp(User user) {
        if (userExists(user.getUsername()) || user.getUsername() == null || user.getPassword() == null) {
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true)))
        {
            writer.write(user.getUsername() + "," + user.getPassword());
            writer.newLine();
            return true;
        }
        catch (IOException e)
        {
            return false;
        }
    }

    /**
     * Helper method to check if a user with the given username already exists in the database.
     * @param username the username to check.
     * @return true if the user exists, false otherwise.
     */
    private boolean userExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials[0].equals(username)) {
                    return true; // User exists
                }
            }
        } catch (IOException e) {
            // Handle error if necessary
        }
        return false; // User does not exist
    }



    /**
     * This simply checks if the user_name and password exists in the database.
     * @param username the username of the user logging in.
     * @param password the password of the user loggin in.
     * @return True if successful else false
     */
    public boolean login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] credentials = line.split(",");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
        }
        catch (IOException e)
        {
            return false;
        }
        return false;
    }
}
