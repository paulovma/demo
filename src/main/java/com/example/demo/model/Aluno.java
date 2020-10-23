package com.example.demo.model;

import com.example.demo.dto.AlunoDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String classe;

    @Column
    private Boolean active;

    public Aluno(String name, String classe) {
        this.name = name;
        this.classe = classe;
    }

    public Aluno(AlunoDTO alunoDTO) {
        this.name = alunoDTO.getName();
        this.classe = alunoDTO.getClasse();
    }

}
