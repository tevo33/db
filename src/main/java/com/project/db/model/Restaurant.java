package com.project.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false, length = 100)
    private String name;

    @Column(name="image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "restaurant")
    private List<Vote> votes;

    @OneToMany(mappedBy = "winningRestaurant")
    private List<Votation> wonVotations;
}
