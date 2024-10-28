package org.wanbang.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.wanbang.entity.MyDocument;

public interface MyDocumentRepository extends MongoRepository<MyDocument, String> {
}
