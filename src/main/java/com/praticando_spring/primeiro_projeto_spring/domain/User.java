package com.praticando_spring.primeiro_projeto_spring.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity // Define que a classe User será uma entidade no nosso sistema e no nosso banco de dados
@Table(name = "users") // Define que essa classe será mapeada para uma tabela do banco de dados chamada `users`
@Setter // Define os setters automaticamente.
@Getter // define os getters automaticamente.
@AllArgsConstructor // define um construtor com todos os argumentos automaticamente.
@NoArgsConstructor
public class User {
    @Id // Define que o atributo id será a PRIMARY KEY da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false) // Define que o atributo name não pode ser nulo
    private String name;

    @Column(nullable = false, unique = true) // Define que o atributo email não pode ser nulo e deve ser unico!
    private String email;

    @Column(nullable = false) // Define que o atributo password não pode ser nulo
    private String password;
}
