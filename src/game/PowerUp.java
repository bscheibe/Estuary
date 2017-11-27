package game;

public class PowerUp extends NPC {

	private static final String[] questions = {
			"What is 1 + 1?",
			"What is 2 + 2?"
	};
	
	private static final String[] answers = {
			"2",
			"4"
	};
	
	/**Default Constructor
	 * 
	 */
	public PowerUp() {
		value = 300;
	}
	
	public static String[] getQuestionAndAnswer()
	{
		int i = (int) (Math.random() * questions.length);
		return new String[] {questions[i],answers[i]};
	}

}
