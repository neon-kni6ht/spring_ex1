package com.example.demo.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@NoArgsConstructor
@Data
@Table(name = "sk_example_table")
public class ModifiableRecord {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JdbcTypeCode(SqlTypes.JSON)
    private InternalObj obj;
}
