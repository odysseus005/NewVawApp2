package jazevangelio.newvawepp.model.response;


import jazevangelio.newvawepp.model.data.User;

public class LoginResponse extends ResultResponse {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
