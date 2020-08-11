package com.ejerciciopoo.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ejerciciopoo.entidades.Persona;
import com.ejerciciopoo.entidades.Ranking;
import com.ejerciciopoo.entidades.Skill;



public class Main {
	static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	
	static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

	public static void main(String[] args) {
		Persona persona= new Persona("Elvis Calderon");
		ingresarPersona(persona);
		Persona persona1= new Persona("Jair Calderon");
		ingresarPersona(persona1);
		
		Ranking ranking= new Ranking(3);
		ingresarRanking(ranking);
		Ranking ranking1= new Ranking(1);
		ingresarRanking(ranking1);
		Ranking ranking2= new Ranking(2);
		ingresarRanking(ranking2);
		
		Skill skill= new Skill("Programacion");
		ingresarSkill(skill);
		Skill skill1= new Skill("POO");
		ingresarSkill(skill1);
		Skill skill2= new Skill("Analisis");
		ingresarSkill(skill2);

	}
	static void ingresarPersona(Persona persona) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(persona);
		session.getTransaction().commit();
		session.close();
	}
	
	static void ingresarSkill(Skill skill) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(skill);
		session.getTransaction().commit();
		session.close();

	}
	
	static void ingresarRanking(Ranking ranking) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ranking);
		session.getTransaction().commit();
		session.close();

	}
	
	static List<Persona> getPersona(){
		Session session = sessionFactory.openSession();
		List<Persona> cursos=(List<Persona>)session.createQuery("from Persona",Persona.class ).list();
		return cursos;
	}

}
