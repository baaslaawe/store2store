package com.playmoweb.store2store.store;

import com.playmoweb.store2store.utils.Filter;
import com.playmoweb.store2store.utils.SortingMode;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * @author Thibaud Giovannetti
 * @by Playmoweb
 * @date 07/09/2017
 */
public abstract class StoreDao<T> {

    public Flowable<Optional<List<T>>> getAll(final Filter filter, final SortingMode sortingMode) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    public Flowable<Optional<List<T>>> getAll(List<T> items) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    public Flowable<Optional<T>> getOne(final Filter filter, final SortingMode sortingMode) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    public Flowable<Optional<T>> getOne(final T item) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    public Flowable<Optional<T>> getById(final int id) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    public Flowable<Optional<T>> insert(final T item) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    public Flowable<Optional<List<T>>> insert(final List<T> items) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    public Flowable<Optional<T>> update(final T item) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    public Flowable<Optional<List<T>>> update(final List<T> items) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    public Flowable<Optional<T>> insertOrUpdate(final T item) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    public Flowable<Optional<List<T>>> insertOrUpdate(final List<T> items) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    /**
     * @return int  Number of items deleted
     */
    public Flowable<Integer> delete(final List<T> items) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    /**
     * @return int  Number of items deleted
     */
    public Flowable<Integer> delete(final T item) {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    /**
     * @return int  Number of items deleted
     */
    public Flowable<Integer> deleteAll() {
        throw new UnsupportedOperationException("This method has not been implemented in the child class");
    }

    /**
     * Wrap an object into an flowable optional
     */
    protected <S> Flowable<Optional<S>> wrapOptional(S obj){
        return Flowable.just(Optional.wrap(obj));
    }

    /**
     * Wrap a flowable object into an flowable optional
     */
    protected <S> Flowable<Optional<S>> wrapOptional(Flowable<S> obj){
        return obj.flatMap(new Function<S, Flowable<Optional<S>>>() {
            @Override
            public Flowable<Optional<S>> apply(S s) throws Exception {
                return wrapOptional(s);
            }
        });
    }
}
