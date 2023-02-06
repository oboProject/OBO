package com.example.passion.controller;

import com.example.passion.mapper.ImageMapper;
import com.example.passion.dto.ImageDTO;
import com.example.passion.dto.PortfolioDTO;
import com.example.passion.model.post.ImageEntity;
import com.example.passion.service.ImageHandler;
import com.example.passion.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/user")
@RequiredArgsConstructor
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;
    ImageHandler imageHandler;
    ImageMapper imageMapper;

    @PostMapping("post/image")
    public ResponseEntity postPortfolioWithImageFile(@ModelAttribute PortfolioDTO.RequestPortfolioDTO requestPortfolioDTO){

        List<ImageDTO.BuffImageDTO> buffImageDTOS =
                requestPortfolioDTO
                        .getRequestImageDTOS()
                        .stream()
                        .map(imageHandler::uploadImage)
                        .collect(Collectors.toList());

        List<ImageEntity> imageEntities =
                buffImageDTOS
                        .stream()
                        .map(imageMapper::buffImageDtoToImageEntity)
                        .collect(Collectors.toList());





        return null;
    }

    @GetMapping("get/{portfolioId}")
    public ResponseEntity getPortfolioEntityById(@PathVariable("portfolioId") String portfolioId){

          return new ResponseEntity(portfolioService.readById(portfolioId),HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity getPortfolioEntityByTitle(@RequestParam String title){
        PortfolioDTO.RequestPortfolioDTO requestPortfolioDTO =
                PortfolioDTO.RequestPortfolioDTO.builder().
                        title(title).
                        build();

        return new ResponseEntity(portfolioService.read(requestPortfolioDTO), HttpStatus.OK);
    }


    @PostMapping("/post")
    public ResponseEntity postPortfolioEntity(@RequestBody PortfolioDTO.RequestPortfolioDTO portfolioRequestDTO){
        return new ResponseEntity(portfolioService.create(portfolioRequestDTO), HttpStatus.OK);
    }

    @PatchMapping("/patch")
    public ResponseEntity patchPortfolioEntity(@RequestBody PortfolioDTO.RequestPortfolioDTO portfolioRequestDTO){
        return new ResponseEntity(portfolioService.modify(portfolioRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deletePortfolioEntity(@RequestBody PortfolioDTO.RequestPortfolioDTO portfolioRequestDTO){
        return new ResponseEntity(portfolioService.delete(portfolioRequestDTO), HttpStatus.OK);
    }

}
