package com.example.demo.minus.service; // パッケージ宣言

import org.springframework.stereotype.Service; // Serviceクラスのインポート

@Service // Serviceクラスを示す
public class MinusService { // MinusServiceクラスの宣言

	public int minus(int num1, int num2) { // publicアクセス修飾子、int戻り値の型(戻り値がない場合はvoid)、minusメソッド名、( )引数 
		return num1 - num2; // 引き算の結果を返す
	}
}
