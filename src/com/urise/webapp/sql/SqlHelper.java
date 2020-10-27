package com.urise.webapp.sql;

import com.urise.webapp.exception.ExceptionUtil;
import com.urise.webapp.exception.StorageException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.urise.webapp.exception.ExceptionUtil.exception;

public class SqlHelper {
    private final ConnectionFactory connectionFactory;

    public SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void execute (String sql) {
        execute(sql, PreparedStatement::execute);
    }

    public <T> T execute (String sql, Executor<T> executor) {
        try (Connection con = connectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            return executor.execute(ps);
        } catch (SQLException e) {
            throw exception(e);
        }
    }
    public <T> T transactionalExecute(SqlTransaction<T> executor) {
        try (Connection conn = connectionFactory.getConnection()) {
            try {
                conn.setAutoCommit(false);
                T res = executor.execute(conn);
                conn.commit();
                return res;
            } catch (SQLException e) {
                conn.rollback();
                throw ExceptionUtil.exception(e);
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }
}
