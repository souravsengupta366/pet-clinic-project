package com.sourav.petclinic.services.map;

import com.sourav.petclinic.services.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMap <T,ID>  implements CrudService<T,ID> {

    protected Map<ID,T> map = new HashMap<>();

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(ID id, T object) {
        map.put(id, object);
        return object;
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<T>(map.values());
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> (entry.getValue().equals(object)));
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }
}
