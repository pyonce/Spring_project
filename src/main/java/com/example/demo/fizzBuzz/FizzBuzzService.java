package com.example.demo.fizzBuzz; // パッケージ宣言

import java.util.ArrayList; // ArrayListクラスをインポート
import java.util.List; // Listインターフェースをインポート

import org.springframework.stereotype.Service; // Serviceクラスをインポート

@Service // Serviceクラスを示す
public class FizzBuzzService { // FizzBuzzServiceクラスを宣言

	public List<String> generateFizzBuzz(int start, int end) { // generateFizzBuzzメソッドの宣言
		List<String> result = new ArrayList<>(); // resultリストの作成と初期化
		
		for (int i = start; i <= end; i++) { // startからendまでの数を繰り返し処理
			if (i % 3 == 0 && i % 5 == 0) { // iが3と5の両方で割り切れる場合
				result.add("FizzBuzz"); // resultリストにFizzBuzzを追加
			} else if (i % 3 == 0) { // iが3で割り切れる場合
				result.add("Fizz"); // resultリストにFizzを追加
			} else if (i % 5 == 0) { // iが5で割り切れる場合
				result.add("Buzz"); // resultリストにBuzzを追加
			} else { // その他の場合
				result.add(String.valueOf(i)); // resultリストにiの値を文字列に変換して追加
			}
		}
		return result;// 結果のリストを返す
	}
}