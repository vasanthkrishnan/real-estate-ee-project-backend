package com.real_estate.real_estate_app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "users")
public class UserSignUp {
    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String username;
    private String email;
    private String password;
    private LocalDateTime time;

}
