package com.example.UserService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor
public class UserPrimaryKey implements Serializable {

    private int id;

    private String username;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPrimaryKey orderPK)) return false;
        return id == orderPK.id && Objects.equals(username, orderPK.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}