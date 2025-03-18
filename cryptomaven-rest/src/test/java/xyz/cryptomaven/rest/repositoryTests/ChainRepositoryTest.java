//package xyz.cryptomaven.rest.repositoryTests;
//
//import jakarta.validation.ConstraintViolationException;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.data.domain.Page;
//import xyz.cryptomaven.rest.util.dataLoader.BootstrapData;
//import xyz.cryptomaven.rest.models.Chain;
//import xyz.cryptomaven.rest.repositories.ChainsRepository;
//import xyz.cryptomaven.rest.service.ChainCsvServiceImpl;
//
//import java.math.BigDecimal;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@DataJpaTest
//@Import({BootstrapData.class })
//class ChainRepositoryTest {
//
//    @Autowired
//    ChainsRepository chainRepository;
//
//    @Test
//    void testGetChainListByName() {
//        Page<Chain> list = chainRepository.search("%ETH%", null);
//
//        assertThat(list.getContent().size()).isNotEqualTo(0);
//    }
//
//    @Test
//    void testSaveNameTooLong() {
//
//        assertThrows(ConstraintViolationException.class, () -> {
//            Chain savedChain = chainRepository.save(Chain.builder()
//                    .name("My Chain TOOO LONG  DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDddddddddddddd")
//                    .symbol("PLS")
//                    .build());
//
//            chainRepository.flush();
//        });
//    }
//
//    @Test
//    void testSaveChain() {
//        Chain savedChain = chainRepository.save(Chain.builder()
//                        .name("My Chain")
//                        .symbol("ETH")
//                .build());
//
//        chainRepository.flush();
//
//        assertThat(savedChain).isNotNull();
//        assertThat(savedChain.getId()).isNotNull();
//    }
//}
