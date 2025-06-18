package com.praticando_spring.primeiro_projeto_spring.configuration;

import org.springframework.context.annotation.Configuration;

// @Configuration define que essa classe será responsavel por configurar @Beans
// @Beans são anotações que definem metodos para instanciar objetos da forma que queremos
// Ex: Temos a interface IUserService e queremos que sempre que uma instancia dessa interface seja solicitada,
//      um objeto de UserService seja retornado no lugar da interface.
//      Se não fizessemos isso, o java tentaria instanciar a própria interface e isso causaria um erro.
@Configuration
public class UserConfiguration {

}
