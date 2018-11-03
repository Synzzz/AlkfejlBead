package hu.elte.Neptun.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//Kurzusok (targyon belul csoport stb)

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Course implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private Integer studentCount;
            
    @Column
    @NotNull
    private Integer studentLimit;       
    
    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students;
    
    @JsonIgnore
    @OneToOne
    private Subject subject;
    
    @JsonIgnore
    @OneToOne
    private Teacher teacher;
    
}
