package com.example.passion.repository;

import com.example.passion.model.post.PortfolioEntity;
import com.example.passion.model.user.UserEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class PortfolioRepositoryTest {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @AfterEach
    public void afterEach() {
        portfolioRepository.deleteAll();
    }

    @Test
    public void save() {
        //Given
        PortfolioEntity portfolio = new PortfolioEntity();
        portfolio.setTitle("portfolio test");
        portfolio.setDescription("테스트를 위한 임시 데이터입니다.");

        //When
        portfolioRepository.save(portfolio);

        //Then
        PortfolioEntity result = portfolioRepository.findById(portfolio.getPortfolioId()).get();
        Assertions.assertEquals(result, portfolio);
    }

    @Test
    public void findByTitle() {
        //Given
        PortfolioEntity portfolio1 = new PortfolioEntity();
        portfolio1.setTitle("portfolio test 1");
        portfolio1.setDescription("테스트를 위한 임시 데이터1입니다.");
        portfolioRepository.save(portfolio1);

        PortfolioEntity portfolio2 = new PortfolioEntity();
        portfolio2.setTitle("portfolio test 2");
        portfolio2.setDescription("테스트를 위한 임시 데이터2입니다.");
        portfolioRepository.save(portfolio2);

        //When
        //PortfolioEntity result = portfolioRepository.findByTitle("portfolio test 2").get();

        //Then
        //Assertions.assertEquals(result, portfolio2);
    }


    /**
     * https://bcp0109.tistory.com/344
     * ERROR CODE: object references an unsaved transient instance - save the transient instance before flushing
     * JPA 연관 관계 테스트 중 발생, FK로 사용되는 컬럼값이 없는 상태에서 데이터를 넣으려다 발생한 에러.
     * 연관 관계 매핑 어노테이션(@ManyToOne, @OneToOne ...)에 cascade 옵션을 설정해서 해결
     * 해결의 핵심은 "영속성 전이", 특정 엔티티를 영속화할 때 연관된 엔티티도 함께 영속화함.
     */
    @Test
    public void findByUserId() {
        //Given
        UserEntity user1 = new UserEntity();
        PortfolioEntity portfolio1 = new PortfolioEntity();
        portfolio1.setUserId(user1);
        portfolio1.setTitle("portfolio test 1");
        portfolio1.setDescription("테스트를 위한 임시 데이터1입니다.");
        portfolioRepository.save(portfolio1);

        PortfolioEntity portfolio2 = new PortfolioEntity();
        portfolio2.setUserId(user1);
        portfolio2.setTitle("portfolio test 2");
        portfolio2.setDescription("테스트를 위한 임시 데이터2입니다.");
        portfolioRepository.save(portfolio2);

        UserEntity user2 = new UserEntity();
        PortfolioEntity portfolio3 = new PortfolioEntity();
        portfolio3.setUserId(user2);
        portfolio3.setTitle("portfolio test 3");
        portfolio3.setDescription("테스트를 위한 임시 데이터3입니다.");
        portfolioRepository.save(portfolio3);

        //When
        List<PortfolioEntity> result = portfolioRepository.findByUserId(user1.getUserId());

        //Then
        Assertions.assertEquals(result.size(), 2);
    }
}
