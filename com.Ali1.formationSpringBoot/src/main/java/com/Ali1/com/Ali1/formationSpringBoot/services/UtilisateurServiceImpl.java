package com.Ali1.com.Ali1.formationSpringBoot.services;

import com.Ali1.com.Ali1.formationSpringBoot.entities.Utilisateur;
import com.Ali1.com.Ali1.formationSpringBoot.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public List<Utilisateur> findByFirstName(String firstName){
        return utilisateurRepository.findByFirstName(firstName);
    }

    @Override
    public List<Utilisateur> findByFirstNameAndLastName(String firstName, String lastName) {
        return utilisateurRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Utilisateur> findByFirstNameAndLastNameWithJPQL(String firstName, String lastName) {
        return utilisateurRepository.findByFirstNameAndLastNameWithJPQLWithNamedParameters(firstName, lastName);
    }

    @Override
    public List<Utilisateur> findByAgeIn(List<Integer> age) {
        return utilisateurRepository.findByAgeIn(age);
    }

    @Override
    public List<Utilisateur> findByStarterDateAfterAndActiveTrue(Date date) {
        return utilisateurRepository.findByStarterDateAfterAndActiveTrue(date);
    }

    @Override
    public List<Utilisateur> findByRolesTitre(String titre) {
        return utilisateurRepository.findByRolesTitre(titre);
    }

    @Override
    public Utilisateur findUtilisateurById(Long id) {
        Optional<Utilisateur> utOptional = utilisateurRepository.findById(id);

        if (utOptional.isEmpty())
            return null;
        else
            return utOptional.get();
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        Optional<Utilisateur> utOptional = utilisateurRepository.findById(utilisateur.getId());

        if (utOptional.isEmpty())
            return null;
        else
            return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);

    }

}
