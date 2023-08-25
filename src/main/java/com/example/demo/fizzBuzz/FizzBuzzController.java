package com.example.demo.fizzBuzz; // パッケージ宣言

import org.springframework.stereotype.Controller; // Controllerクラスをインポート
import org.springframework.ui.Model; // Modelインターフェースをインポート
import org.springframework.web.bind.annotation.GetMapping; // GetMappingアノテーションをインポート

@Controller // Controllerクラスを示す
public class FizzBuzzController { // FizzBuzzControllerクラスの宣言

	private final FizzBuzzService fizzBuzzService;// FizzBuzzServiceクラスのインスタンスを保持するためのfizzBuzzService変数の宣言

	public FizzBuzzController(FizzBuzzService fizzBuzzService) { // FizzBuzzControllerクラスのコンストラクタの宣言
		this.fizzBuzzService = fizzBuzzService;// FizzBuzzControllerクラス内で宣言されているfizzBuzzService変数にコンストラクタ内で受け取ったfizzBuzzServiceインスタンスを代入
	} // これにより、FizzBuzzControllerクラス内でfizzBuzzServiceインスタンスを使って処理を実行することができる

	@GetMapping("fizzBuzz") // HTTP GETリクエストが"fizzBuzz"パスに送信されたときに、以下のメソッドが呼び出されることを示す
	public String fizzBuzz(Model model) {// fizzBuzzメソッドの宣言(引数Modelはビューにデータを渡すためのオブジェクト、modelはModelオブジェクトを表す変数名) 
		model.addAttribute("result", fizzBuzzService.generateFizzBuzz(0, 100)); // ModelオブジェクトにFizzBuzzServiceのgenerateFizzBuzzメソッドを呼び出して結果を取得し"result"という名前で追加
		return "fizzBuzz.html"; // ビューとして"fizzBuzz.html"を表示するように指定
	}
}