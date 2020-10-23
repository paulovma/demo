package com.example.demo.dto;

import com.example.demo.model.Aluno;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoDTO {

    private Long id;

    private String name;

    private String classe;

    private String mentorName;

    private Long mentorId;

    public Aluno getModelo() {
        return new Aluno(this.getName(), this.getClasse());
    }


}
