package com.carwash.userservice.model;
import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String userName;
    @NonNull
    private String fullName;
    private Gender gender;
    @NonNull
    private String phoneNo;
    private String email;
    @NonNull
    private String password;
    private int age;
    @NonNull
    private Role role;
    private Boolean isActive;

}
