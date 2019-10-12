package helpers

public class TestEnvironment {

    private static Map SANDBOX = [sandbox: 'https://api.tmsandbox.co.nz']

    public static Map getSandbox() {
        return SANDBOX
    }

}
