package com.example.demo.service;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.model.Aluno;
import com.example.demo.model.Mentor;
import com.example.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private MentorService mentorService;

    private List<String> alunos = new ArrayList<>(List.of("Paulo", "Paulo Amaral", "Paulo Silva", "Paulo Amaral Silva"));

    public List<String> getAlunos() {
        System.out.println("Teste");
        return alunos;
    }

    public AlunoDTO getAlunoByIndex(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElse(null);
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setClasse(aluno.getClasse());
        alunoDTO.setName(aluno.getName());
//        alunoDTO.setMentorName(aluno.getMentor().getName());
        return alunoDTO;
    }

    public void criaAluno(AlunoDTO alunoDTO) {
        Mentor mentor = mentorService.getById(alunoDTO.getMentorId());
        //recebi um mentorId
        //buscar o mentor mentor na base ( findById(alunoDTO.getMentorId())
        //aluno.setMentor(mentorDaBase)
        //criar um aluno
        //seto os valores
        //salvo
        Aluno aluno = new Aluno(alunoDTO);
        Aluno savedAluno = alunoRepository.save(aluno);
        alunoDTO.setId(savedAluno.getId());
    }

    @Transactional
    public void deleteALunoById(Long id) {
        Aluno one = alunoRepository.getOne(id);
        one.setActive(false);
        alunoRepository.save(one);
    }
}
