package app.mapl.cliTests;//package app.mapl.cliTests;
//
//import app.mapl.models.Chain;
//import app.mapl.repositories.ChainsRepository;
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
//	ChainsRepository chainsRepository;
//
//	@Test
//	public void ifNewProjectSaved_thenSuccess() {
////		Chain newProject = new Chain(1,"ethereum","ETH","description","longDescription","iconUrl","category","chainListIcon","rpcUrl","id","blockExplorerUrl");
//		Chain newProject = new Chain();
//		chainsRepository.save(newProject);
//
//		assertEquals(1, chainsRepository.findAll().size());
//
//	}
//}
