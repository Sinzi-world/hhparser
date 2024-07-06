package parser.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parser.demo.entity.Candidate;
import parser.demo.repository.CandidateRepository;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> findByFullName(String fullName) {
        return candidateRepository.findByFullName(fullName);
    }

    public List<Candidate> findByDesiredPositionContaining(String desiredPosition) {
        return candidateRepository.findByDesiredPositionContaining(desiredPosition);
    }

    public List<Candidate> findBySkillsContaining(String skills) {
        return candidateRepository.findBySkillsContaining(skills);
    }

    public Long countCandidates() {
        return candidateRepository.countCandidates();
    }

    public Candidate findByIdAndAvailability(Long id, String availability) {
        return candidateRepository.findByIdAndAvailability(id, availability);
    }
}
