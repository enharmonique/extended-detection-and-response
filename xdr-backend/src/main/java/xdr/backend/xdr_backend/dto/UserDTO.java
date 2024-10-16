package xdr.backend.xdr_backend.dto;

public class UserDTO {
    private String username;
    private String password;

    public UserDTO() {}

    public UserDTO(String username, String password) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
