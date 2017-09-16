package xyz.santos.alcchallenge.data.remote;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import xyz.santos.alcchallenge.data.remote.model.User;
import xyz.santos.alcchallenge.data.remote.model.UserList;

/**
 * Created by Michael on 10/03/2017.
 */

public interface GithubService {

    @GET("/search/users")
    Observable<UserList> searchUsers(@Query("q") String searchTerm);

    @GET("/users/{username}")
    Observable<User> getUser(@Path("username") String username);
}
