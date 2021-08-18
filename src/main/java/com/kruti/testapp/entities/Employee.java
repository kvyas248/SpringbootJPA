package com.kruti.testapp.entities;


import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employee {
    @Getter
    @Setter
    Integer id;

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    String email;
}
