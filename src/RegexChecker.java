public class RegexChecker implements Checker {
    @Override
    public boolean check(String e) {
        return false;
    }

    @Override
    public boolean isValid (String e) {
        return e.matches("^\\w+$");
    }
}
