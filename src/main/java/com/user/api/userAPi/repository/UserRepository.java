package com.user.api.userAPi.repository;

import com.user.api.userAPi.model.UserForm;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserForm,Integer> {
}
