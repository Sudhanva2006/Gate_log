package gatelog;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password, "ADMIN");
    }

    public boolean login(String inputUser, String inputPass) {
        return username.equals(inputUser) && password.equals(inputPass);
    }
}
