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
>`Controllers` are in charge of taking the `Models` and translating them into `Views`

`GameSetupController.java`
- Deals with all of the popups
  - How many players?
  - What's their name?
  - Are they AI?
- Starts a new `GameController` object if it's a new game
- Loads the old `GameController` that was serialized if they decide to load the game
  - The `GameController` is passed the `GameBoardView` and a list of `PlayerModel`

`GameController.java`
- In charge of listening to any action events coming from the `GameBoardView`
- Also in charge of manipulating the `GameBoardView`
  - Move player to spot X
  - Update timer text
  - Update the draw card pile

### Views
>`Views` are very dumb with no logic, the `Controllers` are responsible for telling it what to do

`GameBoardView.java`
- Renders a png file as the gameboard
- Emits events that `GameController` is listening to
  - `addTokenMovedListener()`
    - This event is sent when the player moves a piece
    - The only information sent is the Piece moved, and the x/y coords
    - It is up to the `GameController` to decide if it's a valid move
  - `addCardDrawnListener()`
    - This event is sent when the player clicks the card
    - The `GameController` asks the `DeckModel` for a new card
    - The `GameController` then tells the `GameBoardView` to render this card

### Models
>`Models` don't have much logic, they are just there to hold information
`PlayerModel.java`
- Holds information about the player
  - A `String` player id;
  - A `String` player name;
  - A `String` piece id;
  - An `int` representation of the current location on the board
  
`DeckModel.java`
- Its only job is to keep track of all the cards in the pile and to return a drawn card when asked

### Misc
`GameHelperUtil.java`
- Helper method for finding spots on the board
- `getNext(int currentSpot, Card card)`
  - Given a location on the board it finds the next spot on the board that matches the given card
  - It loops through an `array` representation of the board `{ Spot.START, Spot.RED, Spot.YELLOW, etc... }`
