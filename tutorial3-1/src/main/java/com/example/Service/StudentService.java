package com.example.Service;
import java.util.List;
import com.example.Model.StudentModel;

public interface StudentService {
	StudentModel selectStudent(String npm);
	List<StudentModel> selectAllStudent();
	void addStudent(StudentModel student);
	void delete(StudentModel student);
}
