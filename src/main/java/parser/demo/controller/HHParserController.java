package parser.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parser.demo.service.HHParserService;

@RestController
@RequestMapping("/api/parser")
public class HHParserController {

    private final HHParserService hhParserService;

    @Autowired
    public HHParserController(HHParserService hhParserService) {
        this.hhParserService = hhParserService;
    }

    @GetMapping("/parseVacancies")
    public ResponseEntity<String> parseVacancies(@RequestParam String query) {
        hhParserService.parseVacancies(query);
        return ResponseEntity.ok("Parsing started for query: " + query);
    }

    @GetMapping("/analytics/vacanciesCount")
    public ResponseEntity<Long> countVacancies() {
        long count = hhParserService.countVacancies();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/analytics/candidatesCount")
    public ResponseEntity<Long> countCandidates() {
        long count = hhParserService.countCandidates();
        return ResponseEntity.ok(count);
    }
}
