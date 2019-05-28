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
        employee.setId(resultSet.getInt(Constants.EMPLOYEE_ID));
        employee.setEmployeeSurname(resultSet.getString(Constants.EMPLOYEE_SURNAME));
        employee.setEmployeeName(resultSet.getString(Constants.EMPLOYEE_NAME));
        employee.setEmployeePatronymic(resultSet.getString(Constants.EMPLOYEE_PATRONYMIC));
        employee.setAccountID(resultSet.getInt(Constants.ACCOUNT_ID));
        employee.setEmployeeState(Employee.EmployeeState.valueOf(resultSet.getString(Constants.EMPLOYEE_STATE_NAME)));

        return employee;
    }

    @Override
    public void parse(Employee entity, PreparedStatement statement, boolean useID) throws SQLException {
        if (entity != null) {
            statement.setString(1, entity.getEmployeeSurname());
            statement.setString(2, entity.getEmployeeName());
            statement.setString(3, entity.getEmployeePatronymic());
            statement.setInt(4,entity.getAccountID());
            statement.setString(5,entity.getEmployeeState().name());

            if (useID) {
                statement.setInt(6, entity.getId());
            }
        }
    }
}
