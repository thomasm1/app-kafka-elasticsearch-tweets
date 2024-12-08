package app.mapl.repositories;

import app.mapl.dataLoader.BootstrapData;
import app.mapl.models.Chain;
import app.mapl.service.ChainCsvServiceImpl;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Import({BootstrapData.class, ChainCsvServiceImpl.class})
class ChainRepositoryTest {

    @Autowired
    ChainsRepository chainRepository;

    @Test
    void testGetChainListByName() {
        Page<Chain> list = chainRepository.findAllByNameIsLikeIgnoreCase("%ETH%", null);

        assertThat(list.getContent().size()).isEqualTo(336);
    }

    @Test
    void testSaveNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            Chain savedChain = chainRepository.save(Chain.builder()
                    .name("My Chain TOOO LONG  DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDddddddddddddd")
                    .symbol("PLS")
                    .build());

            chainRepository.flush();
        });
    }

    @Test
    void testSaveChain() {
        Chain savedChain = chainRepository.save(Chain.builder()
                        .name("My Chain")
                        .symbol("ETH")
                .build());

        chainRepository.flush();

        assertThat(savedChain).isNotNull();
        assertThat(savedChain.getId()).isNotNull();
    }
}
