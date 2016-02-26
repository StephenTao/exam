package com.augmentum.common.mybatis;

public interface IBaseDao<T, K> {

    public boolean add(T obj);

    public boolean delete(K id);

    public boolean update(T obj);

    public T getById(K id);

}