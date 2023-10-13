package com.bofa.repos;

import com.bofa.entities.Clothes;
import com.bofa.exceptions.ClothesNotFoundException;
import com.bofa.utils.MockDB;
import java.util.List;

public class ClothesRepo extends GenericRepo<Clothes> {

    @Override
    public List<Clothes> getAll() {
        return MockDB.clothesList;
    }

    @Override
    public Clothes save(Clothes clothesToSave) {
        MockDB.clothesList.add(clothesToSave);
        return clothesToSave;
    }

    @Override
    public void update(Clothes clothesToUpdate) {
        int index = 0;
        for (Clothes clothes : MockDB.clothesList) {
            if (clothes.getIscn() == clothesToUpdate.getIscn()) {
                index = MockDB.clothesList.indexOf(clothes);
            }
        }
        MockDB.clothesList.set(index, clothesToUpdate);
    }

    @Override
    public void delete(int clothesIscn) {
        MockDB.clothesList.removeIf(clothes -> clothes.getIscn() == clothesIscn);
    }
}
