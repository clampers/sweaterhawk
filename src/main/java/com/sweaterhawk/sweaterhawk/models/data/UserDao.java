package com.sweaterhawk.sweaterhawk.models.data;

import com.sweaterhawk.sweaterhawk.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
    User findByName(String name);
    boolean existsByName(String name);
}
