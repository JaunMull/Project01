package project.main;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import project.handlers.Handlers;

public class Main {
    public static void main(String[] args) {
        //Javalin app = Javalin.create(ctx->{ctx.addStaticFiles("web", Location.CLASSPATH);}).start(8080);
        Javalin app = Javalin.create(ctx -> {ctx.enableCorsForAllOrigins();ctx.addStaticFiles("web",Location.CLASSPATH);}).start(8081);
        app.post("/login", Handlers.loginUser);

        app.post("/managerlogin", Handlers.managerlogin);

        app.post("/reimbursements", Handlers.createForm);

        app.get("/allreimbursements", Handlers.getallusers);

        app.get("/getId",  Handlers.getusersbyId);

        app.post("/logout",  Handlers.logOut);

        app.post("/formId",  Handlers.getformId);

        app.post("/update", Handlers.updatestatus);


    }

}
