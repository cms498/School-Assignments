def make_board(rows = 3, columns = 3, value = " "):
    table = [[value for _ in range(columns)] for _ in range(rows)]
    return table

def print_board(board):
    for _ in range(3):
        print(board[_])

def make_move(board, symbol):
    location = input("Enter row column: ")
    move = location.split()
    board[int(move[0])][int(move[1])] = symbol
    print_board(board)
    
def main():
    board = make_board()
    print_board(board)
    symbol = "X"
    for _ in range(9):
        make_move(board, symbol)
        if symbol == "X":
            symbol = "0"
        else:
            symbol = "X"

if __name__ == "__main__":
    main()