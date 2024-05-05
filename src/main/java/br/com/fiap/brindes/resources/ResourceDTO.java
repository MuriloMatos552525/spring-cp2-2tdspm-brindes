package br.com.fiap.brindes.resources;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import br.com.fiap.brindes.dto.response.CategoriaResponse;

public interface ResourceDTO<Request, Response> {

    //Também deve fazer o findAll() com Example

    ResponseEntity<Response> findById(Long id);

    ResponseEntity<Response> save(Request r);

	ResponseEntity<Collection<CategoriaResponse>> findAll();


}