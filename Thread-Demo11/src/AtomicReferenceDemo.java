import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

    public static AtomicReference<User> atomicReference = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("hxg", "123456");
        atomicReference.set(user);

        User updateUser = new User("qqq", "654321");
        atomicReference.compareAndSet(user, updateUser);
        System.out.println(atomicReference.get().getUserName());
        System.out.println(atomicReference.get().getUserPwd());
    }

    static class User {
        private String userName;
        private String userPwd;

        //省略getter和setter

        public User(String userName, String userPwd) {
            this.userName = userName;
            this.userPwd = userPwd;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPwd() {
            return userPwd;
        }

        public void setUserPwd(String userPwd) {
            this.userPwd = userPwd;
        }
    }
}