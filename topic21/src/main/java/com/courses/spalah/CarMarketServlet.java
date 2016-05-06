package com.courses.spalah;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import home12.Core.Car;
import home12.Core.Owner;
import home12.Service.DaoServices;
import org.json.simple.parser.JSONParser;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class CarMarketServlet extends HttpServlet {
    final List<Car> cars = new CopyOnWriteArrayList<Car>();
    public static void main(String[] args) throws SQLException {

    DaoServices cm = new DaoServices();
    ArrayList arrayList = (ArrayList) cm.getAllCars();
        System.out.println(arrayList);
        Car car = (Car) arrayList.get(1);
        System.out.println(car.getDeveloper());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");


        PrintWriter writer = resp.getWriter();
        DaoServices ds = new DaoServices();
        List<Car> cars = ds.getAllCars();
        List<Owner> owners= ds.getAllOwners();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
//        String json = gson.toJson(cars);
        String json = gson.toJson(owners);
//        fromJson();
        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "     <title>All cars</title>" +
                        "</head>" +
                        "<body>" +

                        "  <cite> " + json + "</cite>" +
//                        this.viewAllOwners() +
                        "</body>" +
                        "</html>"
        );
        writer.flush();

    }

//    private void fromJson(String json) {
//        JSONParser parser = new JSONParser();
//
//        Object obj = null;
//        try
//        {
//            obj = parser.parse(json);
//        }
//        catch ()
//                parser.parse(json);
//        JSONObject jsonObj = (JSONObject) obj;
//        System.out.println(jsonObj.get("paramsStr"));
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(jsonToString(req));
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter writer = resp.getWriter();
        DaoServices ds = new DaoServices();
        List<Owner> owners = ds.getAllOwners();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(owners);


        //Добавление владельца из запроса в базу
           Owner owner = getOwner(req);
        try {
            ds.addOwner(owner.getFirstName(), owner.getLastName(), owner.getTel());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "     <title>All owners</title>" +
                        "</head>" +
                        "<body>" + "<br/>"+

                        "json = "+ json +
                "</body>" +
                        "</html>"
        );
        writer.flush();
    }

/*//old and work on do get
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
        pw.println("<B>Список групп</B>");

        pw.println("<table border=1>");

        try {
            DaoServices ds = new DaoServices();
            List<Car> l = ds.getAllCars();
            for (Car car : l) {
                pw.println("<tr>");
                pw.println("<td>" + car.getCar_id() + "</td>");
                pw.println("<td>" + car.getDeveloper() + "</td>");
                pw.println("<td>" + car.getModel() + "</td>");
                pw.println("<td>" + car.getVin() + "</td>");
                pw.println("<td>" + car.getCreated() + "</td>");
                pw.println("<td>" + car.getOwner_id() + "</td>");
                pw.println("</tr>");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        pw.println("</table>");
*/
public static String jsonToString (HttpServletRequest req) throws IOException {
    String line = null;
    StringBuffer stringBuffer = new StringBuffer();
    BufferedReader bufferedReader = req.getReader();
    while ((line = bufferedReader.readLine()) != null) {
        stringBuffer.append(line);
    }

    return stringBuffer.toString();
}

    private String viewAllCar() {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Cars</p>");
        sb.append("<table border=1>");
        try {
            DaoServices ds = new DaoServices();
            List<Car> l = ds.getAllCars();
            for (Car car : l) {
                sb.append("<tr>");
                sb.append("<td>" + car.getCar_id() + "</td>");
                sb.append("<td>" + car.getDeveloper() + "</td>");
                sb.append("<td>" + car.getModel() + "</td>");
                sb.append("<td>" + car.getVin() + "</td>");
                sb.append("<td>" + car.getCreated() + "</td>");
                sb.append("<td>" + car.getOwner_id() + "</td>");
                sb.append("</tr>");
            }
        } catch (Exception e) {
        }
        sb.append("</table>");
        return sb.toString();
    }
    private String viewAllLot() {
        //not work yet
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Lots</p>");
        sb.append("<table border=1>");
        try {
            DaoServices ds = new DaoServices();
            List<Car> l = ds.getAllCars();
            for (Car car : l) {
                sb.append("<tr>");
                sb.append("<td>" + car.getCar_id() + "</td>");
                sb.append("<td>" + car.getDeveloper() + "</td>");
                sb.append("<td>" + car.getModel() + "</td>");
                sb.append("<td>" + car.getVin() + "</td>");
                sb.append("<td>" + car.getCreated() + "</td>");
                sb.append("<td>" + car.getOwner_id() + "</td>");
                sb.append("<td>" + car.getOwner_id() + "</td>");
                sb.append("<td>" + car.getOwner_id() + "</td>");
                sb.append("</tr>");
            }
        } catch (Exception e) {
        }
        sb.append("</table>");
        return sb.toString();
    }
    private String viewAllOwners() {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Owners</p>");
        sb.append("<table border=1>");
        try {
            DaoServices ds = new DaoServices();
            List<Owner> l = ds.getAllOwners();
            for (Owner owner : l) {
                sb.append("<tr>");
                sb.append("<td>" + owner.getFirstName()+ "</td>");
                sb.append("<td>" + owner.getLastName() + "</td>");
                sb.append("<td>" + owner.getTel() + "</td>");
                sb.append("</tr>");
            }
        } catch (Exception e) {
        }
        sb.append("</table>");
        return sb.toString();
    }

    public Owner getOwner(HttpServletRequest req)
    {
        Owner owner = new Owner();

        String  firstNameparam = req.getParameter("firstName");
        String  lastNameparam = req.getParameter("lastName");
        String  tel = req.getParameter("contact_phone");

        owner.setFirstName(firstNameparam);
        owner.setLastName(lastNameparam);
        owner.setTel(tel);
        return owner;
    }
    public void getOwnerFromJson(String jsonStr, HttpServletRequest req) throws IOException {
//        JSONParser parser = new JSONParser();
//        Object obj = null;
//        try {
//            obj = parser.parse(jsonToString(req));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }
}
