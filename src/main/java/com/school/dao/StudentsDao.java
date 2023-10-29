package com.school.dao;

import java.util.List;

import com.school.dto.AdmissionDto;
import com.school.dto.StudentsDTO;

public interface StudentsDao{

	public void addStudents(StudentsDTO dto); 
	public List<AdmissionDto> listStudents();
	void deleteStudent(String rollNo);
	void updateStudent(StudentsDTO dto);
	AdmissionDto getStudent(int id);
}
