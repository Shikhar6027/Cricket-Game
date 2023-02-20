package com.example.gameofcricket.model;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="Player")
public class Player {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

@SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
)
@Id
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
)
    private Long id;
    private String name;
    private int age;
    private String role;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
