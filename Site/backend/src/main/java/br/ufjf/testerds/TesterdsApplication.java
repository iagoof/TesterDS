package br.ufjf.testerds;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ufjf.testerds.domains.CodeClass;
import br.ufjf.testerds.domains.CurrentStages;
import br.ufjf.testerds.domains.Level;
import br.ufjf.testerds.domains.Student;
import br.ufjf.testerds.domains.SubLevel;
import br.ufjf.testerds.domains.User;
import br.ufjf.testerds.repositories.CodeClassRepository;
import br.ufjf.testerds.repositories.CurrentStagesRepository;
import br.ufjf.testerds.repositories.LevelRepository;
import br.ufjf.testerds.repositories.SubLevelRepository;
import br.ufjf.testerds.services.UserService;
import br.ufjf.testerds.utils.messages.CodeClassMessage;


@SpringBootApplication
public class TesterdsApplication implements CommandLineRunner {

	@Autowired private LevelRepository levelRepository;
	@Autowired private SubLevelRepository subLevelRepository;
	@Autowired private CurrentStagesRepository currentStagesRepository;
	@Autowired private CodeClassRepository codeClassRepository;
	@Autowired UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(TesterdsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Level l1 = new Level(null, "Árvore Binária de Busca",1);
		Level l2 = new Level(null, "Árvore Vermelha e Preta",2);
		Level l3 = new Level(null, "Bubble Sort",3);
		Level l4 = new Level(null, "Fila de Prioridades", 4);
		
		SubLevel sl1 = new SubLevel(null,"Criar Nó: Criar uma classe nó que tenha pelo menos 3 atributos: id (Integer), noDireita (No), noEsquerda (No)",l1,1);
		SubLevel sl2 = new SubLevel(null,"Inicializar árvore: Inicializar uma árvore binária com 1 nó raiz, sem nós filhos, na classe principal (Main)",l1,2);
		SubLevel sl3 = new SubLevel(null,"Criar método para inserir nó filho pela direita: Criar na classe No, um método chamado de insereNoDireita que seja capaz de inserir um nó à direita de um nó raiz.", l1, 3);
		SubLevel sl4 = new SubLevel(null,"Criar método para inserir nó filho pela esquerda: Criar na classe No, um método chamado de insereNoEsquerda que seja capaz de inserir um nó à esquerda de um nó raiz.", l1, 4);
		
		SubLevel sl5 = new SubLevel(null,"Árvore Vermelha e Preta 1",l2,1);
		SubLevel sl6 = new SubLevel(null,"Árvore Vermelha e Preta 2",l2,2);
		
		SubLevel sl7 = new SubLevel(null,"Generico 1",l3,1);
		SubLevel sl8 = new SubLevel(null,"Generico 2",l4,2);
		
		CodeClass exampleCode1 = new CodeClass(null, "Node", CodeClassMessage.getSimpleClassCode("Node"), "code", sl1);
		CodeClass exampleCode2 = new CodeClass(null, "Main", CodeClassMessage.getInitializeTree(), "code", sl1);
		CodeClass exampleCode3 = new CodeClass(null, "Node", CodeClassMessage.getInsertNode("Right"), "code", sl1);
		CodeClass exampleCode4 = new CodeClass(null, "Node", CodeClassMessage.getInsertNode("Left"), "code", sl1);
		CodeClass exampleCode5 = new CodeClass(null, "Aux", CodeClassMessage.getSimpleClassCode("Aux"), "code", sl2);
		CodeClass exampleCode6 = new CodeClass(null, "Aux", CodeClassMessage.getSimpleClassCode("Aux"), "code", sl3);
		CodeClass exampleCode7 = new CodeClass(null, "Aux", CodeClassMessage.getSimpleClassCode("Aux"), "code", sl4);
		CodeClass exampleCode8 = new CodeClass(null, "Aux", CodeClassMessage.getSimpleClassCode("Aux"), "code", sl5);
		CodeClass exampleCode9 = new CodeClass(null, "Aux", CodeClassMessage.getSimpleClassCode("Aux"), "code", sl6);
		CodeClass exampleCode10 = new CodeClass(null, "ClassX", CodeClassMessage.getInsertNode("ClassX"), "code", sl7);
		CodeClass exampleCode11 = new CodeClass(null, "Main", CodeClassMessage.getInitializeTree(), "code", sl8);
		
		sl1.getBaseCode().addAll(Arrays.asList(exampleCode1, exampleCode2, exampleCode3, exampleCode4));
		sl2.getBaseCode().addAll(Arrays.asList(exampleCode5));
		sl3.getBaseCode().addAll(Arrays.asList(exampleCode6));
		sl4.getBaseCode().addAll(Arrays.asList(exampleCode7));
		sl5.getBaseCode().addAll(Arrays.asList(exampleCode8));
		sl6.getBaseCode().addAll(Arrays.asList(exampleCode9));
		sl7.getBaseCode().addAll(Arrays.asList(exampleCode10));
		sl8.getBaseCode().addAll(Arrays.asList(exampleCode11));
		
		
		l1.getSubLevels().addAll(Arrays.asList(sl1,sl2, sl3, sl4));
		l2.getSubLevels().addAll(Arrays.asList(sl5,sl6));
		l3.getSubLevels().addAll(Arrays.asList(sl7));
		l4.getSubLevels().addAll(Arrays.asList(sl8));
		
		levelRepository.save(Arrays.asList(l1,l2, l3, l4));
		subLevelRepository.save(Arrays.asList(sl1,sl2,sl3,sl4, sl5, sl6, sl7, sl8));
		codeClassRepository.save(Arrays.asList(exampleCode1,exampleCode2,exampleCode3,exampleCode4,exampleCode5,exampleCode6,exampleCode7,exampleCode8,exampleCode9,exampleCode10,exampleCode11));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		User user1 = new Student(null, "John", "Doe", "john.doe@email.com", "1234", "assets/img/user2-160x160.jpg", sdf.parse("01/06/1991"), "en");
		User user2 = new Student(null, "Peter", "Allef", "peter.alef@email.com", "1234", "assets/img/user2-160x160.jpg", sdf.parse("09/10/1977"), "fr");
		User user3 = new Student(null, "System", "Admin", "admin", "@dm1n", "assets/img/avatar04.png", sdf.parse("01/01/1991"), "pt");
		User user4 = new Student(null, "Vânia", "Neves", "vania.neves@email.com", "123456", "assets/img/vania.jpg", sdf.parse("01/01/1991"), "pt");
		
		userService.save(Arrays.asList(user1, user2, user3, user4));
		
		CurrentStages currentStages1 = new CurrentStages(user1, l1, sl1.getId());
		CurrentStages currentStages2 = new CurrentStages(user1, l2,sl4.getId());
		CurrentStages currentStages3 = new CurrentStages(user2, l1, sl1.getId());
		CurrentStages currentStages4 = new CurrentStages(user2, l2,sl4.getId());
		CurrentStages currentStages5 = new CurrentStages(user3, l1, sl1.getId());
		CurrentStages currentStages6 = new CurrentStages(user3, l2,sl4.getId());
		CurrentStages currentStages7 = new CurrentStages(user4, l1, sl1.getId());
		CurrentStages currentStages8 = new CurrentStages(user4, l2, sl5.getId());
		CurrentStages currentStages9 = new CurrentStages(user4, l3, sl7.getId());
		CurrentStages currentStages10 = new CurrentStages(user4, l4, sl8.getId());
		
		currentStagesRepository.save(Arrays.asList(
				currentStages1,
				currentStages2,
				currentStages3,
				currentStages4,
				currentStages5,
				currentStages6,
				currentStages7,
				currentStages8,
				currentStages9,
				currentStages10));
		
	}
}
