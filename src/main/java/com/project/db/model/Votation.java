package com.project.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Votations")
public class Votation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date", nullable = false, unique = true)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "winning_restaurant_id")
    private Restaurant winningRestaurant;

    @OneToMany(mappedBy = "votation")
    private List<Vote> votes;
}
