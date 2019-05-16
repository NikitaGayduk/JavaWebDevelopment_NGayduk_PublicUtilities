package by.epam.javawebtraining.gayduknikita.webproject.controller.command;

public class CommandResult {
    private String page;
    private Action action;

    public enum Action {
        REDIRECT,
        FORWARD
    }

    public CommandResult() {
    }

    public CommandResult(String page, Action action) {
        this.page = page;
        this.action = action;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
