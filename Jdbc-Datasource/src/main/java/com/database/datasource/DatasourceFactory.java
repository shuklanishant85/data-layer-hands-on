package com.database.datasource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.h2.jdbcx.JdbcDataSource;

public class DatasourceFactory {
	private static final Log LOGGER = LogFactory.getLog(DatasourceFactory.class);

	private DatasourceFactory() {
		// do nothing
	}

	public static JdbcDataSource getDatasource() {
		JdbcDataSource datasource = null;
		Properties dbProp = new Properties();
		try {
			dbProp.load(new FileInputStream("src/main/resources/db.properties"));
			datasource = new JdbcDataSource();
			datasource.setURL(dbProp.getProperty("spring.datasource.url"));
			datasource.setUser(dbProp.getProperty("spring.datasource.username"));
			datasource.setPassword(dbProp.getProperty("spring.datasource.password"));
		} catch (FileNotFoundException e) {
			LOGGER.error("File not found : db.properties");
		} catch (IOException e) {
			LOGGER.error("IOException while reading file : db.properties");
		}
		return datasource;
	}

	public static Connection getConnection() {
		Connection connection = null;
		JdbcDataSource datasource = DatasourceFactory.getDatasource();
		if (null != datasource) {
			try {
				connection = datasource.getConnection();
			} catch (SQLException e) {
				LOGGER.error("failed to create connection to database");
			}
		}
		return connection;

	}
}
