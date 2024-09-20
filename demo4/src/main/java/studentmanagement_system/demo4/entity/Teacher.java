package studentmanagement_system.demo4.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Trainer_info")
public class Teacher {

    @Id
    @JsonProperty("tid")
    private int tid;

    @Column(length = 25, nullable = false)
    @NotBlank(message = "Trainer name cannot be blank")
    @JsonProperty("tname")
    private String tname;

    @Column(length = 25, nullable = false)
    @NotBlank(message = "Trainer surname cannot be blank")
    @JsonProperty("tsurname")
    private String tsurname;

    @Column(length = 25, nullable = false)
    @NotBlank(message = "Trainer email cannot be blank")
    @Email(message = "email id is not proper")
    @JsonProperty("temail")
    private String temail;

    @Column(length = 11, nullable = false, unique = true)
    @NotNull(message = "trainer phone cannot be null")
    @JsonProperty("tphone")
    private long tphone; 

    @Column(length = 25, nullable = false)
    @NotBlank(message = "Designation cannot be blank")
    @JsonProperty("designation")
    private String designation;

    @OneToMany(mappedBy = "teacher", 
     fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Batches> batchDetails;
	
	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="deptID", referencedColumnName = "did")
	@JsonBackReference 
	private Department department;


    // public Teacher() {
    // }

    // public int getTid() {
    //     return tid;
    // }

    // public void setTid(int tid) {
    //     this.tid = tid;
    // }

    // public String getTname() {
    //     return tname;
    // }

    // public void setTname(String tname) {
    //     this.tname = tname;
    // }

    // public String getTsurname() {
    //     return tsurname;
    // }

    // public void setTsurname(String tsurname) {
    //     this.tsurname = tsurname;
    // }

    // public String getTemail() {
    //     return temail;
    // }

    // public void setTemail(String temail) {
    //     this.temail = temail;
    // }

    // public long getTphone() {
    //     return tphone;
    // }

    // public void setTphone(long tphone) {
    //     this.tphone = tphone;
    // }

    // public String getDesignation() {
    //     return designation;
    // }

    // public void setDesignation(String designation) {
    //     this.designation = designation;
    // }


   
    




     @Override
    public String toString() {
        return "Teacher [tid=" + tid + ", tname=" + tname + ", tsurname=" + tsurname + ", temail=" + temail
                + ", tphone=" + tphone + ", designation=" + designation + "]";
    }
}
    

