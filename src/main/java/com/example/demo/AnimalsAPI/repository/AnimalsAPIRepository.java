package com.example.demo.AnimalsAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.AnimalsAPI.data.AnimalsAPIData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalsAPIRepository { // AnimalsAPIRepositoryクラスの宣言

	public AnimalsAPIData[] getAnimalsAPIData() throws IOException { // getAnimalsAPIData()メソッドの宣言
		// publicアクセス修飾子、AnimalsAPIData[]戻り値の型、getAnimalsAPIDataメソッド名、( )引数、throws IOExceptionは、IOExceptionという例外(エラー)をthrows(発生)する可能性があることを示す

		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi"; // String型のurl変数にデータの取得元となるURLを代入

		RestTemplate rest = new RestTemplate(); // RestTemplateクラスのインスタンスを生成し、rest変数に代入
		// RestTemplateを使うことで、HTTP GET、POST、PUT、DELETEなどのリクエストを行い、応答データを受け取ることができる

		ResponseEntity<String> response = rest.getForEntity(url, String.class); // String.classは、応答のボディを文字列として解釈するための型情報
		// rest変数(RestTemplateクラス)のgetForEntityメソッドでHTTP GETリクエストを送信し、取得した応答データをResponseEntity<String>型のresponse変数に代入

		String json = response.getBody(); // response変数にgetBodyメソッドを使用して応答データのボディ部分を取得し、String型のjson変数に代入

		ObjectMapper mapper = new ObjectMapper();// ObjectMapperクラスのインスタンスを生成し、mapper変数に代入
		// ObjectMapperは、JSONデータとJavaオブジェクトの相互変換を行うために使用される

		AnimalsAPIData[] animalsList = mapper.readValue(json, AnimalsAPIData[].class); // AnimalsAPIData[].classは、AnimalsAPIDataクラスの配列を表す
		// mapper変数(ObjectMapperクラス)のreadValueメソッドを使用してJSONデータをJavaオブジェクトに変換し、AnimalsAPIData[]型のanimalsList変数に代入

		return animalsList; // animalsList変数(AnimalsAPIData配列)を返す
	}

}
