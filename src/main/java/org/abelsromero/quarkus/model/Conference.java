package org.abelsromero.quarkus.model;

import lombok.Data;
import org.abelsromero.quarkus.orm.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "CONFERENCE")
@Data
public class Conference extends BaseEntity {

    @Column(unique = true)
    @NotBlank(message = "conference name cannot be blank")
    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

}
