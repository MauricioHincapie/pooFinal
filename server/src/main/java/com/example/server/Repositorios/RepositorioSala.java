package com.example.server.Repositorios;

import com.example.server.Modelos.Sala;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioSala extends MongoRepository<Sala,String> {
}

