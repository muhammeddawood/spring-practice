package com.sp.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.model.Student;


@Controller
@RequestMapping("/student")
public class StudentController {
	private static List<Student> students = new ArrayList<Student>();

	@RequestMapping(method=RequestMethod.POST, value="")
	public ResponseEntity<Void> addStudent() {
		Student st = new Student();
		st.setId(students.size());
		st.setStudentName("Student " + students.size());
		students.add(st);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ControllerLinkBuilder.linkTo(StudentController.class).slash(st.getId()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{studentId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE })
	public ResponseEntity<Student> showStudent(@PathVariable Long studentId) {
		Student st = students.get(studentId.intValue());
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{studentId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> modifyStudent(@PathVariable Long studentId, @RequestBody Map<String, String> request) {
		Student st = students.get(studentId.intValue());
		st.setStudentName(request.get("studentName"));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<String> handleNotFounds(Exception ex) {
		return new ResponseEntity<String>(String.format("{\"reason\": \"%s\"}", ex.getLocalizedMessage()), HttpStatus.NOT_FOUND);
	}
}
