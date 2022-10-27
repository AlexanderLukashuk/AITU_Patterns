package TamplatePattern;

public class Google extends Log{
    public Google(String User, String password) {
        this.User = User;
        this.password = password;
    }

    public boolean logIn(String userName, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.User);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLogging success on Google");
        return true;
    }

    public boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted) {
            System.out.println("Collection: " + new String(data) + " posted via Google");
            return true;
        } else {
            return false;
        }
    }

    public void logOut() {
        System.out.println("User: '" + User + "' was logged out from Google account");
    }

    private void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 3) {
                System.out.print(".");
                Thread.sleep(400);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}