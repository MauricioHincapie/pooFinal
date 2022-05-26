package com.example.server.Repositorios;

import com.example.server.Modelos.Boleto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioBoleto extends MongoRepository<Boleto,String> {
}
