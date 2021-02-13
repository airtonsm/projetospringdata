package projeto.spring.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.dao.InterfaceSpringDataUser;
import projeto.spring.data.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {
	
	@Autowired
	private InterfaceSpringDataUser InterfaceSpringDataUser;
	
	@Test
	public void testeInsert() {
		
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		
		/*usuarioSpringData.setEmail("maria@java.com");
		usuarioSpringData.setIdade(27);
		usuarioSpringData.setLogin("Maria");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("Maria Silva");
		
		InterfaceSpringDataUser.save(usuarioSpringData);	*/
		
		System.out.println(" Usuários Cadastrados: " + InterfaceSpringDataUser.count() + " Cadastros");
		
	}
	
	

}
