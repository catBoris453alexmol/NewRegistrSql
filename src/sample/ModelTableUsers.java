package sample;

public class ModelTableUsers {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;

    public ModelTableUsers (String id, String firstName, String lastName, String login, String password, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }
}
