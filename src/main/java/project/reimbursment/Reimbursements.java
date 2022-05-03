package project.reimbursment;

public class Reimbursements {
    private int formId;
    private int employeeId;
    private String name;
    private int reimbursement;
    private String reason;
    private String dates;
    private String exact;
    private String status;


    public Reimbursements() {
    }

    public Reimbursements(int employeeId, String fname, int reimbursement, String reason, String dates) {
        this.employeeId = employeeId;
        this.name = fname;
        this.reimbursement = reimbursement;
        this.reason = reason;
        this.dates = dates;
    }

    public Reimbursements(int employeeId, String name, int reimbursement, String reason, String dates, String exact, String status) {
        this.employeeId = employeeId;
        this.name = name;
        this.reimbursement = reimbursement;
        this.reason = reason;
        this.dates = dates;
        this.exact = exact;
        this.status = status;
    }

    public Reimbursements(int formId, int employeeId, String name, int reimbursement, String reason, String dates, String exact, String status) {
        this.formId = formId;
        this.employeeId = employeeId;
        this.name = name;
        this.reimbursement = reimbursement;
        this.reason = reason;
        this.dates = dates;
        this.exact = exact;
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(int reimbursement) {
        this.reimbursement = reimbursement;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getExact() {
        return exact;
    }

    public void setExact(String exact) {
        this.exact = exact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    @Override
    public String toString() {
        return "Reimbursements{" +
                "formId=" + formId +
                ", employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", reimbursement=" + reimbursement +
                ", reason='" + reason + '\'' +
                ", dates='" + dates + '\'' +
                ", exact='" + exact + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
