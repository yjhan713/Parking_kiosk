package parking;

import java.util.Date;

public class State {
	final static int MAX = 36;
	Date date = new Date();

	public Box box[] = new Box[MAX];
	public User user[] = new User[MAX];
	
	public State() {
		this.create(MAX);
	}

	public void create(int a) {
		for (int i = 0; i < a; i++) {
			box[i] = new Box();
			user[i] = new User();
		}

		for (int i = 0; i < a; i++) {
			box[i].setNum("(" + (i + 1) + ")");
		}
	}

	public void print_state() {

		System.out.println("==============================================\n << 현재 주차장 상태 >>");
		for (int i = 0; i < MAX / 6; i++) {
			System.out.print("[" + box[i].getNum() + "]");
		}

		System.out.println();

		for (int i = MAX / 6; i < MAX / 6 * 2; i++) {
			System.out.print("[" + box[i].getNum() + "]");
		}
		System.out.println();
		for (int i = MAX / 6 * 2; i < MAX / 6 * 3; i++) {
			System.out.print("[" + box[i].getNum() + "]");
		}
		System.out.println();
		for (int i = MAX / 6 * 3; i < MAX / 6 * 4; i++) {
			System.out.print("[" + box[i].getNum() + "]");
		}
		System.out.println();
		for (int i = MAX / 6 * 4; i < MAX / 6 * 5; i++) {
			System.out.print("[" + box[i].getNum() + "]");
		}
		System.out.println();
		for (int i = MAX / 6 * 5; i < MAX; i++) {
			System.out.print("[" + box[i].getNum() + "]");
		}

		System.out.println();
	}

	public void init(int a) {
		box[a].setNum("(" + (a + 1) + ")");
		box[a].setName("");
		box[a].setCar_num("");
		box[a].setIn("");
		box[a].setOut("");
		box[a].setCharge(0);
	}

	public void charges(int a) {
		if (box[a].getNum() == " ■ ") {
			int in = (int) box[a].inTime;
			int out = (int) box[a].outTime;

			int freeTime = 0;// 무료시간
			int pricePerTime = 1000;// 기준시간당 요금
			int period = 1;// 기준시간
			int maxPrice = 10000;// 일 최대요금

			int inHour = in / 1000;
			int inMinute = in % 100;
			int outHour = out / 1000;
			int outMinute = out % 100;

			int time = (outHour - inHour) / 60;
			System.out.println("사용시간: " + time + "분");

			int price;

			if (time <= freeTime) {
				price = 0;
			} else {
				time = time - freeTime;
				price = ((time) / period) * pricePerTime;
			}

			if (price > maxPrice) {
				price = maxPrice;
			}

			box[a].setCharge(price);

		}
	}

	public void charge_inform(int i) {
		System.out.println("==============================================\n [ " + (i + 1) + " ]");
		System.out.println("주차시간 : " + box[i].getIn());
		System.out.println("출차시간 : " + box[i].getOut());
		if (box[i].getNum() == " ■ ") {
			box[i].outTime = System.currentTimeMillis();
		}
		charges(i);
		System.out.println("주차요금 : " + box[i].getCharge() + "원");
	}

	public void clear() {
		for (int i = 0; i < 5; i++)
			System.out.println();
	}
}
