package com.example.server.Repositorios;

import com.example.server.Modelos.Funcion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioFuncion extends MongoRepository<Funcion,String> {
}
