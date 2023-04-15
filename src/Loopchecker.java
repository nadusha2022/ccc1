public class Loopchecker implements Checker {
    private static final String ALLOWED_CHARACTERS = "abcdefjhiklmnopqrstuvwxyzABCDEFGHKLMNOPQRSTVWXYZ0123456789";

    @Override
    public boolean check(String e) {
        char[] chars = e.toCharArray();
        for (char symbol : chars) {
            if (!ALLOWED_CHARACTERS.contains(Character.toString(symbol))) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isValid(String login) {
        return false;
    }
}

