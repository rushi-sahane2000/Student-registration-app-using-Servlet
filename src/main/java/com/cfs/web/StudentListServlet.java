package com.cfs.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
    private static final String KEY = "student_list";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Student> list = getList();
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Registered Students</title>");

        // Beautiful Internal CSS
        out.println("<style>");
        out.println("body { font-family: 'Segoe UI', sans-serif; background: #f4f7f6; margin: 0; padding: 40px; display: flex; flex-direction: column; align-items: center; }");
        out.println(".container { background: white; padding: 30px; border-radius: 12px; box-shadow: 0 10px 30px rgba(0,0,0,0.1); width: 100%; max-width: 800px; }");
        out.println("h2 { color: #333; margin-top: 0; border-bottom: 2px solid #4a90e2; padding-bottom: 10px; display: flex; justify-content: space-between; align-items: center; }");
        out.println(".count-badge { background: #4a90e2; color: white; padding: 4px 12px; border-radius: 20px; font-size: 0.9rem; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("th { background-color: #f8f9fa; color: #666; text-align: left; padding: 15px; border-bottom: 2px solid #eee; font-weight: 600; }");
        out.println("td { padding: 15px; border-bottom: 1px solid #eee; color: #444; }");
        out.println("tr:hover { background-color: #f1f7ff; transition: 0.2s; }");
        out.println(".btn-add { text-decoration: none; background: #34c759; color: white; padding: 10px 20px; border-radius: 6px; font-weight: 600; font-size: 0.9rem; transition: 0.3s; }");
        out.println(".btn-add:hover { background: #28a745; box-shadow: 0 4px 12px rgba(52, 199, 89, 0.3); }");
        out.println(".empty-msg { text-align: center; color: #888; padding: 40px; font-style: italic; }");
        out.println("</style>");

        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<h2>Registered Students <span class='count-badge'>" + list.size() + "</span></h2>");
        out.println("<div style='margin-bottom: 20px; text-align: right;'>");
        out.println("<a href='index.html' class='btn-add'>+ Add New Student</a>");
        out.println("</div>");

        if (list.isEmpty()) {
            out.println("<div class='empty-msg'>No students registered yet. Be the first!</div>");
        } else {
            out.println("<table>");
            out.println("<thead><tr><th>#</th><th>Name</th><th>Roll No.</th><th>Selected Course</th><th>Marks</th></tr></thead>");
            out.println("<tbody>");

            int i = 1;
            for (Student s : list) {
                out.println("<tr>");
                out.println("<td>" + (i++) + "</td>");
                out.println("<td><strong>" + s.getName() + "</strong></td>");
                out.println("<td>" + s.getRoll() + "</td>");
                out.println("<td>" + s.getCourse().toUpperCase() + "</td>");
                out.println("<td>" + s.getMarks() + "/100</td>");
                out.println("</tr>");
            }
            out.println("</tbody></table>");
        }

        out.println("</div>");
        out.println("</body></html>");
    }

    private List<Student> getList() {
        ServletContext ctx = getServletContext();
        List<Student> list = (List<Student>) ctx.getAttribute(KEY);
        return (list == null) ? Collections.emptyList() : list;
    }
}