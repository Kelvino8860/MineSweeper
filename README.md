Create a Mine Sweeper game by setting up a grid of rows and columns in
which “bombs” are randomly hidden. You choose the size and difficulty of the
game; for example, you might choose to create a fairly simple game by displaying a
four-by-five grid that contains four bombs. If a player clicks a panel in the grid
that contains a bomb, then the player loses the game. If the clicked panel is not a
bomb, display a number that indicates how many adjacent panels contain a bomb.
For example, if a user clicks a panel containing a 0, the user knows it is safe to click
any panel above, below, beside, or diagonally adjacent to the cell, because those cells
cannot possibly contain a bomb. If the player loses by clicking a bomb, display all
the numeric values as well as the bomb positions. If the player succeeds in clicking all
the panels except those containing bombs, the player wins and you should display a
congratulatory message. Figure 15-44 shows the progression of a typical game. In the
first screen, the user has clicked a panel, and the display indicates that no adjacent cells
contain a bomb. In the second screen, the user has clicked a second panel, and the
display indicates that one adjacent cell contains a bomb. In the last screen, the user has
clicked a bomb panel, and all the bomb positions are displayed. Save the game as
MineSweeper.java.