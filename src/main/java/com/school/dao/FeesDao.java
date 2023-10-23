package com.school.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.school.dto.AdmissionDto;
import com.school.dto.FeesAmountDto;
import com.school.dto.FeesClassesDto;
import com.school.dto.StudentsDTO;
import com.school.mapper.FeesMapper;
import com.school.mapper.StudentsMapper;

@Repository
public class FeesDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<AdmissionDto> listofStudents() {
		String sql = "select * from students";
		List<AdmissionDto> studentList = jdbcTemplate.query(sql, new StudentsMapper());

		return studentList;
	}

	public void displayStudent(List<StudentsDTO> student) {
		for (StudentsDTO stu : student) {
			System.out.println(stu);
		}
	}

	public void amountToDB(String scholarNumber, String amount, String date, String paymentMode,String  bankName,String  chequeNo,
			String  chequeDate,String  accNo,String  recBank,String  remark) {
		System.out.println(scholarNumber + amount + date);

		String sql = "insert into feestransaction(scholarNumber,amount,txnDate,paymentMode, senderBankName, chequeNo, chequeDate, accNo, recBank, remark)values(?,?,?,?,?,?,?,?,?,?) ";
			
		Object[] args = { scholarNumber, amount, date, paymentMode, bankName, chequeNo, chequeDate, accNo, recBank, remark };

		jdbcTemplate.update(sql, args);

		System.out.println("Amount Saved");
	}

	public List<FeesAmountDto> feesSummary(String scholarNumber) {
		System.out.println(scholarNumber);
		String sql = "SELECT * FROM feestransaction WHERE scholarNumber=?";
		List<FeesAmountDto> feesList = jdbcTemplate.query(sql, new FeesMapper(),scholarNumber);
		
		return feesList;

	}
	
	public List<FeesAmountDto> feesSummaryReport(Date startDate, Date endDate) {

		String sql = "SELECT * FROM feestransaction WHERE txnDate BETWEEN ? AND ?";
		List<FeesAmountDto> feesList = jdbcTemplate.query(sql, new FeesMapper(),startDate, endDate);
		
		return feesList;

	}
	
	public List<Integer> feesSummaryReportAmount(Date startDate, Date endDate) {

		String sql = "SELECT sum(amount) FROM feestransaction WHERE txnDate BETWEEN ? AND ?";
		List<Integer> amount =  jdbcTemplate.query(sql, new RowMapper<Integer>() {
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            	return rs.getInt(1);
            }
        },startDate, endDate);
		
		return amount;

	}
	
	
	
	
	

}
