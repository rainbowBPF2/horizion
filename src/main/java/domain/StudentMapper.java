package domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pengfei on 2017/9/20.
 */
public class StudentMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs, int i) throws SQLException {

        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getInt("age"));
        student.setMale(rs.getString("male"));
        student.setSalary(rs.getDouble("salary"));
        student.setComment(rs.getString("comment"));

        return student;
    }
}
