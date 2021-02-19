package com.codetogether.CodeTogether.domain;

import static java.lang.Math.pow;

public class Team {
    int id;
    int teamSize;
    boolean teamLive;
    String[] userList;
    long dueDate;//unix-date
    int exitVote;
    Project project;

    public void exit() {
        if (this.exitVote >= pow(2,this.teamSize/2 + 1) -1)
            this.teamLive = false;
    }
}
