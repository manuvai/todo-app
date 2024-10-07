package fr.lededoc.todo_app.controllers.exceptions;

import java.util.concurrent.ExecutionException;

public class EntityNotFound extends RuntimeException {

    public EntityNotFound() {
        super("L'entité n'a pas été trouvée");
    }

}
