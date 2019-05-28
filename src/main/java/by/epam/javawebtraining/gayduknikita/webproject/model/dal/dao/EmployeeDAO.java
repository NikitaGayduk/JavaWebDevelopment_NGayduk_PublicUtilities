package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Employee;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public interface EmployeeDAO extends DAO<Employee> {

    Employee getEmployeeByAccount(Account account) throws DAOException;

    List<Employee> getEmployeeByOrderId(int id) throws DAOException;

    List<Employee> getAllWorkingEmployee() throws DAOException;

    int addEmployee(Account account, Employee employee) throws DAOException;

    List<Employee> getAllFreeEmployee(Timestamp begin, Timestamp end) throws DAOException;

    void setOrderWorker(int workerId, int orderId) throws DAOException;
}
