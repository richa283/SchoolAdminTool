package com.school.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.school.dto.AdmissionDto;
import com.school.dto.StudentsDTO;

public class StudentsMapper implements RowMapper<AdmissionDto>{

	@Override
	public AdmissionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdmissionDto student = new AdmissionDto();
		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setfName(rs.getString(3));
		student.setfOccupation(rs.getString(4));
		student.setmName(rs.getString(5));
		student.setmOccupation(rs.getString(6));
		student.setContact(rs.getString(7));
		student.setAltContact(rs.getString(8));
		student.setDob(rs.getDate(9));
		student.setSamagraId(rs.getString(10));
		student.setAadhar(rs.getString(11));
		student.setBankName(rs.getString(12));
		student.setAccNo(rs.getString(13));
		student.setIfsc(rs.getString(14));
		student.setAddress(rs.getString(15));
		student.setLastClassAttended(rs.getString(16));
		student.setCity(rs.getString(17));
		student.setState(rs.getString(18));
		student.setZip(rs.getString(19));
		student.setBranch(rs.getString(20));
		student.setStuClass(rs.getString(21));
		student.setFees(rs.getInt(22));
		student.setGender(rs.getString(23));
		student.setCategory(rs.getString(24));
		student.setAdmissionDate(rs.getDate(25));
		student.setScholarNumber(rs.getString(26));
		student.setLastSchoolStudied(rs.getString(27));
		student.setBirthPlace(rs.getString(28));
		student.setReligion(rs.getString(29));
		student.setSession(rs.getString(30));
		student.setAadharPhoto(rs.getString(31));
		student.setStudentPhoto(rs.getString(32));
		student.setSamagraPhoto(rs.getString(33));
		student.setCastPhoto(rs.getString(34));
		student.setTcPhoto(rs.getString(35));
		student.setMigrationPhoto(rs.getString(36));
		
		return student;
	} 

}
