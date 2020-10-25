package com.urise.webapp.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.urise.webapp.exception.SqlException.sqlException;

public class SqlHelper {
    private final ConnectionFactory connectionFactory;

    public SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void sql (String sql) {
        sql(sql, PreparedStatement::execute);
    }

    public <T> T sql (String sql, Executor<T> executor) {
        try (Connection con = connectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return executor.execute(ps);
        } catch (SQLException e) {
            throw sqlException(e);
        }
    }
}
