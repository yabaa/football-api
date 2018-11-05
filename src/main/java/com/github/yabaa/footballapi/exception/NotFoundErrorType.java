package com.github.yabaa.footballapi.exception;

import java.text.MessageFormat;

public enum NotFoundErrorType {

    GAME("Game with id {0} was not found"),
    LEAGUE("League with id {0} was not found"),
    TEAM("Team with id {0} was not found");

    String description;

    NotFoundErrorType(String description) {
        this.description = description;
    }

    public String getDescription(Object[] args) {
        return MessageFormat.format(description, args);
    }

    public String getDescription() {
        return description;
    }

}
