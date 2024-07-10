package org.wanbang.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.wanbang.entity.User;

/**
 * @author rtxtitanv
 * @version 1.0.0
 * @name com.rtxtitanv.repository.UserRepository
 * @description UserRepository用来操作用户集合，此处的集合是MongoDB中的术语
 * @date 2021/5/26 18:34
 */
public interface UserRepository extends MongoRepository<User, ObjectId> {

}

