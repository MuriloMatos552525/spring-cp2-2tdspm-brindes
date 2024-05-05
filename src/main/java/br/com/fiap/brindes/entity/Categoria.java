package br.com.fiap.brindes.entity;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tb_categoria_rm552525", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NOME_CATEGORIA_rm552525", columnNames = {"NM_CATEGORIA_rm552525"})
})

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CATEGORIA_rm552525")
    @SequenceGenerator(
            name = "SQ_CATEGORIA_rm552525",
            sequenceName = "SQ_CATEGORIA_rm552525",
            allocationSize = 1
    )
    @Column(name = "ID_CATEGORIA_rm552525", nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name = "NM_CATEGORIA_rm552525", nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Produto> produtos;

}
