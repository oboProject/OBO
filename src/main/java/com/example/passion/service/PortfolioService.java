package com.example.passion.service;

import com.example.passion.mapper.ImageMapper;
import com.example.passion.mapper.PortfolioMapper;
import com.example.passion.dto.ImageDTO;
import com.example.passion.dto.PortfolioDTO;
import com.example.passion.model.post.ImageEntity;
import com.example.passion.model.post.PortfolioEntity;
import com.example.passion.repository.PortfolioRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PortfolioService implements PostCRUD<PortfolioDTO.ResponsePortfolioDTO,PortfolioDTO.RequestPortfolioDTO> {
    PortfolioRepository portfolioRepository;
    PortfolioMapper mapper;
    ImageMapper imageMapper;
    ImageHandler imageHandler;

    /**
     * portfolioEntity를 레포지토리에 저장하는 메서드
     * @param requestPortfolioDTO 요청받은 portfolioDTO를 entity에 옮겨 저장하고 다시 반환
     * @return PortfolioResponseDTO
     */
    @Override
    public PortfolioDTO.ResponsePortfolioDTO create(PortfolioDTO.RequestPortfolioDTO requestPortfolioDTO) {

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

        PortfolioEntity portfolioEntity = PortfolioEntity.builder()
                .description(requestPortfolioDTO.getDescription())
                .pick(requestPortfolioDTO.getPick())
                .userId(requestPortfolioDTO.getUserId())
                .views(requestPortfolioDTO.getViews())
                .title(requestPortfolioDTO.getTitle())
                .imageEntities(imageEntities)
                .build();


        portfolioRepository.save(portfolioEntity);
        return mapper.portfolioEntityToResponsePortfolioDTO(portfolioEntity);
    }

    @Override
    public PortfolioDTO.ResponsePortfolioDTO delete(PortfolioDTO.RequestPortfolioDTO portfolioRequestDTO) {
        portfolioRepository.delete(mapper.portfolioRequestDtoToPortfolioEntity(portfolioRequestDTO));
        return new PortfolioDTO.ResponsePortfolioDTO();
    }

    @Override
    @Transactional
    public PortfolioDTO.ResponsePortfolioDTO modify(PortfolioDTO.RequestPortfolioDTO portfolioRequestDTO) {

        PortfolioEntity modifiedPortfolioEntity = mapper.portfolioRequestDtoToPortfolioEntity(portfolioRequestDTO);
        Optional<PortfolioEntity> OriginalInOptional = portfolioRepository.findById(portfolioRequestDTO.getPortfolioId());

        try {
            //todo 수정 요망 imageHandler.updateImage(portfolioRequestDTO.getRequestImageDTOS());

            PortfolioEntity portfolioOriginal = OriginalInOptional.get();
            portfolioOriginal.update(
                    portfolioRequestDTO.getTitle(),
                    portfolioRequestDTO.getDescription(),
                    portfolioRequestDTO.getViews(),
                    portfolioRequestDTO.getPick()
            );
            return mapper.portfolioEntityToResponsePortfolioDTO(portfolioOriginal);
        } catch(NoSuchElementException e){
            System.out.println("OriginalInOptional이 null입니다.");
            return null;
        }
    }

    @Override
    public List<PortfolioDTO.ResponsePortfolioDTO> read(PortfolioDTO.RequestPortfolioDTO portfolioRequestDTO) {
        List<PortfolioDTO.ResponsePortfolioDTO> portfolioResponseDTOS = new ArrayList<>();
        String title = portfolioRequestDTO.getTitle();

        portfolioResponseDTOS.add(
                mapper.portfolioEntityToResponsePortfolioDTO(
                        portfolioRepository.findByTitle(title)));

        return portfolioResponseDTOS;
    }

    public List<PortfolioEntity> readAll() { return portfolioRepository.findAll(); }

    public PortfolioEntity getPortfolioById(String portfolioId){
        PortfolioEntity portfolioEntity = portfolioRepository.findById(portfolioId).orElseThrow();
        return portfolioEntity;
    }

}
