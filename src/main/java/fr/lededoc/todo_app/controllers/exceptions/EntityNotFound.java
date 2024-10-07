package fr.lededoc.todo_app.controllers.exceptions;

public class EntityNotFound extends RuntimeException {

    public EntityNotFound() {
        super("L'entité n'a pas été trouvée");
    }

}
