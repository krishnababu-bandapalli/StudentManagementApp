package com.softwareSolutions.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer, Student> db = new HashMap<>();
    // adding information
    public String addStudent( Student student1) {
        int enrollID = student1.getEnrollID();
        db.put(enrollID, student1);
        return "Student added successfully";
    }

    // getting information
    public Student getStudent( int enrollID) {
        return db.get(enrollID);
    }

    // updating information
    public String updateStudent(int enrollID, int age) {
        if(!db.containsKey(enrollID))
            return null;
        db.get(enrollID).setAge(age);
        return "Age updated successfully";
    }

    // delete information
    public String deleteStudent(int enrollID) {
        if(!db.containsKey(enrollID))
            return null;
        db.remove(enrollID);
        return "Deleted successfully";
    }
}
