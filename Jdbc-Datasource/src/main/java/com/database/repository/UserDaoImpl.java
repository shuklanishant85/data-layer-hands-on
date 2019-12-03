package com.database.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.database.constants.Constants;
import com.database.datasource.DatasourceFactory;
import com.database.model.Employee;

public class UserDaoImpl implements UserDao {

	private static final Log LOGGER = LogFactory.getLog(UserDao.class);
	private static final String GET_EMPLOYEE_QUERY = "SELECT * FROM " + Constants.TABLE_NAME + " WHERE empId = ";

	public Employee getEmployee(long employeeId) {
		Employee employee = new Employee();
		Connection connection = DatasourceFactory.getConnection();
		if (null != connection) {
			try (Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery(GET_EMPLOYEE_QUERY + employeeId)) {
				while (result.next()) {
					employee.setEmpId(result.getLong(1));
					employee.setEmpName(result.getString(2));
					employee.setEmpSalary(result.getLong(3));
					employee.setEmpRole(result.getString(4));
					employee.setAdmin(result.getBoolean(5));
				}
			} catch (SQLException e) {
				LOGGER.error("SQL Exception while creating query ");
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					LOGGER.error("unable to close connection ");
				}
			}

		}
		return employee;
	}

	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}
