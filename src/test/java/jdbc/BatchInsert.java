package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchInsert {
    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rainbow?user=root&password=jack_bai?useSSL=false");

            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement("insert into userinfo (name, salary,comment, password,email) values(?,?,?,?,?)");

            for (int i = 0; i < 20980; i++) {
                ps.setString(1, "name" + i);
                ps.setDouble(2, i);
                ps.setString(3, "comment" + i);
                ps.setString(4, "pwd" + i);
                ps.setString(5, "abc@126.com");
                ps.addBatch();

                if (i % 100 == 0) {
                    ps.executeBatch();
                    ps.clearParameters();
                    System.out.println("Executed once!");

                }
            }
            ps.executeBatch();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();

        }


    }
}
