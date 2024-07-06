package parser.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parser.demo.entity.Vacancy;
import parser.demo.service.VacancyService;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyService vacancyService;

    @Autowired
    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Vacancy>> findByTitle(@PathVariable String title) {
        List<Vacancy> vacancies = vacancyService.findByTitle(title);
        return ResponseEntity.ok(vacancies);
    }

    @GetMapping("/skills/{skills}")
    public ResponseEntity<List<Vacancy>> findBySkillsContaining(@PathVariable String skills) {
        List<Vacancy> vacancies = vacancyService.findBySkillsContaining(skills);
        return ResponseEntity.ok(vacancies);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countVacancies() {
        Long count = vacancyService.countVacancies();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/{id}/{employmentType}")
    public ResponseEntity<Vacancy> findByIdAndEmploymentType(@PathVariable Long id, @PathVariable String employmentType) {
        Vacancy vacancy = vacancyService.findByIdAndEmploymentType(id, employmentType);
        return ResponseEntity.ok(vacancy);
    }

    // Другие методы контроллера, если необходимо
}
