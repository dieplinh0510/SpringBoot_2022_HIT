package com.example.ktra_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddressDTO {

    @NotBlank(message = "Khong hop le")
    @Length(max = 20, min = 10, message = "Khong hop le")
    private String name;
    private Long code;

}
