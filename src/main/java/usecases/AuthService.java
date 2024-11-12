//package usecases;
//
//import entities.User;
//import java.io.*;
//public class AuthService {
//    private static final String FILE_PATH = "C:\\Users\\muhta\\OneDrive\\Desktop\\UofT\\csc20\\Uoft-to-go\\Cost-to-Go-Uoft\\Data\\users.csv";// update this line with actual file path
//
//    /**
//     * This is used to input the new user's data into the databse
//     * @param user the new user's object which has their user_name and password
//     * @return true if successful else false
//     */
//    public boolean signUp(User user) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true)))
//        {
//            writer.write(user.getUsername() + "," + user.getPassword());
//            writer.newLine();
//            return true;
//        }
//        catch (IOException e)
//        {
//            return false;
//        }
//    }
//
//    /**
//     * This simply checks if the user_name and password exists in the database.
//     * @param username the username of the user logging in.
//     * @param password the password of the user loggin in.
//     * @return True if successful else false
//     */
//    public boolean login(String username, String password) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH)))
//        {
//            String line;
//            while ((line = reader.readLine()) != null)
//            {
//                String[] credentials = line.split(",");
//                if (credentials[0].equals(username) && credentials[1].equals(password)) {
//                    return true;
//                }
//            }
//        }
//        catch (IOException e)
//        {
//            return false;
//        }
//        return false;
//    }
//}
