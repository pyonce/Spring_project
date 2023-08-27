package com.example.demo.calculator.service; // パッケージ宣言

import org.springframework.stereotype.Service; // Serviceクラスのインポート

@Service // Serviceクラスを示す
public class CalculatorService { // CalculatorServiceクラスの宣言

	public int calculate(int num1, String operator, int num2) { // publicアクセス修飾子、int戻り値の型(戻り値がない場合はvoid)、calculationメソッド名、( )引数 

		int result = 0; // 計算結果を格納するためのresult変数の宣言と初期化

		switch (operator) { // 選択されたoperatorの値による条件分岐

		case "+": // + が選択された場合
			result = num1 + num2; // result変数に num1 + num2 の計算結果を代入
			break; // 処理を終了

		case "-": // - が選択された場合
			result = num1 - num2; // result変数に num1 - num2 の計算結果を代入
			break; // 処理を終了

		case "*": // * が選択された場合
			result = num1 * num2; // result変数に num1 * num2 の計算結果を代入
			break; // 処理を終了

		case "/": // / が選択された場合
			result = num1 / num2; // result変数に num1 / num2 の計算結果を代入
			break; // 処理を終了
		}
		return result; // 計算結果を返す
	}
}
