package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Model.StudentModel;
import com.example.Service.InMemoryStudentService;
import com.example.Service.StudentService;


@Controller
public class StudentController {
	private final StudentService studentService;
	
	public StudentController() {
		studentService = new InMemoryStudentService();
	}
	
	@RequestMapping("student/add")
	public String add(@RequestParam(value = "npm", required = true) String npm, 
					  @RequestParam(value="name", required = true)String name,
					  @RequestParam(value = "gpa", required = true) double gpa) {
			StudentModel student = new StudentModel(npm,name,gpa);
			studentService.addStudent(student);
			return "add";
	}
	
	@RequestMapping("student/view")
	public String view(Model model, @RequestParam(value= "npm" , required = true) String npm) {
		StudentModel student = studentService.selectStudent(npm);
		model.addAttribute("student",student);
		return "view";
	}
	
	@RequestMapping("student/viewall")
	public String viewall(Model model) {
		List<StudentModel> students = studentService.selectAllStudent();
		model.addAttribute("students", students);
		return "viewall";
	}
	
	@RequestMapping("/student/view/{npm}")
	public String viewPath(@PathVariable Optional<String> npm, Model model) {
		if(npm.isPresent()) {
			String npms = npm.get();
			StudentModel student = studentService.selectStudent(npms);
			if(student != null) {
				model.addAttribute("student",student);	
				return "view";
			}
		}
		
		else { 
				return "error1";
			}
		
		return "error";
		
	
	}
	
	@RequestMapping("/student/delete/{npm}")
	public String deletePath(@PathVariable Optional<String> npm, Model model) {
		if(npm.isPresent()) {
			String npms = npm.get();
			StudentModel student = studentService.selectStudent(npms);
			if(student != null) {
				studentService.delete(student);
				return "delete";
			}
		}
		
		else { 
				return "error1";
			}
		
		return "error";
		
	
	}
	
	
}
