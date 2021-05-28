package by.bsuir.filinovichsa.adkpproject.support;

import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;

import javax.persistence.*;

@Entity
@Table(name = "support")
public class SupportMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private AbstractUser user;
    private String text;
    private String answer;

    public SupportMessage() {
    }

    public SupportMessage(AbstractUser user, String text) {
        this.user = user;
        this.text = text;
    }

    public boolean hasAnswer() {
        return answer != null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AbstractUser getUser() {
        return user;
    }

    public void setUser(AbstractUser user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
