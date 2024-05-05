package br.com.fiap.brindes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "TB_LOJA_rm552525" , uniqueConstraints = {
        @UniqueConstraint(name = "UK_NOME_LOJA_rm552525",columnNames = {"NM_LOJA_rm552525"})
})
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_LOJA_rm552525")
    @SequenceGenerator(
            name = "SQ_LOJA_rm552525",
            sequenceName = "SQ_LOJA_rm552525",
            allocationSize = 1
    )
    @Column(name = "ID_LOJA_rm552525", nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name = "NM_LOJA_rm552525", nullable = false, unique = true)
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TB_LOJA_PRODUTO_rm552525",
            joinColumns = {
                    @JoinColumn(
                            name = "LOJA_rm552525",
                            referencedColumnName = "ID_LOJA_rm552525",
                            foreignKey = @ForeignKey(name = "FK_LOJA_PRODUTO_rm552525")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PRODUTO_rm552525",
                            referencedColumnName = "ID_PRODUTO_rm552525",
                            foreignKey = @ForeignKey(name = "FK_PRODUTO_LOJA_rm552525")
                    )
            }
    )

    @PrimaryKeyJoinColumn()
    private Set<Produto> produtosComercializados = new LinkedHashSet<>();

}
