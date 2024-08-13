package com.mycompany.testingsqlconnection.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Employed {

    private String name;

    private String address;

    private String phoneNumber;

    private String birthDate;

    private String email;

    private Gender gender;
}
