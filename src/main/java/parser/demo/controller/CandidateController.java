package parser.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parser.demo.entity.Candidate;
import parser.demo.service.CandidateService;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/fullName/{fullName}")
    public ResponseEntity<List<Candidate>> findByFullName(@PathVariable String fullName) {
        List<Candidate> candidates = candidateService.findByFullName(fullName);
        return ResponseEntity.ok(candidates);
    }

    @GetMapping("/desiredPosition/{desiredPosition}")
    public ResponseEntity<List<Candidate>> findByDesiredPositionContaining(@PathVariable String desiredPosition) {
        List<Candidate> candidates = candidateService.findByDesiredPositionContaining(desiredPosition);
        return ResponseEntity.ok(candidates);
    }

    @GetMapping("/skills/{skills}")
    public ResponseEntity<List<Candidate>> findBySkillsContaining(@PathVariable String skills) {
        List<Candidate> candidates = candidateService.findBySkillsContaining(skills);
        return ResponseEntity.ok(candidates);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countCandidates() {
        Long count = candidateService.countCandidates();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/{id}/{availability}")
    public ResponseEntity<Candidate> findByIdAndAvailability(@PathVariable Long id, @PathVariable String availability) {
        Candidate candidate = candidateService.findByIdAndAvailability(id, availability);
        return ResponseEntity.ok(candidate);
    }

    // Другие методы контроллера, если необходимо
}
