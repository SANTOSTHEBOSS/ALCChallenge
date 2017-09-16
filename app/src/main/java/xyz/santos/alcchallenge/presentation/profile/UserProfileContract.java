package xyz.santos.alcchallenge.presentation.profile;

import xyz.santos.alcchallenge.data.remote.model.User;
import xyz.santos.mvp.Mvp;

/**
 * Created by Michael on 11/03/2017.
 */

public interface UserProfileContract {

    public interface View extends Mvp.View {
        void showUserProfile(User user);

        void showError(String error);

        void showLoading();

        void hideLoading();

    }

    public interface Presenter extends Mvp.Presenter<View> {
        void getUserProfile(String username);
    }
}
