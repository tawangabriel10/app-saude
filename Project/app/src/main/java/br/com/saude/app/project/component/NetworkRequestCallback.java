package br.com.saude.app.project.component;

/**
 * Created by tawan on 3/3/17.
 */

public interface NetworkRequestCallback<T> extends RequestResponseInterface<T> {

    void onRequestResponse(T response);
    void onRequestError(Exception error);
}
