package org.wanbang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wanbang.dao.MyDocumentRepository;
import org.wanbang.entity.MyDocument;
import org.wanbang.service.MyDocumentService;

@Service
public class MyDocumentServiceImpl implements MyDocumentService {

    @Autowired
    private MyDocumentRepository repository;

    public MyDocument insertData(String data) {
        MyDocument document = new MyDocument();
        document.setData(data);
        return repository.insert(document);
    }
}
