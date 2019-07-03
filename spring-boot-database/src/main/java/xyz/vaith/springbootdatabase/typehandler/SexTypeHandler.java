package xyz.vaith.springbootdatabase.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import xyz.vaith.springbootdatabase.enumeration.Sex;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(value = Sex.class)
public class SexTypeHandler extends BaseTypeHandler<Sex> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Sex sex, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sex.getId());
    }

    @Override
    public Sex getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex = resultSet.getInt(s);
        if (sex!= 1 && sex != 2) {
            return null;
        }
        return Sex.getEnumById(sex);
    }

    @Override
    public Sex getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex = resultSet.getInt(i);
        if (sex!= 1 && sex != 2) {
            return null;
        }
        return Sex.getEnumById(sex);
    }

    @Override
    public Sex getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex = callableStatement.getInt(i);
        if (sex!= 1 && sex != 2) {
            return null;
        }
        return Sex.getEnumById(sex);
    }
}
