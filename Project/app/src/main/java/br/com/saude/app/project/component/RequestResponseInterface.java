package br.com.saude.app.project.component;

/**
 * Created by tawan on 3/10/17.
 */
@FunctionalInterface
public interface RequestResponseInterface<T> {

    void onRequestResponse(T response);
}
