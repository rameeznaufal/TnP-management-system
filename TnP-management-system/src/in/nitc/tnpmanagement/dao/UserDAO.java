package in.nitc.tnpmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.nitc.tnpmanagement.model.User;

public class UserDAO {
	env_var UserName = env_var.RootUserMySQL, Password = env_var.RootPasswordMySQL;
	private String jdbcURL = "jdbc:mysql://localhost:3306/tnp_managemnet_sys?useSSL=false";
    private String jdbcUsername = UserName.value;
    private String jdbcPassword = Password.value;
    
    
    public UserDAO() {}
    
    private static final String INSERT_USERS_SQL = "INSERT INTO user" + " (name,regNo,email,password,contact,cgpa,plac_officer) VALUES " + " (?, ?, ?, ?, ?, ?, 0);";
	private static final String SELECT_USER_BY_REGNO_AND_PWD = "SELECT * FROM user WHERE regNo = ? AND password = ?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM user ORDER BY name";
	private static final String DELETE_USERS_SQL = "DELETE FROM user WHERE id = ?;";
	private static final String UPDATE_USERS_SQL = "UPDATE user SET name = ? ,regNo = ? ,email = ? ,password = ?,contact = ?,cgpa = ? WHERE id = ?;";
	private static final String ASSIGN_USERS_SQL = "UPDATE user SET plac_stat = ? ,plac_comp = ? where id = ?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void registerUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getRegNo());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getPhNo());
			preparedStatement.setFloat(6, user.getCgpa());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User loginUser(String regNo, String password) {
		User user = null;
		int FLAG = 0;
		
		try (Connection connection = getConnection();
	      		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_REGNO_AND_PWD);) {
			
			preparedStatement.setString(1, regNo);
			preparedStatement.setString(2, password);	
			System.out.println(preparedStatement);
		
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				FLAG = 1;
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String contact = rs.getString("contact");
				float cgpa = rs.getFloat("cgpa");
				String placStat  = rs.getString("plac_stat");
				String placComp = rs.getString("plac_comp");
				int isPlacOff = rs.getInt("plac_officer");
				
				user = new User(id,name,regNo,email,password,contact,cgpa,placStat,placComp,isPlacOff);
			}
			if(FLAG==0) {
				user = new User();
				user.setId(-1);
				return user;
			}
		} catch (SQLException e) {
			user = new User();
			user.setId(-1);
			printSQLException(e);
			return user;
		}
		return user;
	}

	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			
			System.out.println(preparedStatement);
		
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String regNo = rs.getString("regNo");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String contact = rs.getString("contact");
				float cgpa = rs.getFloat("cgpa");
				String placStat  = rs.getString("plac_stat");
				String placComp = rs.getString("plac_comp");
				int isPlacOff = rs.getInt("plac_officer");
				users.add(new User(id,name,regNo,email,password,contact,cgpa,placStat,placComp,isPlacOff));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	//not implemented
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			
			//"UPDATE user SET name = ? ,regNo = ? ,email = ? ,password = ?,contact = ?,cgpa = ? WHERE id = ?"
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getRegNo());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getPhNo());
			preparedStatement.setFloat(6, user.getCgpa());
			preparedStatement.setInt(7, user.getId());
		
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean assignUser(User user) throws SQLException {
		boolean rowUpdated = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(ASSIGN_USERS_SQL);) {
			
			preparedStatement.setString(1, user.getPlacStat());
			preparedStatement.setString(2, user.getPlacComp());
			preparedStatement.setInt(3, user.getId());
		
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
