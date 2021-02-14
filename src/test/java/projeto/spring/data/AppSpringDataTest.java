package projeto.spring.data;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javafx.scene.chart.PieChart.Data;
import projeto.spring.data.dao.InterfaceSpringDataUser;
import projeto.spring.data.dao.InterfaceTelefone;
import projeto.spring.data.model.Telefone;
import projeto.spring.data.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	@Autowired
	private InterfaceSpringDataUser InterfaceSpringDataUser;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;

	@Test
	public void testeInsert() {

		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();

		usuarioSpringData.setEmail("josi@java.com");
		usuarioSpringData.setIdade(27);
		usuarioSpringData.setLogin("josi");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("Josineuza");

		InterfaceSpringDataUser.save(usuarioSpringData);

		System.out.println(" Usuários Cadastrados: " + InterfaceSpringDataUser.count() + " Cadastros");

	}

	@Test
	public void testeConsulta() {

		Optional<UsuarioSpringData> usuarioSpringData = InterfaceSpringDataUser.findById(2L);

		System.out.println("Dados do usuario id " + usuarioSpringData.get().getId());
		System.out.println();
		System.out.println("Nome : " + usuarioSpringData.get().getNome());
		System.out.println("Idade: " + usuarioSpringData.get().getIdade());
		System.out.println("Email: " + usuarioSpringData.get().getEmail());
		System.out.println("Login: " + usuarioSpringData.get().getLogin());
		System.out.println("Senha: " + usuarioSpringData.get().getSenha());
		
		
		System.out.println("-----------Telefones-------------");
		for(Telefone telefone : usuarioSpringData.get().getTelefones()) {			
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
			System.out.println("------------");
		}
	}

	@Test
	public void testConsultaTodos() {
		Iterable<UsuarioSpringData> list = InterfaceSpringDataUser.findAll();

		for (UsuarioSpringData usuarioSpringData : list) {
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println("-----------------------------------");
		}
	}

	@Test
	public void testUpdate() {

		Optional<UsuarioSpringData> usuarioSpringData = InterfaceSpringDataUser.findById(2L);

		UsuarioSpringData data = usuarioSpringData.get();

		data.setNome("Airton Silva");

		InterfaceSpringDataUser.save(data);
	}

	@Test
	public void testeDelete() {

		InterfaceSpringDataUser.deleteById(3L);
	}

	@Test
	public void testeConsultaNome() {

		List<UsuarioSpringData> list = InterfaceSpringDataUser.buscarPorNome("Airton");

		for (UsuarioSpringData usuarioSpringData : list) {

			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println("----------------------------");

		}
	}

	@Test
	public void testeConsultaNomeParam() {

		List<UsuarioSpringData> list = InterfaceSpringDataUser.buscaPorNomeParam("Airton");

		for (UsuarioSpringData usuarioSpringData : list) {

			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println("----------------------------");

		}
	}

	@Test
	public void deletePorNome() {
		InterfaceSpringDataUser.deletePorNome("Airton Morais");
	}

	@Test
	public void testUpdateEmailPorNome() {
		InterfaceSpringDataUser.updateEmailPorNome("airtonSilva@g.com", "Airton Silva");
	}
	
	@Test
	public void testeInsertTelefone() {
		
		Optional<UsuarioSpringData> usuarioSpringData = InterfaceSpringDataUser.findById(2L);
		
		Telefone telefone = new Telefone();
		telefone.setTipo("Celular");
		telefone.setNumero("61857845");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
		
		interfaceTelefone.save(telefone);
	}

}
