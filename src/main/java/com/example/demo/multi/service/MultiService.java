package com.example.demo.multi.service; // パッケージ宣言

import org.springframework.stereotype.Service; // @Serviceを使用するために必要なimport文

@Service // Serviceクラスを示す
public class MultiService { // MultiServiceクラスの宣言

	public int multi(int num1, int num2) { // multiメソッドの宣言

		int result = num1 * num2; // result変数の宣言と値の代入

		return result; // 結果を呼び出し元に返す

	}
}
