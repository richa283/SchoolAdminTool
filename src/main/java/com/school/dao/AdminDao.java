package com.school.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.school.dto.FeesClassesDto;

@Repository
public class AdminDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addClassesAndFees(String classes,int feesAmount, String submittedBy) {
		String sql = "insert into classes (classes,fees,submittedBy) values(?,?,?)";
		jdbcTemplate.update(sql, classes,feesAmount,submittedBy);
		
	}
	
	public List<FeesClassesDto> listClasses() {
		String sql = "select * from classes";
		List<FeesClassesDto> classes = jdbcTemplate.query(sql,new RowMapper<FeesClassesDto>() {
            public FeesClassesDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            	FeesClassesDto dto = new FeesClassesDto();
            	dto.setClasses(rs.getString(1));
            	dto.setFees(rs.getInt(2));
            	dto.setsubmittedBy(rs.getString(3));
            	return dto;
            }
        });
	return classes;
}
	
	public void addSession(String startSession, String endSession) {
		String sql = "insert into session(startSession, endSession) values(?,?)";
		jdbcTemplate.update(sql, startSession,endSession);
		
	}

	public List<String> listSession() {
		String sql = "select startSession from session";
		List<String> sessionStart = jdbcTemplate.query(sql,new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        });
		
		String sql1 = "select endSession from session";
		List<String> sessionEnd = jdbcTemplate.query(sql1,new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        });
		
		ArrayList<String> session = new ArrayList<String>();
		
		
		for(int i =0; i<sessionStart.size(); i++) {
		session.add(sessionStart.get(i)+"-"+sessionEnd.get(i));
		}
	return session;
}
	
	
	public void addCategory(String category) {
		String sql = "insert into category(category) values(?)";
		jdbcTemplate.update(sql, category);
		
	}

	public List<String> listCategory() {
		String sql = "select category from category";
		List<String> category= jdbcTemplate.query(sql,new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        });
	return category;
}
	

	public void addFeestype(String feestype) {
		String sql = "insert into feestype(feestype) values(?)";
		jdbcTemplate.update(sql, feestype);
		
	}

	public List<String> listfeestype() {
		String sql = "select feestype from feestype";
		List<String> feestype = jdbcTemplate.query(sql,new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        });
	return feestype;
}
	public void deleteFeesType(String feestype) {
		String sql = "delete  from feestype where feestype=?";
		jdbcTemplate.update(sql,feestype);
	}
	
	public void deleteClasses(String classes) {
		String sql = "delete  from classes where classes=?";
		jdbcTemplate.update(sql,classes);
	}
	
	public void deleteSession(String startSession, String endSession) {
		String sql = "delete  from session where startSession=? and endSession=?";
		jdbcTemplate.update(sql,startSession, endSession);
	}
	
	public void deleteCategory(String category) {
		String sql = "delete  from category where category=?";
		jdbcTemplate.update(sql,category);
	}
	
}







