package com.alanflores.mysql_connection.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String id;
    private String name;
    private String email;
    private String phone;
}