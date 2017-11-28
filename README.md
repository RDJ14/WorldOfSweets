# WorldOfSweets
CS1530 Group Project

## Architecture

`WorldOfSweets.java`
- Creates a JFrame on a new thread so we don't do UI work on the main thread.
- Adds `MainPanel.java` as the only JPanel in the JFrame.

`MainPanel.java`
- Creates and adds a `GameBoardView` to the MainPanel
- Creates a `GameSetupController` with the `GameBoardView` as an argument

### Controllers
`GameSetupController`
- Deals with all of the popups
-- How many players
-- What's their name
-- Are they AI
- Starts a new `GameController` object if it's a new game
- Loads the old `GameController` that was serialized if they decide to load the game
-- The `GameController` is passed the `GameBoardView` and a list of `PlayerModel`

`GameController`
- In charge of listening to any action events coming from the `GameBoardView`
- Also in charge of manipulating the `GameBoardView`
-- Move player to spot 2
-- Update timer text
-- Update the draw card pile

### Views

### Models

