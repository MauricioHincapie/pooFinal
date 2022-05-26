package com.example.server.Repositorios;

import com.example.server.Modelos.Pelicula;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPelicula extends MongoRepository<Pelicula,String> {
}
