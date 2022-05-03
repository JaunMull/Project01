package project.handlers;

import io.cucumber.java.hu.Ha;
import io.javalin.http.Handler;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.postgresql.util.PSQLException;
import project.employees.Employees;
import project.jdbc.ConnectionUtils;
import project.managers.Manager;
import project.reimbursment.Reimbursements;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Handlers {

    static Connection conn = ConnectionUtils.createConnection();
    static PreparedStatement pstmt;
    static ResultSet rs;

    public static Handler logOut=ctx-> {
        ctx.req.getSession().invalidate();
    };

    public static Handler loginUser=ctx-> {
        ArrayList<Employees> empList = new ArrayList<Employees>();
        Employees e = new Employees();
        Employees e1 = ctx.bodyAsClass(Employees.class);

        try{


            pstmt = conn.prepareStatement("select * from employees where username=? and passwd=?");
            pstmt.setString(1, e1.getUsername());
            pstmt.setString(2, e1.getPassword());
            rs = pstmt.executeQuery();

            while(rs.next()){
                String user = rs.getString("username");
                String pass = rs.getString("passwd");
                e.setUsername(user);
                e.setPassword(pass);
                empList.add(e);
                ctx.sessionAttribute("id", rs.getInt("employee_id"));
                ctx.sessionAttribute("Username", user);
                System.out.println(ctx.sessionAttributeMap());
            }
            if(empList.size() == 0){

                ctx.status(404);
            }
        }catch (SQLException er){
            er.printStackTrace();
        }
        ctx.json(e);
    };

    public static Handler managerlogin=ctx-> {
        ArrayList<Manager> empList = new ArrayList<Manager>();
        Manager e = new Manager();

        try{
            Manager e1 = ctx.bodyAsClass(Manager.class);

            pstmt = conn.prepareStatement("select * from manager where username=? and passwd=?");
            pstmt.setString(1, e1.getUsername());
            pstmt.setString(2, e1.getPassword());
            rs = pstmt.executeQuery();

            while(rs.next()){
                String user = rs.getString("username");
                String pass = rs.getString("passwd");
                e.setUsername(user);
                e.setPassword(pass);
                empList.add(e);
                ctx.sessionAttribute("id", rs.getInt("manager_id"));
                ctx.sessionAttribute("Username", user);
                System.out.println(ctx.sessionAttributeMap());
            }
            if(empList.size() == 0){

                ctx.status(404);
            }
        }catch (SQLException er){
            er.printStackTrace();
        }
        ctx.json(e);
    };

    public static Handler createForm= ctx-> {
        Reimbursements r1 = ctx.bodyAsClass(Reimbursements.class);
        try{
            pstmt = conn.prepareStatement("insert into reimbursements (emp_id,fname,reimbursement,reason) values (?,?,?,?)");
            pstmt.setInt(1, r1.getEmployeeId());
            pstmt.setString(2, r1.getName());
            pstmt.setInt(3, r1.getReimbursement());
            pstmt.setString(4, r1.getReason());
            //pstmt.setString(5, r1.getDates());
            pstmt.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    };

    public static Handler getallusers=ctx-> {
        try{
            //Employees e1 = ctx.bodyAsClass(Employees.class);

            pstmt = conn.prepareStatement("select * from reimbursements");
            rs = pstmt.executeQuery();

            ArrayList<Reimbursements> reimList = new ArrayList<>();


            while(rs.next()){
                //int form = rs.getInt("form_id");
                int formId = rs.getInt("form_id"); 
                int emp_id = rs.getInt("emp_id");
                String fname = rs.getString("fname");
                int reim = rs.getInt("reimbursement");
                String reason = rs.getString("reason");
                String date = rs.getString("dates");
                String exact = rs.getString("exact");
                String status = rs.getString("status");

                Reimbursements e = new Reimbursements(formId ,emp_id, fname, reim, reason, date, exact, status); ;
                reimList.add(e);
            }
            ctx.json(reimList);

            if(reimList.size() == 0){
                ctx.status(404);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    };

    public static Handler getusersbyId=ctx-> {
        try{
            //Reimbursements e1 = ctx.bodyAsClass(Reimbursements.class);

            int getId = ctx.sessionAttribute("id");
            System.out.println(getId);
            pstmt = conn.prepareStatement("select * from reimbursements where emp_id=?");
            pstmt.setInt(1,getId);
            rs = pstmt.executeQuery();

            ArrayList<Reimbursements> reimList = new ArrayList<Reimbursements>();


            while(rs.next()){
                //int form = rs.getInt("form_id");

                int emp_id = rs.getInt("emp_id");
                String fname = rs.getString("fname");
                int reim = rs.getInt("reimbursement");
                String reason = rs.getString("reason");
                String date = rs.getString("dates");
                String exact = rs.getString("exact");
                String status = rs.getString("status");
                Reimbursements e = new Reimbursements(emp_id, fname, reim, reason, date, exact, status);
                reimList.add(e);
            }
            System.out.println(reimList);
            ctx.json(reimList);

            if(reimList.size() == 0){
                ctx.status(404);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    };

    public static Handler getformId=ctx-> {
        try{
            Reimbursements e1 = ctx.bodyAsClass(Reimbursements.class);
            System.out.println("Hello");
            pstmt = conn.prepareStatement("select * from reimbursements where form_id=?");
            pstmt.setInt(1,e1.getFormId());

            rs = pstmt.executeQuery();


            ArrayList<Reimbursements> reimList = new ArrayList<Reimbursements>();


            while(rs.next()){
                int formId = rs.getInt("form_id");
                int emp_id = rs.getInt("emp_id");
                String fname = rs.getString("fname");
                int reim = rs.getInt("reimbursement");
                String reason = rs.getString("reason");
                String date = rs.getString("dates");
                String exact = rs.getString("exact");
                String status = rs.getString("status");
                Reimbursements e = new Reimbursements(formId ,emp_id, fname, reim, reason, date, exact, status); ;
                reimList.add(e);
            }
            System.out.println(reimList);
            ctx.json(reimList);

            if(reimList.size() == 0){
                ctx.status(404);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    };


    public static Handler updatestatus = ctx-> {
        Reimbursements r1 = ctx.bodyAsClass(Reimbursements.class);

        pstmt = conn.prepareStatement("update reimbursements set status=? where form_id=?");
        pstmt.setInt(2,r1.getFormId());
        pstmt.setString(1, r1.getStatus());
        pstmt.execute();

    };
}
