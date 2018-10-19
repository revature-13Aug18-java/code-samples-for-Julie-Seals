package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.revature.model.BankAccount;
import com.revature.model.UserInfo;
import com.revature.util.ConnectionUtil;

public class UserInfoDaoImpl extends BankAccountDaoImpl implements UserInfoDao {

	private static Logger log = Logger.getRootLogger();

	@Override
	public int createUserAccount(UserInfo user) {
		int usersCreated = 0;
		
		String sql = "{call INSERT_USER_INFO(?, ?, ?, ?)}";
		
		try(Connection con = ConnectionUtil.getConnection();
				CallableStatement cs = con.prepareCall(sql);) {
			
			cs.setString(1, user.getUsername());
			cs.setString(2, user.getPassword());
			cs.setString(3, user.getFname());
			cs.setString(4, user.getLname());
			cs.execute();

		} catch (SQLException | IOException e) {
			log.error(e.getMessage());
		}
		BankAccountDaoImpl badi = new BankAccountDaoImpl();
		BankAccount account = new BankAccount();
		account.setUserId(user.getUsername());
		account.setBalance(0);
		badi.createBankAccount(account);

		return usersCreated;
	}


	@Override
	public int updateAccount(UserInfo user) {
		int usersUpdated = 0;

		String sql = "UPDATE USER_INFO" + " SET FNAME = ?," + " LNAME = ?," + " WHERE USERNAME = ?";

		try (Connection con = ConnectionUtil.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, user.getFname());
			ps.setString(2, user.getLname());
			ps.setString(3, user.getUsername());
			usersUpdated = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			log.error(e.getMessage());
		}
		return usersUpdated;
	}

	@Override
	public List<UserInfo> getUsers() {
		List<UserInfo> userList = new ArrayList<>();
		String sql = "SELECT * FROM USER_INFO";

		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)) {

			while (rs.next()) {
				UserInfo u = new UserInfo();
				String userId = rs.getString("USERNAME");
				u.setUsername(userId);

				String password = rs.getString("PW");
				u.setPassword(password);

				String fname = rs.getString("FNAME");
				u.setFname(fname);

				String lname = rs.getString("LNAME");
				u.setLname(lname);

				userList.add(u);
			}
		} catch (SQLException | IOException e) {
			log.error(e.getMessage());
		}

		return userList;
	}

	public boolean isMatchUsername(String inputUser) {
		boolean match = false;
		ResultSet rs = null;

		String sql = "SELECT * FROM USER_INFO WHERE USERNAME = ?";

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, inputUser);

			rs = ps.executeQuery();

			if (rs.next()) {
				match = true;

			} else {
				match = false;
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

		return match;
	}

	public boolean isMatchPassword(String inputPassword, String inputUser) {
		boolean match = false;
		ResultSet rs = null;

		String sql = "SELECT * FROM USER_INFO WHERE PW = ?" 
				+ " AND USERNAME = ?";

		try (Connection con = ConnectionUtil.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, inputPassword);
			ps.setString(2, inputUser);

			rs = ps.executeQuery();

			while (rs.next()) {
				if ((inputPassword.equals(rs.getString("PW")) && inputUser.equals(rs.getString("USERNAME")))) {
					match = true;
				} else {
					match = false;
				}
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

		return match;
	}
}
