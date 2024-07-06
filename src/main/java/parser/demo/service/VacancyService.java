package parser.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parser.demo.entity.Vacancy;
import parser.demo.repository.VacancyRepository;

import java.util.List;

@Service
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public List<Vacancy> findByTitle(String title) {
        return vacancyRepository.findByTitle(title);
    }

    public List<Vacancy> findBySkillsContaining(String skills) {
        return vacancyRepository.findBySkillsContaining(skills);
    }

    public Long countVacancies() {
        return vacancyRepository.countVacancies();
    }

    public Vacancy findByIdAndEmploymentType(Long id, String employmentType) {
        return vacancyRepository.findByIdAndEmploymentType(id, employmentType);
    }
}
