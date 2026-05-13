package com.Poke.Team.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data //Genera get, set, toString, equals y hashCode
@AllArgsConstructor //Constructor con todos los campos
@NoArgsConstructor //Constructor vació para JPA y serilizacion
public class Trainer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Clave primaria auto-incremental
    private Long id;
    private String name;

    //Relacion uno a uno Trainer tiene un Team y un Team pertenece a un Trainer
    @OneToOne(mappedBy = "trainer", cascade = CascadeType.ALL) //Reflejamos la relation con mappedBy
    @ToString.Exclude
    private Team team;

}
