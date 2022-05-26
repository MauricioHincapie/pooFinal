package com.example.server.Repositorios;

import com.example.server.Modelos.Silla;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioSilla extends MongoRepository<Silla,String> {
}
