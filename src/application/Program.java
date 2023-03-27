package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		
		List<Lesson> list = new ArrayList<>();
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas aulas terá o curso? ");
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			System.out.println("Dado da " + (i + 1) + " aula: ");
			System.out.print("Conteúdo ou tarefa (c/t) ?");
			char ch = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			if(ch == 'c') {
				System.out.print("Url do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				Integer seconds = sc.nextInt();
				
				Lesson lesson = new Video(title, url, seconds);
				list.add(lesson);	
				
			}else if(ch == 't') {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				Integer questionCount = sc.nextInt();
				
				list.add(new Task(title, description, questionCount));
			}
			System.out.println();
		}
		
		Integer sum = 0;
		System.out.println();
		
		for(Lesson l : list) { 
			sum += l.duration();	
		}
		
		System.out.print("DURAÇÃO TOTAL CURSO = " + sum + " segundos.");
		
		
		
		
		
		
		sc.close();
		

	}

}
