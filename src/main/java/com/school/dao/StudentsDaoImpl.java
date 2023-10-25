package com.school.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.school.dto.AdmissionDto;
import com.school.dto.FeesAmountDto;
import com.school.dto.FeesClassesDto;
import com.school.dto.StudentsDTO;
import com.school.mapper.RemFeesMapper;
import com.school.mapper.StudentsMapper;

@Repository
public class StudentsDaoImpl implements StudentsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getPK() {
		String sql = "select max(id) from students";
		return jdbcTemplate.queryForObject(sql,Integer.class)  ;
	}
	
	public AdmissionDto getByScholarNumber(String scholarNumber) {
		String sql = "select * from students where scholarNumber=? ";
		return jdbcTemplate.queryForObject(sql,new StudentsMapper(),scholarNumber);  
	}
	
	public List<String> getListOfScholarNumbers() {
		String sql = "select scholarNumber from students ";
		return jdbcTemplate.queryForList(sql,String.class);  
	}
	



	public List<AdmissionDto> getStudentsByPage(int pageid,int total){    
	 	String sql="select * from students limit ?,?"; 
	  
	    List<AdmissionDto> studentList = jdbcTemplate.query(sql,new StudentsMapper(),pageid-1,total);
	    return studentList;	    		
	}    
	
	
	
	
	
	public int getStudentFees(String stuClass) {
		int fees = 0;
		System.out.println("classes in dao "+stuClass);
		String sql = "select * from classes ";
		List<FeesClassesDto> classes = jdbcTemplate.query(sql,new RowMapper<FeesClassesDto>() {
            public FeesClassesDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            	FeesClassesDto dto = new FeesClassesDto();
            	dto.setClasses(rs.getString(1));
            	dto.setFees(rs.getInt(2));
            	return dto;
            }
        });

		for(FeesClassesDto dto : classes) {
			if(dto.getClasses().equals(stuClass)) {
				fees=dto.getFees();
				break;
			};

		}
		return fees;
	}
	
	public void saveStudents(AdmissionDto dto) throws IOException {
	System.out.println("inside DB method");
		String sql = "insert into students values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		Object[] args = { getPK()+1, dto.getName(), dto.getfName(), dto.getfOccupation(), dto.getmName(), dto.getmOccupation(), dto.getContact(), 
						  dto.getAltContact(), dto.getDob(), dto.getSamagraId(), dto.getAadhar(), dto.getBankName(), dto.getAccNo(), 
						  dto.getIfsc(), dto.getAddress(), dto.getLastClassAttended(), dto.getCity(), dto.getState(), dto.getZip(), 
						  dto.getBranch(), dto.getStuClass(), dto.getFees(), dto.getGender(), dto.getCategory(), dto.getAdmissionDate(),
						  dto.getScholarNumber(), dto.getLastSchoolStudied(), dto.getBirthPlace(), dto.getReligion(), dto.getSession(),
						  dto.getAadharPhoto(),dto.getStudentPhoto(),dto.getSamagraPhoto(), dto.getCastPhoto(), dto.getTcPhoto(), dto.getMigrationPhoto()};
				;
		jdbcTemplate.update(sql, args);
		System.out.println("inserted");
	}

	@Override
	public AdmissionDto getStudent(int id) {
		String sql = "select * from students where id=?";
		AdmissionDto student = jdbcTemplate.queryForObject(sql,new StudentsMapper(),id);
		return student;
	}
	
	public AdmissionDto getStudentbyscholarNumber(String rollNo) {
		String sql = "select * from students where scholarNumber=?";
		AdmissionDto student = jdbcTemplate.queryForObject(sql,new StudentsMapper(),rollNo);
		return student;
	}

	public List<AdmissionDto> searchStudentbyscholarNumber(String scholarNumber) {
		String sql = "select * from students where scholarNumber Like ?";
		List<AdmissionDto> studentList = jdbcTemplate.query(sql,new StudentsMapper(),new String[] { "%" + scholarNumber + "%" });
		return studentList;
	}
	
	//AND scholarNumber Like ?
	//new String[] { "%" + scholarNumber + "%" },

	public List<AdmissionDto> searchStudentbyScholarNumber( String stuClasses,String searchValue,String branch,String session) {
		String search = "%"+searchValue+"%";
		String sql = "select * from students where stuClass=? AND scholarNumber Like ? AND branch=? AND session=?";
		List<AdmissionDto> studentList = jdbcTemplate.query(sql,new StudentsMapper(),stuClasses,search, branch,session);
		
		return studentList;
	}
	
	
	public List<AdmissionDto> searchStudent( String stuClasses,String branch,String session,int pageid,int totalRecords) {
		String sql = "select * from students where stuClass=?  AND branch=? AND session=? limit ?,?";
		List<AdmissionDto> studentList = jdbcTemplate.query(sql,new StudentsMapper(),stuClasses, branch,session,pageid-1, totalRecords);
		
		return studentList;
	}
	
	
	public List<AdmissionDto> searchStudentbyName(String stuClasses,String searchValue,String branch,String session) {
		String search = "%"+searchValue+"%";
		String sql = "select * from students where stuClass=? AND name Like ? AND branch=? AND session=?";
		List<AdmissionDto> studentList = jdbcTemplate.query(sql,new StudentsMapper(),stuClasses,search, branch,session);
		return studentList;
	}
	
	public List<AdmissionDto> searchStudentbyClass(String classes) {
		String sql = "select * from students where stuClass=?";
		List<AdmissionDto> studentList = jdbcTemplate.query(sql,new StudentsMapper(),classes);
		return studentList;
	}
	
	public List<String> listOfclasses() {
		String sql = "select distinct stuClass from students";
		List<String> classes = jdbcTemplate.query(sql,new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        });
		return classes; 
	} 

	@Override
	public List<AdmissionDto> listStudents() {
		String sql = "select * from students";
		List<AdmissionDto> studentList = jdbcTemplate.query(sql, new StudentsMapper());
		//displayStudent(studentList);
		return studentList;
	}
	

	public Integer remainFeesByScholarNumber(String scholarNumber) {
		String sql = "SELECT SUM(amount) FROM feestransaction WHERE scholarNumber=?";
	List<Integer> classes = jdbcTemplate.query(sql,new RowMapper<Integer>() {
        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getInt(1);
        }
    },scholarNumber);
	return classes.get(0); 
	}
	
	public List<FeesAmountDto> remainingFees() {
		String sql ="SELECT scholarNumber,SUM(amount) FROM feestransaction GROUP BY scholarNumber";
	List<FeesAmountDto> feesDto = 	jdbcTemplate.query(sql, new RemFeesMapper());
	System.out.println("list returned");
	return feesDto;
	}
	
	
	public List<FeesAmountDto> remainingFeesOfStudents() {
		String sql ="SELECT scholarNumber,SUM(amount) FROM feestransaction GROUP BY scholarNumber";
	List<FeesAmountDto> feesDto = 	jdbcTemplate.query(sql, new RemFeesMapper());
	System.out.println("list returned");
	return feesDto;
	}
	
	public int totalRemainingFees() {
		String sql ="SELECT SUM(amount) FROM feestransaction";
	return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	
	
	public int totalFees() {
		String sql  = "SELECT SUM(fees) FROM students";
		return  jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public void displayStudent(List<AdmissionDto> student) {
		for (AdmissionDto stu : student) {
			System.out.println(stu);
		}
	}

	
	@Override
	public void deleteStudent(String rollNo) {
		String sql = "delete  from students where scholarNumber=?";
		jdbcTemplate.update(sql,rollNo);
		
		String sql1 = "delete  from feestransaction where scholarNumber=?";
		jdbcTemplate.update(sql1,rollNo);
		
		System.out.println("Student deleted");
	}

	//samagra Id is giving issue
	public void updateStudent(AdmissionDto dto) {
		String sql = "update students set name=?, fName=?, fOccupation=?, mName=?, mOccupation=?, contact=?, altContact=?, dob=?, "
				+ " aadhar=?, bankName=?, accNo=?, ifsc=?, address=?, lastClassAttended=?, city=?, state=?, zip=?, branch=?, stuClass=?, "
				+ "fees=?, gender=?, category=?, admissionDate=?,lastSchoolStudied=?, birthPlace=?, religion=?, session=?, samagraId=? where scholarNumber=?" ;
		Object[] args = {dto.getName(), dto.getfName(), dto.getfOccupation(), dto.getmName(), dto.getmOccupation(), dto.getContact(),
				dto.getAltContact(), dto.getDob(),  dto.getAadhar(), dto.getBankName(), dto.getAccNo(), dto.getIfsc(), dto.getAddress(),
				dto.getLastClassAttended(), dto.getCity(), dto.getState(), dto.getZip(), dto.getBranch(), dto.getStuClass(),
				dto.getFees(), dto.getGender(),dto.getCategory(), dto.getAdmissionDate(), dto.getLastSchoolStudied(), dto.getBirthPlace(), 
				dto.getReligion(), dto.getSession(), dto.getSamagraId(),dto.getScholarNumber(),};
		int result= jdbcTemplate.update(sql, args);
		System.out.println("Record updated");
	}

	@Override
	public void addStudents(StudentsDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent(StudentsDTO dto) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
