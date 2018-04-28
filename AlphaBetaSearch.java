package gomoku2;

import java.util.*;

public class AlphaBetaSearch {
	Board Board = new Board();
	
	public int[] Alpha_Beta_Search(int[][] board, int time) {
		int[] v = new int[3];
		long start = System.currentTimeMillis();
		v = Max_Value(board, -10000, 10000, time, start);
		return v;
	}
	
	public int[] Max_Value(int[][] board, int alpha, int beta, int time, long start) {
		int[] v = new int[3];
		v[0] = -10000;
		long end = System.currentTimeMillis() - start;
		if(end/1000 >= time) {
		//if(time <= 0) {
			v[0] = Board.calculate(board);
			return v;
		}
		ArrayList<Pos> actions = move(board);
		for(Pos move : actions) {
			int[][] next_board = next_state(board, move.x, move.y, 2);
			
			int[] temp = Min_Value(next_board, alpha, beta, time - 1, start);
			
			if(v[0] < temp[0]) {
				v = temp;
				v[1] = move.x;
				v[2] = move.y;
			}
			if(v[0] >= beta) {
				return v;
			}
			if(alpha < v[0]) {
				alpha = v[0];
			}
		}
		return v;
	}
	
	public int[] Min_Value(int[][] board, int alpha, int beta, int time, long start) {
		int[] v = new int[3];
		v[0] = 10000;
		long end = System.currentTimeMillis() - start;
		if(end/1000 >= time) {
		//if(time <= 0) {
			v[0] = Board.calculate(board);
			return v;
		}
		ArrayList<Pos> actions = move(board);
		for(Pos move : actions) {			
			int[][] next_board = next_state(board, move.x, move.y, 1);
			
			int[] temp = Max_Value(next_board, alpha, beta, time - 1, start);
			
			if(v[0] > temp[0]) {
				v = temp;
				v[1] = move.x;
				v[2] = move.y;
			}
			if(v[0] <= alpha) {
				return v;
			}
			if(beta > v[0]) {
				beta = v[0];
			}
		}
		return v;
	}
	
	public ArrayList<Pos> move(int[][] board){
		ArrayList<Pos> possible_move = new ArrayList<Pos>();
		
		for(int y = 0; y < 19; y++) {
			for(int x = 0; x < 19; x++) {
				//if(board[y][x] != 1 && board[y][x] != 2) {
				if(board[y][x] == 0) {
					Pos pos = new Pos();
					pos.x = x;
					pos.y = y;
					possible_move.add(pos);
				}
				else {
					continue;
				}
			}
		}
		
		return possible_move;
	}
	
	public int[][] next_state(int[][] board, int x, int y, int player){
		int[][] next = new int[19][19];
		
		for(int j = 0; j < 19; j++) {
			for(int i = 0; i < 19; i++) {
				next[j][i] = board[j][i];
			}
		}
		
		next[y][x] = player;
		
		return next;
	}
}
