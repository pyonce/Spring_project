package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AnimalsAPI.data.AnimalsAPIData;
import com.example.demo.AnimalsAPI.service.AnimalsAPIService;

@Controller
public class AnimalsAPIController { // AnimalsAPIControllerクラスの宣言

	private final AnimalsAPIService animalsAPIService; // AnimalsAPIServiceクラスのインスタンスを保持するためのanimalsAPIService変数の宣言

	public AnimalsAPIController(AnimalsAPIService animalsAPIService) { // AnimalsAPIControllerクラスのコンストラクタの宣言
		this.animalsAPIService = animalsAPIService; // AnimalsAPIServiceクラスのインスタンスを代入
	} // これにより、AnimalsAPIControllerクラス内のメソッドでanimalsAPIServiceインスタンスを使用できるようになる

	@GetMapping("animalsSerch")
	public String getAnimals(Model model) throws IOException { // getAnimalsメソッドの宣言
		// throws IOExceptionは、IOExceptionという例外(エラー)をスロー(発生)する可能性があることを示す

		List<AnimalsAPIData> animalsList = animalsAPIService.getAnimalsAPIData();
		// animalsAPIServiceからAnimalsAPIData()メソッドを取得し、List<AnimalsAPIData>型のanimalsList変数に代入

		model.addAttribute("animalsList", animalsList); // animalsList変数のデータを"animalsList"という名前でmodel変数に追加

		return "animalsSerch.html"; // ビューとしてanimalsAPI.htmlを表示

	}

	@GetMapping("animalsResult")
	public String displayAnimal(@RequestParam("animals") String animals, Model model) throws IOException { // throws IOExceptionは、IOExceptionという例外(エラー)をスロー(発生)する可能性があることを示す

		List<AnimalsAPIData> animalsList = animalsAPIService.getAnimalsAPIData();
		// animalsAPIServiceからAnimalsAPIData()を取得し、AnimalsAPIDataリストとしてanimalsList変数に代入

		List<AnimalsAPIData> matchingAnimalsList = new ArrayList<>(); // ArrayListインスタンスを作成し、List<AnimalsAPIData>型のmatchingAnimalsList変数に代入

		for (AnimalsAPIData animal : animalsList) { // animalsListリスト内の各要素をAnimalsAPIData型のanimal変数に順番に格納

			if (animal.getName().equals(animals)) { // animal変数のデータとフォームから送信されたanimalsデータをequals(animals)メソッドで比較し、一致したデータをgetName()メソッドで取得
				matchingAnimalsList.add(animal); // 取得したデータをmatchingAnimalsList変数に追加
			}
		}

		model.addAttribute("matchingAnimalsList", matchingAnimalsList); // matchingAnimalsList変数を"matchingAnimalsList"という名前でmodel変数に追加

		return "animalsResult.html"; // ビューとしてanimalsAPI.htmlを表示

	}

}
