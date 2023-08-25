package com.example.demo.minus; // パッケージ宣言

import org.springframework.stereotype.Controller; // Controllerクラスをインポート
import org.springframework.ui.Model; // Modelインターフェースをインポート
import org.springframework.web.bind.annotation.GetMapping; // GetMappingアノテーションをインポート
import org.springframework.web.bind.annotation.PostMapping; // PostMappingアノテーションをインポート
import org.springframework.web.bind.annotation.RequestParam;// RequestParamアノテーションをインポート

@Controller // Controllerクラスを示す
public class MinusController { // MinusControllerクラスの宣言

	private final MinusService minusService; // MinusServiceクラスのインスタンスを保持するためのminusService変数の宣言

	public MinusController(MinusService minusService) { // MinusControllerクラスのコンストラクタ
		this.minusService = minusService; // MinusServiceクラスのインスタンスを代入
	} // これにより、MinusControllerクラス内のメソッドでminusServiceインスタンスを使用できるようになる

	@GetMapping("minus") // HTTP GETリクエストが"minus"パスに送信されたときに、以下のメソッドが呼び出されることを示す
	public String showForm() { // showFormメソッドの宣言
		return "minus.html"; // ビューとして"minus.html"を表示するように指定
	}

	@PostMapping("calculate") // HTTP POSTリクエストが"calculate"パスに送信されたときに、以下のメソッドが呼び出されることを示す
	public String calculate(@RequestParam("num1") int num1, // HTTPリクエストから名前が"num1"のパラメータを受け取り、int型のnum1変数に代入
			@RequestParam("num2") int num2, // HTTPリクエストから名前が"num2"のパラメータを受け取り、int型のnum2変数に代入
			Model model) { // Modelはビューにデータを渡すためのオブジェクト、modelはModelオブジェクトを表す変数名
		
		int result = minusService.minus(num1, num2); // フォームから受け取った2つの数値を引数とし、引き算の結果をresult変数に代入
		
		model.addAttribute("result", result); // 結果を"result"(属性名)という名前でModelオブジェクトに追加(resultは属性値)
		
		return "minus.html"; // ビューとして"minus.html"を表示するように指定
	}
}
