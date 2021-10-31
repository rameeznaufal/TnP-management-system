package in.nitc.tnpmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.nitc.tnpmanagement.model.Company;
import in.nitc.tnpmanagement.model.User_company;


public class CompanyDAO {
	env_var UserName = env_var.RootUserMySQL, Password = env_var.RootPasswordMySQL;
	private String jdbcURL = "jdbc:mysql://localhost:3306/tnp_managemnet_sys?useSSL=false";
    private String jdbcUsername = UserName.value;
    private String jdbcPassword = Password.value;
    
    public CompanyDAO() {}
    
    private static final String INSERT_COMPANY_SQL = "INSERT INTO Company(name,role,ctc,locat) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ALL_COMPANY = "SELECT * FROM Company ORDER BY name;";
    private static final String APPLY_TO_COMPANY = "INSERT INTO user_company VALUES (?, ?);";
    private static final String CHECK_IF_APPLIED = "SELECT * FROM user_company WHERE user_id = ? AND company_id = ?;";
    private static final String DELETE_COMPANY = "DELETE FROM Company WHERE id = ?;";
    private static final String UPDATE_COMPANY = "UPDATE Company SET name = ?, role = ?, ctc = ?, locat = ? WHERE id = ?;";
    
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
    
	public void registerCompany(Company company) throws SQLException {
		System.out.println(INSERT_COMPANY_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMPANY_SQL);) {
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(2, company.getRole());
			preparedStatement.setString(3, company.getctc());
			preparedStatement.setString(4, company.getLoc());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public List<Company> selectAllCompany() {
		List<Company> companies = new ArrayList<>();
		
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMPANY);) {
			
			System.out.println(preparedStatement);
		
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String role = rs.getString("role");
				String ctc = rs.getString("ctc");
				String locat = rs.getString("locat");
				
				companies.add(new Company(id, name , role, ctc, locat));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return companies;
	}
	
	public void applyToCompany(User_company applied) throws SQLException {
		
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(APPLY_TO_COMPANY);) {
			
			preparedStatement.setInt(1, applied.getU_id());
			preparedStatement.setInt(2, applied.getC_id());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public boolean checkApplied(int u_id, int c_id) throws SQLException {
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CHECK_IF_APPLIED);) {
			
			preparedStatement.setInt(1, u_id);
			preparedStatement.setInt(2, c_id);
		
			if(preparedStatement.executeQuery().next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}	
	
	public boolean deleteCompany (int id) throws SQLException {
		boolean rowDeleted = false;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_COMPANY);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean updateCompany(Company company) throws SQLException {
		boolean rowUpdated = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COMPANY);) {
			
			//"UPDATE Company SET name = ?, role = ?, ctc = ?, locat = ? WHERE id = ?;";
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(2, company.getRole());
			preparedStatement.setString(3, company.getctc());
			preparedStatement.setString(4, company.getLoc());
			preparedStatement.setInt(5, company.getId());
			
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
