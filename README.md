# Dev Branch
## Practicas Utilizadas
# Fivechan Forum Project

Este proyecto es una implementación de un foro utilizando Spring Boot 3.3 y Java 21, siguiendo los principios de Domain-Driven Design (DDD) y Clean Architecture, para destacar buenas prácticas de codificación legible implementadas en el proyecto.

## Buenas Prácticas de Codificación Legible

### 1. Nombres Significativos

Los nombres de las clases, métodos y variables deben ser claros y descriptivos para que el código sea autoexplicativo. Esta práctica mejora la legibilidad y facilita el entendimiento del código por otros desarrolladores.

#### Ejemplos:
- **Clases**: `CreateUser`, `FindUserById` en lugar de nombres genéricos como `UserService`.
- **Métodos**: `execute` en lugar de `process` o `run`, ya que `execute` describe mejor la acción realizada.

**Ejemplo en `CreateUser.java`:**
```java
package com.fivechan.forum.context.user.application;

import com.fivechan.forum.context.user.domain.User;
import com.fivechan.forum.context.user.domain.UserRepository;

import java.util.UUID;

public class CreateUser {

    private final UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(UUID id, String name, String description, String avatar) {
        User user = new User(id, name, description, avatar);
        userRepository.save(user);
    }
}

```
### 2. Funciones Pequeñas y Coherentes

Las funciones deben ser pequeñas y realizar una única tarea bien definida. Esto facilita su comprensión, prueba y mantenimiento.

#### Ejemplo:
- **Método `execute` en `CreateUser.java`**: Este método es responsable únicamente de crear un usuario y guardarlo en el repositorio. No realiza ninguna otra tarea, lo que sigue el principio de responsabilidad única.

**Ejemplo en `CreateUser.java`:**
```java
public class CreateUser {

    private final UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(UUID id, String name, String description, String avatar) {
        User user = new User(id, name, description, avatar);
        userRepository.save(user);
    }
}

```

### 3. Configuración de Beans

En lugar de usar anotaciones explícitas como `@Autowired` o constructores en los controladores, se recomienda usar una configuración de beans centralizada para manejar la inyección de dependencias. Esto facilita el mantenimiento y la gestión de las dependencias.

#### Ejemplo en `BeanConfiguration.java`:
```java
package com.fivechan.forum.configuration;

import com.fivechan.forum.context.user.application.CreateUser;
import com.fivechan.forum.context.user.application.FindUserById;
import com.fivechan.forum.context.user.domain.UserRepository;
import com.fivechan.forum.context.user.infrastructure.PostgresqlUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new PostgresqlUserRepository();
    }

    @Bean
    public CreateUser createUser(UserRepository userRepository) {
        return new CreateUser(userRepository);
    }

    @Bean
    public FindUserById findUserById(UserRepository userRepository) {
        return new FindUserById(userRepository);
    }
}

