public class TicTacToe {
    private char[][] board; // 棋盤
    private char currentPlayer; // 當前玩家 ('X' 或 'O')

    public TicTacToe() {
        board = new char[3][3];
        reset();
    }

    // 重設遊戲
    public void reset() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
        currentPlayer = 'X';
    }

    // 取得目前玩家
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    // 設定格子（例如 set(1,2) 表示放在第 2 列第 3 行）
    public boolean set(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (board[row][col] != ' ') {
            return false; // 該位置已被佔
        }

        board[row][col] = currentPlayer;
        // 換玩家
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        return true;
    }

    // 檢查盤面
    public char evaluate() {
        // 檢查橫列
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0];
        }
        // 檢查直行
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j])
                return board[0][j];
        }
        // 檢查對角線
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];

        // 檢查是否平手（滿盤但無勝利）
        boolean full = true;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    full = false;

        if (full) return 'D'; // Draw 平手

        return ' '; // 遊戲未結束
    }

    // 印出棋盤（方便除錯）
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
