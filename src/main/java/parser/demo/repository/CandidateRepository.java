package parser.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import parser.demo.entity.Candidate;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    // Поиск соискателя по полному имени
    @Query("SELECT c FROM Candidate c WHERE c.fullName = :fullName")
    List<Candidate> findByFullName(@Param("fullName") String fullName);

    // Поиск соискателей по желаемой должности (подстрока в desiredPosition)
    @Query("SELECT c FROM Candidate c WHERE LOWER(c.desiredPosition) LIKE LOWER(concat('%', :desiredPosition, '%'))")
    List<Candidate> findByDesiredPositionContaining(@Param("desiredPosition") String desiredPosition);

    // Поиск соискателей по навыкам (подстрока в skills)
    @Query("SELECT c FROM Candidate c WHERE LOWER(c.skills) LIKE LOWER(concat('%', :skills, '%'))")
    List<Candidate> findBySkillsContaining(@Param("skills") String skills);

    // Подсчет количества соискателей
    @Query("SELECT COUNT(c) FROM Candidate c")
    Long countCandidates();

    // Поиск соискателя по ID и доступности
    @Query("SELECT c FROM Candidate c WHERE c.id = :id AND c.availability = :availability")
    Candidate findByIdAndAvailability(@Param("id") Long id, @Param("availability") String availability);
}
