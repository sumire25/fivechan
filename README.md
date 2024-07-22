# Clean Code: Practicas Usadas

## Nombres Descriptivos
Se usan nombres que revelen la intencion para las clases y metodos.
```java
public class Comment {
    private UUID id;
    private UUID topicId;
    private UUID userAuthId;
    private String content;
}
```
```java
public class CreateComment {
    private final CommentRepository commentRepository;

    public CreateComment(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void run(UUID id, UUID postId, UUID userAuthId, String content) {
        Comment comment = new Comment(id, postId, userAuthId, content);
        this.commentRepository.save(comment);
    }
}
```

## Encapsulacion
Se implementan modificadores de acceso apropiados para proteger los datos y garantizar que los cambios en los datos se realicen a traves de metodos definidos.
```java
public String getContent() {
    return content;
}

public void setContent(String content) {
    this.content = content;
}
```

## Uso de Interfaces
Se usan interfaces para abstraer la logica de persistencia, que se implementara luego.
```java
public interface CommentRepository {
    void save(Comment comment);
    Comment findById(UUID id);
    void deleteById(UUID id);
    void updateById(UUID id, Comment comment);
}
```