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

### Views

### Models

