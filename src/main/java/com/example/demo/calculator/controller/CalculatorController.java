package com.example.demo.calculator.controller; // パッケージ宣言

import org.springframework.stereotype.Controller; // Controllerクラスをインポート
import org.springframework.ui.Model; // Modelオブジェクトをインポート
import org.springframework.web.bind.annotation.GetMapping; // GetMappingアノテーションをインポート
import org.springframework.web.bind.annotation.PostMapping; // PostMappingアノテーションをインポート
import org.springframework.web.bind.annotation.RequestParam; // RequestParamアノテーションをインポート

import com.example.demo.calculator.service.CalculatorService;

@Controller // Controllerクラスを示す
public class CalculatorController { // CalculatorControllerクラスの宣言

	private final CalculatorService calculatorService; // CalculatorServiceクラスのインスタンスを保持するためのcalculatorService変数の宣言

	public CalculatorController(CalculatorService calculatorService) { // CalculatorControllerクラスのコンストラクタ
		this.calculatorService = calculatorService; // CalculatorServiceクラスのインスタンスを代入
	} // これにより、CalculatorControllerクラス内のメソッドでcalculatorServiceインスタンスを使用できるようになる

	@GetMapping("calculation") // HTTP GETリクエストが"calculation"パスに送信されたときに、以下のメソッドが呼び出されることを示す
	public String showForm() { // showFormメソッドの宣言
		return "calculator.html"; // ビューとして"calculator.html"を表示するように指定
	}

	@PostMapping("calculation") // HTTP POSTリクエストが"calculate"パスに送信されたときに、以下のメソッドが呼び出されることを示す
	public String calculation(@RequestParam("num1") int num1, // HTTPリクエストから名前が"num1"のパラメータを受け取り、int型のnum1変数に代入
			@RequestParam("operator") String operator, // HTTPリクエストから名前が"operator"のパラメータを受け取り、String型のoperator変数に代入
			@RequestParam("num2") int num2, // HTTPリクエストから名前が"num2"のパラメータを受け取り、int型のnum2変数に代入
			Model model) { // Modelはビューにデータを渡すためのオブジェクト、modelはModelオブジェクトを表す変数名

		int result = calculatorService.calculate(num1, operator, num2); // フォームから受け取った3つの数値をcalculateメソッドの引数とし、実行結果をresult変数に代入

		model.addAttribute("result", result); // 結果resultを"result"(属性名)という名前でModelオブジェクトに追加(resultは属性値)

		return "calculator.html"; // ビューとして"calculator.html"を表示するように指定
	}
}
