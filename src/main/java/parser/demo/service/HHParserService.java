package parser.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import parser.demo.entity.Vacancy;
import parser.demo.repository.CandidateRepository;
import parser.demo.repository.VacancyRepository;

import java.util.Arrays;

@Service
public class HHParserService {

    private final RestTemplate restTemplate;
    private final VacancyRepository vacancyRepository;
    private final CandidateRepository candidateRepository;

    @Autowired
    public HHParserService(RestTemplate restTemplate, VacancyRepository vacancyRepository, CandidateRepository candidateRepository) {
        this.restTemplate = restTemplate;
        this.vacancyRepository = vacancyRepository;
        this.candidateRepository = candidateRepository;
    }

    @Transactional
    public void parseVacancies(String query) {
        String url = "https://api.hh.ru/vacancies?text=" + query;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            System.out.println("Response from HH API:");
            System.out.println(responseBody);

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Vacancy[] vacancies = objectMapper.readValue(responseBody, Vacancy[].class);
                vacancyRepository.saveAll(Arrays.asList(vacancies));
                System.out.println("Saved " + vacancies.length + " vacancies to the database.");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Failed to retrieve vacancies from HH API. Status code: " + response.getStatusCodeValue());
        }
    }

    // Аналитика по вакансиям и соискателям
    public long countVacancies() {
        return vacancyRepository.count();
    }

    public long countCandidates() {
        return candidateRepository.count();
    }
}
