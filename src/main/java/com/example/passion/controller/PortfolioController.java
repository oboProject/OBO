package com.example.passion.controller;

import com.example.passion.domain.post.PortfolioEntity;
import com.example.passion.dto.PortfolioRequestDTO;
import com.example.passion.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
@RequiredArgsConstructor
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @GetMapping("/get")
    public ResponseEntity getPortfolioEntity(@RequestParam String title){
        PortfolioRequestDTO portfolioRequestDTO =
                PortfolioRequestDTO.builder().
                        title(title).
                        build();

        return new ResponseEntity(portfolioService.read(portfolioRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity postPortfolioEntity(@RequestBody PortfolioRequestDTO portfolioRequestDTO){
        return new ResponseEntity(portfolioService.create(portfolioRequestDTO), HttpStatus.OK);
    }

    @PatchMapping("/patch")
    public ResponseEntity patchPortfolioEntity(@RequestBody PortfolioRequestDTO portfolioRequestDTO){
        return new ResponseEntity(portfolioService.modify(portfolioRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deletePortfolioEntity(@RequestBody PortfolioRequestDTO portfolioRequestDTO){
        return new ResponseEntity(portfolioService.delete(portfolioRequestDTO), HttpStatus.OK);
    }

}
