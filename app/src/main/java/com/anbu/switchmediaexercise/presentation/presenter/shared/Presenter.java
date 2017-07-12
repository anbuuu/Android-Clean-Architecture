package com.anbu.switchmediaexercise.presentation.presenter.shared;

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 */
public interface Presenter<V> {
    void bind(V view);
}
