package parking;

import java.util.Scanner;

public class Manage {
	public Manage() {
	}

	void inform(State state) {
		login(state);
		state.print_state(); // 주차 정보 가져오기
		System.out.println("==============================================\n << 현재 주차 칸 별 정보 >>");

		for (int i = 0; i < state.box.length; i++) {
			state.charge_inform(i);
			System.out.println("이름 : " + state.box[i].getName());
			System.out.println("차량번호 : " + state.box[i].getCar_num()); //
		}
	}

	void login(State state) {
		Scanner sc = new Scanner(System.in);
		String id = null;
		String pwd = null;
		int num = 0;
		boolean run = true;

		while (run) {

			System.out.println("1.로그인");
			System.out.println("2.회원가입");
			System.out.println("---------------");
			num = sc.nextInt();
			if (num == 1) {
				System.out.print("아이디: ");
				id = sc.next();
				System.out.print("비밀번호: ");
				pwd = sc.next();
				for (int i = 0; i < state.user.length; i++) {
					if (id.equals(state.user[i].getId()) && pwd.equals(state.user[i].getPwd())) {
						run = false; // .equals로 글자 비교
						System.out.println("로그인성공!");
						break;
					}
				}
				if (run) {
					System.out.println("다시입력해주세요.");
				}
			} else if (num == 2) {
				System.out.print("아이디: ");
				id = sc.next();

				System.out.print("비밀번호: ");
				pwd = sc.next();

				for (int i = 0; i < state.user.length; i++) {
					if ("".equals(state.user[i].getId())) {
						state.user[i].setId(id);
						state.user[i].setPwd(pwd);
						System.out.println("회원가입성공!");
						break;
					}
				}
			}
		}

	}
}
