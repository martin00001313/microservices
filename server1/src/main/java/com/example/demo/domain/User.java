package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author martin
 */
@NoArgsConstructor
@Data
@Document(collection = "qb_expense")
public class User {

    @Id
    private String id;
}
