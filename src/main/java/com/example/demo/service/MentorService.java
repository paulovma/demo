package com.example.demo.service;

import com.example.demo.model.Mentor;
import com.example.demo.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    public Mentor getById(Long id) {
        return mentorRepository.findById(id).orElse(null);
    }
}
