package gomoku2;
import java.util.Scanner;

public class Main {
	static Scanner input;
	Board Board = new Board();
		
	public static void main(String[] args) {
		Main MM = new Main();
		
		input = new Scanner(System.in);
		
		System.out.println("흑돌과 백돌 중 선택해주세요. 흑돌은 1번, 백돌은 2번 입니다.");
		int order;
		order = input.nextInt();
		while(order!=1 && order!=2) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요!");
			order = input.nextInt();
		}
		
		System.out.println("제한시간을 입력해주세요.");
		int time = input.nextInt();

		int count = 1;
		int board[][] = new int[19][19];
		
		if(order == 1) {
			MM.Player(board, time, count, order);
		}
		else if(order == 2) {
			MM.Computer(board, time, count, order);
		}
	}
	
	public void Player(int[][] board, int time, int count, int order) {
		Main MM = new Main();
		
		MM.PrintBoard(board, order);
		input = new Scanner(System.in);
		
		System.out.println("좌표를 입력해주세요. ex: A 2 = 가로 A, 세로 2");
		String x = input.next();
		char cx = x.charAt(0);
		int y = input.nextInt();
		
		
		int xx = cx - 65;
		
		while(true) {
			if(xx >= 0 && xx <= 18 && y >= 1 && y <= 19) {
				if(board[y-1][xx] == 0) {
					board[y-1][xx] = 1;
					break;
				}
				else {
					System.out.println("이미 돌이 있습니다. 다른 좌표를 입력해주세요!");
					x = input.next();
					y = input.nextInt();
					
					cx = x.charAt(0);
					xx = cx - 65;
				}
			}
			else {
				System.out.println("잘못된 좌표입니다. 다시 입력해주세요! *범위는 가로 1~19, 세로 1~19 입니다*");
				x = input.next();
				y = input.nextInt();
				
				cx = x.charAt(0);
				xx = cx - 65;
			}
		}
		
		if(Board.winner_check(board) == 1) {
			MM.PrintBoard(board, order);
			System.out.println("Player WIN!!!");
			return;
		}
		else if(Board.is_full(board) && Board.winner_check(board) == 0) {
			MM.PrintBoard(board, order);
			System.out.println("DRAW!!");
			return;
		}
		else {
			Computer(board, time, count+1, order);
		}
	}
	
	public void Computer(int[][] board, int time, int count, int order) {
		Main MM = new Main();
		
		MM.PrintBoard(board, order);
		
		AlphaBetaSearch AB = new AlphaBetaSearch();
		int x = 0, y = 0;
		if(count == 1) {
			x = 9;
			y = 9;
		}
		else if(count == 2) {
			for(int j = 0; j < 19; j++) {
				for(int i = 0; i < 19; i++) {
					if(board[j][i] == 1) {
						y = j;
						x = i+1;
						break;
					}
				}
			}
		}
		else {
			int[] AI = AB.Alpha_Beta_Search(board, time);
			x = AI[1];
			y = AI[2];
		}
		
		board[y][x] = 2;
		System.out.printf("AI: (%c , %d) \n", x+65, y+1);
		
		if(Board.winner_check(board) == 2) {
			MM.PrintBoard(board, order);
			System.out.println("Computer WIN!!!");
			return;
		}
		else if(Board.is_full(board) && Board.winner_check(board) == 0) {
			MM.PrintBoard(board, order);
			System.out.println("DRAW!!");
			return;
		}
		else {
			Player(board, time, count+1, order);
		}
	}
	
	public void PrintBoard(int[][] board, int order) {
		for(int y = -1; y < 19; y++) {
			for(int x = 0; x < 20; x++) {
				if(y == -1 && x < 19) {
					System.out.printf(" %c ", x + 65);
				}
				else if(y == -1 && x == 19) {
					continue;
				}
				else if(y > -1 && x == 19) {
					System.out.printf(" %d ", y + 1);
				}
				else {
					if(order == 1) {
						if(board[y][x] == 1) {
							System.out.printf(" ● ");
						}
						else if(board[y][x] == 2) {
							System.out.printf(" ○ ");
						}
						else if(board[y][x] == 0){
							System.out.printf(" - ");
						}
					}
					else if(order == 2) {
						if(board[y][x] == 1) {
							System.out.printf(" ○ ");
						}
						else if(board[y][x] == 2) {
							System.out.printf(" ● ");
						}
						else if(board[y][x] == 0){
							System.out.printf(" - ");
						}
					}
				}				
			}
			System.out.println();
		}
	}
}
