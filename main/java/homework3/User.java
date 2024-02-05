package homework3;

public class User {

    String name;
    String password;
    boolean isAuthenticate = false;
    boolean isAdmin = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        this.isAuthenticate = this.name.equals(name) && this.password.equals(password);
        return this.isAuthenticate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (isAuthenticate != user.isAuthenticate) return false;
        if (isAdmin != user.isAdmin) return false;
        if (!name.equals(user.name)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (isAuthenticate ? 1 : 0);
        result = 31 * result + (isAdmin ? 1 : 0);
        return result;
    }
}