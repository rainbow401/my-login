package com.yzh.oauth2.Repository;

import com.yzh.oauth2.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
