//User class represents a user in the system
class User {
    String name;
    int age;
    String email;
    String password;

    public User(String name, int age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }
}
//UserValidator class is responsible for validating user data
class UserValidator {
    public void validate(User user) {
        if (user.name == null || user.name.isEmpty()) {
            throw new RuntimeException("Invalid name");
        }
        if (user.age < 0) {
            throw new RuntimeException("Invalid age");
        }
        if (user.email == null || !user.email.contains("@")) {
            throw new RuntimeException("Invalid email");
        }
        if (user.password == null || user.password.length() < 6) {
            throw new RuntimeException("Invalid password");
        }
    }
}

class UserRepository {
    public void save(User user) {
        System.out.println("User saved to database");
    }
}

interface NotificationService {
    void send(User user);
}

class EmailNotificationService implements NotificationService {
    public void send(User user) {
        System.out.println("Email sent to " + user.email);
    }
}

class UserService {
    private UserValidator validator;
    private UserRepository repository;
    private NotificationService notificationService;

    public UserService(UserValidator validator,
                       UserRepository repository,
                       NotificationService notificationService) {
        this.validator = validator;
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void register(User user) {
        validator.validate(user);
        repository.save(user);
        notificationService.send(user);
    }
}