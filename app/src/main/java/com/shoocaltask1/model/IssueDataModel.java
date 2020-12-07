package com.shoocaltask1.model;

public class IssueDataModel {

    String repository_url;
    String state;
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRepository_url() {
        return repository_url;
    }

    public void setRepository_url(String repository_url) {
        this.repository_url = repository_url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public class User{
        String login;
        String id;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "User{" +
                    "login='" + login + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "IssueDataModel{" +
                "repository_url='" + repository_url + '\'' +
                ", state='" + state + '\'' +
                ", user=" + user +
                '}';
    }
}
