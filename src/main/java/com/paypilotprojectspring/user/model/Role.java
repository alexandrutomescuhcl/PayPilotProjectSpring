package com.paypilotprojectspring.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "SPRING", name = "ROLES")
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    private Long id;

    @Column
    private String name;

    @OneToMany
    List<User> users;
}
