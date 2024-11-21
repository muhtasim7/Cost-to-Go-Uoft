package data_access;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import entities.User;
import entities.UserFactory;
import usecases.change_password.ChangePasswordUserDataAccessInterface;
import usecases.login.LoginUserDataAccessInterface;
import usecases.signup.SignupUserDataAccessInterface;

/**
 * DAO for user data implemented using a File to persist the data.
 */
public class FileUserDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface,
        ChangePasswordUserDataAccessInterface {

    private static final String HEADER = "username,password,gpa,degree,program,language,email";

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, User> accounts = new HashMap<>();

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("gpa", 2);
        headers.put("degree", 3);
        headers.put("program", 4);
        headers.put("language", 5);
        headers.put("email", 6);

        if (csvFile.length() == 0) {
            save();
        }
        else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                final String header = reader.readLine();

                if (!header.equals(HEADER)) {
                    throw new RuntimeException(String.format("header should be%n: %s%but was:%n%s", HEADER, header));
                }

                String row;
                while ((row = reader.readLine()) != null) {
                    final String[] col = row.split(",");
                    final String username = String.valueOf(col[headers.get("username")]);
                    final String password = String.valueOf(col[headers.get("password")]);
                    final String gpa = String.valueOf(col[headers.get("gpa")]);
                    final String degree = String.valueOf(col[headers.get("degree")]);
                    final String program = String.valueOf(col[headers.get("program")]);
                    final String language = String.valueOf(col[headers.get("language")]);
                    final String email = String.valueOf(col[headers.get("email")]);
                    final User user = userFactory.create(username, password, gpa, degree, program,language, email);
                    accounts.put(username, user);
                }
            }
        }
    }

    private void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                        user.getName(),
                        user.getPassword(),
                        user.getGpa() != null ? user.getGpa() : "",
                        user.getDegreeType() != null ? user.getDegreeType() : "",
                        user.getProgram() != null ? user.getProgram() : "",
                        user.getLanguage() != null ? user.getLanguage() : "",
                        user.getEmail());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public void save(User user) {
        accounts.put(user.getName(), user);
        this.save();
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    @Override
    public void setCurrentUser(String name) {

    }

    @Override
    public String getCurrentUser() {
        return "";
    }

    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public void changePassword(User user) {
        // Replace the User object in the map
        accounts.put(user.getName(), user);
        save();
    }
}