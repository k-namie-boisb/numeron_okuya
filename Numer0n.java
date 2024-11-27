import java.util.InputMismatchException;
import java.util.Scanner;

public class Numer0n {

	public static void main(String args[]) {

		// 変数設定
		int answer[] = new int[4];
		int input[] = new int[4];
		int count = 0;
		int bc = 0;
		int ec = 0;
		int cc = 1;

		// 4桁乱数生成
		for (int i = 0; i <= 3; i++) {
			int ans = (int) (Math.random() * 10);
			for (int chk = 0; chk <= 3; chk++) {
				if (answer[(chk)] == ans) {
					count++;
				}
			}

			// 重複チェック部
			if (count > 0) {
				i--;
				count = 0;
				continue;
			} else {
				answer[i] = ans;
			}

			// デバッグ用解答表示
			System.out.println(answer[i]);
		}

		// 挑戦回数分ループ部
		for (int tc = 0; tc <= 9; tc++) {

			// キーボードから入力受付
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("1桁目を入力してください。");
				input[0] = scanner.nextInt();
				System.out.println("2桁目を入力してください。");
				input[1] = scanner.nextInt();
				System.out.println("3桁目を入力してください。");
				input[2] = scanner.nextInt();
				System.out.println("4桁目を入力してください。");
				input[3] = scanner.nextInt();
				System.out.println("入力した数値は " + input[0] + input[1] + input[2] + input[3] + " です。");
			} catch (InputMismatchException e) {
				System.out.println("数値以外が入力されました。終了します");
				break;
			}

			// ループ初期にEat,Biteをリセット
			ec = 0;
			bc = 0;

			// Eat判定部
			for (int j = 0; j <= 3; j++) {
				if (answer[j] == input[j]) {
					ec++;
				} else {
					// Bite判定部
					for (int k = 0; k <= 3; k++) {
						if (j == k) {
							;
						} else if (answer[j] == input[k]) {
							bc++;
						}
					}
				}
			}

			// Eat,Bite表示
			System.out.println(ec + "EAT " + bc + "BITE");

			// Eatが4の場合勝利
			if (ec == 4) {
				System.out.println("\nあなたの勝ちです");
				break;

				// 挑戦回数が10回に到達で終了
			} else if (tc == 9) {
				System.out.println("\n10回以内に正解しませんでした。あなたの負けです");
			} else {
				System.out.println("\n次は" + (cc + 1) + "回目です\n");
				cc++;
			}
		}
	}
}