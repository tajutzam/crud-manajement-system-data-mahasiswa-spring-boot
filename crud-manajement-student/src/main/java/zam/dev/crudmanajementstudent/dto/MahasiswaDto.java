package zam.dev.crudmanajementstudent.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MahasiswaDto {

    
    @NotEmpty(message = "message can empty")
    private String name;


    @NotEmpty(message = "nim can empty")

    private String nim;

    @NotEmpty(message = "address can empty")
    @Column(name = "addres" , length = 200)
    private String addres;

    @NotEmpty(message = "email can empty")
    @Email(message = "email not valid")
    @NotNull(message = "email cant null")

    private String email;
    
}
