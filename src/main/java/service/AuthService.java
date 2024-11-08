package service;

import model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private static final String FILE_PATH = "C:\\Users\\muhta\\OneDrive\\Desktop\\UofT\\csc20\\Uoft-to-go\\Cost-to-Go-Uoft\\Data\\users.csv";// update this line with actual file path

    public boolean signUp(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(user.getUsername() + "," + user.getPassword());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
