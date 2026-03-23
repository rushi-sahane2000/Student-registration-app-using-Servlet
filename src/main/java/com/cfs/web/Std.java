package com.cfs.web;

public class Std {

    public Std(Course course) {
    }


    public static void main(String[] args) {
        Course course=new DSA();
        course.start();
        Course course1=new Springboot();
        course1.start();
    }
}
