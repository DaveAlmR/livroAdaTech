package com.projetinho.livrinho.repository;

import com.projetinho.livrinho.model.IBaseObject;
import com.projetinho.livrinho.model.Livrinho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericRepository<T extends IBaseObject> {
    private List<T> objects = Collections.synchronizedList(new ArrayList<>());
    private static Long lastId = 0L;

    public void create(T object) {
        object.setId(++lastId);
        objects.add(object);
    }

    public T find(Long id) {
        try {
            return objects.stream().filter(o -> o.getId().equals(id)).findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }

    public List<T> getAll() {
        return objects;
    }

    public void update(T object) {
        var objectToUpdate = this.find(object.getId());
        if (objectToUpdate == null)
            this.create(object);
        else {
            objects.remove(objectToUpdate);
            objects.add(object);
        }
    }

    public void delete(Long id) {
        var object = objects.stream().filter(l -> l.getId().equals(id)).findFirst().get();
        objects.remove(object);
    }
}
