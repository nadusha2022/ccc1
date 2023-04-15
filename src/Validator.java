import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Validator {
    private static Object WrongLogingException;
    private static Object WrongPasswordException;

    private Validator() {
    }
    public static boolean validate(String login, String password, String confirmPassword) {
        check(login, password, confirmPassword);
        return true;
    }
    private static void check (String login, String password, String confirmPassword) {
        if (Objects.isNull(login) || login.length() > 20) {
            try {
                throw new WrongLogingException("Длина логин должна быть меньше или равна 20!");
            } catch (WrongLogingException e) {
                throw new RuntimeException(e);
            }
        }
        if (Objects.isNull(password) || password.length() >= 20) {
            try {
                throw new WrongPasswordException("Длина пароля должна быть меньше 20!");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        }
        if (!password.equals(confirmPassword)) {
            try {
                throw new WrongPasswordException("Пароли должны совпадать");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        }
        Checker checker = ThreadLocalRandom.current().nextBoolean()?
                new Loopchecker():
                new RegexChecker();
        if (!checker.isValid(login)){
            try {
                throw new WrongLogingException("Логин содержит некорректные символы!");
            } catch (WrongLogingException e) {
                throw new RuntimeException(e);
            }
        }
        if (!checker.isValid(password)){
            try {
                throw new WrongPasswordException("Пароль содержит некорректные символы!");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        }
    }
    }



