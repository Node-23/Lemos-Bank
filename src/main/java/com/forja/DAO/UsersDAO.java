package com.forja.DAO;

import com.forja.Models.CommonUser;
import com.forja.Models.Enums.UserStatusEnum;
import com.forja.Models.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

public class UsersDAO {
    private static final User testUser = new CommonUser(
            1L,
            "Teste",
            "teste@email.com",
            "Test@123",
            LocalDateTime.now(),
            UserStatusEnum.ACTIVE,
            "Rua das Oliveiras, 120",
            "86999586325",
            null,
            "25695874852"
    );

    @Getter
    private static final ArrayList<User> users = new ArrayList<>(List.of(testUser));

    @Getter
    @Setter
    private static User loggedUser;

    public static Optional<User> findUserByEmail(String email){
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    public static void saveUser(User user){
        getUsers().add(user);
    }
}
