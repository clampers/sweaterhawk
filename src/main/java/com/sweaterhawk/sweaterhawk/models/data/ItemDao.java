package com.sweaterhawk.sweaterhawk.models.data;

import com.sweaterhawk.sweaterhawk.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ItemDao extends CrudRepository<Item, Integer> {
}
