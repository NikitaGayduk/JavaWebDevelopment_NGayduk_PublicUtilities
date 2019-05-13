package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler;

import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Employee;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author NikitaGayduk
 * @date 12.05.2019
 */
class DAOEmployeeHandler extends AbstractDAOHandler<Employee> {

    @Override
    public Employee build(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt(Constants.ColumnName.EMPLOYEE_ID));
        employee.setEmployeeSurname(resultSet.getString(Constants.ColumnName.EMPLOYEE_SURNAME));
        employee.setEmployeeName(resultSet.getString(Constants.ColumnName.EMPLOYEE_NAME));
        employee.setEmployeePatronymic(resultSet.getString(Constants.ColumnName.EMPLOYEE_PATRONYMIC));
        employee.setAccountID(resultSet.getInt(Constants.ColumnName.ACCOUNT_ID));

        return employee;
    }

    @Override
    public void parse(Employee entity, PreparedStatement statement, boolean useID) throws SQLException {
        if (entity != null) {
            statement.setString(1, entity.getEmployeeSurname());
            statement.setString(2, entity.getEmployeeName());
            statement.setString(3, entity.getEmployeePatronymic());
            statement.setInt(4,entity.getAccountID());

            if (useID) {
                statement.setInt(5, entity.getId());
            }
        }
    }
}
