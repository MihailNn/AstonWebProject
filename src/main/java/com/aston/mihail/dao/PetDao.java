package com.aston.mihail.dao;

import com.aston.mihail.model.Pet;

import java.util.Set;

public interface PetDao {
    Pet findById (int id);
    Pet save (Pet pet);
    Set<Pet> findAll();
    Pet delete (int id);
}
