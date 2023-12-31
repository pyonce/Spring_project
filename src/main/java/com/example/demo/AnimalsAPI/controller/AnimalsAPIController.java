package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
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
	public String animalsSearch(Model model) throws IOException { // getAnimalsメソッドの宣言
		// throws IOExceptionは、IOExceptionという例外(エラー)をスロー(発生)する可能性があることを示す

		List<AnimalsAPIData> animalsList = animalsAPIService.getAnimalsAPIData();
		// animalsAPIServiceからAnimalsAPIData()メソッドを取得し、List<AnimalsAPIData>型のanimalsList変数に代入

		model.addAttribute("animalsList", animalsList); // animalsList変数のデータを"animalsList"という名前でmodel変数に追加

		return "animalsSerch.html"; // ビューとしてanimalsAPI.htmlを表示

	}

	@GetMapping("animalsResult")
	public String animalDetails(@RequestParam("animals") String animals, Model model) throws IOException {

		List<AnimalsAPIData> matchingAnimalsList = animalsAPIService.getSelectedAnimalsAPIData(animals);

		model.addAttribute("matchingAnimalsList", matchingAnimalsList);

		return "animalsResult.html";

	}

}
