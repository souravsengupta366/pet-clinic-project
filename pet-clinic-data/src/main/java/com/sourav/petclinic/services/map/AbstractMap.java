package com.sourav.petclinic.services.map;

import com.sourav.petclinic.model.BaseEntity;
import com.sourav.petclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMap <T extends BaseEntity,ID extends Long>  implements CrudService<T,ID> {

    protected Map<Long,T> map = new HashMap<>();

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {
        if(object.getId() == null)
            object.setId(getNextId());
        map.put(object.getId(),object);
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

    public Long getNextId(){
        try{
            return Collections.max(map.keySet())+1;
        }catch (NoSuchElementException e){
            return 1L;
        }

    }
}
