package br.com.fiap.brindes.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProdutoRequest(

        @Size(min = 3, max = 255, message = "Nome inválido")
        @NotNull(message = "Nome não pode ser nulo")
        String nome,

        @Positive(message = "Preço deve ser positivo")
        @NotNull(message = "Preço não pode ser nulo")
        Double preco,

        @NotNull(message = "Categoria não pode ser nula")
        AbstractRequest categoria
) {
}