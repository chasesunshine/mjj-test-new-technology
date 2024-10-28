package org.wanbang.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class MyDocument {
    @Id
    private String id;
    private String data;

    // Getters and Setters
}
