package me.opmaster.game;

public class Tiktaktoe {
    private boolean isXsTurn = true;
    private char[][] fields = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private boolean isRunning = true;
    private boolean isTie = false;
    
    public void makeMove(int x, int y) {
        if (!isRunning) {
            return;
        }
        if (fields[x][y] != ' ') {
            return;
        }
        if (isXsTurn) {
            fields[x][y] = 'X';
        } else  {
            fields[x][y] = 'O';
        }
        System.out.println("Successful move");
        nextTurn();
    }
    
    private void nextTurn() {
        isRunning = !checkForWin(isXsTurn);
        if (checkIfFull()) {
            isRunning = false;
            isTie = true;
        }
        if (isRunning) {
            isXsTurn = !isXsTurn;
        }
    }

    public boolean checkIfFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (fields[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public boolean checkForWin(boolean isX) {
        char player = isX ? 'X' : 'O';
        for (int i = 0; i < 3; i++) {
            if (fields[i][0] == player && fields[i][1] == player && fields[i][2] == player) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (fields[0][i] == player && fields[1][i] == player && fields[2][i] == player) {
                return true;
            }
        }
        if (fields[0][0] == player && fields[1][1] == player && fields[2][2] == player) {
            return true;
        }
        if (fields[0][2] == player && fields[1][1] == player && fields[2][0] == player) {
            return true;
        }
        return false;
    }

    public String getIndicator() {
        if (!isRunning) {
            if (isTie) return "Tie";
            if (isXsTurn) {
                return "X Wins";
            } else {
                return "O Wins";
            }
        }
        if (isXsTurn) {
            return "Xs Turn";
        } else {
            return "Os Turn";
        }
    }
    public char getChar(int x, int y) {
        return fields[x][y];
    }
}