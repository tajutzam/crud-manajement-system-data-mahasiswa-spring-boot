package zam.dev.crudmanajementstudent.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Mahasiswa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name cant not blank")
    private String name;

    @Column(unique = true , length = 10)
    @NotBlank(message = "Nim cant not blank")
    private String nim;

    @Column(name = "addres" , length = 200)
    @NotBlank(message = "addres cant not blank")
    private String addres;

    @Column(unique = true)
    @NotBlank(message = "email cant not blank")
    @Email(message = "email not valid")
    private String email;

    
    
}
