package numeron_okuya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Numer0n_namie {

	public static void main(String args[]) {

		// 変数設定
		List<String> answerList = new ArrayList<>();

		int gemeCount = 0;

		// 4桁乱数生成
		answerList = setAnserList();

		// 挑戦回数分ループ部
		while (true) {
			List<String> inputList = new ArrayList<>();

			gemeCount++;
			System.out.println(String.format("%d 回目", gemeCount));
			// キーボードから入力受付
			try (Scanner scanner = new Scanner(System.in);) {
				System.out.println("回答を入力してください。");
				inputList = Arrays.asList(scanner.next().split(""));
				checkNumber(inputList);
				inputList.addAll(inputList);
				System.out.println("入力した数値は " + inputList.toString() + " です。");
			} catch (NumberFormatException e) {
				System.out.println("数値以外が入力されました。整数で入力してください");
				continue;
			}

			// ループ初期にEat,Biteをリセット
			int bc = 0;
			int ec = 0;

			// Eat判定部
			for (int j = 0; j <= 3; j++) {
				if (answerList.get(j).equals(inputList.get(j))) {
					ec++;
				} else {
					// Bite判定部
					for (String input : inputList) {
						if (answerList.contains(input)) {
							bc++;
							break;
						}
					}
				}
			}

			// Eat,Bite表示
			System.out.println(String.format("%d EAT, %d BITE", ec, bc));

			// Eatが4の場合勝利
			if (ec == 4) {
				System.out.println("\nあなたの勝ちです");
				break;
				// 挑戦回数が10回に到達で終了
			} else if (gemeCount == 10) {
				System.out.println("\n10回以内に正解しませんでした。あなたの負けです");
			}
		}
	}

	/**
	 * ゲームの回答である4桁の被りのない整数を生成する
	 * 
	 * @return
	 */
	private static List<String> setAnserList() {
		List<String> answerList = new ArrayList<>();
		answerList = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
		Collections.shuffle(answerList);
		answerList = answerList.subList(0, 4);

		return answerList;
	}

	private static void checkNumber(List<String> inputList) {
		for (String input : inputList) {
			try {
				Integer.parseInt(input);
			} catch (NumberFormatException ex) {
				throw new NumberFormatException();
			}
		}

	}
}