package com.example.kebbaj1.repositories;

import com.example.kebbaj1.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepo extends JpaRepository<Personne, Long> {
}
