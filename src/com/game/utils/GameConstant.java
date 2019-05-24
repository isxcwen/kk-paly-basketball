package com.game.utils;

public enum GameConstant {
    WINDOW_WIDTH(1000),
    WINDOW_HEIGHT(1000),
    UP_BORDER(33),
    OTHER_BORDER(0);

    int code;
    GameConstant(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
