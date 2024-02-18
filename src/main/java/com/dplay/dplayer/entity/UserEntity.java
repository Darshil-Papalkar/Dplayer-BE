package com.dplay.dplayer.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@ToString
public class UserEntity {
    @Id
    @Setter(value= AccessLevel.NONE)
    private String userId;
    private String userName;
    private String userEmail;
    private String userPassword;

    public UserEntity(String userName, String userEmail, String userPassword) {
        super();
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
