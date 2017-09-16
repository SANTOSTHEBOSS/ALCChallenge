package xyz.santos.alcchallenge.presentation.users;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xyz.santos.alcchallenge.data.UsersRepository;
import xyz.santos.alcchallenge.data.remote.model.User;
import xyz.santos.mvp.BasePresenter;

/**
 * Created by Michael on 10/03/2017.
 */

public class UserListPresenter extends BasePresenter<UsersListMvpContract.View> implements UsersListMvpContract.Presenter {

    private static final String TAG = "UserListPresenter";
    private UsersRepository userRepository;

    public UserListPresenter(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void getUsers() {
        checkViewAttached();
        getView().showLoading();
        addSubscription(userRepository.getAllLagosJavaDevelopers()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<User>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().hideLoading();
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<User> users) {
                        getView().hideLoading();
                        getView().showUsers(users);
                    }
                })
        );
    }
}