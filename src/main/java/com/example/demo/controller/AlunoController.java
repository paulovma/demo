package com.example.demo.controller;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<String>> getAlunos() {
        return new ResponseEntity<List<String>>(alunoService.getAlunos(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getAluno(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.getAlunoByIndex(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> criaAluno(@RequestBody AlunoDTO dto) {
        alunoService.criaAluno(dto);
        return ResponseEntity.created(URI.create("/aluno/45443323")).build();
    }

}
