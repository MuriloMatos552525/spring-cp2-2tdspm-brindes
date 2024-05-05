package br.com.fiap.brindes.service;


import org.springframework.data.domain.Example;

import br.com.fiap.brindes.dto.request.CategoriaRequest;
import br.com.fiap.brindes.dto.request.ProdutoRequest;
import br.com.fiap.brindes.dto.response.CategoriaResponse;
import br.com.fiap.brindes.dto.response.ProdutoResponse;

import java.util.Collection;

/**
 * @param <Entity>    Entity
 * @param <Request>   RequestDTO
 * @param <Response>> ResponseDTO
 */
public interface ServiceDTO<Entity, Request, Response> {
    /**
     * Busca todas as entidades
     *
     * @return
     */
    public Collection<Entity> findAll();

    /**
     * Consulta todas as entidades conforme o exemplo fornecido
     *
     * @param example
     * @return
     */
    public Collection<Entity> findAll(Example<Entity> example);

    /**
     * Busca uma entidade por Id
     *
     * @param id
     * @return
     */
    public Entity findById(Long id);

    /**
     * Persiste uma entidade no banco de dados
     *
     * @param e
     * @return
     */
    public Entity save(Entity e);

    /**
     * Transforma o RequestDTO em Entidade
     *
     * @param dto é um DTO de requisição ( RequestDTO )
     * @return uma Entidade
     */
    public Entity toEntity(Request dto);

    /**
     * Transforma uma Entidade em um DTO de Resposta (ResponseDTO)
     *
     * @param e
     * @return
     */
    public Response toResponse(Entity e);

	CategoriaResponse save(CategoriaRequest request);

	ProdutoResponse save(ProdutoRequest request);


}