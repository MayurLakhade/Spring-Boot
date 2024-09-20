package studentmanagement_system.demo4.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Batches {

    @Id
    private int bid;
    private String bname;
    private String subject;
    private String startDate;
    private String endDate;
    private String duration;

    @ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="TeacherId", referencedColumnName = "tid")
	@JsonBackReference
	private Teacher teacher;
    
}
