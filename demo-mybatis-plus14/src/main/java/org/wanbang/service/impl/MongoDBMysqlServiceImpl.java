package org.wanbang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wanbang.dao.MyDocumentRepository;
import org.wanbang.dao.UserDao;
import org.wanbang.entity.MyDocument;
import org.wanbang.entity.User;
import org.wanbang.service.MongoDBMysqlService;

import javax.annotation.Resource;

@Service
public class MongoDBMysqlServiceImpl implements MongoDBMysqlService {
    @Resource
    private UserDao userDao;

    @Autowired
    private MyDocumentRepository repository;

    @Override
    public Integer insertData() {
        User build = User.builder().id(111L).age(18).name("mjj").password("123").sex("男").build();
        int insert = userDao.insert(build);

        MyDocument document = new MyDocument();
        document.setData("123");
        repository.insert(document);
        return insert;
    }
}
