package connect4;

import utils.YesNoDialog;

class Connect4 {

	private final Board board;
	private final Turn turn;

	Connect4(){
		this.board = new Board();
		this.turn = new Turn(this.board);
	}

	private void play() {
		do {
			this.playGame();
		} while (this.isResumedGame());
	}

	private void playGame() {
		Message.TITLE.writeln();
		this.board.write();
		do {
			this.turn.play();
			this.board.write();
		} while (!this.end());

		if (this.isConnect4()){
			this.turn.writeWinner();
		} else {
			System.out.println(Message.TIE);
		}
	}

	private boolean isConnect4() {
		return this.board.isConnect4(this.turn.getActiveColor());
	}

	private boolean end() {
		return this.isConnect4() || this.board.isBoardFull();
	}


	private boolean isResumedGame() {
		YesNoDialog yesNoDialog = new YesNoDialog();
		yesNoDialog.read(Message.RESUME.toString());
		if (yesNoDialog.isAffirmative()) {
			this.board.reset();
			this.turn.reset();
		}
		return yesNoDialog.isAffirmative();
	}

	public static void main(String[] args) {
		new Connect4().play();
	}

}
