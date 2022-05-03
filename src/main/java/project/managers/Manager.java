package project.managers;

public class Manager {
    private int manId;
    private String fname;
    private String username;
    private String password;

    public Manager() {
    }

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Manager(int manId, String fname, String username, String password) {
        this.manId = manId;
        this.fname = fname;
        this.username = username;
        this.password = password;
    }

    public int getManId() {
        return manId;
    }

    public void setManId(int manId) {
        this.manId = manId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
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

    @Override
    public String toString() {
        return "Manager{" +
                "manId=" + manId +
                ", fname='" + fname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
