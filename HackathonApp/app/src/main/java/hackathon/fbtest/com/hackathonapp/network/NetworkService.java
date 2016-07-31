package hackathon.fbtest.com.hackathonapp.network;

import hackathon.fbtest.com.hackathonapp.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by mr.icetea on 7/31/16.
 */
public interface NetworkService {
    @Headers("Content-Type: application/json")
    @POST("api/v1/public/users/")
    Call<User> createUser(@Body User User);
}
