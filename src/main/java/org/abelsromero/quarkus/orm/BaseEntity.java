package org.abelsromero.quarkus.orm;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonbProperty("created-by")
    @Column(name = "created_by")
    private String createdBy;

    @JsonbProperty("created-on")
    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @JsonbProperty("updated-by")
    @Column(name = "updated_by")
    private String updatedBy;

    @JsonbProperty("updated-on")
    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;

}
