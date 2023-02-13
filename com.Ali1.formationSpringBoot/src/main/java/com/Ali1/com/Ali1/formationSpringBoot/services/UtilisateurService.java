package com.Ali1.com.Ali1.formationSpringBoot.services;

import com.Ali1.com.Ali1.formationSpringBoot.entities.Utilisateur;

import java.util.Date;
import java.util.List;

public interface UtilisateurService {

    // methodes CRUD Basiques
    public List<Utilisateur> getAllUtilisateurs();
    public Utilisateur findUtilisateurById(Long id);
    public Utilisateur createUtilisateur(Utilisateur utilisateur);
    public Utilisateur updateUtilisateur(Utilisateur utilisateur);
    public void deleteUtilisateur(Long id);

    // methodes avancées

    public List<Utilisateur> findByFirstName(String firstName);
    public List<Utilisateur> findByFirstNameAndLastName(String firstName, String lastName);

    public List<Utilisateur> findByFirstNameAndLastNameWithJPQL(String firstName, String lastName);


    public List<Utilisateur> findByAgeIn(List<Integer> age);

    public List<Utilisateur> findByStarterDateAfterAndActiveTrue(Date date);

    public List<Utilisateur> findByRolesTitre(String titre);



}
