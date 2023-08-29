package com.example.demo.AnimalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.AnimalsAPI.data.AnimalsAPIData;
import com.example.demo.AnimalsAPI.repository.AnimalsAPIRepository;

@Service
public class AnimalsAPIService { // AnimalsAPIServiceクラスの宣言

	private final AnimalsAPIRepository animalsAPIRepository; // AnimalsAPIRepositoryクラスのインスタンスを保持するためのanimalsAPIRepository変数の宣言

	public AnimalsAPIService(AnimalsAPIRepository animalsAPIRepository) { // AnimalsAPIServiceクラスのコンストラクタの宣言
		this.animalsAPIRepository = animalsAPIRepository; // AnimalsAPIRepositoryクラスのインスタンスを代入
	} // これにより、AnimalsAPIServiceクラス内のメソッドでanimalsAPIRepositoryインスタンスを使用できるようになる

	public List<AnimalsAPIData> getAnimalsAPIData() throws IOException { // getAnimalsAPIDataメソッドの宣言
		// throws IOExceptionは、IOExceptionという例外(エラー)をスロー(発生)する可能性があることを示す

		AnimalsAPIData[] animalsList = animalsAPIRepository.getAnimalsAPIData();
		// animalsAPIRepositoryからAnimalsAPIData()メソッドを取得し、AnimalsAPIData[]型のanimalsList変数に代入

		return Arrays.asList(animalsList);
		// ArraysクラスのasList()メソッドを使用して、animalsList変数に格納されているAnimalsAPIData配列をList<AnimalsAPIData>に変換
	}

	public List<AnimalsAPIData> getSelectedAnimalsAPIData(String animals) throws IOException {

		AnimalsAPIData[] matchingAnimalsList = animalsAPIRepository.getSelectedAnimalsAPIData(animals);

		return Arrays.asList(matchingAnimalsList);
	}
}
