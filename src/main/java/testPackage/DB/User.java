package testPackage.DB;

public class User {
    private long id;
    private String login;
    private String password;
    private int super_user;
    private String name;
    private String email;

    public User(long id, String login, String name, String email) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.email = email;
    }
    public User(long id, String login, String name,int super_user, String email) {
        this.id = id;
        this.super_user=super_user;
        this.login = login;
        this.name = name;
        this.email = email;
    }
    public User( String login, String name, String email) {

        this.login = login;
        this.name = name;
        this.email = email;
    }
    public User( String login, String password, String name, String email) {
        this.password = password;
        this.login = login;
        this.name = name;
        this.email = email;
    }

    public User(long id, String login, String password, int super_user, String name, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.super_user = super_user;
        this.name = name;
        this.email = email;
    }

    public User(){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getlogin() {
        return login;
    }

    public void setlogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSuper_user() {
        return super_user;
    }

    public void setSuper_user(int super_user) {
        this.super_user = super_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TaskUsers.User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", super_user=" + super_user +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
