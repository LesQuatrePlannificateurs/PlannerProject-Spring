package com.spring.planner.service;

import com.spring.planner.entities.MyUserPrincipal;
import com.spring.planner.entities.Person;
import com.spring.planner.entities.Professor;
import com.spring.planner.repository.ProfessorReporitory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProfessorService implements UserDetailsService {

    @Autowired
    ProfessorReporitory professorRepository;

    /**
     * Add a Professor
     * @param professor is the new professor to add
     * @return the new professor added
     */
    public Professor addProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    /**
     * find a professor by his id
     * @param id id of the professor to find
     * @return return the found professor
     */
    public Professor findProfessorById(Long id){
        return professorRepository.findById(id).orElse(null);
    }

    public void deleteProfessorById(Long id){
        professorRepository.deleteById(id);
    }

    public Professor findProfessorByLogin(String login){
        return professorRepository.findByLogin(login);
    }

    public List<Professor> findAllProfessors(){
        return (List<Professor>) professorRepository.findAll();
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username);
		Person professor = professorRepository.findByLogin(username);
		if (professor == null) {
			throw new UsernameNotFoundException("This user dosn't exist");
		}else {
//			return new MyUserPrincipal(professor);
			return professor;
		}
	}
}
