package com.company;

public enum GameState
{
    NewGame("a new game started"),
    PlayerWin("The player won"),
    PlayerLose("The player lost");
    private String value;
    GameState(String s)
    {
        this.value = s;
    }
    public String getValue()
    {
        return value;
    }

}
