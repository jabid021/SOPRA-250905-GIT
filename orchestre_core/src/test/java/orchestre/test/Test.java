package orchestre.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import orchestre.model.IMusicien;

public class Test {
	
	@Autowired
	@Qualifier("flutiste")
	IMusicien flutiste;
	
	@Autowired
	@Qualifier("guitariste")

	IMusicien guitariste;

	@Autowired
	@Qualifier("pianiste")
	IMusicien pianiste;

	public void run(String[] args) {
	
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");

		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		//Guitariste guitariste=(Guitariste) ctx.getBean(Guitariste.class);
		
		//IMusicien pianiste=(Pianiste) ctx.getBean("pianiste");;
		//IMusicien flutiste=(Flutiste) ctx.getBean("flutiste");;
		
		
		guitariste.jouer();
		pianiste.jouer();
		flutiste.jouer();
		
		
	}

}
