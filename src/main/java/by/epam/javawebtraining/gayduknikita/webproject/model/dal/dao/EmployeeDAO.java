package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Employee;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public interface EmployeeDAO  extends DAO<Employee>{

    Employee getEmployeeByAccount(Account account) throws DAOException;

}
