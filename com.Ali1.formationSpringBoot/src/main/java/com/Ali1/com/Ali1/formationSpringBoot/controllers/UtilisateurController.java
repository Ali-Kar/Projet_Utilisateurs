package com.Ali1.com.Ali1.formationSpringBoot.controllers;

import com.Ali1.com.Ali1.formationSpringBoot.entities.Utilisateur;
import com.Ali1.com.Ali1.formationSpringBoot.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/utilisateur")// localhost:8080/utilisateur
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Utilisateur> findUtilisateurById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.findUtilisateurById(id);

        if (utilisateur == null)
            return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<Utilisateur>(utilisateur,HttpStatus.OK);
    }


    @GetMapping(path = "/findByFirstName/{firstName}")
    public ResponseEntity<List<Utilisateur>> findUtilisateurByFirstName(@PathVariable String firstName) {
        List<Utilisateur> utilisateurs = utilisateurService.findByFirstName(firstName);

        if (utilisateurs.isEmpty())
            return new ResponseEntity<List<Utilisateur>> (HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
    }


    @GetMapping(path = "/findByFirstNameAndLastName/{firstName}/{lastName}")
    public ResponseEntity<List<Utilisateur>> findUtilisateurByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        List<Utilisateur> utilisateurs = utilisateurService.findByFirstNameAndLastName(firstName, lastName);

        if (utilisateurs.isEmpty())
            return new ResponseEntity<List<Utilisateur>> (HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
    }

    @GetMapping(path = "/findByFirstNameAndLastNameWithJPQL/{firstName}/{lastName}")
    public ResponseEntity<List<Utilisateur>> findUtilisateurByFirstNameAndLastNameWithJPQL(@PathVariable String firstName, @PathVariable String lastName) {
        List<Utilisateur> utilisateurs = utilisateurService.findByFirstNameAndLastNameWithJPQL(firstName, lastName);

        if (utilisateurs.isEmpty())
            return new ResponseEntity<List<Utilisateur>> (HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
    }


    @GetMapping(path = "/findByAge")
    public ResponseEntity<List<Utilisateur>> findUtilisateurByAge(@RequestBody List<Integer> age) {
        List<Utilisateur> utilisateurs = utilisateurService.findByAgeIn(age);

        if (utilisateurs.isEmpty())
            return new ResponseEntity<List<Utilisateur>> (HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
    }

    @GetMapping(path = "/findByStartDate/{date}")
    public ResponseEntity<List<Utilisateur>> findUtilisateurByStartDateAfterAndActiveTrue(@PathVariable Date date) {
        List<Utilisateur> utilisateurs = utilisateurService.findByStarterDateAfterAndActiveTrue(date);

        if (utilisateurs.isEmpty())
            return new ResponseEntity<List<Utilisateur>> (HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
    }


    @GetMapping(path = "/findByRoleTitre/{titre}")
    public ResponseEntity<List<Utilisateur>> findUtilisateurByRoleTitre(@PathVariable String titre) {
        List<Utilisateur> utilisateurs = utilisateurService.findByRolesTitre(titre);

        if (utilisateurs.isEmpty())
            return new ResponseEntity<List<Utilisateur>> (HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
    }

//    @GetMapping(path = "/findByIdWithRequestParam") //localhost:8080/utilisateur/findByIdWithRequestParam?id=2
//    public ResponseEntity<Utilisateur> findUtilisateurById(@RequestParam Long id){
//        Utilisateur utilisateur = utilisateurService.findUtilisateurById(id);
//
//        if(utilisateur==null)
//            return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
//        else
//            return new ResponseEntity<Utilisateur>(HttpStatus.OK);
//
//    }
    @PostMapping
    public Utilisateur createUtilisateurs(@RequestBody Utilisateur utilisateur){
        return utilisateurService.createUtilisateur(utilisateur);
    }
    @PutMapping
    public Utilisateur updateAllUtilisateurs(@RequestBody Utilisateur utilisateur){
        return utilisateurService.updateUtilisateur(utilisateur);
    }
    @DeleteMapping(path = "/{id}")
    public void deleteAllUtilisateurs(@PathVariable Long id){
        utilisateurService.deleteUtilisateur(id);
    }
}
