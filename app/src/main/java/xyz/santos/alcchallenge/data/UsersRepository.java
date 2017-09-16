package xyz.santos.alcchallenge.data;

import java.util.List;

import rx.Observable;
import xyz.santos.alcchallenge.data.remote.model.User;

/**
 * Created by Michael on 10/03/2017.
 */

public interface UsersRepository {

    Observable<List<User>> getAllLagosJavaDevelopers();

    Observable<User> getUserProfile(String username);
}
