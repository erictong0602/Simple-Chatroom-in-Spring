package com.user.api.userAPi.repository;

import com.user.api.userAPi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value=" update users u set u.logged_in = ?1 , u.last_modified_by=?2 , u.last_modified_date=?3 WHERE u.username = ?4 ", nativeQuery = true)
    void userStatus(Boolean status, String modifier, Date date, String username);
}
