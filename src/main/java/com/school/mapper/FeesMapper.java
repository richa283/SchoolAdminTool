package com.school.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.school.dto.FeesAmountDto;
import com.school.dto.StudentsDTO;

public class FeesMapper implements RowMapper<FeesAmountDto>{

	@Override
	public FeesAmountDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		FeesAmountDto fees= new FeesAmountDto();
		fees.setScholarNumberOrName(rs.getString(1));
		fees.setAmount(rs.getString(2));
		fees.setReceiptNo(rs.getInt(3));
		fees.setDate(rs.getString(4));
		fees.setPaymentMode(rs.getString(5));
		fees.setSenderBankName(rs.getString(6));
		fees.setChequeNo(rs.getString(7));
		fees.setChequeDate(rs.getString(8));
		fees.setAccNo(rs.getString(9));
		fees.setRecBank(rs.getString(10));
		fees.setRemark(rs.getString(11));
		return fees;
	} 
}