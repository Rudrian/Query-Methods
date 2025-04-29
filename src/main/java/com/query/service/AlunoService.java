package com.query.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.query.entities.Aluno;
import com.query.repository.AlunoRepository;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    
    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    
    //Query Methods
    public List<Aluno> buscarAlunosPorCidade(String cidade){
    	return alunoRepository.findByCidade(cidade);
    }
    public List<Aluno> buscarAlunosPorNome(String nome){
    	return alunoRepository.findByNome(nome);
    }
    
    public List<Aluno> buscarAlunosPorRenda(double renda){
    	return alunoRepository.findByRenda(renda);
    }
    
    public List<Aluno> buscarAlunosPorRa(String ra){
    	return alunoRepository.findByRa(ra);
    }
    
    public List<Aluno> buscarAlunosPorEmail(String email){
    	return alunoRepository.findByEmail(email);
    }

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }
    
    public Aluno getAlunoById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }
    

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno updateAluno(Long id, Aluno updatedAluno) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) {
            updatedAluno.setId(id);
            return alunoRepository.save(updatedAluno);
        }
        return null;
    }

    public boolean deleteAluno(Long id) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

