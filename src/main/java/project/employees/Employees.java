package project.employees;

public class Employees {
    private int empId;
    private String fname;
    private String username;
    private String password;
    private int mid;

    public Employees() {
    }

    public Employees(int empId, String fname, String username, String password, int mid) {
        this.empId = empId;
        this.fname = fname;
        this.username = username;
        this.password = password;
        this.mid = mid;
    }

    public Employees(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
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

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "empId=" + empId +
                ", fname='" + fname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mid=" + mid +
                '}';
    }
}
