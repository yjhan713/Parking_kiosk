package parking;

import java.util.Date;
import java.util.Scanner;

public class Out {
	public Out() {
	}

	void out(State state, Scanner s) {
		int num = 0;
		String receipt;

		System.out.println("==============================================\n 주차 했던 곳의 번호를 고르시오.");
		num = s.nextInt();
		num--;

		try {
			if (state.box[num].getNum() == " ■ ") {
				Date date = new Date();
				state.box[num].setOut(date.toString());
				state.box[num].outTime = System.currentTimeMillis();

				state.clear();
				System.out.println(" (" + (num + 1) + ")번 공간의 차량이 출차되었습니다.");

				state.charge_inform(num);
				state.init(num);
			} else {
				System.out.println("이미 출차가 되어있거나, 잘못된 번호를 누르셨습니다.");
			}
		} catch (Exception e) {

		}
		Scanner sc = new Scanner(System.in);
		boolean isreceipt = true;
		while (isreceipt) {
			System.out.println("영수증 받겠습니까? (Y/N)");
			switch (sc.next()) {
			case "Y":
			case "y":
				System.out.println("모바일 영수증으로 발송되었습니다.^^");
				System.out.println("이용해주셨어 감사합니다.");
				state.clear();
				isreceipt = false;
				break;
			case "N":
			case "n":
				System.out.println("이용해주셨어 감사합니다.");
				state.clear();
				isreceipt = false;
				break;
			default:
				System.out.println("다시 입력하세요.");
				break;
			}
		}
		state.print_state();
	}
}
