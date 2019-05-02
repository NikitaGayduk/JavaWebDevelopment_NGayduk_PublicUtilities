package by.epam.javawebtraining.gayduknikita.webproject.model.service.validator;

/**
 * @author NikitaGayduk
 * @date 02.05.2019
 */
public class ValidatorsFactory {

    private static Validator[] validators = {
            new RegistrationValidator(),
            new LogInValidator()
    };

    public static Validator getRegistrationValidator(){
        return validators[0];
    }

    public static Validator getLogInValidator(){
        return validators[1];
    }
}
