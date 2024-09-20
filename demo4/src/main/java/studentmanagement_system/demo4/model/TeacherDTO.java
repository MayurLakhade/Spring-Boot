package studentmanagement_system.demo4.model;

//import com.fasterxml.jackson.annotation.JsonProperty;

//import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO {

    private int tid;

    //@Column(length = 25, nullable = false)
    @NotBlank(message = "Trainer name cannot be blank")
    //@JsonProperty("tname")
    @Size(max = 25)
    private String tname;

    //@Column(length = 25, nullable = false)
    @NotBlank(message = "Trainer surname cannot be blank")
   //@JsonProperty("tsurname")
    @Size(max = 25)
    private String tsurname;

    //@Column(length = 25, nullable = false)
    @NotBlank(message = "Trainer email cannot be blank")
    @Email(message = "email id is not proper")
    //@JsonProperty("temail")
    @Size(max = 25)
    private String temail;

    //@Column(length = 11, nullable = false, unique = true)
    @NotNull(message = "trainer phone cannot be null")
   // @JsonProperty("tphone")
   @Size(max = 11)
    private long tphone;

    //@Column(length = 25, nullable = false)
    @NotBlank(message = "Designation cannot be blank")
    //@JsonProperty("designation")
    @Size(max = 25)
    private String designation;

    
}
