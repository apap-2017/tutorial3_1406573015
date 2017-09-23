package com.example.Service;

import java.util.List;
import java.util.ArrayList;
import com.example.Model.StudentModel;

public class InMemoryStudentService implements StudentService{
	List<StudentModel> student = new ArrayList<StudentModel>();
	
	@Override
	public StudentModel selectStudent(String npm) {
		for(int i = 0; i < student.size();i++ ) {
			if(npm.equals(student.get(i).getNpm())) {
				return student.get(i);
			}
		}
		return null;
	}

	@Override
	public List<StudentModel> selectAllStudent() {
		return student;
	}

	@Override
	public void addStudent(StudentModel student) {
		this.student.add(student);
		
	}

	@Override
	public void delete(StudentModel student) {
		this.student.remove(student);
	}
}
