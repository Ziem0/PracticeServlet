package com.practice.servlet.model;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter
public class InputHandler {

	private String name;
	private String last;
	private LocalDate date;

	public InputHandler(String name, String last, String date) {
		this.name = name;
		this.last = last;
		this.date = LocalDate.parse(date);
	}

	public Map<String, String> calculateGuitaristData() {
		Map<String, String> kv = new HashMap<>();

		int sum = name.length() + last.length();
		this.date = this.date.plusDays(sum);

		DayOfWeek dayOfWeek = this.date.getDayOfWeek();
		int choice = dayOfWeek.getValue();

		switch (choice) {
			case 1:
				kv.put("name", "Jimi Hendrix");
				kv.put("path", "jh.jpeg");
				break;
			case 2:
				kv.put("name", "Jeff Beck");
				kv.put("path", "jb.jpeg");
				break;
			case 3:
				kv.put("name", "Jimmi Page");
				kv.put("path", "jp.jpeg");
				break;
			case 4:
				kv.put("name", "Mike Landau");
				kv.put("path", "ml.jpeg");
				break;
			case 5:
				kv.put("name", "Paco de Lucia");
				kv.put("path", "pdl.jpeg");
				break;
			case 6:
				kv.put("name", "Philip Sayce");
				kv.put("path", "ps.jpeg");
				break;
			case 7:
				kv.put("name", "Steve Vai");
				kv.put("path", "sv.jpeg");
				break;
		}
		return kv;
	}

}
