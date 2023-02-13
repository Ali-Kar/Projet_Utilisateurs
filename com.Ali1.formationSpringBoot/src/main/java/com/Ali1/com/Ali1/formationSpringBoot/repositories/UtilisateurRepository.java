package com.Ali1.com.Ali1.formationSpringBoot.repositories;

import com.Ali1.com.Ali1.formationSpringBoot.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    public List<Utilisateur> findByFirstName(String firstName);
    public List<Utilisateur> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT u FROM Utilisateur u WHERE u.firstName = ?1 OR u.lastName = ?2")
    public List<Utilisateur> findByFirstNameAndLastNameWithJPQL(String firstName, String lastName);

    @Query("SELECT u FROM Utilisateur u WHERE u.firstName LIKE :myFirstName OR u.lastName LIKE :myLastName")
    public List<Utilisateur> findByFirstNameAndLastNameWithJPQLWithNamedParameters(@Param(value = "myFirstName") String firstName, @Param(value = "myLastName") String lastName);


    public List<Utilisateur> findByAgeIn(List<Integer> age);

    public List<Utilisateur> findByStarterDateAfterAndActiveTrue(Date date);

    public List<Utilisateur> findByRolesTitre(String titre);


}
