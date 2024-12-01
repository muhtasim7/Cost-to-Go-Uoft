package use_case_rosa.universities;

import entities.User;

public interface UniversitiesUserDataAccessInterface {
    User get(String username); // returns the current user based on the username

    String getCurrentUser(); //returns the username

//    User currentUser = userDataAccess.get(userDataAccess.getCurrentUser());
}
