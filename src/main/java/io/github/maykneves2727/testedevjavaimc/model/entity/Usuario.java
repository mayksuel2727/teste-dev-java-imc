package io.github.maykneves2727.testedevjavaimc.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150, nullable = false)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @Column(length = 11, nullable = false, unique = true)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(length = 50, nullable = false)
    private String classificacao;

    @Column(nullable = false)
    @NotNull(message = "{campo.peso.obrigatorio}")
    private double peso;

    @Column(nullable = false)
    @NotNull(message = "{campo.altura.obrigatorio}")
    private double altura;

    @Column(nullable = false)
    private  double imc;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @PrePersist
    public void prePersist(){
        setData(LocalDate.now());
    }

}
