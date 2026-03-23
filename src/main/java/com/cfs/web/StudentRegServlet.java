package com.cfs.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/student-registration")
public class StudentRegServlet extends HttpServlet {

    private static final String KEY="student_list";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String roll=req.getParameter("roll");
        String course=req.getParameter("course");
        String marksstr=req.getParameter("marks");

        int marks=(marksstr==null || marksstr.isEmpty()) ? 0:Integer.parseInt(marksstr);

        Student student=new Student(name,roll,course,marks);

        List<Student>  list=getOrCreateList();

        list.add(student);

        resp.sendRedirect("students");

    }

    private  List<Student> getOrCreateList(){
        ServletContext ctx=getServletContext();
        synchronized (ctx)
        {
            List<Student> list= (List<Student>) ctx.getAttribute(KEY);

            if (list==null)
            {
                list= Collections.synchronizedList(new ArrayList<>());
                ctx.setAttribute(KEY,list);
            }
            return  list;
        }
    }

   }
