package com.praticando_spring.primeiro_projeto_spring.repositories;

import com.praticando_spring.primeiro_projeto_spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

// Definimos uma interface de repositorio para a nossa entidade/classe `User`
// O repositório é uma classe que vai centralizar a lógica de acesso a dados do nosso sistema
// Aqui ficará todas as queries SQL que vamos criar e usar no sistema.
// Para facilitar o processo de construção de classes de repositório vamos extender a classe com a interface JpaRepository<Entity, identifier>
// O JpaRepository<Entity, identifier> define metodos prontos para CRUD na nossa classe de repositório.
// Alguns exemplos dos metodos prontos: findAll(), findById, delete(), save() e muitas outras.
// É possivel criar metodos adicionais caso sejá necessário.
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    UserDetails findByEmail(String email);
}
