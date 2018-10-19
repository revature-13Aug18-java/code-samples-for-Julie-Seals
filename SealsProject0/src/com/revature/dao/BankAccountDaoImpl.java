package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.revature.model.BankAccount;
import com.revature.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao {

	private static Logger log = Logger.getRootLogger();

	@Override
	public int createBankAccount(BankAccount account) {
		int accountsCreated = 0;

		String sql = "INSERT INTO BANK_ACCOUNT(USERNAME, BALANCE) VALUES (?, ?)";

		try (Connection con = ConnectionUtil.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, account.getUserId());
			ps.setDouble(2, account.getBalance());
			accountsCreated = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			log.error(e.getMessage());
		}

		return accountsCreated;

	}

	@Override
	public double getBalance(String id) {
		double balance = 0;
		ResultSet rs = null;

		String sql = "SELECT * FROM BANK_ACCOUNT WHERE USERNAME = ?";
		try (Connection con = ConnectionUtil.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				balance = rs.getDouble("BALANCE");
			}
		} catch (SQLException | IOException e) {
			log.error(e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				log.error(e.getMessage());
			}
		}

		return balance;
	}

	@Override
	public int updateAccount(BankAccount account) {
		int accountsUpdated = 0;
		String sql = "UPDATE BANK_ACCOUNT " 
		+ " SET BALANCE = ?" 
		+ " WHERE USERNAME = ?";
		
		try (Connection con = ConnectionUtil.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setDouble(1, account.getBalance());
			ps.setString(2, account.getUserId());
			accountsUpdated = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			log.error(e.getMessage());
		
		}
		return accountsUpdated;
	}

}