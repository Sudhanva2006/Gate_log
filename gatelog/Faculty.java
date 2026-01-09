package gatelog;

public class Faculty extends User {

    public Faculty(String username, String password) {
        super(username, password, "FACULTY");
    }

    public boolean login(String inputUser, String inputPass) {
        return username.equals(inputUser) && password.equals(inputPass);
    }
}
