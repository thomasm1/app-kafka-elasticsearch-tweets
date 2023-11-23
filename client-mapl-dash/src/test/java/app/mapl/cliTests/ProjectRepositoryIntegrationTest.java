package app.mapl.cliTests;//package app.mapl.cliTests;
//
//import app.mapl.models.Coin;
//import app.mapl.repositories.CoinsRepository;
//;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
//import org.springframework.test.context.jdbc.SqlGroup;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@SqlGroup({
//    @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema-mysql.sql", "classpath:data-mysql.sql"}),
//    @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")
//})
//public class ProjectRepositoryIntegrationTest {
//
//	@Autowired
//	CoinsRepository chainsRepository;
//
//	@Test
//	public void ifNewProjectSaved_thenSuccess() {
////		Coin newProject = new Coin(1,"ethereum","ETH","description","longDescription","iconUrl","category","chainListIcon","rpcUrl","id","blockExplorerUrl");
//		Coin newProject = new Coin();
//		chainsRepository.save(newProject);
//
//		assertEquals(1, chainsRepository.findAll().size());
//
//	}
//}
