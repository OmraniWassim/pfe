package com.ltms.pfe.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class PlantSection {
    @Id
    @SequenceGenerator(name="ps_sequence",sequenceName ="ps_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ps_sequence")
    long id;
    @Column(unique = true)
    String name;
    String description;
    String emplacement;
    String manager;
    String rsponsableRH;
    String Organisation;


}
