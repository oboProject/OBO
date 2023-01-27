package com.example.passion.service;

import com.example.passion.domain.post.PortfolioEntity;
import com.example.passion.dto.PortfolioRequestDTO;
import com.example.passion.mapper.PortfolioMapper;
import com.example.passion.dto.PortfolioResponseDTO;
import com.example.passion.repository.PortfolioRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class PortfolioService implements PostCRUD<PortfolioResponseDTO, PortfolioRequestDTO> {
    PortfolioRepository portfolioRepository;
    PortfolioMapper mapper;

    /**
     * portfolioEntity를 레포지토리에 저장하는 메서드
     * @param portfolioRequestDTO 요청받은 portfolioDTO를 entity에 옮겨 저장하고 다시 반환
     * @return PortfolioResponseDTO
     */
    @Override
    public PortfolioResponseDTO create(PortfolioRequestDTO portfolioRequestDTO) {
        PortfolioEntity savedPortfolioEntity = mapper.portfolioRequestDtoToPortfolioEntity(portfolioRequestDTO);
        portfolioRepository.save(savedPortfolioEntity);
        return mapper.portfolioEntityToPortfolioResponseDto(savedPortfolioEntity);
    }

    @Override
    public PortfolioResponseDTO delete(PortfolioRequestDTO portfolioRequestDTO) {
        portfolioRepository.delete(mapper.portfolioRequestDtoToPortfolioEntity(portfolioRequestDTO));
        return new PortfolioResponseDTO();
    }

    @Override
    @Transactional
    public PortfolioResponseDTO modify(PortfolioRequestDTO portfolioRequestDTO) {

        PortfolioEntity modifiedPortfolioEntity = mapper.portfolioRequestDtoToPortfolioEntity(portfolioRequestDTO);
        Optional<PortfolioEntity> OriginalInOptional = portfolioRepository.findById(portfolioRequestDTO.getPortfolioId());

        try{
            PortfolioEntity portfolioOriginal = OriginalInOptional.get();
            portfolioOriginal.update(
                    portfolioRequestDTO.getTitle(),
                    portfolioRequestDTO.getDescription(),
                    portfolioRequestDTO.getViews(),
                    portfolioRequestDTO.getPick()
            );
            return mapper.portfolioEntityToPortfolioResponseDto(portfolioOriginal);
        } catch(NoSuchElementException e){
            System.out.println("OriginalInOptional이 null입니다.");
            return null;
        }
    }

    @Override
    public List<PortfolioResponseDTO> read(PortfolioRequestDTO portfolioRequestDTO) {
        List<PortfolioResponseDTO> portfolioResponseDTOS = new ArrayList<>();
        String title = portfolioRequestDTO.getTitle();

        portfolioResponseDTOS.add(
                mapper.portfolioEntityToPortfolioResponseDto(
                        portfolioRepository.findByTitle(title)));

        return portfolioResponseDTOS;
    }

    public List<PortfolioEntity> readAll() { return portfolioRepository.findAll(); }

}
