package com.example.auth.mapper;

import com.example.auth.model.User;

import java.util.List;
import java.util.Optional;

public interface  IEntityMapper <R, E> {

    R toResource(E e);

    E toEntity(R r);

    List<R> toResourse(List<E> eList);

    List<E> toEntity(List<R> rList);
}
