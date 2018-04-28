package gomoku2;

public class Board {
	public int calculate(int[][] board) {
		int score = 0;                                                         
		int total_score = 0;                                                    
		
		for (int i = 0; i <= 18; i++) {
			for (int k = 0; k <= 18; k++) {
				if(k - 1 >= 0 && k - 1 <= 18 && k + 1 >= 0 && k + 1 <= 18) {
					if(k - 2 >= 0 && k - 2 <= 18 && k + 2 >= 0 && k + 2 <= 18) {
						//가로
						if (board[i][k - 2] == 2 && board[i][k - 1] == 2 && board[i][k] == 2 && board[i][k + 1] == 2 && board[i][k + 2] == 2) {
							score = 1000;
							total_score = total_score + score;
						}  //ooooo 승리시
						else if (board[i][k - 2] == 2 && board[i][k - 1] == 2 && board[i][k] == 2 && board[i][k + 1] == 2 && board[i][k + 2] == 0) {
							score = 50;
							total_score = total_score + score;
						}  //oooo 4개 연속
						else if (board[i][k - 2] == 2 && board[i][k - 1] == 2 && board[i][k] == 2 && board[i][k + 1] == 2 && board[i][k + 2] == 1) {
							score = 40;
							total_score = total_score + score;
						}  //oooox 4개 연속 막힘
						else if (board[i][k - 2] == 1 && board[i][k - 1] == 2 && board[i][k] == 2 && board[i][k + 1] == 2 && board[i][k + 2] == 2) {
							score = 40;
							total_score = total_score + score;
						}  //xoooo 4개 연속 막힘
						else if (board[i][k - 2] == 0 && board[i][k - 1] == 2 && board[i][k] == 2 && board[i][k + 1] == 2 && board[i][k + 2] == 0) {
							score = 6;
							total_score = total_score + score;
						}  //ooo 3개 연속 막히지 않음
						else if (board[i][k - 2] == 0 && board[i][k - 1] == 2 && board[i][k] == 2 && board[i][k + 1] == 2 && board[i][k + 2] == 1) {
							score = 4;
							total_score = total_score + score;
						}  //ooox 3개 연속 막힘
						else if (board[i][k - 2] == 1 && board[i][k - 1] == 2 && board[i][k] == 2 && board[i][k + 1] == 2 && board[i][k + 2] == 0) {
							score = 4;
							total_score = total_score + score;
						}  //xooo 3개 연속 막힘
						//수비
						else if (board[i][k - 2] == 1 && board[i][k - 1] == 1 && board[i][k] == 1 && board[i][k + 1] == 1 && board[i][k + 2] == 2) {
							score = 100;
							total_score = total_score + score;
						}  //oooox 가로 수비시
						else if (board[i][k - 2] == 2 && board[i][k - 1] == 1 && board[i][k] == 1 && board[i][k + 1] == 1 && board[i][k + 2] == 1) {
							score = 100;
							total_score = total_score + score;
						}  //xoooo 가로 수비시
						else if (board[i][k - 1] == 1 && board[i][k] == 1 && board[i][k + 1] == 1 && board[i][k + 2] == 2) {
							if (board[i][k - 2] == 2) {
								score = 3;        //한쪽이 막혀있는데 수비 하려는 경우
							}
							else {
								score = 30;
							}
							total_score = total_score + score;
						}  //ooox 가로 수비시
						else if (board[i][k - 2] == 2 && board[i][k - 1] == 1 && board[i][k] == 1 && board[i][k + 1] == 1) {
							if (board[i][k + 2] == 2) {
								score = 3;        //한쪽이 막혀있는데 수비 하려는 경우
							}
							else {
								score = 30;
							}
							total_score = total_score + score;
						}  //xooo 가로 수비시
						//추가한 코드
						else if (board[i][k - 1] == 1 && board[i][k] == 1 && board[i][k + 1] == 2 && board[i][k + 2] == 1) {
							score = 200;
							total_score = total_score + score;
						}  //ooxo 
						else if (board[i][k - 2] == 1 && board[i][k - 1] == 2 && board[i][k] == 1 && board[i][k + 1] == 1) {
							score = 200;
							total_score = total_score + score;
						}  //oxoo 
						else if (board[i][k - 2] == 1 && board[i][k - 1] == 1 && board[i][k] == 1 && board[i][k + 1] == 2 && board[i][k + 2] == 1) {
							score = 200;
							total_score = total_score + score;
						}  //oooxo 
						else if (board[i][k - 2] == 1 && board[i][k - 1] == 2 && board[i][k] == 1 && board[i][k + 1] == 1 && board[i][k + 2] == 1) {
							score = 200;
							total_score = total_score + score;
						}  //oxooo 
						else if (board[i][k - 2] == 1 && board[i][k-1] == 1 && board[i][k] == 2 && board[i][k+1] == 1 && board[i][k+2] == 1) {
							score = 200;
							total_score = total_score + score;
						}
						else if (board[i][k - 1] == 0 && board[i][k] == 2 && board[i][k + 1] == 2 && board[i][k + 2] == 0) {
							if(k - 1 == 0) {
								score = 1;
							}
							else {
								score = 5;
							}							
							total_score = total_score + score;
						}  //oo 2개 연속
						else if (board[i][k - 1] == 0 && board[i][k] == 2 && board[i][k + 1] == 2 && board[i][k + 2] == 1) {
							score = 1;
							total_score = total_score + score;
						}  //oox 2개 연속 막힘
						else if (board[i][k - 1] == 1 && board[i][k] == 2 && board[i][k + 1] == 2 && board[i][k + 2] == 0) {
							score = 1;
							total_score = total_score + score;
						}  //xoo 2개 연속 막힘
					}
					
					if(i - 1 >= 0 && i - 1 <= 18 && i + 1 >= 0 && i + 1 <= 18) {
						if(i - 2 >= 0 && i - 2 <= 18 && i + 2 >= 0 && i + 2 <= 18) {
							//세로
							if (board[i - 2][k] == 2 && board[i - 1][k] == 2 && board[i][k] == 2 && board[i + 1][k] == 2 && board[i + 2][k] == 2) {
								score = 1000;
								total_score = total_score + score;
							}  //ooooo 승리시
							else if (board[i - 2][k] == 2 && board[i - 1][k] == 2 && board[i][k] == 2 && board[i + 1][k] == 2 && board[i + 2][k] == 0) {
								score = 50;
								total_score = total_score + score;
							}  //oooo 4개 연속
							else if (board[i - 2][k] == 2 && board[i - 1][k] == 2 && board[i][k] == 2 && board[i + 1][k] == 2 && board[i + 2][k] == 1) {
								score = 40;
								total_score = total_score + score;
							}  //oooox 4개 연속 막힘
							else if (board[i - 2][k] == 1 && board[i - 1][k] == 2 && board[i][k] == 2 && board[i + 1][k] == 2 && board[i + 2][k] == 2) {
								score = 40;
								total_score = total_score + score;
							}  //xoooo 4개 연속 막힘
							else if (board[i - 2][k] == 0 && board[i - 1][k] == 2 && board[i][k] == 2 && board[i + 1][k] == 2 && board[i + 2][k] == 0) {
								score = 6;
								total_score = total_score + score;
							}  //ooo 3개 연속
							else if (board[i - 2][k] == 0 && board[i - 1][k] == 2 && board[i][k] == 2 && board[i + 1][k] == 2 && board[i + 2][k] == 1) {
								score = 4;
								total_score = total_score + score;
							}  //ooox 3개 연속 막힘
							else if (board[i - 2][k] == 1 && board[i - 1][k] == 2 && board[i][k] == 2 && board[i + 1][k] == 2 && board[i + 2][k] == 0) {
								score = 4;
								total_score = total_score + score;
							}  //xooo 3개 연속 막힘
							else if (board[i - 2][k] == 1 && board[i - 1][k] == 1 && board[i][k] == 1 && board[i + 1][k] == 1 && board[i + 2][k] == 2) {
								score = 100;
								total_score = total_score + score;
							}  //oooox 세로 수비시
							else if (board[i - 2][k] == 2 && board[i - 1][k] == 1 && board[i][k] == 1 && board[i + 1][k] == 1 && board[i + 2][k] == 1) {
								score = 100;
								total_score = total_score + score;
							}  //xoooo 세로 수비시
							else if (board[i - 1][k] == 1 && board[i][k] == 1 && board[i + 1][k] == 1 && board[i + 2][k] == 2) {
								if (board[i - 2][k] == 2) {
									score = 3;        //한쪽이 막혀있는데 수비 하려는 경우
								}
								else {
									score = 30;
								}
								total_score = total_score + score;
							}  //ooox 세로 수비시
							else if (board[i - 2][k] == 2 && board[i - 1][k] == 1 && board[i][k] == 1 && board[i + 1][k] == 1) {
								if (board[i + 2][k] == 2) {
									score = 3;        //한쪽이 막혀있는데 수비 하려는 경우
								}
								else {
									score = 30;
								}
								total_score = total_score + score;
							}  //xooo 세로 수비시
							else if (board[i-1][k] == 1 && board[i][k] == 1 && board[i+1][k] == 2 && board[i+2][k] == 1) {
								score = 200;
								total_score = total_score + score;
							}  //ooxo 
							else if (board[i-2][k] == 1 && board[i-1][k] == 2 && board[i][k] == 1 && board[i+1][k] == 1) {
								score = 200;
								total_score = total_score + score;
							}  //oxoo 
							else if (board[i-2][k] == 1 && board[i-1][k] == 1 && board[i][k] == 1 && board[i+1][k] == 2 && board[i+2][k] == 1) {
								score = 200;
								total_score = total_score + score;
							}  //oooxo 
							else if (board[i-2][k] == 1 && board[i-1][k] == 2 && board[i][k] == 1 && board[i+1][k] == 1 && board[i+2][k] == 1) {
								score = 200;
								total_score = total_score + score;
							}  //oxooo 
							else if (board[i-2][k] == 1 && board[i-1][k] == 1 && board[i][k] == 2 && board[i+1][k] == 1 && board[i+2][k] == 1) {
								score = 200;
								total_score = total_score + score;
							}
							else if (board[i - 1][k] == 0 && board[i][k] == 2 && board[i + 1][k] == 2 && board[i + 2][k] == 0) {
								if(i - 1 == 0) {
									score = 1;
								}
								else {
									score = 2;
								}				
								total_score = total_score + score;
							}  //oo 2개 연속
							else if (board[i - 1][k] == 0 && board[i][k] == 2 && board[i + 1][k] == 2 && board[i + 2][k] == 1) {
								score = 1;
								total_score = total_score + score;
							}  //oox 2개 연속 막힘
							else if (board[i - 1][k] == 1 && board[i][k] == 2 && board[i + 1][k] == 2 && board[i + 2][k] == 0) {
								score = 1;
								total_score = total_score + score;
							}  //xoo 2개 연속 막힘
						}
					}
					if(i - 1 >= 0 && i - 1 <= 18 && i + 1 >= 0 && i + 1 <= 18 && k - 1 >= 0 && k - 1 <= 18 && k + 1 >= 0 && k + 1 <= 18) {
						if(i - 2 >= 0 && i - 2 <= 18 && i + 2 >= 0 && i + 2 <= 18 && k - 2 >= 0 && k - 2 <= 18 && k + 2 >= 0 && k + 2 <= 18) {
							//대각선1
							if (board[i - 2][k + 2] == 2 && board[i - 1][k + 1] == 2 && board[i][k] == 2 && board[i + 1][k - 1] == 2 && board[i + 2][k - 2] == 2) {
								score = 1000;
								total_score = total_score + score;
							}  //ooooo 승리시
							else if (board[i - 2][k + 2] == 2 && board[i - 1][k + 1] == 2 && board[i][k] == 2 && board[i + 1][k - 1] == 2 && board[i + 2][k - 2] == 0) {
								score = 50;
								total_score = total_score + score;
							}  //oooo 4개 연속
							else if (board[i - 2][k + 2] == 2 && board[i - 1][k + 1] == 2 && board[i][k] == 2 && board[i + 1][k - 1] == 2 && board[i + 2][k - 2] == 1) {
								score = 40;
								total_score = total_score + score;
							}  //oooox 4개 연속 막힘
							else if (board[i - 2][k + 2] == 1 && board[i - 1][k + 1] == 2 && board[i][k] == 2 && board[i + 1][k - 1] == 2 && board[i + 2][k - 2] == 2) {
								score = 40;
								total_score = total_score + score;
							}  //xoooo 4개 연속 막힘
							else if (board[i - 2][k + 2] == 0 && board[i - 1][k + 1] == 2 && board[i][k] == 2 && board[i + 1][k - 1] == 2 && board[i + 2][k - 2] == 0) {
								score = 7;
								total_score = total_score + score;
							}  //ooo 3개 연속
							else if (board[i - 2][k + 2] == 0 && board[i - 1][k + 1] == 2 && board[i][k] == 2 && board[i + 1][k - 1] == 2 && board[i + 2][k - 2] == 1) {
								score = 6;
								total_score = total_score + score;
							}  //ooox 3개 연속 막힘
							else if (board[i - 2][k + 2] == 1 && board[i - 1][k + 1] == 2 && board[i][k] == 2 && board[i + 1][k - 1] == 2 && board[i + 2][k - 2] == 0) {
								score = 6;
								total_score = total_score + score;
							}  //xooo 3개 연속 막힘
							//대각선 2
							else if (board[i - 2][k - 2] == 2 && board[i - 1][k - 1] == 2 && board[i][k] == 2 && board[i + 1][k + 1] == 2 && board[i + 2][k + 2] == 2) {
								score = 1000;
								total_score = total_score + score;
							}  //ooooo 승리시
							else if (board[i - 2][k - 2] == 2 && board[i - 1][k - 1] == 2 && board[i][k] == 2 && board[i + 1][k + 1] == 2 && board[i + 2][k + 2] == 0) {
								score = 50;
								total_score = total_score + score;
							}  //oooo 4개 연속
							else if (board[i - 2][k - 2] == 2 && board[i - 1][k - 1] == 2 && board[i][k] == 2 && board[i + 1][k + 1] == 2 && board[i + 2][k + 2] == 1) {
								score = 40;
								total_score = total_score + score;
							}  //oooox 4개 연속 막힘
							else if (board[i - 2][k - 2] == 1 && board[i - 1][k - 1] == 2 && board[i][k] == 2 && board[i + 1][k + 1] == 2 && board[i + 2][k + 2] == 2) {
								score = 40;
								total_score = total_score + score;
							}  //xoooo 4개 연속 막힘
							else if (board[i - 2][k - 2] == 0 && board[i - 1][k - 1] == 2 && board[i][k] == 2 && board[i + 1][k + 1] == 2 && board[i + 2][k + 2] == 0) {
								score = 7;
								total_score = total_score + score;
							}  //ooo 3개 연속
							else if (board[i - 2][k - 2] == 0 && board[i - 1][k - 1] == 2 && board[i][k] == 2 && board[i + 1][k + 1] == 2 && board[i + 2][k + 2] == 1) {
								score = 6;
								total_score = total_score + score;
							}  //ooox 3개 연속 막힘
							else if (board[i - 2][k - 2] == 1 && board[i - 1][k - 1] == 2 && board[i][k] == 2 && board[i + 1][k + 1] == 2 && board[i + 2][k + 2] == 0) {
								score = 6;
								total_score = total_score + score;
							}  //xooo 3개 연속 막힘
							else if (board[i - 2][k - 2] == 1 && board[i - 1][k - 1] == 1 && board[i][k] == 1 && board[i + 1][k + 1] == 1 && board[i + 2][k + 2] == 2) {
								score = 100;
								total_score = total_score + score;
							}  //oooox 반대 대각선 수비시
							else if (board[i - 2][k - 2] == 2 && board[i - 1][k - 1] == 1 && board[i][k] == 1 && board[i + 1][k + 1] == 1 && board[i + 2][k + 2] == 1) {
								score = 100;
								total_score = total_score + score;
							}  //xoooo 반대 대각선 수비시
							else if (board[i - 2][k + 2] == 1 && board[i - 1][k + 1] == 1 && board[i][k] == 1 && board[i + 1][k - 1] == 1 && board[i + 2][k - 2] == 2) {
								score = 100;
								total_score = total_score + score;
							}  //oooox 대각선 수비시
							else if (board[i - 2][k + 2] == 2 && board[i - 1][k + 1] == 1 && board[i][k] == 1 && board[i + 1][k - 1] == 1 && board[i + 2][k - 2] == 1) {
								score = 100;
								total_score = total_score + score;
							}  //xoooo 대각선 수비시
							else if (board[i - 1][k + 1] == 1 && board[i][k] == 1 && board[i + 1][k - 1] == 1 && board[i + 2][k - 2] == 2) {
								if (board[i - 2][k + 2] == 2) {
									score = 3;        //한쪽이 막혀있는데 수비 하려는 경우
								}
								else {
									score = 30;
								}
								total_score = total_score + score;
							}  //ooox 대각선 수비시
							else if (board[i - 2][k + 2] == 2 && board[i - 1][k + 1] == 1 && board[i][k] == 1 && board[i + 1][k - 1] == 1) {
								if (board[i + 2][k - 2] == 2) {
									score = 3;        //한쪽이 막혀있는데 수비 하려는 경우
								}
								else {
									score = 30;
								}
								total_score = total_score + score;
							}  //xooo 대각선 수비시
							else if (board[i - 1][k - 1] == 1 && board[i][k] == 1 && board[i + 1][k + 1] == 1 && board[i + 2][k + 2] == 2) {
								if (board[i - 2][k - 2] == 2) {
									score = 3;        //한쪽이 막혀있는데 수비 하려는 경우
								}
								else {
									score = 30;
								}
								total_score = total_score + score;
							}  //ooox 반대 대각선 수비시
							else if (board[i - 2][k - 2] == 2 && board[i - 1][k - 1] == 1 && board[i][k] == 1 && board[i + 1][k + 1] == 1) {
								if (board[i + 2][k + 2] == 2) {
									score = 3;        //한쪽이 막혀있는데 수비 하려는 경우
								}
								else {
									score = 30;
								}
								total_score = total_score + score;
							}  //xooo 반대 대각선 수비시
							else if (board[i-1][k - 1] == 1 && board[i][k] == 1 && board[i+1][k + 1] == 2 && board[i+2][k + 2] == 1) {
								score = 200;
								total_score = total_score + score;
							}  //ooxo 
							else if (board[i-2][k - 2] == 1 && board[i-1][k - 1] == 2 && board[i][k] == 1 && board[i+1][k + 1] == 1) {
								score = 200;
								total_score = total_score + score;
							}  //oxoo 
							else if (board[i-2][k - 2] == 1 && board[i-1][k - 1] == 1 && board[i][k] == 1 && board[i+1][k + 1] == 2 && board[i+2][k + 2] == 1) {
								score = 200;
								total_score = total_score + score;
							}  //oooxo 
							else if (board[i-2][k - 2] == 1 && board[i-1][k - 1] == 2 && board[i][k] == 1 && board[i+1][k + 1] == 1 && board[i+2][k + 2] == 1) {
								score = 200;
								total_score = total_score + score;
							}  //oxooo 
							else if (board[i-2][k - 2] == 1 && board[i-1][k-1] == 1 && board[i][k] == 2 && board[i+1][k+1] == 1 && board[i+2][k+2] == 1) {
								score = 200;
								total_score = total_score + score;
							}
							else if (board[i+1][k - 1] == 1 && board[i][k] == 1 && board[i-1][k + 1] == 2 && board[i-2][k + 2] == 1) {
								score = 200;
								total_score = total_score + score;
							}  //ooxo 
							else if (board[i+2][k - 2] == 1 && board[i+1][k - 1] == 2 && board[i][k] == 1 && board[i-1][k + 1] == 1) {
								score = 200;
								total_score = total_score + score;
							}  //oxoo 
							else if (board[i+2][k - 2] == 1 && board[i+1][k - 1] == 1 && board[i][k] == 1 && board[i-1][k + 1] == 2 && board[i-2][k + 2] == 1) {
								score = 200;
								total_score = total_score + score;
							}  //oooxo 
							else if (board[i+2][k - 2] == 1 && board[i+1][k - 1] == 2 && board[i][k] == 1 && board[i-1][k + 1] == 1 && board[i-2][k + 2] == 1) {
								score = 200;
								total_score = total_score + score;
							}  //oxooo 
							else if (board[i+2][k - 2] == 1 && board[i+1][k-1] == 1 && board[i][k] == 2 && board[i-1][k+1] == 1 && board[i-2][k+2] == 1) {
								score = 200;
								total_score = total_score + score;
							}
							//대각선1
							else if (board[i - 1][k + 1] == 0 && board[i][k] == 2 && board[i + 1][k - 1] == 2 && board[i + 2][k - 2] == 0) {
								if(i-1 == 0) {
									score = 1;
								}
								else {
									score = 2;
								}	
								total_score = total_score + score;
							}  //oo 2개 연속
							else if (board[i - 1][k + 1] == 0 && board[i][k] == 2 && board[i + 1][k - 1] == 2 && board[i + 2][k - 2] == 1) {
								score = 1;
								total_score = total_score + score;
							}  //oox 2개 연속 막힘
							else if (board[i - 1][k + 1] == 1 && board[i][k] == 2 && board[i + 1][k - 1] == 2 && board[i + 2][k - 2] == 0) {
								score = 1;
								total_score = total_score + score;
							}  //xoo 2개 연속 막힘
							//대각선2
							else if (board[i - 1][k - 1] == 0 && board[i][k] == 2 && board[i + 1][k + 1] == 2 && board[i + 2][k + 2] == 0) {
								if(i-1 == 0) {
									score = 1;
								}
								else {
									score = 2;
								}	
								total_score = total_score + score;
							}  //oo 2개 연속
							else if (board[i - 1][k - 1] == 0 && board[i][k] == 2 && board[i + 1][k + 1] == 2 && board[i + 2][k + 2] == 1) {
								score = 1;
								total_score = total_score + score;
							}  //oox 2개 연속 막힘
							else if (board[i - 1][k - 1] == 1 && board[i][k] == 2 && board[i + 1][k + 1] == 2 && board[i + 2][k + 2] == 0) {
								score = 1;
								total_score = total_score + score;
							}  //xoo 2개 연속 막힘
						}
					}
				}
			}
		}
		return total_score;
	}
	
	public int winner_check(int[][] board) {
		int winchk = 0;
		int i;
		int k;

		for (i = 0; i <= 18; i++) {
			for (k = 2; k <= 16; k++) {
				if (board[i][k - 2] == 1 && board[i][k - 1] == 1 && board[i][k] == 1 && board[i][k + 1] == 1 && board[i][k + 2] == 1) {
					winchk = 1;					
				}
				else if (board[i][k - 2] == 2 && board[i][k - 1] == 2 && board[i][k] == 2 && board[i][k + 1] == 2 && board[i][k + 2] == 2) {
					winchk = 2;					
				}
				if (board[k - 2][i] == 1 && board[k - 1][i] == 1 && board[k][i] == 1 && board[k + 1][i] == 1 && board[k + 2][i] == 1) {
					winchk = 1;					
				}
				else if (board[k - 2][i] == 2 && board[k - 1][i] == 2 && board[k][i] == 2 && board[k + 1][i] == 2 && board[k + 2][i] == 2) {
					winchk = 2;					
				}
			}
		}


		for (i = 2; i <= 16; i++) {
			for (k = 2; k <= 16; k++) {
				if (board[k - 2][i - 2] == 1 && board[k - 1][i - 1] == 1 && board[k][i] == 1 && board[k + 1][i + 1] == 1 && board[k + 2][i + 2] == 1) {
					winchk = 1;
				}
				else if (board[k - 2][i - 2] == 2 && board[k - 1][i - 1] == 2 && board[k][i] == 2 && board[k + 1][i + 1] == 2 && board[k + 2][i + 2] == 2) {
					winchk = 2;
				}
				if (board[k - 2][i + 2] == 1 && board[k - 1][i + 1] == 1 && board[k][i] == 1 && board[k + 1][i - 1] == 1 && board[k + 2][i - 2] == 1) {
					winchk = 1;
				}
				else if (board[k - 2][i + 2] == 2 && board[k - 1][i + 1] == 2 && board[k][i] == 2 && board[k + 1][i - 1] == 2 && board[k + 2][i - 2] == 2) {
					winchk = 2;
				}
			}
		}
		return winchk;
	}
	
	public boolean is_full(int[][] board) {
		for(int y = 0; y < 19; y++) {
			for(int x = 0; x < 19; x++) {
				if(board[y][x] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
