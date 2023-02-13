package com.Ali1.com.Ali1.formationSpringBoot.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Role implements Serializable {
    @Id
    private int id;
    private String titre;
}
