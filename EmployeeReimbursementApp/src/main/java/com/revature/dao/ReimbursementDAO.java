package com.revature.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.ReimbursementService;
import com.revature.util.JDBCUtility;

public class ReimbursementDAO {

	private static final String Reimbursent = null;


	public List<Reimbursement> getAllReimbursement() throws SQLException {
		try (Connection con = JDBCUtility.getConnection()) {
			List<Reimbursement> reimbursement = new ArrayList<>();
			
			String sql = "SELECT * FROM project1.reimbursements";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				reimbursement.add(new Reimbursement(rs.getInt("id"),rs.getInt("amount"),rs.getString("submitted"),rs.getString("resolved"),rs.getString("status"),rs.getString("reimb_type"),rs.getString("description"),rs.getInt("author"),rs.getInt("resolver")));
				
			}
			return (reimbursement);
		}
	}
	
	public List<Reimbursement> getAllReimbursementByEmployee( int resolver) throws SQLException {
		try (Connection con = JDBCUtility.getConnection()) {
			List<Reimbursement> reimbursement = new ArrayList<>();
			
			String sql = "SELECT * FROM project1.reimbursements  where resolver = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt (1 ,resolver);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				reimbursement.add(new Reimbursement(rs.getInt("id"),rs.getInt("amount"),rs.getString("submitted"),rs.getString("resolved"),rs.getString("status"),rs.getString("reimb_type"),rs.getString("description"),rs.getInt("author"),rs.getInt("resolver")));
							
			
			}
			return (reimbursement);
		}
	}
	
	public  Reimbursement getReimbursementById(int id) throws SQLException {
		try (Connection con = JDBCUtility.getConnection()) {
			
			
			String sql ="SELECT * FROM project1.reimbursements WHERE id= ? ;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return new Reimbursement(rs.getInt("id"),rs.getInt("amount"),rs.getString("submitted"),rs.getString("resolved"),rs.getString("status"),rs.getString("reimb_type"),rs.getString("description"),rs.getInt("author"),rs.getInt("resolver"));
			 	}
			else {
				return null;
			} 
			
			}
		
			}
		
		public void changedStatus(int resolver, String status, int id) throws SQLException {
		try (Connection con = JDBCUtility.getConnection()) {
			String sql = "UPDATE project1.reimbursements SET resolver= ? , status= ? "
					+ "WHERE id = ? ;" ;
					
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, resolver);
			pstmt.setString(2, status);
			pstmt.setInt(3, id);
			
			int updatedCount = pstmt.executeUpdate();
			
			if (updatedCount != 1) {
				throw new SQLException("Something bad occurred when trying to update status");
				}
		}
				
				
				catch(SQLException e) 
				{ throw new SQLException("Something bad occurred when trying to update status");
			}
		
		
	}
	
	public Reimbursement addReimbursements(String type, String description, int amount, int author, InputStream receipt) throws SQLException{
		try (Connection con = JDBCUtility.getConnection()) {
			con.setAutoCommit(false); // Turn off autocommit
			
			String sql = "INSERT INTO project1.reimbursements"
					+ "(reimb_type, description, amount,submitted,author,receipt)"
					+ "Values (?,?,?,now(),?,?);";
					
			
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, type);
		
			pstmt.setString(2, description);
			pstmt.setInt(3 , amount);
			pstmt.setInt(4, author);
			
			pstmt.setBinaryStream(5,receipt);
			
			
			int numberOfInsertedRecords = pstmt.executeUpdate();
			
			if (numberOfInsertedRecords != 1) {
				throw new SQLException("Issue occurred when adding reimbursement");
			}
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			rs.next();
			int generatedId = rs.getInt(1);
			
			
			con.commit(); 

			return new Reimbursement (generatedId,amount, rs.getString("submitted"),rs.getString("resolved"),rs.getString("status"),type,description,author,rs.getInt("resolver"));
					
			
					
		}
	}

	
	public InputStream getReceiptFromReimbursementById(int id) throws SQLException {
		try(Connection con = JDBCUtility.getConnection()) {
			String sql = "SELECT receipt "
					+ "FROM project1.reimbursements where id = ? ";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				InputStream receipt = rs.getBinaryStream("receipt");
				
				return receipt;
			}
			
			return null;
		}
	}
}	