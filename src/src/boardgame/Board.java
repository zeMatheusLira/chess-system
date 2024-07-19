package boardgame;

public class Board {

    private int rows;
    private int collumns;
    private Piece[][] pieces;

    public Board(int rows, int collumns) {
        if (rows <1 || collumns <1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.collumns = collumns;
        pieces = new Piece[rows][collumns];
    }

    public Piece piece(int row, int column){
        if (!positionExists(row, column)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if(theresIsAPiece(position)) {
            throw new BoardException("There is already a piece on position "+position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int collumn) {
        return row >=0 && row < rows && collumn >=0 && collumn < collumns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean theresIsAPiece(Position position) {
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }

    public int getRows() {
        return rows;
    }

    public int getCollumns() {
        return collumns;
    }


}
