package com.courses.spalah;



import home12.Core.Car;
import home12.Service.DaoServices;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CarMarketServlet extends HttpServlet {

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
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
