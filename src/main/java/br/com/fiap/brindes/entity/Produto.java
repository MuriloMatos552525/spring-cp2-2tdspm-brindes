package br.com.fiap.brindes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "TB_PRODUTO_rm552525" , uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NM_PRODUTO_rm552525","ID_CATEGORIA_rm552525"})
})
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO_rm552525")
    @SequenceGenerator(
            name = "SQ_PRODUTO_rm552525",
            sequenceName = "SQ_PRODUTO_rm552525",
            allocationSize = 1
    )
    @PrimaryKeyJoinColumn()
    @Column(name = "ID_PRODUTO_rm552525", nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name = "NM_PRODUTO_rm552525", nullable = false, unique = true)
    private String nome;

    @NotNull
    @Column(name = "PRECO_PROD_rm552525", nullable = false)
    private Double preco;

    @ManyToOne()
    @JoinColumn(name = "ID_CATEGORIA_rm552525", nullable = false, foreignKey = @ForeignKey(name="FK_PRODUTO_CATEGORIA_rm552525"))
    private Categoria categoria;

    @ManyToMany(mappedBy = "produtosComercializados")
    private Set<Loja> lojas;

}
