package parser.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String skills;
    private String employmentType;
}