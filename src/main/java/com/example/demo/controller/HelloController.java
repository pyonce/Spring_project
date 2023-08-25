package com.example.demo.controller; // パッケージ宣言

import org.springframework.stereotype.Controller; // 異なるパッケージ内にあるクラスを利用
import org.springframework.web.bind.annotation.GetMapping; // 異なるパッケージ内にあるクラスを利用

@Controller
public class HelloController {

	@GetMapping("hello") // メソッドとGETの処理を行うURLを紐づける
	public String greeting() {
		return "index.html";
	}
}
