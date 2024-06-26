package com.dplay.dplayer.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "users")
@Getter
@Setter
@ToString
public class UserEntity {
    @Id
    private String id;
    private String userName;
    private String userEmail;
    private String userPassword;
    @CreatedDate
    private Date insertTimestamp;
    @LastModifiedDate
    private Date updateTimestamp;

    public UserEntity(String userName, String userEmail, String userPassword) {
        super();
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
