package usecases.change_password;

import entities.User;

/**
 * The interface of the DAO for the Change Password Use Case.
 */
public interface ChangePasswordUserDataAccessInterface {

    /**
     * Updates the system to record this user's updated information.
     *
     * @param user the user whose information is to be updated
     */

    void changeInformation(User user);

}