package com.codetogether.CodeTogether.domain;

public class User {
    String intraId;
    Team team;
    Project project;

    public Boolean isTeamMatched() {
        if(this.team == null)
            return false;
        return true;
    }

    public Boolean isProjectApplied(){
        if (this.project == null)
            return false;
        return true;
    }

    public void projectApply(Project project){
        this.project = project;
    }
    public void voteExit(){
        if(isTeamMatched())
        {
            this.team.exitVote *= 2;
            this.team.exitVote += 1;
        }
    }
    public void projectCancel(){
        if(isProjectApplied())
        {
            this.project = null;
        }
    }
}
