package parser.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import parser.demo.entity.Vacancy;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    // Поиск вакансий по заголовку
    @Query("SELECT v FROM Vacancy v WHERE v.title = :title")
    List<Vacancy> findByTitle(@Param("title") String title);

    // Поиск вакансий по навыкам
    @Query("SELECT v FROM Vacancy v WHERE LOWER(v.skills) LIKE LOWER(concat('%', :skills, '%'))")
    List<Vacancy> findBySkillsContaining(@Param("skills") String skills);

    // Подсчет количества вакансий
    @Query("SELECT COUNT(v) FROM Vacancy v")
    Long countVacancies();

    // Поиск вакансии по ID и типу занятости
    @Query("SELECT v FROM Vacancy v WHERE v.id = :id AND v.employmentType = :employmentType")
    Vacancy findByIdAndEmploymentType(@Param("id") Long id, @Param("employmentType") String employmentType);
}
