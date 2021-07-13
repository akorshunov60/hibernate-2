package com.example.hibernate2.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "FROM User u"),
        @NamedQuery(name = "User.findById", query = "FROM User u WHERE u.id = :id"),
        @NamedQuery(name = "User.deleteById", query = "DELETE FROM User u WHERE u.id = :id")
})
public class User {

    public User(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;
}
