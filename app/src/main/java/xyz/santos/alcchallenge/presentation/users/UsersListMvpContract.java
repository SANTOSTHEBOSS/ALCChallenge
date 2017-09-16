package xyz.santos.alcchallenge.presentation.users;

import java.util.List;

import xyz.santos.alcchallenge.data.remote.model.User;
import xyz.santos.mvp.Mvp;

/**
 * Created by Michael on 10/03/2017.
 *
 * Interface to hold all possible presentation actions for activity
 */

public interface UsersListMvpContract {

    public interface View extends Mvp.View {
        void showUsers(List<User> users);

        void showError(String error);

        void showLoading();

        void hideLoading();
    }

    public interface Presenter extends Mvp.Presenter<View> {
        void getUsers();
    }
}
