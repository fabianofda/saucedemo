package com.sucedemo.support.fixtures;

import java.util.HashMap;
import java.util.Map;

public class Users {

    public static class UserCredentials {
        private String username;
        private String password;

        public UserCredentials(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

    }

    private Map<String, UserCredentials> userCredentialsMap;

    public Users() {
        userCredentialsMap = new HashMap<>();
        userCredentialsMap.put("standard", new UserCredentials("standard_user", "secret_sauce"));
        userCredentialsMap.put("lockedOut", new UserCredentials("locked_out_user", "secret_sauce"));
        userCredentialsMap.put("visual", new UserCredentials("visual_user", "secret_sauce"));
        userCredentialsMap.put("usernameIsRequired", new UserCredentials("", "secret_sauce"));
        userCredentialsMap.put("passwordIsRequired", new UserCredentials("secret_user", ""));
        userCredentialsMap.put("invalidCredentials", new UserCredentials("404_user", "secret_not_found"));
    }

    public UserCredentials getStandardUserCredentials() {
        return userCredentialsMap.get("standard");
    }

    public UserCredentials getLockedOutUserCredentials() {
        return userCredentialsMap.get("lockedOut");
    }

    public UserCredentials getVisualUserCredentials() {
        return userCredentialsMap.get("visual");
    }

    public UserCredentials getUsernameIsRequired() {
        return userCredentialsMap.get("usernameIsRequired");
    }

    public UserCredentials getPasswordIsRequired() {
        return userCredentialsMap.get("passwordIsRequired");
    }

    public UserCredentials getInvalidCredentials() {
        return userCredentialsMap.get("invalidCredentials");
    }
}
