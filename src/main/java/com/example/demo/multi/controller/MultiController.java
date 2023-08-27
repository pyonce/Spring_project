package com.example.demo.multi.controller; // パッケージ宣言

import org.springframework.stereotype.Controller; // @Controllerを使用するために必要なimport文
import org.springframework.ui.Model; // ビューへデータを渡すために使用されるModelクラスを利用するためのimport文
import org.springframework.web.bind.annotation.GetMapping; // HTTP GETリクエストを処理するための@GetMappingを利用するためのimport文

import com.example.demo.multi.service.MultiService;

@Controller // Controllerクラスを示す
public class MultiController { // MultiControllerクラスの宣言

	private final MultiService multiService; // MultiServiceクラスを使用するためのフィールド宣言(multiServiceはMultiServiceクラスのインスタンス)

	public MultiController(MultiService multiService) { // MultiControllerクラスのコンストラクタの宣言
		this.multiService = multiService; // MultiControllerクラス内で宣言されているmultiServiceフィールドにコンストラクタ内で受け取ったmultiServiceインスタンスを代入
	} // これにより、MultiControllerクラス内でmultiServiceインスタンスを使って処理を実行することができる

	@GetMapping("multi") // HTTP GETリクエストが"/multi"パスに送信されたときに、以下のメソッドが呼び出されることを示す
	public String multi(Model model) { // multiメソッドの宣言(引数Modelはビューにデータを渡すためのオブジェクト、modelはModelオブジェクトを表す変数名) 

		String result = ""; // result変数の宣言と初期化

		result = String.valueOf(multiService.multi(8, 5)); // multiServiceインスタンスのmultiメソッドを呼び出し、引数として 8 と 5 を渡し、その結果を文字列に変換してresult変数に代入する

		model.addAttribute("result", result); // Modelオブジェクトにresult変数の値を"result"という名前で追加

		return "multi.html"; // ビューとして"multi.html"を表示するように指定
	}

}
